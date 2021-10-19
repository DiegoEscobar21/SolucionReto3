package Solucion_Reto3.Reto3_Desarrollo.Controlador;

import Solucion_Reto3.Reto3_Desarrollo.Modelo.Doctor;
import Solucion_Reto3.Reto3_Desarrollo.Servicios.serviciosDoctor;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author diegoandres
 */

@RestController
@RequestMapping("/api/Doctor")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class DoctorWeb {
    
    @Autowired
    
    private serviciosDoctor servicios;
    
    @GetMapping("/all")
    
    public List<Doctor> getDoctors(){
        
        return servicios.getAll();
        
    }
    
    @GetMapping("/{id}")
    
    public Optional<Doctor> getDoctor(@PathVariable("id") int id){
        
        return servicios.getDoctor(id);
        
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)

    public Doctor save(@RequestBody Doctor doctor){
        
        return servicios.save(doctor);
        
    }
    
    
    @PutMapping ("/update")
    @ResponseStatus(HttpStatus.CREATED)
    
    public Doctor update (@RequestBody Doctor doctor){    
        return servicios.update(doctor);
        
    }
    
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    
    
    public boolean delete(@PathVariable ("id") int id){
        
        return servicios.deleteDoctor(id);
        
    }
 
    
}
