package net.brianjlee.springExample;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.Integer.parseInt;

@WebServlet(name = "userServlet", urlPatterns = { "/users/*" })
public class UserServlet extends HttpServlet {
    private DataAccessObject data = new DataAccessObject();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = parseInt(req.getPathInfo().substring(1));
            User user = data.getUser(id);
            req.setAttribute("user", user);
            req.getRequestDispatcher("/jsp/user.jsp").forward(req, resp);
        } catch (NumberFormatException e) {
            resp.setStatus(404);
        }
    }
}
