package com.foodtruck.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodtruck.dao.FoodTruckDAO;
import com.foodtruck.vo.FoodTruckVO;

@Service
public class FoodTruckService {
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	//Ǫ��Ʈ�� ����
	public FoodTruckVO getFoodTruck(int ftruckNo) throws Exception {
		FoodTruckDAO dao = sessionTemplate.getMapper(FoodTruckDAO.class);
		return dao.getFoodTruck(ftruckNo);
	}
	//Ǫ��Ʈ�� ����Ʈ
	public List<FoodTruckVO> getFoodTruckList() throws Exception{
		FoodTruckDAO dao = sessionTemplate.getMapper(FoodTruckDAO.class);
		return dao.getFoodTruckList();
	}
	//Ǫ��Ʈ�� �Է�
	public int insertFoodTruck(FoodTruckVO vo) throws Exception{
		FoodTruckDAO dao = sessionTemplate.getMapper(FoodTruckDAO.class);
		return dao.insertFoodTruck(vo);
	}
	//Ǫ��Ʈ�� ����
	public int updateFoodTruck(FoodTruckVO vo) throws Exception {
		FoodTruckDAO dao = sessionTemplate.getMapper(FoodTruckDAO.class);
		return dao.updateTruck(vo);
	}
	//Ǫ��Ʈ�� ����
	public int deleteFoodTruck(int ftruckNo) throws Exception{
		FoodTruckDAO dao = sessionTemplate.getMapper(FoodTruckDAO.class);
		return dao.deleteTruck(ftruckNo);
	}

}
