package com.example.mvc.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.mvc.parameter.StateGetDto;
import com.example.mvc.stateDao.StateDao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 상태 확인 및 메세지 삽입
 * @author leechangbok
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class StateService {
	
	@Autowired
	private StateDao stateDao;
	
	@Scheduled(cron = "0 34 15 * * *")
	public void batchProcess() {
		List<StateGetDto> stateList = stateDao.getStateList();
		System.out.println("stateList ===" + stateList );
		log.info("stateList === {}", stateList);
		
		if(stateList != null) {
			List<StateGetDto> sList = new ArrayList<>();
			for (StateGetDto state : stateList) {
				sList.add(state);
				log.info("State: {}", sList);
			}			
			stateDao.insertState(sList);
		}
	}
}













