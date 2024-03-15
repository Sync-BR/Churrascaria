package Dao;

import Conexao.ConexaoDB;
import Beans.SessaoBeans;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author SYNC
 */
public class LoginDao  {

    /*Variavel global de login e sessão*/
    public static boolean AutenticarSucesso = false;
    public static boolean AutenthicarUser = false;
    public static boolean AutenticarPass = false;
    public static String Status = "";
    public static String UsuarioConectado;
    public static String PasswordConectado;


    /*Funcionalidade para efetuar login*/
    
    public void AuthenticarLogin(SessaoBeans Login) throws Exception {
        Status = "";
        AutenticarSucesso = false;
        AutenticarPass = false;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            String sql = "select * from churrascaria.usuarios where Login = ? and Password = ?";
            conn = ConexaoDB.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, Login.getUsuario());
            stm.setString(2, Login.getSenha());
            rs = stm.executeQuery();
            //Iniciar uma sessão
            if (rs.next()) {

                String AuthenticarUser = rs.getString("Login");
                String AuthenticarPass = rs.getString("Password");
                //Verificar usuario
                if (AuthenticarUser.equals(Login.getUsuario())) {
                    AutenthicarUser = true;
                } else {
                    AutenthicarUser = false;

                }
                //Verificar Senha
                if (AuthenticarPass.equals(Login.getSenha())) {
                    AutenticarPass = true;
                    PasswordConectado = AuthenticarPass;
                } else {
                    AutenticarPass = false;
                }
                //Verificar se se os dados estão corretos
                if (AutenthicarUser && AutenticarPass) {
                    AutenticarSucesso = true;
                    UsuarioConectado = AuthenticarUser;
                }
            } else {
                AutenticarSucesso = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexaoDB.closeConnection(conn, stm, rs);
        }
    }

    /**
     *
     * @author SYNC
     * @Funcionalidade Alterar Dados do usuario
     */
    public static String StatusConfig;
    public void AlterarDados(SessaoBeans login) throws Exception {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            String sql = "UPDATE churrascaria.usuarios SET Password = ? where Login = ?";
            conn = ConexaoDB.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, login.getSenha());
            stm.setString(2, login.getUsuario());
            int update = stm.executeUpdate();
            if(update > 0){

            } else{
                StatusConfig = "Falhou ao alterar";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            ConexaoDB.closeConnection(conn, stm);
        }

    }
}
