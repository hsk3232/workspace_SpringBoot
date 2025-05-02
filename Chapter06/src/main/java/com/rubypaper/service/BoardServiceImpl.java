package com.rubypaper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubypaper.domain.Board;
import com.rubypaper.persistence.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardRepository boardRepo;
	
	
	public List<Board> getBoardList() {
		return boardRepo.findAll();
	}
	
	
	public Board getBoard(Board board) {
		Board b = boardRepo.findById(board.getSeq()).get();
		b.setCnt(b.getCnt()+1);
		return boardRepo.save(b);		
	}
	
	public void insertBoard(Board board) {
		boardRepo.save(board);
	}
	
	public void updateBoard(Board board) {
		Board b = boardRepo.findById(board.getSeq()).get();
		b.setTitle(board.getTitle());
		b.setContent(board.getContent());;
		b.setCnt(board.getCnt());
		boardRepo.save(b);
	}
	
	public void deleteBoard(Board board) {
		boardRepo.deleteById(board.getSeq());
	}
}
