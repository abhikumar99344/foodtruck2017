package com.foodtruck.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

	// ������ �޴� - ��������
	@RequestMapping("/adminCalendar")
	public String adminFoodTruckPage() {
		return "admin/calendar";
	}
	
	// ������ �޴� - ��Ʈ
	@RequestMapping("/adminChart")
	public String adminChart() {
		return "admin/chart";
	}
	
	// ������ �޴� - ��� ? 
	@RequestMapping("/adminMain")
	public String adminMain() {
		return "admin/main";
	}
}
