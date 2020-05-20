package com.controller;

import com.jdbc.StudentHomeworkJdbc;
import com.entity.Homework;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@Controller
public class AddHomeworkController {
  @RequestMapping("/addHomework")
  public void addHomework(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    Homework homework = new Homework();
    homework.setTitle(req.getParameter("title"));
    homework.setContent(req.getParameter("content"));

    try {
      StudentHomeworkJdbc.addHomework(homework);
    } catch (SQLException e) {
      e.printStackTrace();
    }

    PrintWriter out = resp.getWriter();
    out.println("Submit successfully!");
  }


}
