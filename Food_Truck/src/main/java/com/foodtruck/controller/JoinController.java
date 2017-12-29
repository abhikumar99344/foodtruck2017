package com.foodtruck.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.foodtruck.service.MemberService;
import com.foodtruck.vo.MemberVO;

@Controller
public class JoinController {
	
	@Autowired
	MemberService memberService;
	
	// ȸ�� ����
	@RequestMapping("/join1")
	public String insertMember(HttpServletRequest request, MemberVO vo) {

		String gubun[] = request.getParameterValues("gubun");

		for(String g : gubun) {
			if(g.equals("member")) {
				vo.setMemberAuth(3);
			} else if(g.equals("seller")) {
				vo.setMemberAuth(2);
			}
		}

		memberService.insertMember(vo);

		return "home";
	}

	// ID �ߺ�üũ
	@ResponseBody
	@RequestMapping("/idCheck")
	public MemberVO memberIdCheck(HttpServletRequest request) {
		String memberId = request.getParameter("memberId");

		return memberService.getMember(memberId);
	}

}
