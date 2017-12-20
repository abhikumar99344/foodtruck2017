package com.foodtruck.dao;

import java.util.List;
import com.foodtruck.vo.FoodTruckVO;

public interface FoodTruckDAO {
	
	// Ǫ��Ʈ�� ����
	public FoodTruckVO getFoodTruck(String licenseNo)throws Exception;

	// Ǫ��Ʈ�� ����Ʈ
	public List<FoodTruckVO> getFoodTruckList()throws Exception;
	
	// ī�װ��� ����Ʈ
	public List<FoodTruckVO> getCategoryList(int category)throws Exception;

	// Ǫ��Ʈ�� ���
	public int insertFoodTruck(FoodTruckVO vo)throws Exception;

	// Ǫ��Ʈ�� ����
	public int updateTruck(FoodTruckVO vo)throws Exception;

	// Ǫ��Ʈ�� ����
	public int deleteTruck(String licenseNo)throws Exception;
}
