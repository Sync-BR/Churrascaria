/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import Dao.LoginDao;
import Conexao.ConexaoDB;
import Beans.SessaoBeans;
import static Dao.LoginDao.AutenthicarUser;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author SYNC
 */
@WebServlet(name = "Sessao", urlPatterns = {"/Sessao"})
public class Sessao extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        LoginDao Authenticar = new LoginDao();
        SessaoBeans Login = new SessaoBeans();
        //buscar sessão
        Login.setUsuario(request.getParameter("UsuarioLogin"));
        Login.setSenha(request.getParameter("UsuarioPassword"));
       
        try {
            Authenticar.AuthenticarLogin(Login);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        //Verificar se o login está correto
        if (LoginDao.AutenthicarUser) {
            //Verificar se a senha está corretar
            if (LoginDao.AutenticarPass) {
                LoginDao.AutenticarSucesso = true;
            } else if (!LoginDao.AutenticarPass) {
                LoginDao.Status = "Senha incorretar";

            }
        } else if (!LoginDao.AutenthicarUser) {
            LoginDao.Status = "Usuario não encontrado";
            response.sendRedirect("index.jsp");
        }
        //Verificar se o login e a senha estão correta
        if (LoginDao.AutenticarSucesso) {
            response.sendRedirect("Painel/index.jsp");
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
