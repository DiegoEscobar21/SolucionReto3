package Solucion_Reto3.Reto3_Desarrollo.Servicios;

import Solucion_Reto3.Reto3_Desarrollo.Modelo.Doctor;
import Solucion_Reto3.Reto3_Desarrollo.Repositorio.RepositorioDoctor;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author diegoandres
 */

@Service

public class serviciosDoctor {
    
   @Autowired

    private RepositorioDoctor metodosCrud;

    public List<Doctor> getAll() {

        return metodosCrud.getAll();

    }

    public Optional<Doctor> getDoctor(int id) {

        return metodosCrud.getDoctor(id);

    }

    public Doctor save(Doctor doctor) {

        if (doctor.getId()== null) {

            return metodosCrud.save(doctor);

        } else {

            Optional<Doctor> evento2 = metodosCrud.getDoctor(doctor.getId());

            if (evento2.isEmpty()) {

                return metodosCrud.save(doctor);

            } else {

                return doctor;

            }

        }

    }
    

    public Doctor update(Doctor doctor){
        
        if (doctor.getId()!= null){
            
            Optional<Doctor> evento2 = metodosCrud.getDoctor(doctor.getId());
            
            if (!evento2.isEmpty()){
                
                if(doctor.getName() != null){
                    
                    evento2.get().setName(doctor.getName());
                    
                }
                
                if (doctor.getDepartment() != null){
                    
                    evento2.get().setDepartment(doctor.getDepartment());
                    
                }
                
                if (doctor.getYear() != null){
                    
                    evento2.get().setYear(doctor.getYear());
                    
                }
                
                if (doctor.getDescription() != null){
                    
                    evento2.get().setDescription(doctor.getDescription());
                    
                }
                
                if (doctor.getSpecialty() != null){
                    
                    evento2.get().setSpecialty(doctor.getSpecialty());
                    
                }
                
                metodosCrud.save(evento2.get());
                
                return evento2.get();
                
            } else {
                
                return doctor;
                
            }
            
        } else {
            
            return doctor;
            
        }
        
    }
    
    
    public boolean deleteDoctor(int id){
        
        Boolean bBoolean = getDoctor(id).map(doctor -> {
            
            metodosCrud.delete(doctor);
            return true;
            
        }).orElse(false);
        
        return bBoolean;
    }
    
 
    
}
