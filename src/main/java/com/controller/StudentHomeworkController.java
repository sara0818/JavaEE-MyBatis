package com.controller;


import com.jdbc.StudentHomeworkJdbc;
import com.entity.StudentHomework;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;
import java.util.List;

@Controller
public class StudentHomeworkController {

  @RequestMapping(value="/studentHomework")
  public String addHomework(Model model){
    List<StudentHomework> list = null;

    list = StudentHomeworkJdbc.selectAll();


    model.addAttribute(list);
    return "/WEB-INF/index.jsp";
  }
}
