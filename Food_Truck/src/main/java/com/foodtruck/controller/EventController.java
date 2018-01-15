package com.foodtruck.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.foodtruck.service.EventService;
import com.foodtruck.service.MemberService;
import com.foodtruck.vo.EventVO;
import com.foodtruck.vo.MemberVO;

@Controller
public class EventController {
	
	@Autowired
	EventService eventService;
	
	@Autowired
	MemberService memberService;
	
	// ��������
	@RequestMapping("/eventBoard")
	public String getEventBoardList(Model model, HttpServletResponse response, HttpSession session, MemberVO mvo, HttpServletRequest request) {
		List<EventVO> list = eventService.getEventBoardList();
		
		if(list != null) {
			model.addAttribute("rank", list);
		}
		
		return "nav/eventBoard";
	}
	
	// �������� ��
	@RequestMapping("/detailEventForm")
	public String detailEventForm(@RequestParam("noticeNo")int noticeNo, HttpServletRequest request) {
		EventVO vo = eventService.getEvent(noticeNo);
		
		request.setAttribute("vo", vo);
		
		eventService.countEvent(vo.getNoticeNo()); // ��ȸ��
		
		return "nav/detailEventForm";
	}
	
	
	// �������� �۾���
	@RequestMapping("/writeEventForm")
	public String writeEvent() {
		return "nav/writeEventForm";
	}
	
	
	// �������� ���
	@RequestMapping("/insertEvent")
	public String insertEvent(HttpSession session, EventVO vo, MemberVO mvo) {
		
		MemberVO m = (MemberVO)session.getAttribute("member");
		vo.setMemberId(m.getMemberId());
		
//		vo.setMemberId(mvo.getMemberId());
		
		eventService.insertEvent(vo);
		return "redirect:/eventBoard";
	}

	
	// �������� ���� ��
	@RequestMapping("/updateEventForm")
	public String updateEventForm(HttpServletRequest request, @RequestParam("noticeNo")int noticeNo) {
		EventVO vo = eventService.getEvent(noticeNo);
		request.setAttribute("event", vo);
		return "nav/updateEventForm";
	}
	
	
	// �������� ����
	@RequestMapping("/updateEvent")
	public String updateEvent(EventVO vo) {
		eventService.updateEvent(vo);
		
		System.out.println("update Controller");
		return "redirect:/eventBoard";
	}
	
	
	// �������� ����
	@RequestMapping("/deleteEvent")
	public String deleteEvent(EventVO vo) {
		eventService.deleteEvent(vo);
		
		return "redirect:/eventBoard";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
