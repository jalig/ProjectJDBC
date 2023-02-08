package jdbc.dao;

import jdbc.config.HibernateSessionFactoryUtil;
import jdbc.model.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;


public class EmployeeDAOImpl implements EmployeeDAO {
    public EmployeeDAOImpl() {
    }

    @Override
    public void create(Employee employee) {

        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {

            Transaction transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();

        }
    }

    @Override
    public Employee getById(int id) {

        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {

            return session.get(Employee.class, id);
        }
    }

    @Override
    public List<Employee> getAllEmployees() {

        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {

            return session.createQuery("FROM Employee").list();
        }
    }

    @Override
    public void updateById(Employee employee) {

        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
        }
    }

    @Override
    public void deleteById(Employee employee) {

        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(employee);
            transaction.commit();
        }
    }
}
