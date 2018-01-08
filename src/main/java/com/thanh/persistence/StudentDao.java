package com.thanh.persistence;

import com.thanh.Exercise1.Student;
import com.thanh.Exercise2.DatabaseUtils;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;

@Repository
public class StudentDao {
    DatabaseUtils databaseUtils = new DatabaseUtils();

    public void create(ArrayList<Student> students){
        databaseUtils.insertStudents(students);
    }

    public ArrayList<Student> read(){
        return (ArrayList<Student>) databaseUtils.readStudents();
    }

}
