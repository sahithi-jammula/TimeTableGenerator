<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="com.klef.ep.models.TimeTable" %>
<%@ page import="com.klef.ep.services.TimeTableService" %>
<%@ page import="com.klef.ep.services.TimeTableServiceImpl" %>
<%@ page import="com.klef.ep.models.Faculty" %>

<!DOCTYPE html>
<html>
<head>
    <title>View Timetable</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background: url('https://images.pexels.com/photos/6893329/pexels-photo-6893329.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2') no-repeat center center fixed;
            background-size: cover;
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
        nav a.active {
            color: orange;
        }
        .container {
            width: 90%;
            max-width: 1200px;
            margin: 20px auto;
            padding: 20px;
            background-color: rgba(255, 255, 255, 0.9); /* Slightly transparent background */
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 10px;
            text-align: center;
        }
        th {
            background-color: darkblue;
            color: white;
        }
        tbody tr:nth-child(odd) {
            background-color: #f9f9f9; /* Light grey for odd rows */
        }
        tbody tr:nth-child(even) {
            background-color: #ffffff; /* White for even rows */
        }
        tbody tr:hover {
            background-color: #e0e0e0; /* Highlight row on hover */
        }
        .header {
            text-align: center;
            font-weight: bold;
        }
        h2 {
            color: white;
            text-align: center;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <div class="navbar-container">
        <nav>
            <a href="facultyhome.jsp" class="logo">Schedule Maker</a>
            <a href="facultyhome.jsp" class="active">Home</a>
            <a href="facultyprofile.jsp">Profile</a>
            <a href="updatefacultyprofile.jsp">Update Profile</a>
            <a href="viewmycourses.jsf">My Courses</a>
            <a href="viewTimetable.jsp">View Timetable</a>
            <a href="facultylogout.jsp">Logout</a>
        </nav>
    </div>

    <div class="container">
        <h2>Timetable</h2>
        <%
            Faculty fac = (Faculty) session.getAttribute("fac");

            if (fac == null) {
                out.println("<p>No faculty ID found in session. Please log in.</p>");
            } else {
                // Create an instance of TimeTableService and fetch the timetable
                TimeTableService timeTableService = new TimeTableServiceImpl();
                int facultyId = fac.getId();
                List<TimeTable> timetable = timeTableService.getTimetableByFacultyId(facultyId);

                if (timetable == null || timetable.isEmpty()) {
                    out.println("<p>No timetable available for the given faculty ID.</p>");
                } else {
                    // Organize timetable data into a matrix format
                    Map<String, Map<String, String>> timetableMatrix = new HashMap<>();
                    String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
                    String[] timeSlots = {"09:00-10:00", "10:00-11:00", "11:00-12:00", "01:00-02:00", "02:00-03:00", "03:00-04:00"};

                    // Initialize timetable matrix
                    for (String day : days) {
                        timetableMatrix.put(day, new HashMap<>());
                    }

                    // Populate timetable matrix
                    for (TimeTable tt : timetable) {
                        timetableMatrix.get(tt.getDay()).put(tt.getTimeSlot(), tt.getCourseCode());
                    }
        %>
                    <table>
                        <thead>
                            <tr>
                                <th>Day/Time Slot</th>
                                <% for (String timeSlot : timeSlots) { %>
                                    <th><%= timeSlot %></th>
                                <% } %>
                            </tr>
                        </thead>
                        <tbody>
                            <% for (String day : days) { %>
                                <tr>
                                    <td class="header"><%= day %></td>
                                    <% for (String timeSlot : timeSlots) { %>
                                        <td><%= timetableMatrix.get(day).getOrDefault(timeSlot, "N/A") %></td>
                                    <% } %>
                                </tr>
                            <% } %>
                        </tbody>
                    </table>
        <%
                }
            }
        %>
    </div>
</body>
</html>
