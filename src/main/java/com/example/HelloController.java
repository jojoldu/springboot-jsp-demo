package com.example;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	@Autowired
	private MemberRepository memberRepository;
	
	@GetMapping("/")
	@ResponseBody
	public String main() {
		return "Hello World";
	}
	
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@PostMapping("/add")
	@ResponseBody
	public List<String> add(Member member){
		memberRepository.save(member);
		return memberRepository
				.findAll()
				.stream()
				.map(m -> m.toString())
				.collect(Collectors.toList());
	}
	
}
