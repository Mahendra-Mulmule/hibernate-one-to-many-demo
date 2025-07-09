package Student_service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import code.Hibernateutil;
import code.Student;

import java.util.List;

public class Studentservice {

    private SessionFactory sessionFactory = Hibernateutil.getSessionFactory();

    public void saveStudent(Student student) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(student);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Student getbyid(Long studentid) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Student.class, studentid);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Student updateStudent(long studentid, Student student) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            Student oldstudent = session.get(Student.class, studentid);
            if (oldstudent != null) {
                oldstudent.setStud_name(student.getStud_name());
                oldstudent.setFathername(student.getFathername());
                session.merge(oldstudent);
            }
            tx.commit();
            return oldstudent;
        }
    }

    public void deleteStudent(long studentid) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            Student student = session.get(Student.class, studentid);
            if (student != null) {
                session.remove(student);
            }
            tx.commit();
        }
    }

    public List<Student> getAllStudents() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Student", Student.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }
}
