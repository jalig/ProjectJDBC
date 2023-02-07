package jdbc.dao;

import jdbc.model.City;
import jdbc.model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

enum Queries {
    GET("SELECT * FROM employee INNER JOIN city ON employee.city_id = city.city_id WHERE id = (?)"),
    GET_ALL("SELECT * FROM employee INNER JOIN city ON employee.city_id = city.city_id"),
    INSERT("INSERT INTO employee (first_name, last_name, gender, age, city_id) VALUES ((?), (?), (?), (?), (?))"),
    UPDATE ("UPDATE employee SET first_name = (?), last_name = (?), gender = (?), age = (?), city_id = (?) WHERE id = (?)"),
    DELETE("DELETE FROM employee WHERE id = (?)");

    final String query;

    Queries(String query) {
        this.query = query;
    }
}

public class EmployeeDAOImpl implements EmployeeDAO {
    private Connection connection;

    public EmployeeDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Employee employee) {
        try (PreparedStatement statement = connection.prepareStatement(Queries.INSERT.query)) {

            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getLastName());
            statement.setString(3, employee.getGender());
            statement.setInt(4, employee.getAge());
            statement.setInt(5, employee.getCity().getId());
            statement.executeQuery();

        } catch (SQLException e) {

        }
    }

    @Override
    public Employee getById(int id) {
        Employee employee = new Employee();

        try (PreparedStatement statement = connection.prepareStatement(Queries.GET.query)) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                employee.setId(resultSet.getInt("id"));
                employee.setFirstName(resultSet.getString("first_name"));
                employee.setLastName(resultSet.getString("last_name"));
                employee.setGender(resultSet.getString("gender"));
                employee.setAge(resultSet.getInt("age"));
                employee.setCity(new City((resultSet.getInt("city_id")),
                        (resultSet.getString("city_name"))));
            }

        } catch (SQLException e) {
        }
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(Queries.GET_ALL.query)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String gender = resultSet.getString("gender");
                int age = resultSet.getInt("age");
                City city = new City((resultSet.getInt("city_id")),
                        (resultSet.getString("city_name")));

                employees.add(new Employee(id, firstName, lastName, gender, age, city));
            }

        } catch (SQLException e) {
        }
        return employees;
    }

    @Override
    public void updateById(int id, String firstName, String lastName, String gender, int age, int cityId) {
        try (PreparedStatement statement = connection.prepareStatement(Queries.UPDATE.query)) {
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, gender);
            statement.setInt(4, age);
            statement.setInt(5, cityId);
            statement.setInt(6, id);

            statement.execute();

        } catch (SQLException e) {
        }

    }

    @Override
    public void deleteById(int id) {
        try (PreparedStatement statement = connection.prepareStatement(Queries.DELETE.query)) {
            statement.setInt(1, id);
            statement.execute();

        } catch (SQLException e) {

        }
    }
}
