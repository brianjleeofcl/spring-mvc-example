package net.brianjlee.springExample;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "usersServlet", urlPatterns = { "/users" }, loadOnStartup = 1)
public class UsersServlet extends HttpServlet {
    private DataAccessObject data = new DataAccessObject();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User[] users = data.getUsers();
        req.setAttribute("users", users);
        req.getRequestDispatcher("/jsp/users.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String phone = req.getParameter("phone");

        try {
            User user = data.insertUser(firstName, lastName, phone);

            req.setAttribute("user", user);
            req.getRequestDispatcher("/jsp/user.jsp").forward(req, resp);
        } catch (InstantiationException e) {
            resp.setStatus(400);
        }
    }
}
