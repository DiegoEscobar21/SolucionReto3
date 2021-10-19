package Solucion_Reto3.Reto3_Desarrollo.Controlador;

import Solucion_Reto3.Reto3_Desarrollo.Modelo.Specialty;
import Solucion_Reto3.Reto3_Desarrollo.Servicios.serviciosSpecialty;
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
@RequestMapping("/api/Specialty")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class SpecialtyWeb {
    
    @Autowired
    
    private serviciosSpecialty servicio;
    
    @GetMapping("/all")
    
    public List<Specialty> getSpecialtys(){
        
        return servicio.getAll();
        
    }
    
    @GetMapping("/{id}")
    
    public Optional<Specialty> getSpecialty(@PathVariable("id") int id){
        
        return servicio.getSpecialty(id);
        
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)

    public Specialty save(@RequestBody Specialty specialty){
        
        return servicio.save(specialty);
        
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Specialty update(@RequestBody Specialty specialty) {
        return servicio.update(specialty);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return servicio.deleteSpecialty(id);
    }
    
    
}
