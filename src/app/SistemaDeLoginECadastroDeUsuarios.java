package app;

import java.util.Map;
import model.TipoConta;
import model.Usuario;
import service.ServicoUsuario;
import storage.UsuarioOO;

public class SistemaDeLoginECadastroDeUsuarios {
    public static void main(String[] args) {
        ServicoUsuario servico = null;
        
        try {
            UsuarioOO data = new UsuarioOO();
            servico = new ServicoUsuario(data);
            servico.atualizarDados("lol", "1234", "admin", "admin");
        } catch ( IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }catch(Exception e){
            System.out.println(e);
        }
        
        Map<String,Usuario> us = servico.getListaUsuarios();
        
        for (Map.Entry<String, Usuario> e : us.entrySet()) {
            System.out.println(e.getValue().getNomeUsuario() + " : " + e.getValue().getSenha() + "-" + e.getValue().getTipoConta());
            
        }

    }
    
}
