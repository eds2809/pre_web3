package servlet;

import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/")
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean result = false;
        try {
            result = UserService.instance.updateUser(
                    Long.parseLong(req.getParameter("id")),
                    req.getParameter("name"),
                    req.getParameter("pass"),
                    Long.parseLong(req.getParameter("age"))
            );
        } catch (NumberFormatException ignored) {

        }

        resp.setStatus(result ? HttpServletResponse.SC_OK : HttpServletResponse.SC_BAD_REQUEST);
        resp.sendRedirect("/web3/");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean result = false;

        try {
            result = UserService.instance.delUser(Long.parseLong(req.getParameter("id")));
        } catch (NumberFormatException ignored) {

        }

        resp.setStatus(result ? HttpServletResponse.SC_OK : HttpServletResponse.SC_BAD_REQUEST);
        resp.sendRedirect("/web3/");
    }
}
