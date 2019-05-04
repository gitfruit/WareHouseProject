package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IWhUserTypeDao;
import com.app.model.WhUserType;

@Repository
public class WhUserTypeDao implements IWhUserTypeDao{

	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public Integer saveWhUserType(WhUserType whUserType) {
		return(Integer) ht.save(whUserType);
	}

	@Override
	public void updateWhUserType(WhUserType whUserType) {
      ht.update(whUserType);		
	}

	@Override
	public void deleteWhUseType(Integer id) {
            ht.delete(new WhUserType(id));		
	}

	@Override
	public WhUserType getWhUserTypeByID(Integer id) {
		return  ht.get(WhUserType.class, id);
	}

	@Override
	public List<WhUserType> getAllWhUserType() {
		return  ht.loadAll(WhUserType.class);
	}

	@Override
	public List<Object[]> getWhUserTypeCountByType() {
		String hql=" select userType ,count(userType) "
				    +" from "+WhUserType.class.getName()
				    +" group by userType ";
       List<Object[]> list= (List<Object[]>) ht.find(hql);		
		return list;
	}

}
