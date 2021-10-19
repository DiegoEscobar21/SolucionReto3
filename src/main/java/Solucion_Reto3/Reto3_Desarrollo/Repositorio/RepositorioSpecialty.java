package Solucion_Reto3.Reto3_Desarrollo.Repositorio;

import Solucion_Reto3.Reto3_Desarrollo.Modelo.Specialty;
import Solucion_Reto3.Reto3_Desarrollo.RepositorioCrud.interfaceSpecialty;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author diegoandres
 */

@Repository

public class RepositorioSpecialty {
    
    @Autowired
    
    private interfaceSpecialty crud1;
    
    public List<Specialty> getAll(){
        
        return (List<Specialty>) crud1.findAll();
    }
    
    public Optional <Specialty> getSpecialty(int id){
        
        return crud1.findById(id);
        
    }
    
    public Specialty save(Specialty specialty){
        
        return crud1.save(specialty);
        
    }
        

    public void delete(Specialty specialty){  
        crud1.delete(specialty);   
    }
    
}
