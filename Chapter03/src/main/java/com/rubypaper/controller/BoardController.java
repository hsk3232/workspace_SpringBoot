package com.rubypaper.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rubypaper.domain.BoardVO;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
public class BoardController {

	@GetMapping("/hello")
	public String hello(String name) {
		log.trace("Hello 호출");
		return "Hello : " +  name;
	}

	
	@GetMapping("/getBoard")
	public BoardVO getBoard() {
		return BoardVO.builder().seq(1).title("히히").writer("테스터").build();
	}

}
