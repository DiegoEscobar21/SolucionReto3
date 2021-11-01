package Solucion_Reto3.Reto3_Desarrollo.Repositorio;

import Solucion_Reto3.Reto3_Desarrollo.Modelo.Client;
import Solucion_Reto3.Reto3_Desarrollo.Modelo.Reservation;
import Solucion_Reto3.Reto3_Desarrollo.Reportes.ContadorClientes;
import Solucion_Reto3.Reto3_Desarrollo.RepositorioCrud.interfaceReservation;
import java.util.ArrayList;
import java.util.Date;
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
    
    public void delete(Reservation reservation){
        crud4.delete(reservation);
    }
    
    
    public List <Reservation> ReservacionStatus (String status){
        
        return crud4.findAllByStatus(status);   
    }
    
    public List <Reservation> ReservacionTiempo (Date a, Date b){
        
        return crud4.findAllByStartDateAfterAndStartDateBefore(a, b);
    }
    
    public List <ContadorClientes> getTopClientes(){
        
        List <ContadorClientes> res = new ArrayList <> ();
        List< Object[] > report = crud4.countTotalReservationsByClient();
        
        for(int i=0; i < report.size();i++){
             res.add(new ContadorClientes((Long)report.get(i)[1],(Client) report.get(i)[0]));
         
         }
         return res;
        
    }
    
    
}
