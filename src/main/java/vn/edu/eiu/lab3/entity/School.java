package vn.edu.eiu.lab3.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_School")
public class School {
    @Id
    @Column(name = "SchoolId", columnDefinition = "CHAR(3)")
    private String schoolId;

    @Column(name = "SchoolName", columnDefinition = "NVARCHAR(100)", nullable = false)
    private String schoolName;

    @Column(name = "Location", columnDefinition = "NVARCHAR(100)")
    private String location;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "school")
    private List<Major> majors = new ArrayList<>();
    private List<Student> students = new ArrayList<>();

    public void addMajor(Major major) {
        majors.add(major);
        major.setSchool(this);
    }

    public void addStudent(Student student) {
        students.add(student);
        student.setSchool(this);
    }

    public School(String schoolId, String schoolName, String location) {
        this.schoolId = schoolId;
        this.schoolName = schoolName;
        this.location = location;
    }
}
