package com.example.mvc.service;

import java.util.ArrayList;
import java.util.List;

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
	
	@Scheduled(cron = "0 0 23 * * *")
	public void batchProcess() {
		List<StateGetDto> stateList = stateDao.getStateList();
		List<StateGetDto> sList = new ArrayList<>();
		List<StateGetDto> tList = stateDao.getTemplete();
		
		if(stateList != null) {
			for (StateGetDto state : stateList) {				
				 for (StateGetDto templeteDto : tList) {
					 if(templeteDto != null) {
						 String templete = templeteDto.getTemplete();		                
						 templete = templete.replace("#{title}", state.getTitle())
								 			.replace("#{contents}", state.getContents());
						 state.setTemplete(templete);
						 sList.add(state);
						 break;
					 }
	             	}
			}
			try {
				stateDao.insertState(sList);
				log.info("State: {}", sList);				
			} catch (Exception e) {
				log.error("Error : {}", e.getMessage());
			}
		}
	}
}













