package entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    private LocalDate birthday;
    @Column(name = "id_adress")
    private int idAddress;

    @ManyToMany
    private List<Course> courses;

    public Student(){

    }

    public Student(String firstName, String lastName, String email, LocalDate birthday, int idAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthday = birthday;
        this.idAddress = idAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public int getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(int idAddress) {
        this.idAddress = idAddress;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                ", idAddress=" + idAddress +
                '}';
    }
}
