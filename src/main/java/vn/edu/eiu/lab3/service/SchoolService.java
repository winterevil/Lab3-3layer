package vn.edu.eiu.lab3.service;

import vn.edu.eiu.lab3.entity.School;
import vn.edu.eiu.lab3.repository.SchoolRepo;

import java.util.List;

public class SchoolService {
    //1.1 Create School
    public void createSchool(School school) {
        SchoolRepo.add(school);
    }

    //2.1 Read School
    public List<School> getAllSchools() {
        return SchoolRepo.findAll();
    }

    //3.1 Update School
    public void updateSchool(School school) {
        SchoolRepo.edit(school);
    }

    //4.1 Delete School
    public void deleteSchool(School school) {
        SchoolRepo.remove(school);
    }
}
