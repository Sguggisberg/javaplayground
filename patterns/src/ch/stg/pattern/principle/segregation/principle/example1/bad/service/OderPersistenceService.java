package ch.stg.pattern.principle.segregation.principle.example1.bad.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ch.stg.pattern.principle.segregation.principle.example1.bad.entity.Order;

public class OderPersistenceService implements PersistenceService<Order> {

	private static final Map<Long, Order> ORDERS = new HashMap<>();

	@Override
	public void save(Order entity) {
		synchronized (ORDERS) {
			ORDERS.put(entity.getId(), entity);
		}
	}

	@Override
	public void delete(Order entity) {
		synchronized (ORDERS) {
			ORDERS.remove(entity.getId());
		}
	}

	@Override
	public Order findById(Long id) {
		return ORDERS.get(id);
	}

	@Override
	public List<Order> findByName(String name) {
		throw new UnsupportedOperationException("Not supported");
	}

}
