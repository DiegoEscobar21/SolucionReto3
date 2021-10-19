package Solucion_Reto3.Reto3_Desarrollo.Servicios;

import Solucion_Reto3.Reto3_Desarrollo.Modelo.Client;
import Solucion_Reto3.Reto3_Desarrollo.Repositorio.RepositorioClient;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author diegoandres
 */

@Service

public class serviciosClient {
    
    @Autowired
    
    private RepositorioClient metodosCrud;
    
    public List<Client> getAll(){
        return metodosCrud.getAll();
        
    }
    
    public Optional <Client> getClient(int clientId){ 
        return metodosCrud.getClient(clientId);
        
    }
    
    public Client save(Client client){
        
        if (client.getIdClient() == null){    
            return metodosCrud.save(client);
            
        } else {
            
            Optional <Client> evento3 = metodosCrud.getClient(client.getIdClient());
            
            if (evento3.isEmpty()){
                
                return metodosCrud.save(client);
                
            } else {
                
                return client;
                
            }
            
        }
        
    }
    

    public Client update(Client client){
        
        if (client.getIdClient() != null){
            
            Optional<Client> evento3 = metodosCrud.getClient(client.getIdClient());
            
            if(!evento3.isEmpty()){
                
                if (client.getName() != null){
                
                    evento3.get().setName(client.getName());
                
                }
                
                if (client.getAge() != null ){
                    
                    evento3.get().setAge(client.getAge());
                    
                }
                
                if(client.getPassword() != null ){
                    
                    evento3.get().setPassword(client.getPassword());
                    
                }
                                
                metodosCrud.save(evento3.get());
                
                return evento3.get();
                
            } else {
                
                return client;
                
            }
               
        } else {
            
            return client;
            
        }
               
    }
    
    
    public boolean deleteClient(int clientId){
        
        Boolean cBoolean = getClient(clientId).map(client -> {
            
            metodosCrud.delete(client);
            return true;
            
        }).orElse(false);
        
        return cBoolean;
        
    }    
    
}
