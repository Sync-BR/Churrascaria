package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Beans.SessaoBeans;
import Dao.LoginDao;

/**
 *
 * @author SYNC
 */
public class ServletConfig extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SessaoBeans sessao = new SessaoBeans();
        LoginDao EfetuarTrocas = new LoginDao();
        //Verificar usuario
        String VerificarUser = request.getParameter("UserForm");
        String OldPassword = request.getParameter("OldPass");
        String NewPassword = request.getParameter("NewPass");
        String RepeatPassword = request.getParameter("RepeatPass");
        //Verificar se o Usuario está correto
        if (LoginDao.UsuarioConectado.equals(VerificarUser)) {
            //Verificar se a antiga senha está correta
            System.out.println("Etapa 1 ok");
            System.out.println("Senha verificada: " + LoginDao.PasswordConectado);
            if (LoginDao.PasswordConectado.equals(OldPassword)) {
                //verificar as senhas novas
                System.out.println("Senha antiga ok");
                if (NewPassword.equals(RepeatPassword)) {
                    try {
                        sessao.setUsuario(VerificarUser);
                        sessao.setSenha(NewPassword);
                        EfetuarTrocas.AlterarDados(sessao);
                        LoginDao.StatusConfig = "Dados alterado com sucesso";
                        response.sendRedirect("Painel/Paginas/Config.jsp");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else{
                    LoginDao.StatusConfig = "Senhas não sao iguais";
                    response.sendRedirect("Painel/Paginas/Config.jsp");
                }
            } else {

                LoginDao.StatusConfig = "Senha antiga não bate com banco de dados";
                response.sendRedirect("Painel/Paginas/Config.jsp");
            }
        } else {
            LoginDao.Status = "Usuario não conectado";
            response.sendRedirect("/ChurrascariaPizzaria/index.jsp");
        }
        //Se o login for igual ao conectado
        // if (VerificarUser == LoginDao.UsuarioConectado) {
        //     System.out.println("teste 1: " +VerificarUser);
        //     System.out.println("teste 2" +LoginDao.UsuarioConectado);
        //     //Verificar a senha
        //     if (OldPassword.equals(PasswordConectado)) {
        //         //Verificar se as senhas novas estão correta
        //         if(NewPassword.equals(RepeatPassword)){
        //             sessao.setUsuario(VerificarUser);
        //             sessao.setUsuario(NewPassword);
        //             try{
        //                 EfetuarTrocas.AlterarDados(sessao);
        //                 response.sendRedirect("Painel/Paginas/Config.jsp");
        //             } catch(Exception e){
        //                 e.printStackTrace();
        //             }
        //         } else{
        //             response.sendRedirect("Painel/Paginas/Config.jsp");
        //             LoginDao.StatusConfig = "Senhas diferentes";
        //         }
        //     } else {
        //         response.sendRedirect("Painel/Paginas/Config.jsp");
        //         LoginDao.StatusConfig = "Senha antiga incorreta";
        //     }

        // } else {
        //     response.sendRedirect("Painel/Paginas/Config.jsp");
        //     LoginDao.StatusConfig = "Conta não conectada";
        //     System.out.println("Usuario Verificado: " +VerificarUser);
        //     System.out.println("Usuario Conectado " +LoginDao.UsuarioConectado);
        // }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
