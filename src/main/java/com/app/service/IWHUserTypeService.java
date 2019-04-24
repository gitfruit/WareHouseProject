package com.app.service;

import java.util.List;

import com.app.model.WHUserType;

public interface IWHUserTypeService {

	public Integer saveWHUserType(WHUserType wHUserType);
	public void updateWHUserType(WHUserType wHUserType);
	public void deleteWHUseType(Integer id);
	public WHUserType getWHUserTypeByID(Integer id);
	public List<WHUserType> getAllWHUserType();
	public List<Object[]> getWHUserTypeCountByType();

}
