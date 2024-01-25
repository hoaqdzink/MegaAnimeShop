package vinhnh.com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import vinhnh.com.model.Product;

public class ProductDao extends AbstractEntityDao<Product>{

	public ProductDao() {
		super(Product.class);
		// TODO Auto-generated constructor stub
	}
	
	public List<Product> productMegaAnime(String mageAnime) {
		String jpql = "SELECT p FROM Product p WHERE p.mageAnime = :mageAnime";
		
		EntityManager em = JpaUtils.getEntityManager();
		List<Product> list = null;
		
		try {
			TypedQuery<Product> query = em.createQuery(jpql,Product.class);
			query.setParameter("mageAnime", mageAnime);
			list = query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			em.close();
		}
		
		return list;
    }
	
	public List<String> category() {
	    String jpql = "SELECT DISTINCT mageAnime FROM Product";
	    
	    EntityManager em = JpaUtils.getEntityManager();
	    List<String> list = null;
	    
	    try {
	        TypedQuery<String> query = em.createQuery(jpql, String.class);
	        list = query.getResultList();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        em.close();
	    }
	    return list;
	}
	
	public List<Product> relatedProducts(String mageAnime) {
		String jpql = "SELECT p FROM Product p WHERE p.mageAnime = :mageAnime ORDER BY NEWID()";
		
		EntityManager em = JpaUtils.getEntityManager();
		List<Product> list = null;
		
		try {
			TypedQuery<Product> query = em.createQuery(jpql,Product.class);
			query.setParameter("mageAnime", mageAnime);
			list = query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			em.close();
		}
		
		return list;
    }
	
	public List<Product> relatedProducts(String mageAnime, int firstResult, int maxResult) {
	    String jpql = "SELECT p FROM Product p WHERE p.mageAnime = :mageAnime";

	    EntityManager em = JpaUtils.getEntityManager();
	    List<Product> list = null;

	    try {
	        TypedQuery<Product> query = em.createQuery(jpql, Product.class);
	        query.setParameter("mageAnime", mageAnime);
	        query.setFirstResult(firstResult);
	        query.setMaxResults(maxResult);
	        list = query.getResultList();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        em.close();
	    }

	    return list;
	}
	
	public int count(String mageAnime) {
	    EntityManager em = JpaUtils.getEntityManager();
	    try {
	        String jpql = "SELECT COUNT(p) FROM Product p WHERE p.mageAnime = :mageAnime";

	        TypedQuery<Long> query = em.createQuery(jpql, Long.class);
	        query.setParameter("mageAnime", mageAnime);

	        return query.getSingleResult().intValue();
	    } finally {
	        em.close();
	    }
	}
	
	public List<Product> search(String search) {
		String jpql = "SELECT p FROM Product p WHERE p.characterName LIKE :search "
    	        + "OR p.mageAnime LIKE :search OR p.nameProduct LIKE :search";

	    EntityManager em = JpaUtils.getEntityManager();
	    List<Product> list = null;
	    try {
	        TypedQuery<Product> query = em.createQuery(jpql, Product.class);
	        query.setParameter("search", "%" + search + "%");
	        
	       list = query.getResultList();
	    } finally {
	        em.close();
	    }
	    return list;
	}


}
