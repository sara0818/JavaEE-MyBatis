package com.dao;

import com.entity.StudentHomework;

import java.util.List;

public interface StudentHomeworkMapper {
  void submitHomework(StudentHomework sh);
  void resubmitHomework(StudentHomework sh);
  List<StudentHomework> selectAll();
}
