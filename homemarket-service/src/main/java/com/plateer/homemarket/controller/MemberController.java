package com.plateer.homemarket.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.plateer.homemarket.entity.Member;
import com.plateer.homemarket.service.MemberService;

@RestController
@RequestMapping("/member")
public class MemberController {
	
	private final MemberService memberService;
	
	MemberController(MemberService memberService){
		this.memberService = memberService;
	}
	
	@PostMapping("/create")
	public void register(@RequestBody Member member) {	
		memberService.register(member);
	}
	
	@GetMapping("/retrieveAll")
	public List<Member> findAll(){
		return memberService.findAll();
	}
	
	@GetMapping("/retrieveById")
	public Member findById(@RequestParam String memberId) {
		return memberService.findById(memberId);
	}
	
	@GetMapping("/retrieveByName")
	public List<Member> findByName(@RequestParam String name){
		return memberService.findByName(name);
	}
	
	@PutMapping("/update")
	public void modify(@RequestBody Member member) {
		memberService.modify(member);
	}
	
	@DeleteMapping("/delete")
	public void remove(@RequestParam String memberId) {
		memberService.remove(memberId);
	}
}
