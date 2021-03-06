package edu.school_21.cinema.servlets;

import edu.school_21.cinema.repositories.UpdatableBCrypt;
import edu.school_21.cinema.repositories.UserDAO;
import org.springframework.context.ApplicationContext;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/sign")
public class SignUpServlet extends HttpServlet {
    public SignUpServlet(){}

    private UserDAO userDAO;

    @Override
    public void init(ServletConfig config ) throws ServletException {
        super.init(config);
        this.userDAO = (UserDAO)config.getServletContext().getAttribute("userDAO");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        String phoneNum = request.getParameter("phoneNum");
        String pass = request.getParameter("pass");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        userDAO.createUser(firstname, lastname, phoneNum, UpdatableBCrypt.hashPassword(pass));
        System.out.println(UpdatableBCrypt.hashPassword(pass));
        HttpSession session = request.getSession();
        session.setAttribute("name", phoneNum);
        RequestDispatcher rs = request.getRequestDispatcher("/welcome");
        rs.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/signUp.html").forward(req, resp);
    }
}
