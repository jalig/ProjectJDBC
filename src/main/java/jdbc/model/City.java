package jdbc.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private Integer id;
    @Column(name = "city_name")
    private String cityName;
    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private List <Employee> employees;

    public City(String cityName) {
        this.cityName = cityName;
    }

    public City() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City city = (City) o;
        return Objects.equals(id, city.id) && Objects.equals(cityName, city.cityName) && Objects.equals(employees, city.employees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cityName, employees);
    }

    @Override
    public String toString() {
        return "id: " + id + " "+
                "Город: " + cityName + "\n";
    }
}
