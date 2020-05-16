package com.ithuangyonghua.web;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //
        if(ServletFileUpload.isMultipartContent(req)){
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);

            try {
                List<FileItem> list = servletFileUpload.parseRequest(req);
                for(FileItem i: list){
                    if(i.isFormField()){//普通表单类型
                        System.out.println(i.getFieldName());
                        System.out.println(i.getString("utf-8"));
                    }else{//上传文件类型
                        System.out.println(i.getFieldName());
                        System.out.println(i.getName());
                        i.write(new File("f:\\" + i.getName()));

                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
