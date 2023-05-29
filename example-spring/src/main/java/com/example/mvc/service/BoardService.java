package com.example.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mvc.boardDao.BoardDao;
import com.example.mvc.domain.BoardModel;
import com.example.mvc.parameter.BoardParameter;

import lombok.RequiredArgsConstructor;


/**
 * 게시판 서비스
 * @author leechangbok
 */

@Service
@RequiredArgsConstructor
public class BoardService {
	
	@Autowired
	private BoardDao boardDao;
	
	
	/**
	 * @return
	 * 목록 리턴.
	 */
	public List<BoardModel> getList() {
		return boardDao.getList();
	};
	
	/**
	 * @param boardSeq
	 * @return
	 * 상세정보 리턴.
	 */
	public BoardModel get(int boardSeq) {
		return boardDao.get(boardSeq);
	};
	
	/**
	 * @param board
	 * 등록 처리.
	 * @return 
	 */
	public void insert(BoardParameter parameter) {
		// 조회하여 리턴된 정보
		BoardModel board = boardDao.get(parameter.getBoardSeq());
		if (board == null) {
			boardDao.insert(parameter);
		} else {
			boardDao.update(parameter);
		}
	};

	
	/**
	 * @param boardSeq
	 * 삭제 처리.
	 */
	public void delete(int boardSeq) {
		boardDao.delete(boardSeq);
	};
	
}
