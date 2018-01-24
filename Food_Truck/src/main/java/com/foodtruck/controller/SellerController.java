package com.foodtruck.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.foodtruck.service.FoodTruckService;
import com.foodtruck.service.OrderService;
import com.foodtruck.vo.FoodTruckVO;
import com.foodtruck.vo.MemberVO;
import com.foodtruck.vo.OrderVO;

@Controller
public class SellerController {

	@Autowired
	OrderService orderService;	
	
	@Autowired
	FoodTruckService foodTruckService;
	
	
	// ������ �޴� - �Ǹ���  ��������
	@RequestMapping("/sellerCalendar")
	public String sellerCalendar() {
		return "seller/calendar";
	}
	
	// ������ �޴� - ��Ʈ
	@RequestMapping("/sellerChart")
	public String sellerChart() {
		return "seller/chart";
	}
	
	// �Ǹ��� �޴� - �Ǹ��� ��� ?
	@RequestMapping("/sellerMain")
	public String sellerMain(@RequestParam("licenseNo")String licenseNo,HttpServletRequest request, Model model, HttpSession session) {
		
		MemberVO mvo = (MemberVO)session.getAttribute("member");
		OrderVO ovo = (OrderVO) session.getAttribute("licenseNo");
		
		model.addAttribute("order1", orderService.getLicense(mvo.getMemberId()));
		
		return "seller/main";
	}
	
	@RequestMapping("/test")
	public String sellerTest(HttpServletRequest request, Model model) {
		System.out.println(request.getParameter("licenseNo"));
		
		return "seller/main";
	}
}
