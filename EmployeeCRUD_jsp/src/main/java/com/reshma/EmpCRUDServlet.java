package com.reshma;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmpCRUDServlet
 */
@WebServlet("/EmpCRUDServlet")
public class EmpCRUDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String eno = request.getParameter("eno");
		String name = request.getParameter("name");
		String job = request.getParameter("job");
		String url;
		// Perform database insertion here (using JDBC or any other ORM)
		// Example JDBC code:
		try {
			Class.forName("org.postgresql.Driver");

			url = "jdbc:postgresql://192.168.110.48:5432/plf_training?user=plf_training_admin&password=pff123";

			Connection conn = DriverManager.getConnection(url);
			String query = "INSERT INTO reshma_emp(empno, ename, job) VALUES (?, ?, ?)";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, eno);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, job);
			preparedStatement.executeUpdate();
			conn.close();
			System.out.println("data inserted");
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Redirect to a confirmation page or back to the main JSP
		response.sendRedirect("confirmation.jsp");
	}
}