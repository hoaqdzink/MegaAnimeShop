package vinhnh.com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import vinhnh.com.domain.CartDetails;
import vinhnh.com.model.Cart;

public class CartDao extends AbstractEntityDao<Cart>{

	public CartDao() {
		super(Cart.class);
	}
	
	public int countCartOfUsername(String username) {
		if (username == null) {
	        return 0;
	    }
	    EntityManager em = JpaUtils.getEntityManager();
	    try {
	        // Sử dụng JPQL để đếm số lượng sản phẩm trong giỏ hàng của người dùng
	        String jpql = "SELECT COUNT(c) FROM Cart c WHERE c.user.username = :username";
	        Query query = em.createQuery(jpql);
	        query.setParameter("username", username);

	        // Thực hiện truy vấn và trả về kết quả
	        Long result = (Long) query.getSingleResult();
	        return result.intValue(); // Chuyển đổi từ Long sang int
	    } finally {
	        em.close(); // Đảm bảo đóng EntityManager sau khi sử dụng xong
	    }
	}
	
	public List<CartDetails> FindAllByUsername(String username){
		if (username == null) {
	        return null;
	    }
		List<CartDetails> list = null;
		EntityManager em = JpaUtils.getEntityManager();
		try {
			String jpql = "SELECT NEW vinhnh.com.domain.CartDetails(c.product.images, c.product.nameProduct, c.product.id, c.product.price, COUNT(*), COUNT(*) * c.product.price) "
					+ "FROM Cart c "
					+ "WHERE c.user.username = :username "
					+ "GROUP BY c.product.images, c.product.nameProduct, c.product.id, c.product.price"
					+ "";
			TypedQuery<CartDetails> query = em.createQuery(jpql,CartDetails.class);
			query.setParameter("username", username);
			list = query.getResultList();
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return list;
	}
	
	public void detelteCart(String username, int idProduct) {
		String jpql = "DELETE FROM Cart c WHERE c.user.id = (SELECT u.id FROM User u WHERE u.username = :username) AND c.product.id = :idProduct";
	    EntityManager em = JpaUtils.getEntityManager();
	    EntityTransaction trans = em.getTransaction();

	    try {
	        trans.begin();

	        Query query = em.createQuery(jpql);
	        query.setParameter("username", username);
	        query.setParameter("idProduct", idProduct);

	        // Thực hiện execute của câu truy vấn DELETE
	        int deletedCount = query.executeUpdate();
        
	        trans.commit();
	    } catch (Exception e) {
	        e.printStackTrace();
	        trans.rollback();
	    } finally {
	        em.close();
	    }
	}


}
