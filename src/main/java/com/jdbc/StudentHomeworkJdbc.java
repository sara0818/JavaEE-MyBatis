package com.jdbc;

import com.dao.HomeworkMapper;
import com.dao.StudentHomeworkMapper;
import com.dao.StudentMapper;
import com.entity.Homework;
import com.entity.Student;
import com.entity.StudentHomework;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class StudentHomeworkJdbc{

  public static void main(String[] args) throws SQLException {
    List<StudentHomework> list = selectAll();

    for (StudentHomework sh : list){
      System.out.println(sh.getHomeworkContent());
    }
  }
  //发布作业
  public static void addHomework(Homework sh) throws SQLException {

    SqlSessionFactory sqlSessionFactory = DBtools.getSqlSessionFactory();
    //2.创建SqlSession
    SqlSession session = sqlSessionFactory.openSession();

    HomeworkMapper homeworkMapper = session.getMapper(HomeworkMapper.class);

    homeworkMapper.addHomework(sh);

    session.commit();

  }


  //添加学生
  public static void addStudent(Student s) throws SQLException {

    SqlSessionFactory sqlSessionFactory = DBtools.getSqlSessionFactory();
    //2.创建SqlSession
    SqlSession session = sqlSessionFactory.openSession();

    StudentMapper studentMapper = session.getMapper(StudentMapper.class);

    studentMapper.addStudent(s);

    session.commit();

  }


  //提交作业
  public static void submitHomework(StudentHomework sh) throws SQLException {

    SqlSessionFactory sqlSessionFactory = DBtools.getSqlSessionFactory();
    //2.创建SqlSession
    SqlSession session = sqlSessionFactory.openSession();

    StudentHomeworkMapper studentHomeworkMapper = session.getMapper(StudentHomeworkMapper.class);

    studentHomeworkMapper.submitHomework(sh);

    session.commit();

  }


  //重新提交作业
  public static void resubmitHomework(StudentHomework sh) throws SQLException {

    SqlSessionFactory sqlSessionFactory = DBtools.getSqlSessionFactory();
    //2.创建SqlSession
    SqlSession session = sqlSessionFactory.openSession();

    StudentHomeworkMapper studentHomeworkMapper = session.getMapper(StudentHomeworkMapper.class);

    studentHomeworkMapper.resubmitHomework(sh);

    session.commit();

  }


  //教师修改作业
  public static void modifyHomework(Homework h) throws SQLException {

    SqlSessionFactory sqlSessionFactory = DBtools.getSqlSessionFactory();
    //2.创建SqlSession
    SqlSession session = sqlSessionFactory.openSession();

    HomeworkMapper homeworkMapper = session.getMapper(HomeworkMapper.class);

    homeworkMapper.modifyHomework(h);

    session.commit();

  }

  //修改学生信息
  public static void modifyStudent(Student s) throws SQLException {

    SqlSessionFactory sqlSessionFactory = DBtools.getSqlSessionFactory();
    //2.创建SqlSession
    SqlSession session = sqlSessionFactory.openSession();

    StudentMapper studentMapper = session.getMapper(StudentMapper.class);

    studentMapper.modifyStudent(s);

    session.commit();

  }



  //查询已提交作业
  public static List<StudentHomework> selectAll() {

    List<StudentHomework> list;

    SqlSessionFactory sqlSessionFactory = DBtools.getSqlSessionFactory();
    //2.创建SqlSession
    SqlSession session = sqlSessionFactory.openSession();

    StudentHomeworkMapper studentHomeworkMapper = session.getMapper(StudentHomeworkMapper.class);

    list = studentHomeworkMapper.selectAll();

    session.commit();
    for(StudentHomework sh:list){
      System.out.println(sh.getId());
      System.out.println(sh.getStudentId());
      System.out.println(sh.getHomeworkId());
    }

    return list;

  }

}
