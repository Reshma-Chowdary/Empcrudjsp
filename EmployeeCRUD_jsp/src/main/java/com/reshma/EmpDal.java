package com.reshma;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmpDal {
	public ArrayList<Employee> getData() {
		String eno;
		String name, ejob;

		ArrayList<Employee> edetails = new ArrayList<>();

		String url, query;

		try {
			Class.forName("org.postgresql.Driver");

			url = "jdbc:postgresql://192.168.110.48:5432/plf_training?user=plf_training_admin&password=pff123";

			Connection conn = DriverManager.getConnection(url);
			query = "select empno,ename,job from reshma_emp";
			Statement st = conn.createStatement();
			ResultSet rst = st.executeQuery(query);
			System.out.println("sfd");

			while (rst.next()) {
				eno = rst.getString("empno");
				name = rst.getString("ename");
				ejob = rst.getString("job");

				Employee e = new Employee(eno, name, ejob);
				edetails.add(e);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return edetails;
	}
}