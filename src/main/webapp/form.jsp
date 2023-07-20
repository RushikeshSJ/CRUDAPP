<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="studentmanagement.model.Student" %>
   
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
<%
	Student s = (Student) request.getAttribute("student");

%>
 <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
                    <div>
                        <a href="" class="navbar-brand"> Student Management App </a>
                    </div>

                    <ul class="navbar-nav">
                       <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Students List</a></li>
                    </ul>
                    </ul>
                </nav>
            </header>
            <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
                        
                        <% if ( s == null) { %>
                        
						<form action="insert" method="post">						
                        <caption> <h2> Add New Student </h2> </caption>
                        
                        <%}else { %>
                        
                        <form action="update" method="post">						
                        <caption> <h2> Update Student </h2> </caption>
                        <%} %>
                        
						<fieldset class="form-group">
                            <label>Roll</label> <input type="text" value="<% if ( s!=null) out.println(s.getRoll()); %>" class="form-control" name="roll" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Name</label> <input type="text" value="<% if ( s!=null) out.println(s.getName()); %>" class="form-control" name="name" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Address</label> <input type="text" value="<% if ( s!=null) out.println(s.getAddress()); %>" class="form-control" name="address">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Marks</label> <input type="text" value="<% if ( s!=null) out.println(s.getMarks()); %>" class="form-control" name="marks">
                        </fieldset>

                        <button type="submit" class="btn btn-success">Save</button>
                        </form>
                    </div>
                </div>
            </div>
</body>
</html>