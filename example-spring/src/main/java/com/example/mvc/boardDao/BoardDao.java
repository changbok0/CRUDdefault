package com.example.mvc.boardDao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.mvc.domain.BoardModel;
import com.example.mvc.parameter.BoardParameter;


/**
 * @author leechangbok
 * 게시판 Repository
 */
@Repository
public interface BoardDao {
	
	List<BoardModel> getList();
	
	BoardModel get(int boardSeq);
	
	void insert(BoardParameter board);
	
	void update(BoardParameter board);
	
	void delete(int boardSeq);
	
}
