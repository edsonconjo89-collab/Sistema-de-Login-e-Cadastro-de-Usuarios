package service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import model.TipoConta;
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
        
        Map<String, Usuario> copiaUsuariosMap = new HashMap<>(usuarios);
        copiaUsuariosMap.remove(nomeAtual);
        
        if(copiaUsuariosMap.containsKey(nomenovo)){
            throw new IllegalArgumentException("Não foi possivel atualizar os dados!\nJa existe um usuario com nome " + nomenovo + ".");
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
    
    public Usuario getUser(String user){
        if(!usuarios.containsKey(user)){
            throw new IllegalArgumentException("Usuario requisitado inexistente.");
        }
        
        return usuarios.get(user);
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
    
    public int getNumeroDeUsuarios(){
        int quantidade = 0;
        
        if(usuarios == null){
            return quantidade;
        }
        
        for (Map.Entry<String, Usuario> entry : usuarios.entrySet()) {
           quantidade++;
            
        }
        
        return quantidade;
    }
    
    public boolean atualizarTipoConta(String nome, TipoConta tipoConta) {
        if(!usuarios.containsKey(nome)){
            throw new IllegalArgumentException ("O usuario " + nome + "não existe!");
        }
        
        Usuario usuario = usuarios.get(nome);
        
        usuario.setTipoConta(tipoConta);
        
        usuarios.remove(nome);
        usuarios.put(nome, usuario);
        
        gerenciarDisco.guardarDados(usuarios);
        
        return true;
    }

    
}
