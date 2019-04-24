package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IWHUserTypeDao;
import com.app.model.WHUserType;

@Repository
public class WHUserTypeDao implements IWHUserTypeDao{

	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public Integer saveWHUserType(WHUserType wHUserType) {
		return(Integer) ht.save(wHUserType);
	}

	@Override
	public void updateWHUserType(WHUserType wHUserType) {
      ht.update(wHUserType);		
	}

	@Override
	public void deleteWHUseType(Integer id) {
            ht.delete(new WHUserType(id));		
	}

	@Override
	public WHUserType getWHUserTypeByID(Integer id) {
		return  ht.get(WHUserType.class, id);
	}

	@Override
	public List<WHUserType> getAllWHUserType() {
		return  ht.loadAll(WHUserType.class);
	}

	@Override
	public List<Object[]> getWHUserTypeCountByType() {
		String hql=" select userType ,count(userType) "
				    +" from "+WHUserType.class.getName()
				    +" group by userType ";
       List<Object[]> list= (List<Object[]>) ht.find(hql);		
		return list;
	}

}
