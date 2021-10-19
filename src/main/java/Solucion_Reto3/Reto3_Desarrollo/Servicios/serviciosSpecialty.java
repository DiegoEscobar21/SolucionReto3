package Solucion_Reto3.Reto3_Desarrollo.Servicios;

import Solucion_Reto3.Reto3_Desarrollo.Modelo.Specialty;
import Solucion_Reto3.Reto3_Desarrollo.Repositorio.RepositorioSpecialty;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author diegoandres
 */

@Service

public class serviciosSpecialty {
    
   @Autowired
    
    private RepositorioSpecialty metodosCrud;
    
    public List<Specialty> getAll(){
        
        return metodosCrud.getAll();
                
    }
    
    public Optional<Specialty> getSpecialty(int id){
        
        return metodosCrud.getSpecialty(id);
        
    }
    
    public Specialty save(Specialty specialty){
        
        if (specialty.getId() == null){
            
            return metodosCrud.save(specialty);
                      
        } else {
            
            Optional <Specialty> evento1 = metodosCrud.getSpecialty(specialty.getId());
            
            if (evento1.isEmpty()){
                
                return metodosCrud.save(specialty);
                
            } else{
                
                return specialty;
                
            }
            
        } 
        
    }
    

    public Specialty update (Specialty specialty){
        
        if (specialty.getId() != null){
            
            Optional<Specialty> evento1 = metodosCrud.getSpecialty(specialty.getId());
            
            if (!evento1.isEmpty()){
                
                if (specialty.getDescription() != null){
                    
                    evento1.get().setDescription(specialty.getDescription());
                    
                }
                
                if (specialty.getName() != null){
                    
                    evento1.get().setName(specialty.getName());
                    
                }
                
                return metodosCrud.save(evento1.get());
                
            }
            
        }
        
        return specialty;
        
    }
    
    
    public boolean deleteSpecialty(int id){
        
        boolean aBoolean = getSpecialty(id).map(specialty -> {
            
            metodosCrud.delete(specialty);
            return true;
            
        }).orElse(false);
        
        return aBoolean;
        
    }
     
    
}
