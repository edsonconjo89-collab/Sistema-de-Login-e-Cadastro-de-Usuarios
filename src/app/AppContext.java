/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import java.io.IOException;
import service.ServicoUsuario;
import storage.UsuarioOO;

/**
 *
 * @author upo
 */
public class AppContext {
    public static ServicoUsuario servicoUsuario;
    
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
}
