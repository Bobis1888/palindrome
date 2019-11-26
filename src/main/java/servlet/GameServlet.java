package servlet;

import core.GameCore;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/game")
public class GameServlet extends HttpServlet {
    GameCore core = new GameCore();
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String palindrome = request.getParameter("palindrome");
        int points = core.searchPalindrome(palindrome);
        request.setAttribute("points",points);
        getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
    }
}
