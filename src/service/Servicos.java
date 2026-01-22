package service;

import java.util.Map;
import model.Usuario;

public interface Servicos {
    
    public abstract boolean cadastrar(Usuario usuario);
    public abstract boolean remover(String username);
    public abstract boolean atualizarDados(String nomeAtual, String senhaAtual,String nomenovo, String senhaNova);
    public abstract Map<String, Usuario> getListaUsuarios();
    public abstract boolean logar(String user,String senha);
}
