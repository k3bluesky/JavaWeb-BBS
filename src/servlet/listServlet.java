package servlet;

import dao.BoardDao;
import dao.ReplyDao;
import dao.TopicDao;
import dao.impl.BoardDaoImpl;
import dao.impl.ReplyDaoImpl;
import dao.impl.TopicDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/list")
public class listServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int boardId = Integer.parseInt(request.getParameter("boardId"));
        TopicDao topicDao = new TopicDaoImpl();
        List topicList = topicDao.findListTopic(1,boardId);
        ReplyDao replyDao = new ReplyDaoImpl();
        BoardDao boardDao = new BoardDaoImpl();

        request.setAttribute("boardId",boardId);
        request.setAttribute("boardDao",boardDao);
        request.setAttribute("topicList",topicList);
        request.setAttribute("replyDao",replyDao);

        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }
}
