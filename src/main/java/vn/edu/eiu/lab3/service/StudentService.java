package vn.edu.eiu.lab3.service;

import vn.edu.eiu.lab3.entity.Student;
import vn.edu.eiu.lab3.repository.StudentRepo;

import java.util.List;

public class StudentService {
    //1.3 Create Student
    public void createStudent(Student student) {
        StudentRepo.add(student);
    }

    //2.3 Read Student
    public List<Student> getAllStudents() {
        return StudentRepo.findAll();
    }

    //3.3 Update Student
    public void updateStudent(Student student) {
        StudentRepo.edit(student);
    }

    //4.3 Delete Student
    public void deleteStudent(Student student) {
        StudentRepo.remove(student);
    }
}
