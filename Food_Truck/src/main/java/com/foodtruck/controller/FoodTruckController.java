package com.foodtruck.controller;

import java.text.DecimalFormat;
import java.text.Format;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.foodtruck.service.FoodTruckService;
import com.foodtruck.service.ProductService;
import com.foodtruck.service.ReviewService;
import com.foodtruck.vo.FoodTruckVO;
import com.foodtruck.vo.ProductVO;
import com.foodtruck.vo.ReviewVO;

@Controller
public class FoodTruckController {

	@Autowired
	private FoodTruckService fservice;
	@Autowired
	private ReviewService rservice;
	@Autowired
	private ProductService pservice;

	// FoodTrcuk List
	@RequestMapping("/menuBoard")
	public String menuBoarPage(Model model) throws Exception {
		model.addAttribute("list", fservice.getFoodTruckList());
		return "foodtruck/menuBoard";
	}

	// Korean Food
	@RequestMapping("/korFood")
	public String korFoodPage(Model model) throws Exception {
		model.addAttribute("list", fservice.getCategoryList(1));
		return "foodtruck/korFood";
	}

	// Chinese Food
	@RequestMapping("/chiFood")
	public String chiFoodPage(Model model) throws Exception {
		model.addAttribute("list", fservice.getCategoryList(2));
		return "foodtruck/chiFood";
	}

	// Western Food
	@RequestMapping("/westFood")
	public String westFoodPage(Model model) throws Exception {
		model.addAttribute("list", fservice.getCategoryList(3));
		return "foodtruck/westFood";
	}

	// Japanese Food
	@RequestMapping("/jpFood")
	public String jpFoodPage(Model model) throws Exception {
		model.addAttribute("list", fservice.getCategoryList(4));
		return "foodtruck/jpFood";
	}

	// ������
	@RequestMapping("/read")
	public String foodinfo(@RequestParam("licenseNo") String licenseNo, HttpServletRequest request) throws Exception {
		double pyengjum = 0;//���� ���� �հ�
		double count = 0; //���� ��
		double total = 0; //Ǫ��Ʈ�� �� ����
		FoodTruckVO vo = fservice.getFoodTruck(licenseNo);//Ǫ��Ʈ�� ���� ȣ��
		List<ReviewVO> Rlist = rservice.getReviewList(licenseNo);// ���� ���� ȣ��
		List<ProductVO> Plist = pservice.getProductList(licenseNo);// ��ǰ ���� ȣ��
		if(Rlist.size()!=0) {
			for (int i = 0; i < Rlist.size(); i++) {
				double score = Rlist.get(i).getGrade();
				pyengjum += score;
				count = Rlist.size();
				total = pyengjum / count;
				total = Double.parseDouble(String.format("%.2f",total));
			}	
		}else {
			total=0;		
		}
		vo.setFtruckGrade(total);
		request.setAttribute("vo", vo);
		request.setAttribute("review", Rlist);
		request.setAttribute("product", Plist);
		return "foodtruck/detail";
	}
}
