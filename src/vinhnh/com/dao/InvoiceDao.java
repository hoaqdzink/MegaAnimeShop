package vinhnh.com.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import vinhnh.com.model.Invoice;

public class InvoiceDao extends AbstractEntityDao<Invoice>{

	public InvoiceDao() {
		super(Invoice.class);
	}
	
	public int insertKey(Invoice invoice) {
        EntityManager em = JpaUtils.getEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.persist(invoice);
            trans.commit();

            // Lấy giá trị ID sau khi commit
            int generatedId = invoice.getId();
            
            return generatedId;
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            throw e;
        } finally {
            em.close();
        }
    }
}

