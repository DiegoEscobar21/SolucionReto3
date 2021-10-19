package Solucion_Reto3.Reto3_Desarrollo.Servicios;

import Solucion_Reto3.Reto3_Desarrollo.Modelo.Message;
import Solucion_Reto3.Reto3_Desarrollo.Repositorio.RepositorioMessage;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author diegoandres
 */

@Service

public class serviciosMessage {
    
    @Autowired
    
    private RepositorioMessage metodosCrud;
    
    public List<Message> getAll(){ 
        return metodosCrud.getAll();
        
    }
    
    public Optional <Message> getMessage(int messageId){
        return metodosCrud.getMessage(messageId);
                
    }
    
    public Message save(Message message){
        if (message.getIdMessage() == null){
            
            return metodosCrud.save(message);
            
        } else {
            
            Optional<Message> evento4 = metodosCrud.getMessage(message.getIdMessage());
            
            if(evento4.isEmpty()){
                
                return metodosCrud.save(message);
                
            } else {
                
                return message;
                
            }
            
        }
        
    }
    

    public Message update(Message message){
        
        if (message.getIdMessage() != null){
            
            Optional <Message> evento4 = metodosCrud.getMessage(message.getIdMessage());
            
            if (!evento4.isEmpty()){
                
                if (message.getMessageText() != null){
                
                    evento4.get().setMessageText(message.getMessageText());
                
                }
            
                metodosCrud.save(evento4.get());
            
                return evento4.get();
            
            } else {
            
                return message;
                
            }
                
        } else {
                
            return message;
                
        }
     
    }

    

    public boolean deleteMessage(int messageId){
        
        Boolean dBoolean = getMessage(messageId).map(message -> {
            
            metodosCrud.delete(message);
            return true;
            
        }).orElse(false);
        
        return dBoolean;
        
    }
    
    
}
