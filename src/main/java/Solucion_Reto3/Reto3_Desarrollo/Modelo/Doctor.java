package Solucion_Reto3.Reto3_Desarrollo.Modelo;

/*
Importaciones
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author diegoandres
 */

@Entity
@Table(name = "doctor")

/*
clase Doctor 
*/
public class Doctor implements Serializable {
    
    /*
    id y generatedValue
    */
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    /*
    variable id de la clase doctor
    */
    private Integer id;
    
    /*
    variable name
    */
    
    private String name;
    
    /*
    variable deparment
    */
    
    private String department;
    
    /*
    variable year
    */
    
    private Integer year;
    
    /*
    variable description
    */
    
    private String description;

    /*
    Relacion de muchos a uno
    */
    
    @ManyToOne
    @JoinColumn(name = "specialtyId")
    @JsonIgnoreProperties("doctors")
    private Specialty specialty;
    
    /*
    Relacion de uno a muchos
    */
    
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "doctor")
    @JsonIgnoreProperties({"doctor","client"})
    private List<Message> messages;

    /*
    Relacion de uno a muchos
    */
    
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "doctor")
    @JsonIgnoreProperties({"doctor","messages"})
    public List<Reservation> reservations;

    /*
    getter de id
    */
    
    public Integer getId() {
        return id;
    }

    /*
    setter de id
    */
    
    public void setId(Integer id) {
        this.id = id;
    }

    /*
    getter de name
    */
    
    public String getName() {
        return name;
    }

    /*
    setter de name
    */
    
    public void setName(String name) {
        this.name = name;
    }

    /*
    getter de deparment
    */
    
    public String getDepartment() {
        return department;
    }

    /*
    setter de deparment
    */
    
    public void setDepartment(String department) {
        this.department = department;
    }

    /*
    getter de year
    */
    
    public Integer getYear() {
        return year;
    }

    /*
    setter de year
    */
    
    public void setYear(Integer year) {
        this.year = year;
    }

    /*
    getter de description
    */
    
    public String getDescription() {
        return description;
    }

    /*
    setter de description
    */
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    /*
    getter de specialty
    */

    public Specialty getSpecialty() {
        return specialty;
    }

    /*
    setter de specialty
    */
    
    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    /*
    getter de message
    */
    
    public List<Message> getMessages() {
        return messages;
    }

    /*
    setter de message
    */
    
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    /*
    getter de reservation
    */
    
    public List<Reservation> getReservations() {
        return reservations;
    }

    /*
    setter de reservation
    */
    
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    /*
    fin getters y setters
    */        
    
}

/*
Fin clase doctor
*/