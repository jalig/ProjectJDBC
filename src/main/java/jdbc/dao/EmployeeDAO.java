package jdbc.dao;

import jdbc.model.Employee;

import java.util.List;

public interface EmployeeDAO {
    void create(Employee employee);

    Employee getById(int id);

    List<Employee> getAllEmployees();

    void updateById(int id, String firstName, String lastName, String gender, int age, int cityId);
    void deleteById(int id);


}
