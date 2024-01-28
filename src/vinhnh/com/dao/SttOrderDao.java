package vinhnh.com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import vinhnh.com.domain.OrderStatus;
import vinhnh.com.model.SttOder;

public class SttOrderDao extends AbstractEntityDao<SttOder>{

	public SttOrderDao() {
		super(SttOder.class);
	}
	
	public List<OrderStatus> findAllOrderUser(String username){
		String jpql ="SELECT new vinhnh.com.domain.OrderStatus(s.id,s.invoice.id, s.invoice.product.nameProduct, s.invoice.product.id, s.invoice.product.price, s.invoice.quantity, s.invoice.totalMoney, s.invoice.createDate, s.statuss, s.descriptions) "
				+ "FROM SttOder s WHERE s.user.username = :username";
		EntityManager em = JpaUtils.getEntityManager();
		List<OrderStatus> list = null;
		
		try {
			TypedQuery<OrderStatus> query = em.createQuery(jpql,OrderStatus.class);
			query.setParameter("username", username);
			list = query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			em.close();
		}
		return list;
	}
	
	public List<SttOder> orderStatus(String status){
		String jpql ="SELECT s FROM SttOder s WHERE s.statuss = :status";
		EntityManager em = JpaUtils.getEntityManager();
		List<SttOder> list = null;
		try {
			TypedQuery<SttOder> query = em.createQuery(jpql, SttOder.class);
			query.setParameter("status", status);
			list = query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			em.close();
		}
		return list;
	}
}
