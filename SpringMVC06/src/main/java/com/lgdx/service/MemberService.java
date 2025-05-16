package com.lgdx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lgdx.entity.Member;
import com.lgdx.repository.MemberRepository;

@Service
public class MemberService {
	@Autowired
	private MemberRepository repository ;
	
	public void join(Member mem) {
		repository.save(mem);
	}

	public Member login(Member mem) {
		String id = mem.getId();
		String pw = mem.getPw();
		return repository.findByIdAndPw(id, pw);
	}
}
