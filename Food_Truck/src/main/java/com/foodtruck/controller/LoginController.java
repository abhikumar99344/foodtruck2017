package com.foodtruck.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.foodtruck.service.AdminService;
import com.foodtruck.service.MemberService;
import com.foodtruck.service.SellerService;
import com.foodtruck.vo.AdminVO;
import com.foodtruck.vo.MemberVO;
import com.foodtruck.vo.SellerVO;

@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	MemberService memberService;

	@Autowired
	AdminService adminService;

	@Autowired
	SellerService sellerService;
	
	@RequestMapping("/loginChk")
	public String loginchk(@RequestParam("userId") String userId, @RequestParam("userPw") String userPw,
			HttpSession session, Model model ) {

		System.out.println(userId + " / " + userPw);
		
		// ȸ�� ����
		MemberVO mvo = memberService.getMember(userId);
		AdminVO avo = adminService.getAdmin(userId); 
		SellerVO svo = sellerService.getSeller(userId);		
		
		// �Ϲ� ȸ���� ���
		if (mvo != null) {
			System.out.println("�Ϲ�ȸ��");
			if (mvo.getMemberPw().equals(userPw)) {
				session.setAttribute("userId", mvo.getMemberId());
				session.setAttribute("gubun", "3");
				return "loginChk";
			} else {
				return "home";
			}
			
		// �������� ���
		} else if(avo != null) {
			System.out.println("������");
			if(avo.getAdminPw().equals(userPw)) {
				session.setAttribute("userId", avo.getAdminId());
				session.setAttribute("gubun", "1");
				return "loginChk";
			} else {
				return "home";
			}
		// �Ǹ����� ���
		} else if(svo != null) {
			System.out.println("�Ǹ���");
			if(svo.getSelPw().equals(userPw)) {
				session.setAttribute("userId", svo.getSelId());
				session.setAttribute("gubun", "2");
				return "loginChk";
			} else {
				return "home";
			}
		}
		return "home";
	}
	
	@RequestMapping("/logout")
	public String logoutPage() {
		return "logout";
	}
}
