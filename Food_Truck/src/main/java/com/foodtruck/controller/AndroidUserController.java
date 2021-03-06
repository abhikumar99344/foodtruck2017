package com.foodtruck.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.foodtruck.service.MemberService;
import com.foodtruck.service.SellerService;
import com.foodtruck.vo.MInquiryVO;

@Controller
@RequestMapping("/android")
public class AndroidUserController {

	@Autowired
	private MemberService memberService;
	@Autowired
	private SellerService sellerService;

	/* 문의하기 */
	// MemberController - memberinquriy 메소드, MinquiryVO, MinquiryReplyVO
	@RequestMapping(value = "/user/memberinquiry", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<String> androidinquriy(@RequestBody MInquiryVO vo) throws Exception {
		System.out.println("inquiry connect");

		if (vo.getOrdNo() != null) {
			memberService.insertInquiry(vo);
		} else if (vo.getLicenseNo() != null) {
			memberService.insertInquiry2(vo);
		} else {

		}

		return new ResponseEntity<String>(HttpStatus.OK);

	}

	/* 문의내역 */
	@RequestMapping(value = "/user/inqueryinfo/{id:.+}", method = RequestMethod.GET, produces = "application/json;charset=utf-8", consumes = "application/json;charset=utf-8")
	@ResponseBody
	public String androidInquriyInfo(@PathVariable("id") String id) throws Exception {
		System.out.println("inqueryinfo connect" + " : " + id);

		JSONObject json = new ObjectMapper().readValue(id, JSONObject.class);

		List<MInquiryVO> list = memberService.getSellerQaSelInfoList(json.get("id").toString());

		if (list != null) {
			String result = new ObjectMapper().writeValueAsString(list);

			System.out.println("json: " + result);

			return result;
		} else {
			return null;
		}

	}

	/* 주문하기 */
	/* 주문내역 */
	/* 주문한제품 상태 변경되면 알림 */
	/* 평점, 댓글 달기 */

}
