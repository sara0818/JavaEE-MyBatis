<%@ page import="com.jdbc.StudentHomeworkJdbc" %>
<%@ page import="com.entity.Student" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ModifyStudent</title>
</head>
<body>
<div style="text-align: center;">
  <form action="modifyStudent" method="post">
    请输入要修改的学生学号：
    <input type="text" name="studentID" width="600px">
    <br><br>
    请输入新的姓名：
    <input type="text" name="name" width="600px">
    <br><br>
    <button onclick="window.location.href('index.jsp')">返回</button>
    &nbsp;&nbsp;&nbsp;
    <input type="submit" value="提交">
  </form>
</div>
</body>
</html>
