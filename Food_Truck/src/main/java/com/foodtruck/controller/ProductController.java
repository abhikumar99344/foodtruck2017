package com.foodtruck.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.foodtruck.service.FoodTruckService;
import com.foodtruck.service.MemberService;
import com.foodtruck.service.ProductService;
import com.foodtruck.vo.FoodTruckVO;
import com.foodtruck.vo.MemberVO;
import com.foodtruck.vo.ProductVO;

@Controller
public class ProductController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	
	@Autowired
	MappingJackson2JsonView jsonView;

	@Autowired
	private ProductService productService;

	@Autowired
	private MemberService memberService;
	
	@Autowired 
	private ServletContext servletContext;
	
	@Autowired
	private FoodTruckService fservice;

	// ��ǰ ��� �ϴ� ������ �̵�
	@RequestMapping("/insertProductForm")
	public String insertProductForm(Model model, HttpSession session) {

		MemberVO mvo = (MemberVO) session.getAttribute("member");

		String selId = mvo.getMemberId();

		// ����� ��ȣ
		model.addAttribute("list", memberService.getLicenseNo(selId));

		return "nav/productInsert";
	}

	// ��ǰ ���
	@RequestMapping("/insertProduct")
	@ResponseBody
	public int insertProduct(ProductVO vo) throws Exception {
		String licenseNo=vo.getLicenseNo();
		FoodTruckVO vo1=fservice.getFoodTruck2(licenseNo);
		System.out.println("sdfsdf"+vo.getFtruckNo());
		vo.setFtruckNo(vo1.getFtruckNo());
		int num = productService.insertProduct(vo);
		return num;

	}

	@RequestMapping("/imggo")
	@ResponseBody
	public HashMap img(MultipartHttpServletRequest request,HttpServletRequest req) throws IllegalStateException, IOException {
		String user=System.getProperty("user.dir");
		String path1="";
		path1 += user;
		path1 += "\\food\\Food_Truck\\src\\main\\webapp\\resources\\img\\upload\\";		
		
		
		Iterator<String> itr = request.getFileNames();

		if (itr.hasNext()) {
			List<MultipartFile> mpf = request.getFiles(itr.next());
			
			//DB에 저장될 값
			String pname="\\resources\\img\\upload\\"+mpf.get(0).getOriginalFilename();
			
			for (int i = 0; i < mpf.size(); i++) {
				
				File file = new File(path1 + mpf.get(i).getOriginalFilename());				
				
				System.out.println("========");
				System.out.println("dsff="+path1);
				System.out.println("========");
				logger.info(file.getCanonicalPath());
				String root = request.getContextPath();

				mpf.get(i).transferTo(file);

			}

			
			// model.addObject("path", PATH);
			String pa=path1 + mpf.get(0).getOriginalFilename();
			HashMap map = new HashMap();
			map.put("path", pname);
			return map;
		} else {
			HashMap map = new HashMap();		
			map.put("path", "실패");
			return map;
			
		}

	}
	//상품 상세보기
	@RequestMapping("/productInfo")
	@ResponseBody
	public HashMap productInfo(ProductVO vo1) {

		ProductVO vo=productService.getProduct(vo1.getProdNo());
		
		HashMap map2 = new HashMap();
		
		map2.put("prodName", vo.getProdName());	
		map2.put("prodContent", vo.getProdContent());	
		map2.put("prodImg", vo.getProdImg());	
		map2.put("prodPrice", vo.getProdPrice());	
		map2.put("prodOrgin", vo.getProdOrgin());	
		map2.put("prodNo", vo.getProdNo());

		return map2;
	}
	
	//상품 업데이트
	@RequestMapping("/productUpdate")
	@ResponseBody
	public int productUpdate(ProductVO vo) {
		
		int num=productService.updateProduct(vo);
		return num;
	}
	//상품 삭제
	@RequestMapping("/productDelete")
	@ResponseBody
	public int productDelete(@RequestParam("prodNo") String prodNo) {
		int num=productService.deleteProduct(prodNo);
		return num;
	}
}
