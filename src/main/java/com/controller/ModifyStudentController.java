package com.controller;


import com.jdbc.StudentHomeworkJdbc;
import com.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@Controller
public class ModifyStudentController {
  @RequestMapping("/modifyStudent")
  public void modifyStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    Student s = new Student();
    s.setId(Long.parseLong(req.getParameter("studentID")));
    s.setName(req.getParameter("name"));


    try {
      StudentHomeworkJdbc.modifyStudent(s);
    } catch (SQLException e) {
      e.printStackTrace();
    }

    PrintWriter out = resp.getWriter();
    out.println("Submit successfully!");
  }
}
