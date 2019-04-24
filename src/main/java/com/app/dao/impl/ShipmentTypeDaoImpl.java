package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IShipmentTypeDao;
import com.app.model.ShipmentType;

@Repository
public class ShipmentTypeDaoImpl implements IShipmentTypeDao{

	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public Integer saveShipmentType(ShipmentType st) {
		return (Integer)ht.save(st);
	}

	@Override
	public void updateShipmentType(ShipmentType st) {
             ht.update(st);		
	}

	@Override
	public void deleteShipmentType(Integer id) {
            ht.delete(new ShipmentType(id));		
	}

	@Override
	public ShipmentType getShipmentTypeId(Integer id) {
            
		return ht.get(ShipmentType.class,id);
	}

	@Override
	public List<ShipmentType> getAllShipmentTypes() {
          
		return  ht.loadAll(ShipmentType.class);
	}

	@Override
	public List<Object[]> getShipmentCountByMode() {

		/*String hql=" select shipmentMode,count(shipmentMode) "
				   +"  from " + ShipmentType.class.getName()
				   +"  group by shipmentMode ";
		
		List<Object[]> list=(List<Object[]>)ht.find(hql);
		*/
		DetachedCriteria dc=DetachedCriteria.forClass(ShipmentType.class);
		dc.setProjection(Projections.projectionList().
				add(Projections.groupProperty("shipmentMode")).
				add(Projections.count("shipmentMode")));
		List<Object[]> list=(List<Object[]>)ht.findByCriteria(dc);
		return list;
	
	}

	
}
