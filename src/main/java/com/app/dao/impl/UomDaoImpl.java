package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IUomDao;
import com.app.model.Uom;

@Repository
public class UomDaoImpl implements IUomDao{

	@Autowired
	private HibernateTemplate ht;
	@Override
	public Integer saveUom(Uom uom) {
		return (Integer)ht.save(uom);
	}

	@Override
	public void updateUom(Uom uom) {
            ht.update(uom);		
	}

	@Override
	public void deleteUom(Integer id) {
             
             ht.delete(new Uom(id));
	}

	@Override
	public Uom getUomById(Integer id) {
		 return ht.get(Uom.class, id);
	}

	@Override
	public List<Uom> getAllUoms() {
		return ht.loadAll(Uom.class);
	}

	@Override
	public List<Object[]> getUomCountByType() {
		String hql=" select uomType,count(uomType) "+" from "
		+ Uom.class.getName() +" group by uomType ";
		List<Object[]> list=(List<Object[]>) ht.find(hql);
		return list;
	}
	

	
}
