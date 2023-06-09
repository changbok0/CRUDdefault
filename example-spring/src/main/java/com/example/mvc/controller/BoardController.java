package com.example.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mvc.domain.BoardModel;
import com.example.mvc.parameter.BoardParameter;
import com.example.mvc.service.BoardService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


/**
 * @author leechangbok
 * 게시판 컨트롤러
 */
@RestController
@RequestMapping("/board")
@Api(tags = "게시판 API")
public class BoardController {
	
	@Autowired
	@Qualifier("boardService")
	private BoardService boardService;
	
	/**
	 * @return
	 * 목록 리턴.
	 */
	@GetMapping("/selectAll")
	@ApiOperation(value = "목록 조회", notes = "게시물 목록 조회가 가능합니다.")
	public List<BoardModel> getList() {
		return boardService.getList();
	};
	
	/**
	 * @param boardSeq
	 * @return
	 * 상세정보 리턴.
	 */
	@GetMapping("/{boardSeq}")
	@ApiOperation(value = "상세 조회", notes = "게시물 번호에 해당하는 상세 정보를 조회할 수 있습니다.")
	@ApiImplicitParams({
		@ApiImplicitParam(name="boardSeq", value="게시물번호", example="1")
	})
	public BoardModel get(@PathVariable int boardSeq) {
		return boardService.get(boardSeq);
	};
	
	/**
	 * @param board
	 * 등록/수정 처리.
	 */
	@PutMapping("/insert")
	@ApiOperation(value = "등록 / 수정 처리", notes = "신규 게시물 저장 및 기존 게시물 업데이트가 가능합니다.")
	@ApiImplicitParams({
	@ApiImplicitParam(name="boardSeq", value="게시물번호", example="1"),
	@ApiImplicitParam(name="title", value="제목", example="spring"),
	@ApiImplicitParam(name="contents", value="내용", example="spring 강좌"),
	})
	public int save(BoardParameter parameter) {
		boardService.insert(parameter);
		return parameter.getBoardSeq();
	};
	
	
	/**
	 * @param boardSeq
	 * 삭제 처리.
	 */
	@DeleteMapping("/{boardSeq}")
	@ApiOperation(value = "삭제 처리", notes = "게시물 번호에 해당하는 정보를 삭제합니다.")
	@ApiImplicitParams({
		@ApiImplicitParam(name="boardSeq", value="게시물번호", example="1"),
	})
	public boolean delete(@PathVariable int boardSeq) {
		BoardModel board = boardService.get(boardSeq);
		if (board == null) {
			return false;
		}
		boardService.delete(boardSeq);
		return true;
	};
	
}
