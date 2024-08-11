<%@page import="com.klef.ep.models.Faculty"%>
<%
Faculty fac = (Faculty) session.getAttribute("fac");
if(fac==null)
{
    response.sendRedirect("sessionexpiry.html");
}
%>
<html>
<head>
    <title>Faculty Profile</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            background-image: url('https://images.pexels.com/photos/6893329/pexels-photo-6893329.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2');            
            background-size: cover;
            background-position: center;
            font-family: Arial, sans-serif;
        }

        nav {
            background-color: darkblue; 
            overflow: hidden;
            padding: 10px;
        }
        
        nav a.logo {
            font-size: 20px;
            font-weight: bold;
            color: orange;
            text-decoration: none;
        }
        
        nav a {
            float: left;
            color: white;
            text-align: center; 
            padding: 14px 16px; 
            text-decoration: none; 
            font-size: 16px; 
        }
        
        nav a:hover {
            background-color: #555; 
        }

        .container {
            background: rgba(255, 255, 255, 0.9); /* Slightly transparent white background */
            padding: 20px;
            border-radius: 10px;
            margin: 20px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
            text-align: center;
            max-width: 600px; /* Adjust the width as needed */
            margin-left: auto;
            margin-right: auto;
        }

        .container h3 {
            margin-bottom: 20px;
            color: #333;
        }

        .user-info {
            line-height: 1.6;
            color: #555;
        }
    </style>
</head>
<body>
    <nav>
        <a href="" class="logo">Schedule Maker</a>
        <a href="facultyhome.jsp">Home</a>
        <a href="facultyprofile.jsp">Profile</a>
        <a href="updatefacultyprofile.jsp">Update Profile</a>
        <a href="viewmycourses.jsf">My Courses</a>
        <a href="viewTimetable.jsp">View timetable</a>
        <a href="facultylogout.jsp">Logout</a>
    </nav>
    
    <div class="container">
        <h3><u>Faculty Profile</u></h3>
        <div class="user-info">
            ID: <%= fac.getId() %><br/>
            Name: <%= fac.getName() %><br/>
            Gender: <%= fac.getGender() %><br/>
            Department: <%= fac.getBranch() %><br/>
            Salary: <%= fac.getDob() %><br/>
            Email: <%= fac.getEmail() %><br/>
            Contact No: <%= fac.getContact() %><br/>
        </div>
    </div>
</body>
</html>
