package jdbc.dao;

import jdbc.model.Employee;

import java.util.List;

public interface EmployeeDAO {
    void create(Employee employee);

    Employee getById(int id);

    List<Employee> getAllEmployees();

    void updateById(Employee employee);

    void deleteById(Employee employee);


}
