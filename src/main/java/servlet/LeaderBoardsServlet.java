package servlet;

import Data.Data;
import core.Gamer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
@WebServlet("/view")
public class LeaderBoardsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Data data = new Data();
        ArrayList<Gamer> gamers = data.getListOfGamers();
        req.setAttribute("gamers",gamers);
        data.closeConnect();
        getServletConfig().getServletContext().getRequestDispatcher("/leader.jsp").forward(req,resp);
    }
}
