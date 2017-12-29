package com.foodtruck.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.foodtruck.service.MemberService;
import com.foodtruck.vo.MemberVO;

@Controller
public class JoinController {

	private static final Logger logger = LoggerFactory.getLogger(JoinController.class);

	@Autowired
	MemberService memberService;

	// ȸ������������
	@RequestMapping("/joinform")
	public String joinFormPage() {
		return "nav/joinform";
	}

	// ȸ�� ����
	@RequestMapping("/join")
	public String insertMember(HttpServletRequest request, MemberVO vo) {

		String gubun[] = request.getParameterValues("gubun");

		for (String g : gubun) {
			if (g.equals("member")) {
				vo.setMemberAuth("3");
			} else if (g.equals("seller")) {
				vo.setMemberAuth("2");
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
