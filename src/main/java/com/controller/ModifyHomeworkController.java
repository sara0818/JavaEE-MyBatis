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
public class ModifyHomeworkController {
  @RequestMapping("/modifyHomework")
  public void modifyHomework(HttpServletRequest req, HttpServletResponse resp) throws IOException {

    Homework h = new Homework();
    h.setTitle(req.getParameter("title"));
    h.setContent(req.getParameter("content"));

    try {
      StudentHomeworkJdbc.modifyHomework(h);
    } catch (SQLException e) {
      e.printStackTrace();
    }

    PrintWriter out = resp.getWriter();
    out.println("Submit successfully!");
  }
}
