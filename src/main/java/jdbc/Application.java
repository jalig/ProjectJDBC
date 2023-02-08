package jdbc;

import jdbc.dao.CityDAO;
import jdbc.dao.CityDAOImpl;
import jdbc.dao.EmployeeDAO;
import jdbc.dao.EmployeeDAOImpl;
import jdbc.model.City;
import jdbc.model.Employee;

public class Application {
    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        CityDAO cityDAO = new CityDAOImpl();
        City city = new City("Тверь");
        Employee employee = new Employee("Slavik","Varan","male",20, new City("Олёшкинск"));

//        employeeDAO.create(employee);

//        System.out.println(employeeDAO.getById(2));

//        System.out.println(employeeDAO.getAllEmployees());

//        employeeDAO.updateById(new Employee(9,"Bplavik","Baran","male",5,5));

//        employeeDAO.deleteById(employee);

// _____________________________________________________________________________________________________________________

//        cityDAO.create(city);
//
//        System.out.println(cityDAO.getById(3));
//
//        System.out.println(cityDAO.getAllEmployees());
//
//        cityDAO.updateById(city);
//
//        cityDAO.deleteById(cityDAO.getById(3));
//

    }
}
