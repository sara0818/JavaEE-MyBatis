package com.controller;


import com.jdbc.StudentHomeworkJdbc;
import com.entity.StudentHomework;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@Controller
public class ResubmitHomeworkController {
  @RequestMapping("/resubmitHomework")
  public void resubmitHomework(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    StudentHomework sh = new StudentHomework();

    sh.setStudentId(Long.parseLong(req.getParameter("studentID")));
    sh.setHomeworkId(Long.parseLong(req.getParameter("homeworkID")));
    sh.setHomeworkTitle(req.getParameter("title"));
    sh.setHomeworkContent(req.getParameter("content"));


    try {
      StudentHomeworkJdbc.resubmitHomework(sh);
    } catch (SQLException e) {
      e.printStackTrace();
    }

    PrintWriter out = resp.getWriter();
    out.println("Submit successfully!");
  }

}
