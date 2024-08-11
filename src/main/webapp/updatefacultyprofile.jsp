<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Update Profile</title>
    <style>
        body {
                    background-image: url('https://images.pexels.com/photos/6893329/pexels-photo-6893329.jpeg?auto=compress&amp;cs=tinysrgb&amp;w=1260&amp;h=750&amp;dpr=2');
        
            margin: 0;
            padding: 0;
            background-color: #f0f0f0;
            font-family: Arial, sans-serif;
        }

        nav {
            background-color: darkblue;
            overflow: hidden;
        }

        nav a {
            float: left;
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
            font-size: 16px;
        }

        nav a.logo {
            font-size: 20px;
            font-weight: bold;
            color: orange; /* Changed logo color to orange */
        }

        nav a:hover {
            background-color: #555;
        }

        .container {
            margin: 20px auto;
            width: 80%;
            max-width: 600px;
            padding: 20px;
            background: white;
            border-radius: 10px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        }

        h3 {
            text-align: center;
            color: #333;
        }

        form {
            width: 100%;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        td {
            padding: 10px;
        }

        td:first-child {
            text-align: right;
            font-weight: bold;
            color: #555;
        }

        input[type="text"],
        input[type="number"],
        input[type="password"] {
            width: calc(100% - 22px); /* Adjust width to account for padding and border */
            padding: 10px;
            margin: 5px 0;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        input[type="submit"],
        input[type="reset"] {
            padding: 10px 20px;
            margin: 10px;
            border: none;
            border-radius: 5px;
            background-color: #007bff;
            color: white;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        input[type="submit"]:hover,
        input[type="reset"]:hover {
            background-color: #0056b3;
        }

        .button-group {
            text-align: center;
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
        <a href="viewTimetable.jsp">View Timetable</a>
        <a href="facultylogout.jsp">Logout</a>
    </nav>

    <%@ page import="javax.naming.InitialContext" %>
    <%@ page import="java.util.List" %>
    <%@ page import="javax.ejb.EJB" %>
    <%@ page import="com.klef.ep.services.FacultyService" %>
    <%@ page import="com.klef.ep.models.Faculty" %>

    <%
        Faculty fac = (Faculty) session.getAttribute("fac");
        if (fac == null) {
            response.sendRedirect("sessionexpiry.html");
        }
    %>

    <div class="container">
        <h3><u>Update Employee Profile</u></h3>
        <form method="post" action="profileupdate.jsp">
            <table>
                <tr>
                    <td><b>ID</b></td>
                    <td>
                        <input type="number" name="id" value="<%= fac.getId() %>" readonly required>
                    </td>
                </tr>
                <tr>
                    <td><b>Enter Name</b></td>
                    <td>
                        <input type="text" name="name" value="<%= fac.getName() %>" required>
                    </td>
                </tr>
                <tr>
                    <td><b>Enter Password</b></td>
                    <td>
                        <input type="password" name="password" value="<%= fac.getPassword() %>" required>
                    </td>
                </tr>
                <tr>
                    <td><b>Enter Contact</b></td>
                    <td>
                        <input type="number" name="contact" value="<%= fac.getContact() %>" required>
                    </td>
                </tr>
                <tr class="button-group">
                    <td colspan="2">
                        <input type="submit" value="Update">
                        <input type="reset" value="Clear">
                    </td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
