package service;

import java.io.Serializable;
import java.util.Map;
import model.Usuario;
import storage.UsuarioOO;

public class ServicoUsuario implements Servicos,Serializable{

    private static final long serialVersionUID = 1L;
    
    private Map<String, Usuario> usuarios;
    private UsuarioOO gerenciarDisco;
    
    public ServicoUsuario(UsuarioOO g){
        this.gerenciarDisco = g; 
        this.usuarios = gerenciarDisco.lerDados();

    }
    
    @Override
    public boolean cadastrar(Usuario usuario) {
        if(usuarios.containsKey(usuario.getNomeUsuario())){
            throw new IllegalArgumentException ("O usuario " + usuario.getNomeUsuario() + " já existe!");
        }
        
        usuarios.put(usuario.getNomeUsuario(), usuario);
        gerenciarDisco.guardarDados(usuarios);
        return true;
    }

    @Override
    public boolean remover(String username) {
        if(!usuarios.containsKey(username)){
            throw new IllegalArgumentException ("O usuario " + username + "não existe!");
        }
        usuarios.remove(username);
        gerenciarDisco.guardarDados(usuarios);
        return true;
    }

    @Override
    public boolean atualizarDados(String nomeAtual, String senhaAtual,String nomenovo, String senhaNova) {
        if(!usuarios.containsKey(nomeAtual)){
            throw new IllegalArgumentException ("O usuario " + nomeAtual + "não existe!");
        }
        
        Usuario usuario = usuarios.get(nomeAtual);
        
        if(!usuario.getSenha().equals(senhaAtual)){
            throw new IllegalArgumentException("Senha Incorreta!");
        }
        
        usuario.setNomeUsuario(nomenovo);
        usuario.setSenha(senhaNova);
        
        usuarios.remove(nomeAtual);
        usuarios.put(nomenovo, usuario);
        
        gerenciarDisco.guardarDados(usuarios);
        
        return true;
    }

    @Override
    public Map<String, Usuario> getListaUsuarios() {
        return usuarios;
    }

    @Override
    public boolean logar(String user, String senha) {
        if(usuarios.containsKey(user)){
            
            Usuario usuario = usuarios.get(user);
            
            if(usuario.getSenha().equals(senha)){
                return true;
            }
        }
        
        return false;
    }
    
}
