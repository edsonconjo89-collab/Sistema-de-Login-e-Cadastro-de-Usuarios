package app;

import java.util.Map;
import model.Usuario;
import service.ServicoUsuario;
import storage.UsuarioOO;
import ui.TelaLogin;

public class SistemaDeLoginECadastroDeUsuarios {
    public static void main(String[] args) {
        //so sao testes do crud
//        ServicoUsuario servico = null;
        ServicoUsuario servico = AppContext.getInstanceServicoUsuario();
           
           
           boolean isValid = servico.logar("gg", "admin");
           if(isValid){
               System.out.println("Logado com sucesso!");
            }else{
               System.err.println("nome ou user incorretos");
            }
//        try {
//            UsuarioOO data = new UsuarioOO();
//            servico = new ServicoUsuario(data);
//            
//        } catch ( IllegalArgumentException e) {
//            System.err.println(e.getMessage());
//        }catch(Exception e){
//            System.out.println(e);
//        }
        
        Map<String,Usuario> us = servico.getListaUsuarios();
        
        for (Map.Entry<String, Usuario> e : us.entrySet()) {
            System.out.println(e.getValue().getNomeUsuario() + " : " + e.getValue().getSenha() + "-" + e.getValue().getTipoConta());
            
        }

    }
    
}
