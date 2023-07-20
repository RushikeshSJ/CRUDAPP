package studentmanagement.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentmanagement.dao.StudentDAO;
import studentmanagement.model.Student;

@WebServlet("/")
public class StudentController extends HttpServlet {
	
	StudentDAO studentDAO;
	
	public void init()
	{
		studentDAO = new StudentDAO();
	}
	
	public void insertForm ( HttpServletRequest request,HttpServletResponse resp) throws IOException
	{
		int roll = Integer.parseInt(request.getParameter("roll"));
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		double marks = Double.parseDouble(request.getParameter("marks"));
		
		Student st = new Student(roll,name,address,marks);
		studentDAO.insert(st);
		
		resp.sendRedirect(request.getContextPath()+"/list");
		
	}

	public void updateForm ( HttpServletRequest request,HttpServletResponse resp) throws IOException
	{
		int roll = Integer.parseInt(request.getParameter("roll"));
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		double marks = Double.parseDouble(request.getParameter("marks"));
		
		Student st = new Student(roll,name,address,marks);
		studentDAO.update(st);
		
		resp.sendRedirect(request.getContextPath()+"/list");
		
	}
	public void listRows ( HttpServletRequest request,HttpServletResponse resp) throws IOException, ServletException
	{
			List<Student> list = studentDAO.getAllStudents();
			RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
			request.setAttribute("list", list);
			dispatcher.forward(request, resp);
			
		
	}
	public void deleteRow ( HttpServletRequest request,HttpServletResponse resp) throws IOException
	{
		int roll = Integer.parseInt(request.getParameter("roll"));		
		studentDAO.delete(roll);		
		resp.sendRedirect(request.getContextPath()+"/list");
		
	}
	public void editForm ( HttpServletRequest request,HttpServletResponse resp) throws IOException, ServletException
	{
		int roll = Integer.parseInt(request.getParameter("roll"));		
		Student student = studentDAO.getStudent(roll);		
		RequestDispatcher dispatcher = request.getRequestDispatcher("form.jsp");
		request.setAttribute("student", student);
		dispatcher.forward(request, resp);
		
	}
	public void doGet(HttpServletRequest request,HttpServletResponse resp)throws ServletException,IOException
	{
		String path =request.getServletPath();
		switch(path)
		{
			case "/new":
				resp.sendRedirect("form.jsp");
				break;
				
			case "/insert":
				insertForm(request,resp);
				break;
				
			case "/list":
				listRows(request,resp);
				break;
				
			case "/delete":
				deleteRow(request,resp);
				break;
				
			case "/edit":
				editForm(request,resp);
				break;
			case "/update":
				updateForm(request,resp);
				break;
		}
		
	}
	public void doPost(HttpServletRequest request,HttpServletResponse resp)throws ServletException,IOException
	{
		doGet(request,resp);
		
	}
}
