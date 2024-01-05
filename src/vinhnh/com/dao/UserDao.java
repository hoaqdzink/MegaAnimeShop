package vinhnh.com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import vinhnh.com.model.User;

public class UserDao extends AbstractEntityDao<User>{

	public UserDao() {
		super(User.class);
	}
	
	// Phương thức tìm kiếm theo username
    public User findByUsername(String username) {
        EntityManager em = JpaUtils.getEntityManager();

        try {
            TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class);
            query.setParameter("username", username);
            query.setMaxResults(1);

            List<User> resultList = query.getResultList();
            return resultList.isEmpty() ? null : resultList.get(0);
        } finally {
            em.close();
        }
    }
    
    public User findByEmail(String mail) {
    	EntityManager em = JpaUtils.getEntityManager();
    	try {
			TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.email = :mail",User.class);
			query.setParameter("mail", mail);
			return query.getSingleResult();
    	} catch (NoResultException e) {
			return null; // Trả về null nếu không tìm thấy kết quả
		} finally {
			em.close();
		}
    }

}
