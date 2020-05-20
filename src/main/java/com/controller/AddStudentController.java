package com.controller;


import com.entity.Homework;
import com.jdbc.StudentHomeworkJdbc;
import com.entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@Controller
public class AddStudentController {
  @RequestMapping(value="/addStudent")
  public void addStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    Student s = new Student();

    s.setName(req.getParameter("studentName"));

    try {
      StudentHomeworkJdbc.addStudent(s);
    } catch (SQLException e) {
      e.printStackTrace();
    }

    PrintWriter out = resp.getWriter();
    out.println("Submit successfully!");
  }

}
