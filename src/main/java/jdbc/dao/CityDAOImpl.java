package jdbc.dao;

import jdbc.config.HibernateSessionFactoryUtil;
import jdbc.model.City;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CityDAOImpl implements CityDAO {
    @Override
    public void create(City city) {

        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {

            Transaction transaction = session.beginTransaction();
            session.save(city);
            transaction.commit();
        }

    }

    @Override
    public City getById(int id) {

        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {

            return session.get(City.class, id);
        }

    }

    @Override
    public List<City> getAllEmployees() {

        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {

            return session.createQuery("FROM City").list();
        }
    }

    @Override
    public void updateById(City city) {

        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {

            Transaction transaction = session.beginTransaction();
            session.update(city);
            transaction.commit();
        }

    }

    @Override
    public void deleteById(City city) {

        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {

            Transaction transaction = session.beginTransaction();
            session.delete(city);
            transaction.commit();
        }

    }
}
