package storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import model.Usuario;

public class UsuarioOO implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private final String file = "usuarios.bin";
    private Map<String,Usuario> usuarios;

    public UsuarioOO() {
        
        
    }
    
    
    
    public void guardarDados(Map<String,Usuario> usuarios){
        
        ObjectOutputStream oos = null;
        
        try {
            oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(usuarios);
        } catch (IOException e) {
            throw new IllegalArgumentException("Erro ao ler dados!");
        }finally{
            if(oos != null){
                try {
                    oos.close();
                } catch (IOException e) {
                    throw new IllegalArgumentException("Erro ao ler dados!");
                }
            }
        }
        
    }
    
    public Map<String,Usuario> lerDados(){
        ObjectInputStream ois = null;
        
        File fl  = new File(file);
        
        if(!fl.exists()){
            try{
                fl.createNewFile();
            }catch(IOException e){
               throw new IllegalArgumentException("Erro ao Salvar!");
            }
            
            return new HashMap<>();
        }
        
        if(fl.length() == 0){
            return new HashMap<>();
        }
        
        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            usuarios = (Map<String, Usuario>) ois.readObject();
            return usuarios;
        }catch(ClassNotFoundException e){
            throw new IllegalArgumentException("Erro ao ler dados: Classe nao encontrada!");
        }catch(FileNotFoundException e){
            throw new IllegalArgumentException("Erro: dados nao encontrados!");
        }catch(IOException e){
            throw new IllegalArgumentException("Erro ao ler dados!");
        }finally{
            if(ois != null){
                try {
                    ois.close();
                } catch (Exception e) {
                    System.err.println(e);
                }
            }
        }
        
        
    }
}

