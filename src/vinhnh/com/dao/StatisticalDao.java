package vinhnh.com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import vinhnh.com.domain.Top5BestSellingProducts;

public class StatisticalDao {
	public List<Top5BestSellingProducts> top5BestSellingProduct(){
	    String jpql ="SELECT new vinhnh.com.domain.Top5BestSellingProducts(p.nameProduct, COUNT(i.id)) "
	            + "FROM Product p "
	            + "JOIN Invoice i ON p.id = i.product.id "  // Đảm bảo có điều kiện kết nối giữa Product và Invoice
	            + "GROUP BY p.nameProduct "
	            + "ORDER BY COUNT(i.id) DESC";
	    EntityManager em = JpaUtils.getEntityManager();
	    List<Top5BestSellingProducts> list = null;
	    try {
	        TypedQuery<Top5BestSellingProducts> query = em.createQuery(jpql, Top5BestSellingProducts.class);
	        query.setMaxResults(5);
	        list = query.getResultList();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        em.close();
	    }
	    
	    return list;
	}
}
