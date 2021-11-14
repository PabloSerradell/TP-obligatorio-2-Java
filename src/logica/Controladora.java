package logica;

import java.util.List;
import persistencia.ControladoraPersistencia;

public class Controladora {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    public void crearPerro (String numero_cliente, String nombre_perro, String raza, String color, boolean alergico, boolean atencion_especial, String nombre_duenio, String celular_duenio, String observaciones){
        
        Perro perr = new Perro();
        perr.setNum_cliente(numero_cliente);
        perr.setNombre_perro(nombre_perro);
        perr.setRaza(raza);
        perr.setColor(color);
        perr.setAlergico(alergico);
        perr.setAtencion_especial(atencion_especial);
        perr.setNombre_duenio(nombre_duenio);
        perr.setCelular_duenio(celular_duenio);
        perr.setObservaciones(observaciones);
        
        controlPersis.crearPerro(perr);
    }
    
    public void crearPerro (Perro perr){
        controlPersis.crearPerro(perr);
    }
    
    public void bajaPerro (int id){
        controlPersis.eliminarPerro(id);
    }
    
    public void bajaPerro (Perro perr){
        controlPersis.eliminarPerro(perr);
    }
    
    public void modificarPerro (Perro perr){
        controlPersis.modificarPerro(perr);
    }
    
    public List<Perro> obtenerPerros (){
        return controlPersis.obtenerPerros();
    }
    
    //Método al que se debe llamar desde la lógica para mostrar por pantalla la lista de perros con sus datos
    public void mostrarPerros (){
        List<Perro> lista = controlPersis.obtenerPerros();
        for (Perro perrito: lista){
            System.out.println("");
            System.out.println("Numero de cliente: " + perrito.getNum_cliente());
            System.out.println("");
            System.out.println("Nombre del perro: " + perrito.getNombre_perro() + ";");
            System.out.println("Raza: " + perrito.getRaza() + ";");
            System.out.println("Color: " + perrito.getColor() + ";");
            System.out.println("Es alérgico: " + perrito.isAlergico() + ";");
            System.out.println("Tiene atención especial: " + perrito.isAtencion_especial() + ";");
            System.out.println("Nombre del dueño: " + perrito.getNombre_duenio() + ";");
            System.out.println("Celular del dueño: " + perrito.getCelular_duenio() + ";");
            System.out.println("Observaciones: " + perrito.getObservaciones() + ".");
            System.out.println("");
            System.out.println("-------");
        }
    }
    
    public Perro buscarPerro (int id){
        return controlPersis.buscarPerroEnParticular(id);
    }
    
    public Perro buscarPerro (Perro perr){
        return controlPersis.buscarPerroEnParticular(perr);
    }
    
    
}
