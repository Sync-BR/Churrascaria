package com.mycompany.churrascariapizzaria.Beans.Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static jdk.internal.net.http.common.Utils.close;

/**
 *
 * @author SYNC
 */
public class ConexaoDB {

    private static Connection conexao = null;

    public static Connection getConnection() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://"+Config.IP+"/"+Config.DB,Config.UsuarioDB,Config.PasswordDB);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro nesta linha " +e);
        }
        return conexao;

    }

    /**
     *
     * @author SYNC
     * @Funcionalidade Encerra Conexão Funcionalidade para verificar se uma
     * conexão está aberta e encerrar
     */
    private void close(Connection conn, ResultSet rs, Statement stm) throws Exception {
        try {
            if (conn != null) {
                conn.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    private static void close(Connection conn, Statement stmt, ResultSet rs) throws Exception {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }
    // Fechar conexão Statement & Conjunto de resultado do ResultSet

    public static void closeConnection(Connection conn, Statement stmt, ResultSet rs) throws Exception {
        close(conn, stmt, rs);
    }
    //Fechar conexão sem fechar o conjunto do ResultSet

    public static void closeConnection(Connection conn, Statement stmt) throws Exception {
        close(conn, stmt, null);
    }
    //Fechar apenas a conexão

    public static void closeConnection(Connection conn) throws Exception {
        closeConnection(conn, null, null);
    }
}
