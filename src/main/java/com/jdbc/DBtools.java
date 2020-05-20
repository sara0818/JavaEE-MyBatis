package com.jdbc;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class DBtools {

  private static SqlSessionFactory sqlSessionFactory;
  static {
    try {
      Reader reader = Resources.getResourceAsReader("config/mybatis-conf.xml");
      sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  public static SqlSessionFactory getSqlSessionFactory(){
    return sqlSessionFactory;
  }

}
