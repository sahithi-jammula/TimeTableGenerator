<%@page import="javax.naming.InitialContext"%>
<%@page import="java.util.List"%>
<%@page import="javax.ejb.EJB"%>
<%@page import="com.klef.ep.services.FacultyService"%>
<%@page import="com.klef.ep.models.Faculty"%>
<%
Faculty fac = (Faculty) session.getAttribute("fac");
if(fac==null)
{
	response.sendRedirect("sessionexpiry.html");
}
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Faculty Home</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: lightgrey;
            background-image: url('https://images.pexels.com/photos/6893329/pexels-photo-6893329.jpeg?auto=compress&amp;cs=tinysrgb&amp;w=1260&amp;h=750&amp;dpr=2');
            background-size: cover;
            background-repeat: no-repeat;
            background-attachment: fixed;
            background-position: center;
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
            padding: 20px;
            text-align: center;
        }
        .dashboard {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
        }
        .card {
            background-color: white;
            border: 1px solid #ccc;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
            margin: 20px;
            overflow: hidden;
            width: 350px; /* Increased card width */
            height: 250px; /* Increased card height */
            position: relative;
            perspective: 1000px;
        }
        .card-inner {
            position: relative;
            width: 100%;
            height: 100%;
            transition: transform 0.6s;
            transform-style: preserve-3d;
        }
        .card:hover .card-inner {
            transform: rotateY(180deg);
        }
        .card-front, .card-back {
            position: absolute;
            width: 100%;
            height: 100%;
            backface-visibility: hidden;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .card-front {
            background-size: cover;
            background-position: center;
            color: white;
        }
        .card-back {
            background-color: #f8f8f8;
            color: black;
            transform: rotateY(180deg);
            padding: 20px;
            box-sizing: border-box;
            overflow-y: auto; /* Added for scrolling in case of long text */
        }
        .card-content {
            text-align: center;
        }
        .card-title {
            font-size: 1.6em; /* Increased title font size */
            margin-bottom: 10px;
        }
        .user-info {
            margin-top: 10px;
            line-height: 1.6;
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
        
        <div class="dashboard">
            <div class="card">
                <div class="card-inner">
                    <div class="card-front" style="background-image: url('https://i.pinimg.com/736x/b1/e3/0b/b1e30bc225bec5ea1388793bc4e831c0--timetable-ui-timetable-design.jpg');">
                        <!-- Optionally, you can place text or content here if needed -->
                    </div>
                    <div class="card-back">
                        <div class="card-content">
                            <div class="card-title">Profile</div>
                            <p>View and update your personal profile information including contact details and preferences.</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="card">
                <div class="card-inner">
                    <div class="card-front" style="background-image: url('https://images.pexels.com/photos/5417664/pexels-photo-5417664.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2');">
                        <!-- Optionally, you can place text or content here if needed -->
                    </div>
                    <div class="card-back">
                        <div class="card-content">
                            <div class="card-title">My Courses</div>
                            <p>View all courses you are enrolled in. You can check course details and your performance here.</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="card">
                <div class="card-inner">
                    <div class="card-front" style="background-image: url('https://images.pexels.com/photos/7428863/pexels-photo-7428863.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2');">
                        <!-- Optionally, you can place text or content here if needed -->
                    </div>
                    <div class="card-back">
                        <div class="card-content">
                            <div class="card-title">View Timetable</div>
                            <p>Access your timetable to check your class schedule and stay organized throughout the semester.</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

   <%--  <div class="user-info">
        <b>Full Name:</b> <%= name %><br>
        <b>Email:</b> <%= email %><br>
        <b>Contact:</b> <%= contact %><br>
    </div> --%>
</body>
</html>