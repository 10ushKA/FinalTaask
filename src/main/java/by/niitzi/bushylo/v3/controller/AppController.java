package by.niitzi.bushylo.v3.controller;

import by.niitzi.bushylo.v3.command.CommandFactory;
import by.niitzi.bushylo.v3.command.CommandResult;
import by.niitzi.bushylo.v3.db.ConnectionPool;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.ServiceException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Map;

import by.niitzi.bushylo.v3.exception.DAOException;


@WebServlet(urlPatterns = {"/home", "/admin", "/client" })
public class AppController extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        try {
            ConnectionPool.CONNECTION_POOL.init();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Init");
    }

    @Override
    public void destroy() {
        try {
            ConnectionPool.CONNECTION_POOL.closeAll();
            System.out.println("Destroy");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, UnsupportedEncodingException {
        try {
            processRequest(req, resp);
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, UnsupportedEncodingException {
        try {
            processRequest(req, resp);
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, UnsupportedEncodingException, ServiceException, by.niitzi.bushylo.v3.exception.ServiceException, DAOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        String command = req.getParameter("command");

        CommandResult commandResult = CommandFactory.command(command).execute(req);

        for (Map.Entry<String, Object> entry : commandResult.getAttributes().entrySet()) {
            req.setAttribute(entry.getKey(), entry.getValue());
        }
        if (commandResult.getResponseType().equals(CommandResult.ResponseType.FORWARD)) {
            req.getRequestDispatcher(commandResult.getPage()).forward(req, resp);
        } else {
            resp.sendRedirect(commandResult.getPage());//ПРОПИСАТЬ КУДА ПЕРЕЙДЕТ НА КОНКРЕТНУЮ СТР, ЕСЛИ НЕ НАЙДЕТ В ИФЕ
        }
    }
}
