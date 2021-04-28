package com.ciaoshen.sia.demo.gradle_demo.todo.web;

import com.ciaoshen.sia.demo.gradle_demo.todo.model.ToDoItem;

/* tomcat 10 migrated to servlet 5.0 and jsp 3.0, which use jakarta.servlet instead of javax.servlet */
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import java.util.List;
import java.util.ArrayList;
import java.io.IOException;

public class ToDoServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String servletPath = request.getServletPath();
        String view = processRequest(servletPath, request);
        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
        dispatcher.forward(request, response);
    }

    private String processRequest(String servletPath, HttpServletRequest request) {
        if (servletPath.equals("/")) {
            return "/jsp/index.jsp";
        } else if (servletPath.equals("/all-items")) {
            List<ToDoItem> todos = new ArrayList<ToDoItem>();
            for (int i = 0; i < 5; i++) {
                ToDoItem item = new ToDoItem(String.valueOf(i));
                item.setId((long)i);
                todos.add(item);
            }
            request.setAttribute("toDoItems", todos);
            return "/jsp/all-items.jsp";
        } else {
            return "/jsp/index.jsp";
        }
    } 

}