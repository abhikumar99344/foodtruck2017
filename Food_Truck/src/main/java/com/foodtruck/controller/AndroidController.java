package com.foodtruck.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.Session;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.foodtruck.service.EventService;
import com.foodtruck.service.FoodTruckService;
import com.foodtruck.service.MemberService;
import com.foodtruck.service.NoticeService;
import com.foodtruck.service.SellerService;
import com.foodtruck.vo.EventVO;
import com.foodtruck.vo.LicenseVO;
import com.foodtruck.vo.MInquiryVO;
import com.foodtruck.vo.MemberVO;
import com.foodtruck.vo.NoticeVO;
    
@Controller
@RequestMapping("/android")
public class AndroidController<Article> {
	@Autowired
	private NoticeService noticeService;
	@Autowired
	private EventService eventService;
	@Autowired
	private MemberService memberService;
	@Autowired
	private SellerService sellerService;
	@Autowired
	private FoodTruckService ftruckService;
	/* 안드로이드에서 페이징처리 어떻게 할것인지 */

	/* NOTICE */
	@RequestMapping(value = "/notice/{pageNo}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	@ResponseBody
	public String androidNotice(@PathVariable("pageNo") int pageNo) throws Exception {
		System.out.println("android notice connect");

		int page = noticeService.getCountNotice();
		
		
	
		List<NoticeVO> list = noticeService.getNoticeBoardList(pageNo);

		String result = new ObjectMapper().writeValueAsString(list);

		System.out.println("json: " + result);
		int pagecount =noticeService.getCountNotice();
		

		return result;

	}

	/* NOTICE COUNT */
	@RequestMapping(value = "/noticecount", method = RequestMethod.PUT)
	public ResponseEntity<String> androidNoticeCount(@RequestBody NoticeVO vo) throws Exception {
		System.out.println("android notice connect");

		int i = noticeService.countNotice(vo.getNoticeNo());

		return new ResponseEntity<String>(HttpStatus.OK);
	}

	/* EVENT */
	@RequestMapping(value = "/event", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	@ResponseBody
	public String androidEvent() throws Exception {
		System.out.println("android event connect");

		List<EventVO> list = eventService.getEventBoardList(1);

		String result = new ObjectMapper().writeValueAsString(list);

		System.out.println("json: " + result);

		return result;
	}

	/* EVENT COUNT */
	@RequestMapping(value = "/eventcount", method = RequestMethod.PUT)
	public ResponseEntity<String> androidEventCount(@RequestBody EventVO vo) throws Exception {

		if (eventService.countEvent(vo.getEventNo()) <= 1) {
			return new ResponseEntity<String>(HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}

	}

	/* REGISTER */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> androidRegister(@RequestBody MemberVO vo) throws Exception {
		
		System.out.println("register connect");
		memberService.insertMember(vo);
		if(vo.getLicenseNo() != null ) {
			System.out.println("license no empty ");
			LicenseVO lvo = new LicenseVO();
			lvo.setLicenseNo(vo.getLicenseNo());
			lvo.setMemId(vo.getMemberId());
			sellerService.insertLicense(lvo);
		}
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}

	/* LOGIN CHECK */
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json;charset=utf-8", consumes = "application/json;charset=utf-8")
	@ResponseBody
	public String androidLogin(@RequestBody String json) throws Exception {
		System.out.println("login connect");
		System.out.println("json : " + json);
		// Map<String, String> map = new ObjectMapper().readValue(params, Map.class);
		JSONObject jsonObject = new ObjectMapper().readValue(json, JSONObject.class);

		MemberVO mvo = memberService.getMember(jsonObject.get("id").toString());
		System.out.println("mvo : " + mvo);

		String result;

		JSONObject jsonObject2 = new JSONObject();
		JSONObject jsonObject3 = new JSONObject();
		/* 데이터베이스에 사용자가 등록되어있는지 */
		if (mvo != null) {
			/* 비밀번호가 맞는지 */
			if (mvo.getMemberPw().equals(jsonObject.get("pw").toString())) {

				jsonObject2.put("licenseNo", mvo.getLicenseNo());
				jsonObject2.put("memId", mvo.getMemberId());
				jsonObject2.put("memberId", mvo.getMemberId());
				jsonObject2.put("memberName", mvo.getMemberName());
				jsonObject2.put("memberTel", mvo.getMemberTel());
				jsonObject2.put("memberAuth", mvo.getMemberAuth());
				jsonObject2.put("mileage", mvo.getMileage());

				jsonObject3.put("data", jsonObject2);
				jsonObject3.put("userinfo", "1");
				// result = new ObjectMapper().writeValueAsString(mvo);

				System.out.println(jsonObject3.toJSONString());
				/* mvo(데이터베이스정보)를 json을 안드로이드에 전달.하고 로그인이 성공했다고 알려주기 */
				return jsonObject3.toJSONString();
			} else {
				/* 비밀번호가 틀렸을때 */
				jsonObject2.put("userinfo", "0");
				System.out.println(jsonObject3.toJSONString());
				return jsonObject3.toJSONString();
			}

		} else {
			/* 없는 사용자일때 */
			jsonObject3.put("userinfo", "0");
			System.out.println(jsonObject3.toJSONString());
			return jsonObject3.toJSONString();
		}

		/*
		 * 안드로이드 : 서버에 로그인정보를 post로 보낸다. 서버: 아이디와 비밀번호가 데이터베이스의 정보와 같으면 jwt 토큰을 생성한 후
		 * 클라이언트에게 전달한다. 안드로이드 : 전달받은 토큰을 sqlite 에 저장한다. 안드로이드2 : 권한이 필요한 페이지가 있을경우 서버에
		 * 요청하면서 헤더에 발급받은 jwt토큰을 보낸다. 서버 : jwt 토큰이 맞는지 확인 후 정보를 맞으면 정보를 주고 아니면 권한이 없다고
		 * 알려준다.
		 */

	}
	/* idcheck */
	@RequestMapping(value = "/idcheck/{id:.+}", method = RequestMethod.GET)
	@ResponseBody
	public String checkId(@PathVariable("id") String id) throws Exception {
		System.out.println("inqueryinfo connect" + " : " + id);

		JSONObject json = new ObjectMapper().readValue(id, JSONObject.class);
		
		MemberVO vo = memberService.getMember(json.get("id").toString());
		
		if(vo !=null) {
			return "id";	
		}else {
			return "checked";
		}
	}
	
	/* 푸드트럭과 상품보여주기 */
	
	
	/* 푸드트럭 검색기능 */
	/* 푸드트럭 상세보기 기능 */
	/* 푸드트럭 위치 지도로 보여주는 기능 */

}
