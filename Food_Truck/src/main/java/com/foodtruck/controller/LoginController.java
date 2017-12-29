package com.foodtruck.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.foodtruck.service.MemberService;
import com.foodtruck.vo.MemberVO;

@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	MemberService memberService;
	
	
	
	// �α��� ������ �̵�
		@RequestMapping("/loginform")
		public String loginform() {
			System.out.println("loginform");
			return "/login/login";
		}

		// �α��� ������
		@RequestMapping("/login")
		public String login(@RequestParam("id") String id, @RequestParam("pw") String pw, HttpSession session,
				HttpServletRequest request, HttpServletResponse response) {
			
			
			MemberVO mvo = memberService.getMember(id);

			if (mvo!=null) {
				if(mvo.getMemberPw().equals(pw)) {
					session.setAttribute("member", mvo);	
					System.out.println("�α��μ���");
					return "home";
				}else{
					request.setAttribute("msg", "��й�ȣ�� ���� �ʽ��ϴ�.");
					return "/login/msg";
				}
			}else {
				
				request.setAttribute("msg", "ȸ�������� ���ų� �Էµ��� �ʾҽ��ϴ�.");
				return "/login/msg";	
			}
		}
		// �α׾ƿ� ������
		@RequestMapping("/logout")
		public String logout(HttpSession session, HttpServletRequest request) {
			session.invalidate();
			return "home";
		}
	

	/*
	@RequestMapping("/loginChk")
	public String loginchk(@RequestParam("userId") String userId, @RequestParam("userPw") String userPw,
			HttpSession session, HttpServletRequest request) {

		System.out.println(userId + " / " + userPw);
		
		// ȸ�� ����     1.���     2. �Ǹ���     3. �Ϲ�ȸ��
		MemberVO mvo = memberService.getMember(userId);
		
		if(mvo != null) {
			if(mvo.getMemberPw().equals(userPw)) {
				if(mvo.getMemberAuth() == 1 ) {
					System.out.println("��� �α���");
					session.setAttribute("userId", mvo.getMemberId());
					session.setAttribute("gubun", mvo.getMemberAuth());
					return "loginChk";
				} else if(mvo.getMemberAuth() == 2) {
					System.out.println("�Ǹ��� �α���");
					session.setAttribute("userId", mvo.getMemberId());
					session.setAttribute("gubun", mvo.getMemberAuth());
					return "loginChk";
				} else if(mvo.getMemberAuth() == 3) {
					System.out.println("�Ϲ� ȸ�� �α���");
					session.setAttribute("userId", mvo.getMemberId());
					session.setAttribute("gubun", mvo.getMemberAuth());
					return "loginChk";
				}
				return "home";
			} 
		}
		return "home";
	}

	*/
}
