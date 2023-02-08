package jdbc.dao;

import jdbc.model.City;
import jdbc.model.Employee;

import java.util.List;

public interface CityDAO {
    void create(City city);

    City getById(int id);

    List<City> getAllEmployees();

    void updateById(City city);

    void deleteById(City city);
}
