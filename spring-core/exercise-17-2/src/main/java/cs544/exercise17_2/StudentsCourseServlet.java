package cs544.exercise17_2;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class StudentsCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String studentIdStr = request.getParameter("studentid");
		
		long studentid = -1;
		Student student = null;
		
		ServletContext context = getServletContext();
		WebApplicationContext applicationContext = 
		        WebApplicationContextUtils.getWebApplicationContext(context);
	    StudentService studentService = applicationContext.getBean(
		        "studentService", StudentService.class);
	    
		if (studentIdStr != null && studentIdStr.matches("\\d+")) {
			studentid = Long.parseLong(studentIdStr);
			student = studentService.getStudent(studentid);
		}
		else {
			try {
				studentService.init();
			}
			catch(RuntimeException e) {
				System.out.println(e);
			}
			
		}

		request.setAttribute("student", student);
		request.getRequestDispatcher("student.jsp").forward(request, response);
		
	}

}
