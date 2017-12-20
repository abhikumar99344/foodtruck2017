package com.foodtruck.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.foodtruck.service.FoodTruckService;

@Controller
public class NavController {
	
	@Autowired
	private FoodTruckService fservice;
	
	// ��������
	@RequestMapping("/noticeBoard")
	public String noticeBoardPage() {
		return "nav/noticeBoard";
	}
	
	// �̺�Ʈ
	@RequestMapping("/eventBoard")
	public String eventBoardPage() {
		return "nav/eventBoard";
	}
	
	// 1:1 ����
	@RequestMapping("/inquiry")
	public String inquiryPage() {
		return "nav/inquiry";
	}
	
	// �α���  ���� �� �׽�Ʈ��  -> nav/login ���� �ٲٱ�
	@RequestMapping("/login")
	public String loginPage() {
		return "nav/login";
	}
	
	// ����
	@RequestMapping("/join")
	public String joinPage() {
		return "nav/test";
	}

	// FoodTrcuk List
	@RequestMapping("/menuBoard")
	public String menuBoarPage(Model model)throws Exception {
		model.addAttribute("list", fservice.getFoodTruckList());
		return  "nav/menuBoard";
	}
	
	// Korean Food
	@RequestMapping("/korFood")
	public String korFoodPage(Model model)throws Exception {
		model.addAttribute("list", fservice.getCategoryList(1));
		return "nav/korFood";
	}
	
	// Chinese Food
	@RequestMapping("/chiFood")
	public String chiFoodPage(Model model)throws Exception {
		model.addAttribute("list", fservice.getCategoryList(2));
		return "nav/chiFood";
	}
	
	// Western Food
	@RequestMapping("/westFood")
	public String westFoodPage(Model model)throws Exception {
		model.addAttribute("list", fservice.getCategoryList(3));
		return "nav/westFood";
	}
	
	// Japanese Food
	@RequestMapping("/jpFood")
	public String jpFoodPage(Model model)throws Exception {
		model.addAttribute("list", fservice.getCategoryList(4));
		return "nav/jpFood";
	}
	
	// ������
	@RequestMapping("/read")
	public String foodinfo(@RequestParam("licenseNo")String licenseNo,Model model)throws Exception {
		model.addAttribute("one",fservice.getFoodTruck(licenseNo));
		return "nav/detail";
	}
	
	// ������ �޴�
	@RequestMapping("/adminBoard")
	public String adminBoardPage() {
		return "nav/adminBoard";
	}
	
	// ������ �޴� - ȸ������
	@RequestMapping("/adminMember")
	public String adminMemberPage() {
		return "nav/adminMember";
	}
	
	// ������ �޴� - �Ǹ��� ����
	@RequestMapping("/adminSeller")
	public String adminSellerPage() {
		return "nav/adminSeller";
	}
	
	// ������ �޴� - Ǫ��Ʈ�� ����
	@RequestMapping("/adminFoodTruck")
	public String adminFoodTruckPage() {
		return "nav/adminFoodTruck";
	}
	
	// �Ǹ��� �޴�
	@RequestMapping("/sellerBoard")
	public String sellerBoardPage() {
		return "nav/sellerBoard";
	}
	
	// �Ǹ��� �޴� - ���� ����
	@RequestMapping("/orderDetail")
	public String orderDetailPage() {
		return "nav/orderDetail";
	}
	
	// �Ǹ��� �޴� - ���� ����
	@RequestMapping("/productInsert")
	public String productInsertPage() {
		return "nav/productInsert";
	}
	
	// �Ǹ��� �޴� - ��� ����
	@RequestMapping("/deliveryDetails")
	public String deliveryDetailsPage() {
		return "nav/deliveryDetails";
	}
		
	// �Ǹ��� �޴� - �Ǹ��� ����
	@RequestMapping("/sellerSetting")
	public String sellerSettingPage() {
		return "nav/sellerSetting";
	}
	
	// ������ �޴�
	@RequestMapping("/myBoard")
	public String myBoardPage() {
		return "nav/myBoard";
	}
	
	// ������ �޴� - ��ü �ֹ� ����
	@RequestMapping("/orderList")
	public String orderListPage() {
		return "nav/orderList";
	}
	
	// ������ �޴� - ���� Ǫ��Ʈ��
	@RequestMapping("/favoritFoodtruck")
	public String favoritFoodtruckPage() {
		return "nav/favoritFoodtruck";
	}
	
	// ������ �޴� - ���� ����
	@RequestMapping("/myWriting")
	public String myWritingPage() {
		return "nav/myWriting";
	}
	
	// ������ �޴� - ���� ����
	@RequestMapping("/mySetting")
	public String mySettingPage() {
		return "nav/mySetting";
	}
}
