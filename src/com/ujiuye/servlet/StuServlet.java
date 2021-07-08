package com.ujiuye.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ujiuye.bean.Student;
import com.ujiuye.service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.print.PrinterGraphics;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/stuServlet")
public class StuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String sname = request.getParameter("sname");
//       String sname = request.getParameter("sname");
//        String sage = request.getParameter("sage");
//        Student student = new Student(Integer.parseInt(sid),sname,Integer.parseInt(sage));
//        Student student = new Student();
        Student student = new Student(0,sname,0);

        StudentServiceImpl ss = new StudentServiceImpl();
     //   List<Student> studentService = ss.getStudentService(student);
        Student sService = ss.getService(student);

        System.out.println("----------studentService");
        //响应到前端
        ObjectMapper mapper = new ObjectMapper();
        String res = mapper.writeValueAsString(sService);
        PrintWriter out = response.getWriter();
        out.print(res);
        out.close();
    }
}
