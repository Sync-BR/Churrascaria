/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import Dao.LoginDao;
import com.mycompany.churrascariapizzaria.Beans.Conexao.ConexaoDB;
import com.mycompany.churrascariapizzaria.Beans.SessaoBeans;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Eduar
 */
@WebServlet(name = "Sessao", urlPatterns = {"/Sessao"})
public class Sessao extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        LoginDao Authenticar = new LoginDao();
        SessaoBeans Login = new SessaoBeans();
        Login.setUsuario(request.getParameter("UsuarioLogin"));
        Login.setSenha(request.getParameter("UsuarioPassword"));
        try {
            Authenticar.AuthenticarLogin(Login);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (LoginDao.AutenticarSucesso == true && LoginDao.AutenticarPass) {
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet SessaoServlet</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Sucesso</h1>");
                out.println("</body>");
                out.println("</html>");

            }
        } else if (!LoginDao.AutenticarPass) {
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet SessaoServlet</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1> Senha errada</h1>");
                out.println("</body>");
                out.println("</html>");
            }

        } else if (!LoginDao.AutenticarSucesso && !LoginDao.AutenticarPass ) {
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet SessaoServlet</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1> Login errada</h1>");
                out.println("</body>");
                out.println("</html>");
            }
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
