package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IWhUserTypeDao;
import com.app.model.WhUserType;
import com.app.service.IWhUserTypeService;

@Service
public class WhUserTypeServiceImpl implements IWhUserTypeService{

	@Autowired
	private IWhUserTypeDao dao;
	

	@Transactional
	public Integer saveWhUserType(WhUserType whUserType) {
		return dao.saveWhUserType(whUserType);
	}


	@Transactional
	public void updateWhUserType(WhUserType whUserType) {
           dao.updateWhUserType(whUserType);		
	}


	@Transactional
	public void deleteWhUseType(Integer id) {
            dao.deleteWhUseType(id);
	}


	@Transactional(readOnly=true)
	public WhUserType getWhUserTypeByID(Integer id) {
		return dao.getWhUserTypeByID(id);
	}


	@Transactional(readOnly=true)
	public List<WhUserType> getAllWhUserType() {
		return  dao.getAllWhUserType();
	}


	@Override
	@Transactional(readOnly=true)
	public List<Object[]> getWhUserTypeCountByType() {
		return dao.getWhUserTypeCountByType();
	}

}
