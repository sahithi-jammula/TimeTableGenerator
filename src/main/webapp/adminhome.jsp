

<!DOCTYPE html>
<html>
<head>
    <title>Admin Home</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            background-image: url('https://images.pexels.com/photos/6893329/pexels-photo-6893329.jpeg?auto=compress&amp;cs=tinysrgb&amp;w=1260&amp;h=750&amp;dpr=2');
            background-size: cover;
            background-position: center;
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
            color: orange;
        }
        nav a:hover {
            background-color: #555;
        }
        .dropdown {
            float: left;
            overflow: hidden;
        }
        .dropdown .dropbtn {
            font-size: 16px;
            border: none;
            outline: none;
            color: white;
            padding: 14px 16px;
            background-color: inherit;
            font-family: inherit;
            margin: 0;
        }
        .dropdown-content {
            display: none;
            position: absolute;
            background-color: darkblue;
            min-width: 160px;
            box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
            z-index: 1;
        }
        .dropdown-content a {
            float: none;
            color: white;
            padding: 12px 16px;
            text-decoration: none;
            display: block;
            text-align: left;
        }
        .dropdown-content a:hover {
            background-color: #555;
        }
        .dropdown:hover .dropdown-content {
            display: block;
        }
    </style>
</head>
<body bgcolor="lightgrey">
    <nav>
        <a href="adminhome.jsp" class="logo">Schedule Maker</a>
        <a href="adminhome.jsp">Home</a>
        <a href="adminprofile.jsp">Profile</a>
        <div class="dropdown">
            <button class="dropbtn">Courses</button>
            <div class="dropdown-content">
                <a href="addcoursesform.jsf">Add Course</a>
                <a href="viewallcourse.jsf">View Courses</a>
            </div>
        </div>
        <a href="viewallfaculty.jsf">View Faculty</a>
        <a href="mapcourses.jsf">Map Courses</a>
        <a href="viewmappedcourses.jsf">View Mapped Courses</a>
        <a href="generateTimetableAllFaculty.jsf">Generate Timetable</a>
        <a href="adminlogout.jsp">Logout</a>
    </nav>
</body>
</html>
