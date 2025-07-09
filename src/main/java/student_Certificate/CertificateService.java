
	package student_Certificate;
	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.hibernate.Transaction;

import code.Hibernateutil;


	public class CertificateService {

	    private SessionFactory sessionFactory = Hibernateutil.getSessionFactory();

	    public void saveCertificate(Certificate certificate) {
	        try (Session session = sessionFactory.openSession()) {
	            Transaction tx = session.beginTransaction();
	            session.persist(certificate);
	            tx.commit();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}



