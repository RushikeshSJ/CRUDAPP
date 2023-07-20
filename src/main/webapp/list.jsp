<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,studentmanagement.model.Student" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	</head>
<body>
  <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
                    <div>
                        <a href="https://www.javaguides.net" class="navbar-brand"> User
     Management App </a>
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Student List</a></li>
                    </ul>
                </nav>
            </header>
            <br>
            <div class="row">
             <h3 class="text-center">List of Users</h3>
                    <hr>
                    <div class="container text-left">

         <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
     New User</a>
                    </div>
                    <br>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>Roll</th>
                                <th>Name</th>
                                <th>Address</th>
                                <th>Marks</th>
                                
                            </tr>
                        </thead>
                        <tbody>
                        <% List<Student> list = (List<Student>) request.getAttribute("list"); %>
                        <% for ( Student student : list){ %>
                        <tr>
                        	<td><%= student.getRoll() %></td>
                        	<td><%= student.getName() %></td>
                        	<td><%= student.getAddress() %></td>
                        	<td><%= student.getMarks() %></td>
                        	<td><a href="<%=request.getContextPath()%>/edit?roll=<%=student.getRoll()%>">Edit</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/delete?roll=<%=student.getRoll()%>">Delete</a></td>
                        </tr>
                        <% } %>
                        
                        </tbody>
            </div>
</body>
</html>