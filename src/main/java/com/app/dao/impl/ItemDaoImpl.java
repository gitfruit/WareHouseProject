package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IItemDao;
import com.app.model.Item;

@Repository	
public class ItemDaoImpl implements IItemDao {

	@Autowired
	private HibernateTemplate ht;
	@Override
	public Integer saveItem(Item item) {
		return (Integer)ht.save(item);
	}
	@Override
	public void deleteItem(Integer id) {
              ht.delete(new Item(id));		
	}
	@Override
	public void updateItem(Item item) {
              ht.update(item);
	}
	@Override
	public Item getItemsById(Integer id) {
		return ht.get(Item.class, id);
	}
	@Override
	public List<Item> getAllItems() {
		return ht.loadAll(Item.class);
	}
	@Override
	public List<Object[]> getItemCountByBaseCurrency() {
		    @SuppressWarnings("unchecked")
			List<Object[]> lt=  (List<Object[]>) ht.findByCriteria(DetachedCriteria.forClass(Item.class)
		    		   .setProjection(Projections.projectionList()
		    		   .add(Projections.groupProperty("baseCurrency"))
		    		   .add(Projections.count("baseCurrency"))
		    		  ));
		     
		return    lt;
	}

}