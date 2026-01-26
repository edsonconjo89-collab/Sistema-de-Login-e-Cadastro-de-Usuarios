/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import java.util.Map;
import model.Usuario;
import service.ServicoUsuario;
import storage.UsuarioOO;

/**
 *
 * @author upo
 */
public class AppContext {
    public static ServicoUsuario servicoUsuario;
    private static Usuario usuario; 
    
    public static void inicializar(){
        UsuarioOO data = new UsuarioOO();
        servicoUsuario = new ServicoUsuario(data);
    }
    
    public static ServicoUsuario getInstanceServicoUsuario(){
        if(servicoUsuario == null){
            inicializar();
        }
        return  servicoUsuario;
    }
    
    public static void setUsuarioLogado(String user){
        Map<String,Usuario> users = servicoUsuario.getListaUsuarios();
        AppContext.usuario = users.get(user);
    }
    
    public static Usuario getUsuarioLogado(){
        return usuario;
    }
    
    public static void logout(){
        setUsuarioLogado(null);
    }
    
}
