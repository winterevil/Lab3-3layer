package vn.edu.eiu.lab3.service;

import vn.edu.eiu.lab3.entity.Major;
import vn.edu.eiu.lab3.repository.MajorRepo;

import java.util.List;

public class MajorService {
    //1.2 Create Major
    public void createMajor(Major major) {
        MajorRepo.add(major);
    }

    //2.2 Read Major
    public List<Major> getAllMajors() {
        return MajorRepo.findAll();
    }

    //3.2 Update Major
    public void updateMajor(Major major) {
        MajorRepo.edit(major);
    }

    //4.2 Delete Major
    public void deleteMajor(Major major) {
        MajorRepo.remove(major);
    }
}
