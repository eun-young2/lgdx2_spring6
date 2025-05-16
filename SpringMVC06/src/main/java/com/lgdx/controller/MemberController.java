package com.lgdx.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.lgdx.entity.Board;
import com.lgdx.entity.Member;
import com.lgdx.service.MemberService;


@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;

	@GetMapping("/login.do")
	public String login() {
		return "login";
	}
	
	@GetMapping("/join.do")
	public String join() {
		return "join";
	}
	
	@PostMapping("/join.do")
	public String join(Member mem) {
		service.join(mem);
		return "redirect:/login.do";
	}
	
	@PostMapping("/login.do")
	public String login(Member mem, HttpSession session) {
		Member info= service.login(mem);
		System.out.println(info);
		
		if(info != null) {
			session.setAttribute("info", info);
		}
		return "redirect:/boardList.do";
		
	}
	
	@GetMapping("/logout.do")
	public String logout(HttpSession session) {
		// session.removeAttribute("info");
		session.invalidate();
		return "redirect:/login.do";
	}
}
