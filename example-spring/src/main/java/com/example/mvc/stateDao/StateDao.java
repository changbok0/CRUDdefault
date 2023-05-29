package com.example.mvc.stateDao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.mvc.parameter.StateGetDto;

@Repository
public interface StateDao {
	
	List<StateGetDto> getStateList();
	
	void insertState(List<StateGetDto> stateGetDto);
}
