package com.controller;


import com.jdbc.StudentHomeworkJdbc;
import com.entity.StudentHomework;
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
public class SubmitHomeworkController {

  @RequestMapping("/submitHomework")
  public void submitHomework(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    StudentHomework sh = new StudentHomework();
    sh.setStudentId(Long.parseLong(req.getParameter("studentID")));
    sh.setHomeworkId(Long.parseLong(req.getParameter("homeworkID")));
    sh.setHomeworkTitle(req.getParameter("title"));
    sh.setHomeworkContent(req.getParameter("content"));

    try {
      StudentHomeworkJdbc.submitHomework(sh);
    } catch (SQLException e) {
      e.printStackTrace();
    }

    PrintWriter out = resp.getWriter();
    out.println("Submit successfully!");
  }

}
