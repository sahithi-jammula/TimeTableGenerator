<%@page import="com.klef.ep.models.Faculty"%>
<%@page import="com.klef.ep.services.FacultyService"%>
<%@page import="javax.naming.InitialContext"%>
<%

int id = Integer.parseInt(request.getParameter("id"));
String name = request.getParameter("name");
String password = request.getParameter("password");
String contact = request.getParameter("contact");


InitialContext context = new InitialContext();

FacultyService facultyService = (FacultyService) context.lookup("java:global/TimeTableGenerator/FacultyServiceImpl!com.klef.ep.services.FacultyService");

Faculty f =facultyService.viewfacultybyid(id);

if(f!=null)
{
	  //System.out.println("ID Found");
	  Faculty emp = new Faculty();
	  f.setId(id);
	  f.setName(name);
	  f.setContact(contact);
	  f.setPassword(password);
	  
	  facultyService.updatefaculty(f);
	  
	  Faculty faculty = facultyService.viewfacultybyid(id);
	  
	  session.setAttribute("fac", faculty);
	  
	  out.println("Employee Profile Updated Successfully");
}
else
{
	out.println("Employee ID Not Found");
}


%>
