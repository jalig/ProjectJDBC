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
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    List <City> cityList;

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

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City city = (City) o;
        return Objects.equals(id, city.id) && Objects.equals(cityName, city.cityName) && Objects.equals(cityList, city.cityList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cityName, cityList);
    }

    @Override
    public String toString() {
        return "id: " + id + " "+
                "Город: " + cityName + "\n";
    }
}
