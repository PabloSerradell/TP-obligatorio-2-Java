package persistencia;

import java.util.List;
import logica.Perro;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.exceptions.NonexistentEntityException;


public class ControladoraPersistencia {
    
    PerroJpaController perrJPA = new PerroJpaController();
    
    //Método para alta de un perro
    public void crearPerro(Perro perr){
        
        try {
            perrJPA.create(perr);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Métodos para baja de una mascota, con mismo nombre pero distintos parámetros
    public void eliminarPerro(int id) {
        try {
            perrJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminarPerro(Perro perr) {
        try {
            perrJPA.destroy(perr.getId());
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Método para modificar un perro
    public void modificarPerro(Perro perr) {
        try {
            perrJPA.edit(perr);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Método para lectura de todos los perros a través de una lista
    public List<Perro> obtenerPerros() {
        
        return perrJPA.findPerroEntities();
    }
    
    //Métodos para lectura de un perro en particular, con mismo nombre pero distintos parámetros
    public Perro buscarPerroEnParticular(int id) {
        
        return perrJPA.findPerro(id);
    }
    
    public Perro buscarPerroEnParticular(Perro perr) {
        
        return perrJPA.findPerro(perr.getId());
    }
    
    
}
