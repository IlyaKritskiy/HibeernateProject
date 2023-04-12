package entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "students_courses")
public class StudentCourse {

    @Id
    @GeneratedValue
    private int id;
    @Column(name = "student_id")
    private int studentId;
    @Column(name = "courses_id")
    private int coursesId;
    @Column(name = "registr_date")
    private LocalDate dateOfReceipt;

    public StudentCourse(){
    }

    public StudentCourse(int studentId, int coursesId, LocalDate dateOfReceipt) {
        this.studentId = studentId;
        this.coursesId = coursesId;
        this.dateOfReceipt = dateOfReceipt;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return coursesId;
    }

    public void setCourseId(int courseId) {
        this.coursesId = courseId;
    }

    public LocalDate getDateOfReceipt() {
        return dateOfReceipt;
    }

    public void setDateOfReceipt(LocalDate dateOfReceipt) {
        this.dateOfReceipt = dateOfReceipt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "StudentCourse{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", courseId=" + coursesId +
                ", dateOfReceipt=" + dateOfReceipt +
                '}';
    }
}
