package vn.edu.eiu.lab3.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import vn.edu.eiu.lab3.Gender;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_Student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "StudentId")
    private long studentId;

    @Column(name = "FullName", columnDefinition = "NVARCHAR(100)", nullable = false)
    private String fullName;

    @Column(name = "Gender", nullable = false)
    private Gender gender;

    @Column(name = "Dob", nullable = false)
    private LocalDate dob;

    @Column(name = "Gpa")
    private double gpa;

    @Column(name = "EnrollmentYear", nullable = false)
    private int enrollmentYear;

    @ManyToOne
    @JoinColumn(name = "MajorId")
    @ToString.Exclude
    private Major major;

    @ManyToOne
    @JoinColumn(name = "SchoolId")
    @ToString.Exclude
    private School sc;

    public Student(String fullName, Gender gender, LocalDate dob, double gpa, int enrollmentYear) {
        this.fullName = fullName;
        this.gender = gender;
        this.dob = dob;
        this.gpa = gpa;
        this.enrollmentYear = enrollmentYear;
    }
}
