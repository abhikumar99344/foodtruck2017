package com.foodtruck.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.foodtruck.service.FoodTruckService;
import com.foodtruck.service.MemberService;
import com.foodtruck.service.OrderService;
import com.foodtruck.service.ProductService;
import com.foodtruck.service.SellerService;
import com.foodtruck.vo.FoodTruckVO;
import com.foodtruck.vo.MInquiryVO;
import com.foodtruck.vo.MemberVO;
import com.foodtruck.vo.OrderVO;
import com.foodtruck.vo.ProductVO;
import com.foodtruck.vo.SellerVO;

@Controller
public class SellerController {
	//ArrayList<SellerVO> list = new ArrayList<SellerVO>();
	@Autowired
	FoodTruckService foodTruckService;
	
	@Autowired

	MemberService mservice;
	@Autowired
	SellerService sservice;
	
	@Autowired
	private ProductService productService;

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
	public String sellerMain(@RequestParam(value = "licenseNo")String licenseNo,HttpServletRequest request, Model model, HttpSession session) {
		
		MemberVO mvo = (MemberVO)session.getAttribute("member");
//		OrderVO ovo = (OrderVO) session.getAttribute("licenseNo");
		
		model.addAttribute("order1", sservice.getLicense(mvo.getMemberId()));
		model.addAttribute("order2", sservice.getOrderList(request.getParameter("licenseNo")));
		model.addAttribute("img", sservice.getFoodTruckList(request.getParameter("licenseNo")));
		
		return "seller/main";
	}
	
	
	@RequestMapping("/insertFoodTruckForm")
	public String insertFoodTruckForm() {
		return "seller/insertFoodTruck";
	}
	
	@RequestMapping("/sellerProduct")
	public String sellerProduct(@RequestParam(value = "licenseNo")String licenseNo,HttpServletRequest request,Model model,HttpSession session) {
		MemberVO mvo = (MemberVO)session.getAttribute("member");
		List<SellerVO> list =sservice.getLicense(mvo.getMemberId());
		List<ProductVO> list2 =productService.getProductList(licenseNo);
		request.setAttribute("list", list);
		request.setAttribute("licenseNo", licenseNo);
		request.setAttribute("list2", list2);
		
		
		return "seller/sellerProduct";
	}
	@RequestMapping("/modal")
	@ResponseBody
	public HashMap modal(@RequestParam("licenseNo") String licenseNo) {
		HashMap map = new HashMap();
		map.put("licenseNo", licenseNo);
		System.out.println("ㄴㅇ"+licenseNo);
		return map;
	}
	@RequestMapping("/insertFoodTruck")
	public String insertFoodTruck(HttpServletRequest request, FoodTruckVO vo) {
		
		String category[] = request.getParameterValues("category");
		String ftruckDlvYn[] = request.getParameterValues("ftruckDlvYn");
		String ftruckRsvYn[] = request.getParameterValues("ftruckRsvYn");
		String ftruckState[] = request.getParameterValues("ftruckState");
		
		for(String c : category) {
			switch(c) {
			case "1" : vo.setCategory(1); break;
			case "2" : vo.setCategory(2); break;
			case "3" : vo.setCategory(3); break;
			case "4" : vo.setCategory(4); break;
			}
			
			/*
			if(c.equals("1")) {
				vo.setCategory(1);
			} else if(c.equals("2")) {
				vo.setCategory(2);
			} else if(c.equals("3")) {
				vo.setCategory(3);
			} else if(c.equals("4")) {
				vo.setCategory(4);
			}*/
		}
		
		for(String dlv : ftruckDlvYn) {
			switch(dlv) {
			case "Y" : vo.setFtruckDlvYn("Y"); break;
			case "N" : vo.setFtruckDlvYn("N"); break;
			}
		}
		
		for(String rsv : ftruckRsvYn) {
			switch(rsv) {
			case "Y" : vo.setFtruckRsvYn("Y"); break;
			case "N" : vo.setFtruckRsvYn("N"); break;
			}
		}
		
		for(String state : ftruckState) {
			switch(state) {
			case "Y" : vo.setFtruckState("Y"); break;
			case "N" : vo.setFtruckState("N"); break;
			}
		}
		
		sservice.insertFoodTruck(vo);
		
		return "seller/main";
	}

	
	@RequestMapping("/detailFoodTruckForm")
	public String detailFoodTruckForm() {
		return "seller/detailFoodTruck";
	}
	
	@ResponseBody
	@RequestMapping("/licenseNoCheck")
	public FoodTruckVO licenseNoCheck(HttpServletRequest request) {
		String licenseNo = request.getParameter("licenseNo");

		return sservice.getFoodTruck(licenseNo);
	}
		

	//판매자 1:1문의
	@RequestMapping("sellerinquriy")
	public String sellerinquriy(MInquiryVO vo) {	
		String result="N";
		vo.setQaScStat(result);
		System.out.println(vo.getLicenseNo());
		mservice.insertInquiry2(vo);
		return "home";
	}
	//판매자 licenseNo로 푸드트럭 정보 가져오기
	@RequestMapping("/asd")
	@ResponseBody
	public HashMap foodtruckInfo(@RequestParam("licenseNo") String licenseNo) {
		HashMap map = new HashMap();
		FoodTruckVO vo = sservice.getFoodtruckDtail(licenseNo);
		if(vo.getFtruckAddr()==null) {
			vo.setFtruckAddr(vo.getFtruckAddr2());
		}
		map.put("name", vo.getFtruckName());
		map.put("addr", vo.getFtruckAddr());
		map.put("img", vo.getFtruckImg());
		map.put("intro", vo.getFtruckIntro());
		map.put("tel", vo.getFtruckTel());
		map.put("dliver", vo.getFtruckDlvYn());
		map.put("reserve", vo.getFtruckRsvYn());
		map.put("category", vo.getCategory());
		String com="";
		com+="<script type=\"text/javascript\">";
		com+="var geocoder = new daum.maps.services.Geocoder();\r\n" + 
				"geocoder.addressSearch('"+vo.getFtruckAddr()+"', function(result, status) {\r\n" + 
				"     if (status === daum.maps.services.Status.OK) {\r\n" + 
				"        var coords = new daum.maps.LatLng(result[0].y, result[0].x);\r\n" + 
				"        var marker = new daum.maps.Marker({\r\n" + 
				"            map: map,\r\n" + 
				"            position: coords\r\n" + 
				"        });\r\n" + 
				"        var infowindow = new daum.maps.InfoWindow({\r\n" + 
				"            content: '<div style=\"width:150px;text-align:center;padding:6px 0;\">"+vo.getFtruckName()+"</div>'\r\n" + 
				"        });\r\n" + 
				"        infowindow.open(map, marker);\r\n" + 
				"        map.setCenter(coords);\r\n" + 
				"    } \r\n" + 
				"});";
		com+="</script>";
		map.put("com", com);
		String info="";
		
		return map;
	}

}
