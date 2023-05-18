package com.example.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mvc.domain.Board;
import com.example.mvc.parameter.BoardParameter;
import com.example.mvc.repository.BoardRepository;

import lombok.RequiredArgsConstructor;


/**
 * 게시판 서비스
 * @author leechangbok
 */

@Service
@RequiredArgsConstructor
public class BoardService {
	
	@Autowired
	private BoardRepository repository;
	
	
	/**
	 * @return
	 * 목록 리턴.
	 */
	public List<Board> getList() {
		return repository.getList();
	};
	
	/**
	 * @param boardSeq
	 * @return
	 * 상세정보 리턴.
	 */
	public Board get(int boardSeq) {
		return repository.get(boardSeq);
	};
	
	/**
	 * @param board
	 * 등록 처리.
	 * @return 
	 */
	public void save(BoardParameter parameter) {
		// 조회하여 리턴된 정보
		Board board = repository.get(parameter.getBoardSeq());
		if (board == null) {
			repository.save(parameter);
		} else {
			repository.update(parameter);
		}
	};

	
	/**
	 * @param boardSeq
	 * 삭제 처리.
	 */
	public void delete(int boardSeq) {
		repository.delete(boardSeq);
	};
	
}
