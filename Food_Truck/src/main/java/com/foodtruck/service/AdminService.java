package com.foodtruck.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodtruck.dao.AdminDAO;
import com.foodtruck.vo.AdminVO;

@Service
public class AdminService {
	@Autowired
	private SqlSessionTemplate sessionTemplate;

	// ������ ����
	public AdminVO getAdmin(String AdminId) {
		AdminDAO dao = sessionTemplate.getMapper(AdminDAO.class);
		return dao.getAdmin(AdminId);
	}
//
//	// ������ ����Ʈ
//	public List<AdminVO> getAdminList() {
//		AdminDAO dao = sessionTemplate.getMapper(AdminDAO.class);
//		return dao.getAdminList();
//	}
//
//	// ������ �Է�
//	public int insertAdmin(AdminVO vo) {
//		AdminDAO dao = sessionTemplate.getMapper(AdminDAO.class);
//		return dao.insertAdmin(vo);
//	}
//
//	// ������ ����
//	public int updateAdmin(AdminVO vo) {
//		AdminDAO dao = sessionTemplate.getMapper(AdminDAO.class);
//		return dao.updateAdmin(vo);
//	}
//
//	// ������ ����
//	public int deleteAdmin(String AdminId) {
//		AdminDAO dao = sessionTemplate.getMapper(AdminDAO.class);
//		return dao.deleteAdmin(AdminId);
//	}

}
