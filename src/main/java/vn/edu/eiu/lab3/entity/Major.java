package vn.edu.eiu.lab3.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_Major")
public class Major {
    @Id
    @Column(name = "MajorId", columnDefinition = "CHAR(4)")
    private String majorId;

    @Column(name = "MajorName", columnDefinition = "NVARCHAR(100)", nullable = false)
    private String majorName;

    @ManyToOne
    @JoinColumn(name = "SchoolId")
    private School school;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "major")
    private List<Student> students =  new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
        student.setMajor(this);
    }

    public Major(String majorId, String majorName) {
        this.majorId = majorId;
        this.majorName = majorName;
    }
}
