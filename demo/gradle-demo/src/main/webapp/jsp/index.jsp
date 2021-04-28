<!doctype html>
<html>
<head><title>First JSP</title></head>
<body>
    <h2>--- To Do Application: index.jsp ---</h2>
    <h2>Please make a choice:</h2>
    <h3><a href="<%= request.getContextPath() %>/all-items">    all items --> 
        <%
            String uri = request.getContextPath();
            out.println(uri + "/all-items");
        %>
    </a></h3>
</body>
</html>