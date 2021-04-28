<%@ page import="java.util.List" %>
<%@ page import="com.ciaoshen.sia.demo.gradle_demo.todo.model.ToDoItem" %>
<html>
<head><title>To Do Application</title></head>
<body>
    <h2>--- To Do Application ---</h2>
    <table>
      <tr><td>Items: </td></tr>
      <%
        List<ToDoItem> toDoItems = (List)request.getAttribute("toDoItems");
        for (ToDoItem item : toDoItems) {
          out.println("<tr><td>id = " + item.getId() + "</td><td>name = " + item.getName() + "</td><td>completed? " + item.getCompleted() + "</td></tr>");
        }
      %>
    </table>
    <a href="<%= request.getContextPath() %>/">    back --> 
      <%
          String uri = request.getContextPath();
          out.println(uri + "/");
      %>
    </a>
</body>
</html>