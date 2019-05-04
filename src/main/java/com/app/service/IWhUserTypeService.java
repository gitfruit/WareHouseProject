package com.app.service;

import java.util.List;

import com.app.model.WhUserType;

public interface IWhUserTypeService {

	public Integer saveWhUserType(WhUserType whUserType);
	public void updateWhUserType(WhUserType whUserType);
	public void deleteWhUseType(Integer id);
	public WhUserType getWhUserTypeByID(Integer id);
	public List<WhUserType> getAllWhUserType();
	public List<Object[]> getWhUserTypeCountByType();

}
