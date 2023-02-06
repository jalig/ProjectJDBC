package jdbc;

import jdbc.dao.EmployeeDAO;
import jdbc.dao.EmployeeDAOImpl;
import jdbc.model.City;
import jdbc.model.Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Application {
    public static void main(String[] args) {
        final String user = "postgres";
        final String pass = "369303253";
        final String url = "jdbc:postgresql://localhost:5432/skypro";

        try (final Connection connection = DriverManager.getConnection(url, user, pass)) {

            EmployeeDAO employeeDAO = new EmployeeDAOImpl(connection);

            City city = new City(5, "Саратов");
            Employee denzel = new Employee("Denzel", "Washington", "male", 68, city);

//            employeeDAO.create(denzel);
//            System.out.println(employeeDAO.getById(2));
//            System.out.println(employeeDAO.getAllEmployees());
//            employeeDAO.updateById(4, "Valera", "Semenov", "male", 21, 4);
//            employeeDAO.deleteById(7);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
