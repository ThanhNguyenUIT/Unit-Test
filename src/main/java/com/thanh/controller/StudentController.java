package com.thanh.controller;

import com.thanh.Exercise1.Student;
import com.thanh.service.StudentService;
import com.thanh.util.FileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
public class StudentController {

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String doUpload(HttpServletRequest request) {
        StudentService studentService = new StudentService();
        FileUtil fileUtil = new FileUtil();

        String fileUrl = fileUtil.store(request);

        if (fileUrl.equals("")) {
            request.setAttribute("isStored", "Fail!");
        } else {
            request.setAttribute("isStored", "Upload Success!");

            List<Student> students = fileUtil.read(fileUrl);

            studentService.process((ArrayList<Student>) students);
        }
        return "upload";
    }

    @RequestMapping(value = "/read")
    public String doRead(){
        return "read";
    }
}
