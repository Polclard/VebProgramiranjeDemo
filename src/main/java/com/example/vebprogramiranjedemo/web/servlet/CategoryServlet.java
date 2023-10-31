package com.example.vebprogramiranjedemo.web.servlet;

import com.example.vebprogramiranjedemo.model.Category;
import com.example.vebprogramiranjedemo.service.CategoryService;
import javax .servlet.ServletException;
import javax .servlet.annotation.WebServlet;
import javax .servlet.http.HttpServlet;
import javax .servlet.http.HttpServletRequest;
import javax .servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "category-servlet", urlPatterns = "/servlet/category")
public class CategoryServlet extends HttpServlet {


    private final CategoryService categoryService;
    public CategoryServlet(CategoryService categoryService)
    {
        this.categoryService = categoryService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ipAddress = req.getRemoteAddr();
        String clientAgent = req.getHeader("User-Agent");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");
        out.format("<h2>User IP address: %s</h2>", ipAddress);
        out.format("<h2>Client Agent: %s</h2>", clientAgent);
        out.println("<h3>Category List</h3>");
        out.println("<ul>");
        this.categoryService.listCategories().stream().forEach(r ->
                out.format("<li>%s  (%s)</li>", r.getName(), r.getDescription())
        );
        out.println("</ul>");
        out.println("<h3>Add Category</h3>");
        out.println("<form method='POST' action='/servlet/category'>");

        out.println("<label>Name: </label>");
        out.println("<input id='categoryName' name='categoryName' type='text'/>");


        out.println("<label>Description: </label>");
        out.println("<input id='categoryDescription' name='categoryDescription' type='text'/>");
        out.println("<input type='submit' value='Submit'/>");

        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String categoryName = req.getParameter("categoryName");
        String categoryDescription = req.getParameter("categoryDescription");
        categoryService.create(categoryName,categoryDescription);
        resp.sendRedirect("/servlet/category");
    }
}
