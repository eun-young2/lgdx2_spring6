package com.lgdx.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lgdx.entity.Board;
import com.lgdx.service.BoardService;

@Controller
public class BoardContoller {
	@Autowired
	private BoardService service;
	
	@GetMapping("/boardList.do")
	public String boardList(Model model) {
		List<Board> list = service.boardList();
		System.out.println(list.toString());
		model.addAttribute("list", list);
		return "boardList";
	}
	
	@GetMapping("/boardContents.do")
		// 한개 가져오려고 사용
	public String boardContents(@RequestParam("idx") Long idx, Model model) {
	System.out.println("게시글 상세보기 기능");
	service.boardCount(idx);
	// 게시글 상세 내용 가져오기
		Board vo = service.boardContents(idx);
		System.out.println(vo.toString());
		model.addAttribute("board", vo);
		model.addAttribute("ln","\n");
		return "boardContents";
	}
	
	@GetMapping("/boardInsert.do")
	public String boardInsert() {
		System.out.println("게시글 작성 페이지 이동");
		
		return "boardInsert";
	}
	
	//오버로딩, 매개변수 3가지(title,contents,writer)가 있는데 vo 안에 있음
	@PostMapping("/boardInsert.do")
	public String boardInsert(Board vo) {
		System.out.println("게시글 작성 기능");
		System.out.println(vo.toString());
		service.boardInsert(vo);
		return "redirect:/boardList.do";
	}
	
	@GetMapping("/boardDelete.do")
	public String boardContents(@RequestParam("idx") Long idx) {
		System.out.println("게시글 삭제 기능");
		service.boardDelete(idx);
		
		return "redirect:/boardList.do";
	}
	
	@GetMapping("/boardUpdate.do")
	public String boardUpdate(@RequestParam("idx") Long idx, Model model) {
		System.out.println("수정 게시판 이동");
		//상세보기
		Board vo = service.boardContents(idx);
		model.addAttribute("board",vo);
		return "boardUpdate";
	}
	
	@PostMapping("/boardUpdate.do")
	public String boardUpdate(Board vo) {
		System.out.println("게시글 수정 기능");
		service.boardUpdate(vo);
		return "redirect:/boardList.do";
	}	
	
}
