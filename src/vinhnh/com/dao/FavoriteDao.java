package vinhnh.com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import vinhnh.com.domain.FavoriteList;
import vinhnh.com.model.Favorite;

public class FavoriteDao extends AbstractEntityDao<Favorite>{

	public FavoriteDao() {
		super(Favorite.class);
	}
	
	public int countFavoriteDaoOfUsername(String username){
		EntityManager em = JpaUtils.getEntityManager();
		if (username == null) {
	        return 0;
	    }
		try {
			String jpql = "SELECT COUNT(f) FROM Favorite f WHERE f.user.username = :username";
			Query query = em.createQuery(jpql);
	        query.setParameter("username", username);

	        // Thực hiện truy vấn và trả về kết quả
	        Long result = (Long) query.getSingleResult();
	        return result.intValue(); // Chuyển đổi từ Long sang int
		}finally {
			em.close();
		}
	}
	
	public List<FavoriteList> findAllByUsername(String username){
		if (username == null) {
	        return null;
	    }
		EntityManager em = JpaUtils.getEntityManager();
		List<FavoriteList> list = null;
		try {
			String jpql = "SELECT new vinhnh.com.domain.FavoriteList(f.product.images, f.product.nameProduct, f.product.id, f.product.price) FROM Favorite f WHERE f.user.username = :username";
			
			
			TypedQuery<FavoriteList> query = em.createQuery(jpql, FavoriteList.class);
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
	
	public void delete(String username, int idProduct) {
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			String jpql = "DELETE FROM Favorite f WHERE f.user.id = (SELECT u.id FROM User u WHERE u.username = :username) AND f.product.id = :idProduct";
			Query query = em.createQuery(jpql);
			query.setParameter("username", username);
			query.setParameter("idProduct", idProduct);
			
			query.executeUpdate();
			trans.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			trans.rollback();
		}finally {
			em.close();
		}
	}
}
