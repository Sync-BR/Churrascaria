
package com.mycompany.churrascariapizzaria.Beans;

/**
 *
 * @author SYNC
 */
public class SessaoBeans {
    private String Usuario;
    private String Senha;
    private boolean Authenticar;
    private boolean UsuarioVerificado;
    private boolean PasswordVerificado;

    public SessaoBeans() {
    }
    
    public SessaoBeans(String Login, String Password){
        this.Usuario = Login;
        this.Senha = Password;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

    public boolean isAuthenticar() {
        return Authenticar;
    }

    public void setAuthenticar(boolean Authenticar) {
        this.Authenticar = Authenticar;
    }

    public boolean isUsuarioVerificado() {
        return UsuarioVerificado;
    }

    public void setUsuarioVerificado(boolean UsuarioVerificado) {
        this.UsuarioVerificado = UsuarioVerificado;
    }

    public boolean isPasswordVerificado() {
        return PasswordVerificado;
    }

    public void setPasswordVerificado(boolean PasswordVerificado) {
        this.PasswordVerificado = PasswordVerificado;
    }
    
    
}
