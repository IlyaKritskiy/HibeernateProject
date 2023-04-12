package entity;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    private int id;
    private String name;
    private String info;
    @Column(name = "start_date")
    private LocalDate startDay;
    @Column(name = "end_date")
    private LocalDate endDay;
    @ManyToMany(mappedBy = "courses")
    private List<Student> students;

    public Course(){

    }

    public Course(int id, String name, String info, LocalDate startDay, LocalDate endDay) {
        this.id = id;
        this.name = name;
        this.info = info;
        this.startDay = startDay;
        this.endDay = endDay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public LocalDate getStartDay() {
        return startDay;
    }

    public void setStartDay(LocalDate startDay) {
        this.startDay = startDay;
    }

    public LocalDate getEndDay() {
        return endDay;
    }

    public void setEndDay(LocalDate endDay) {
        this.endDay = endDay;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", info='" + info + '\'' +
                ", startDay=" + startDay +
                ", endDay=" + endDay +
                '}';
    }
}
