package Solucion_Reto3.Reto3_Desarrollo.Repositorio;

import Solucion_Reto3.Reto3_Desarrollo.Modelo.Reservation;
import Solucion_Reto3.Reto3_Desarrollo.RepositorioCrud.interfaceReservation;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author diegoandres
 */

@Repository

public class RepositorioReservation {
 
    @Autowired
    
    private interfaceReservation crud4;
    
    public List<Reservation> getAll(){
        return (List<Reservation>) crud4.findAll();        
    }
    
    public Optional<Reservation> getReservation(int id){
        return crud4.findById(id);
    }
    
    public Reservation save(Reservation reservation){
        return crud4.save(reservation);
    }
    
    public void delete(Reservation reservations){
        crud4.delete(reservations);
    }
    
}
