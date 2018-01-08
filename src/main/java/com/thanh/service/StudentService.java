package com.thanh.service;

import com.thanh.Exercise1.Student;
import com.thanh.persistence.StudentDao;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class StudentService {
    StudentDao studentDao = new StudentDao();

    public void process(ArrayList<Student> students){
        studentDao.create(students);
    }

    public ArrayList<Student> get(){
        return studentDao.read();
    }
}
