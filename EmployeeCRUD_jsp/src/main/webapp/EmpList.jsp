<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, com.reshma.Employee"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h2>Employees</h2>
		<table border="1px black" border-collapse=collapse>
			<tr>
				<th width="100px">Emp No.</th>
				<th width="400px">Emp Name</th>
				<th width="100px">Job</th>
				<th></th>
				<th></th>
			</tr>
			<%
			ArrayList<Employee> edetails = (ArrayList<Employee>) request.getAttribute("Employees");

			for (Employee k : edetails) {
			%>
			<tr>
				<td><%=k.getEno()%></td>
				<td><%=k.getName()%></td>
				<td><%=k.getJob()%></td>
				<td><a href="javascript:void(0);" onclick="add()">add</a></td>
				<td><a href="javascript:void(0);" onclick="edit()">edit</a></td>

				<script>
					function add() {
						var popup = window.open('', 'Popup',
								'width=400,height=300');

						// Set the content of the pop-up
						popup.document.write('<html><body>');
						popup.document.write('<h2>Pop-up Form</h2>');
						popup.document
								.write('<form action="EmpCRUDServlet" method="post">');
						popup.document.write('<label for="no">Emp no:</label>');
						popup.document
								.write('<input type="text" id="no" name="name"><br>');
						
						popup.document.write('<label for="name">Employee name:</label>');
						popup.document
								.write('<input type="text" id="name" name="name"><br>');
						
						popup.document.write('<label for="job">Emp job:</label>');
						popup.document
								.write('<input type="text" id="job" name="job"><br>');
						
						popup.document.write('<button type="button" onclick="save()">save</button>');
						popup.document.write('</form>');
						popup.document.write('</body></html>');
					}
					function save() {
						var eno = popup.document.getElementById("no").value;
					    var name = popup.document.getElementById("name").value;
					    var job = popup.document.getElementById("job").value;
					   
					    var url = "addEmp.jsp?eno=" + eno +"&name="+name+"&job="+job ;
					    
					    
					    window.opener.location.href = url;
					    popup.close();
					}
				</script>

			</tr>
			<%
			}
			%>
		</table>
	</center>
</body>
</html>