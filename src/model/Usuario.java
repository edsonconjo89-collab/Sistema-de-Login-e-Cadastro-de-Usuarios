package model;

import java.io.Serializable;
import java.util.Objects;

public class Usuario implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private String nomeUsuario;
    private String senha;
    private TipoConta tipoConta;

    public Usuario(String nomeUsuario, String senha, TipoConta tipoConta) {
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.tipoConta = tipoConta;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + Objects.hashCode(this.nomeUsuario);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        return Objects.equals(this.nomeUsuario, other.nomeUsuario);
    }
    
    
    
}
