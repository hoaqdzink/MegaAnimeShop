package vinhnh.com.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import vinhnh.com.domain.ProductsSoilInMonths;
import vinhnh.com.domain.StatusOrder;
import vinhnh.com.domain.Top5BestSellingProducts;
import vinhnh.com.domain.Top5MostPurchasedMegaAnime;

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
	
	public List<Top5MostPurchasedMegaAnime> mostPurchasedMegaAnimes(){
		String jpql="SELECT new vinhnh.com.domain.Top5MostPurchasedMegaAnime(p.mageAnime, SUM(i.quantity)) "
				+ "FROM Product p "
				+ "JOIN Invoice i ON p.id = i.product.id "
				+ "GROUP BY p.mageAnime "
				+ "ORDER BY SUM(i.quantity) DESC";
		EntityManager em = JpaUtils.getEntityManager();
	    List<Top5MostPurchasedMegaAnime> list = null;
	    try {
	        TypedQuery<Top5MostPurchasedMegaAnime> query = em.createQuery(jpql, Top5MostPurchasedMegaAnime.class);
	        query.setMaxResults(5);
	        list = query.getResultList();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        em.close();
	    }
	    
	    return list;
	}
	
	public List<ProductsSoilInMonths> productsSoilInMonths(){
		String jpql = "SELECT new vinhnh.com.domain.ProductsSoilInMonths(MONTH(i.createDate), COUNT(i.product.id)) "
	            + "FROM Invoice i "
	            + "JOIN SttOder s ON i.id = s.invoice.id "
	            + "WHERE s.statuss = :statuss "
	            + "GROUP BY MONTH(i.createDate) "
	            + "ORDER BY MONTH(i.createDate)";


	    EntityManager em = JpaUtils.getEntityManager();
	    List<ProductsSoilInMonths> list = null;
	    try {
	        TypedQuery<ProductsSoilInMonths> query = em.createQuery(jpql, ProductsSoilInMonths.class);
	     // Thiết lập giá trị cho tham số ":statuss"
	        query.setParameter("statuss", "Đã giao");
	        list = query.getResultList();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        em.close();
	    }
	    
	    return list;
	}
	
	public List<StatusOrder> statusOrders(){
		String jpql = "SELECT new vinhnh.com.domain.StatusOrder(s.statuss, COUNT(s)) "
				+ "FROM SttOder s "
				+ "GROUP BY s.statuss";	

	    EntityManager em = JpaUtils.getEntityManager();
	    List<StatusOrder> list = null;
	    try {
	        TypedQuery<StatusOrder> query = em.createQuery(jpql, StatusOrder.class);
	        list = query.getResultList();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        em.close();
	    }
	    
	    return list;
	}
	
	public BigDecimal totalPriceMonth() {
        String jpql ="SELECT SUM(i.totalMoney) FROM Invoice i JOIN SttOder s ON i.id = s.invoice.id "
                + "WHERE MONTH(s.createDate) = MONTH(CURRENT_DATE()) AND YEAR(s.createDate) = YEAR(CURRENT_DATE()) "
                + "AND s.statuss = :statuss ";
        EntityManager em = JpaUtils.getEntityManager();
        
        TypedQuery<BigDecimal> query = em.createQuery(jpql, BigDecimal.class);
        // Đặt tham số cho statuss, bạn cần đảm bảo tham số này đã được thiết lập trước khi thực hiện truy vấn
        query.setParameter("statuss", "Đã giao");

        // Lấy kết quả về
        BigDecimal total = query.getSingleResult();

        // Đóng EntityManager sau khi sử dụng xong
        em.close();

        return total;
    }
	
	public BigDecimal totalPrice() {
        String jpql ="SELECT SUM(i.totalMoney) FROM Invoice i JOIN SttOder s ON i.id = s.invoice.id "
                + "WHERE s.statuss = :statuss ";
        EntityManager em = JpaUtils.getEntityManager();
        
        TypedQuery<BigDecimal> query = em.createQuery(jpql, BigDecimal.class);
        // Đặt tham số cho statuss, bạn cần đảm bảo tham số này đã được thiết lập trước khi thực hiện truy vấn
        query.setParameter("statuss", "Đã giao");

        // Lấy kết quả về
        BigDecimal total = query.getSingleResult();

        // Đóng EntityManager sau khi sử dụng xong
        em.close();

        return total;
    }
}
