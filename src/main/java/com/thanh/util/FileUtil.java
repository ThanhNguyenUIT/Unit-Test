package com.thanh.util;

import com.thanh.Exercise1.FileUtils;
import com.thanh.Exercise1.Student;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

@Component
public class FileUtil {
    public String store(HttpServletRequest request) {
        DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
        String fileUrl = "";

        try {
            List<FileItem> fileItems = upload.parseRequest(request);
            for (FileItem fileItem : fileItems) {
                if (!fileItem.isFormField()) {
                    String fileName = fileItem.getName();
                    if (!fileName.equals("")) {
                        String dirUrl = request.getServletContext().getRealPath("") + "files";
                        File dir = new File(dirUrl);

                        if (!dir.exists()) {
                            dir.mkdir();
                        }

                        fileUrl = dirUrl + File.separator + fileName;
                        File file = new File(fileUrl);

                        try {
                            fileItem.write(file);
                            System.out.println("Upload Success!");
                            System.out.println("Directory: \n" + dirUrl);
                        } catch (Exception e) {
                            System.out.println("Fail!");
                            e.printStackTrace();
                            return "";
                        }
                    }
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
            return "";
        }
        return fileUrl;
    }

    public List<Student> read(String fileUrl) {
        return FileUtils.getListStudent(fileUrl);
    }
}
