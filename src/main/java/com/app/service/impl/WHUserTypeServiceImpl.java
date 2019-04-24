package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IWHUserTypeDao;
import com.app.model.WHUserType;
import com.app.service.IWHUserTypeService;

@Service
public class WHUserTypeServiceImpl implements IWHUserTypeService{

	@Autowired
	private IWHUserTypeDao dao;
	

	@Transactional
	public Integer saveWHUserType(WHUserType wHUserType) {
		return dao.saveWHUserType(wHUserType);
	}


	@Transactional
	public void updateWHUserType(WHUserType wHUserType) {
           dao.updateWHUserType(wHUserType);		
	}


	@Transactional
	public void deleteWHUseType(Integer id) {
            dao.deleteWHUseType(id);
	}


	@Transactional(readOnly=true)
	public WHUserType getWHUserTypeByID(Integer id) {
		return dao.getWHUserTypeByID(id);
	}


	@Transactional(readOnly=true)
	public List<WHUserType> getAllWHUserType() {
		return  dao.getAllWHUserType();
	}


	@Override
	@Transactional(readOnly=true)
	public List<Object[]> getWHUserTypeCountByType() {
		return dao.getWHUserTypeCountByType();
	}

}
