package com.reshma;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		EmpDal ed = new EmpDal();
		ArrayList<Employee> res = ed.getData();
		System.out.println(res);
		request.setAttribute("Employees", res);

		RequestDispatcher rs = request.getRequestDispatcher("/EmpList.jsp");
		rs.forward(request, response);
	}

}
