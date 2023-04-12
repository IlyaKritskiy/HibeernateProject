package entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "adress")
public class Address {

    @Id
    private int id;
    private String city;
    private String street;
    private int house;
    private int apartment;

    public Address(){

    }

    public Address(int id, String city, String street, int house, int apartment) {
        this.id = id;
        this.city = city;
        this.street = street;
        this.house = house;
        this.apartment = apartment;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    public int getApartment() {
        return apartment;
    }

    public void setApartment(int apartment) {
        this.apartment = apartment;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house=" + house +
                ", apartment=" + apartment +
                '}';
    }
}
