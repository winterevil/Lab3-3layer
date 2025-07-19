package vn.edu.eiu.lab3;

import jakarta.persistence.EntityManager;
import vn.edu.eiu.lab3.entity.Major;
import vn.edu.eiu.lab3.entity.School;
import vn.edu.eiu.lab3.entity.Student;
import vn.edu.eiu.lab3.service.MajorService;
import vn.edu.eiu.lab3.service.SchoolService;
import vn.edu.eiu.lab3.service.StudentService;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        SchoolService schoolService = new SchoolService();
        MajorService majorService = new MajorService();
        StudentService studentService = new StudentService();
        School sc1 = new School("CIT", "Computing of Information Technology", "B11");
        School sc2 = new School("BSA", "Business Administration", "B3");

        Major mj1 = new Major("CSE", "Software Engineering");
        Major mj2 = new Major("HRM", "Human Resources");

        Student std1 = new Student("Tuấn Trịnh", Gender.MALE, LocalDate.parse("2000-07-19"), 3.4, 2018);
        Student std2 = new Student("An Trần", Gender.FEMALE, LocalDate.parse("2001-03-16"), 3.2, 2019);
        Student std3 = new Student("Đan Trần", Gender.FEMALE, LocalDate.parse("2003-11-29"), 2.9, 2021);
        Student std4 = new Student("Loan Trần", Gender.FEMALE, LocalDate.parse("1999-12-07"), 3.0, 2017);

        //bidrectional
        sc1.addMajor(mj1);
        sc2.addMajor(mj2);

        mj1.addStudent(std1);
        mj2.addStudent(std2);
        mj2.addStudent(std3);

        sc1.addStudent(std1);
        sc2.addStudent(std2);
        sc2.addStudent(std3);

        //persist School
        schoolService.createSchool(sc1);
        schoolService.createSchool(sc2);

        //Read All
        System.out.println("Schools:");
        schoolService.getAllSchools().forEach(System.out::println);

        System.out.println("Majors:");
        majorService.getAllMajors().forEach(System.out::println);

        System.out.println("Students:");
        studentService.getAllStudents().forEach(System.out::println);

        //Update School
        sc2.setLocation("B8");
        schoolService.updateSchool(sc2);
        System.out.println("After Updating Schools:");
        schoolService.getAllSchools().forEach(System.out::println);

        //Update Major
        mj2.setMajorName("Human Resource Management");
        majorService.updateMajor(mj2);
        System.out.println("After Updating Majors:");
        majorService.getAllMajors().forEach(System.out::println);

        //Update Student
        std3.setGpa(3.7);
        studentService.updateStudent(std3);
        System.out.println("After Updating Students:");
        studentService.getAllStudents().forEach(System.out::println);

        System.out.println("List of schools before delete: ");
        schoolService.getAllSchools().forEach(System.out::println);

        //Delete Student
        studentService.deleteStudent(std3);
        System.out.println("After Deleting Students:");
        studentService.getAllStudents().forEach(System.out::println);

        //Delete Major
        majorService.deleteMajor(mj2);
        System.out.println("After Deleting Majors:");
        majorService.getAllMajors().forEach(System.out::println);

        //Delete School
        schoolService.deleteSchool(sc2);
        System.out.println("After Deleting Schools:");
        schoolService.getAllSchools().forEach(System.out::println);
    }
}