/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package registrodepersonas;

import java.awt.HeadlessException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class RegistroDePersonas {

    public static void main(String[] args) throws ParseException {
        
        SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
        
        List<Persona> listaPersona = new ArrayList<>();
        
        //Empiesa el bucle do while
        String opcion = "";
        do {
            opcion = JOptionPane.showInputDialog(null, "***REGISTRO DE PERSONAS***\n\n1.Registrar una persona\n2.Mostrar lista de personas\n3.Salir\nElija una opccion");
            if (opcion == null) {
                opcion = "3";
            }
            
            //Selector de opciones
            
            switch (opcion) {
                case "1":
                    //Inicialisa al objeto persona
                    Persona persona = new Persona();
                    persona.setNombre(JOptionPane.showInputDialog(null, "Nombre de la persona"));
                    //Evalua si el dato se en blanco o nulo y si es verdadero
                    if ((persona.getNombre()==null) || "".equals(persona.getNombre())) {
                        JOptionPane.showMessageDialog(null, "No puede haber espacios en blanco");
                    } else {
                        persona.setApellido(JOptionPane.showInputDialog(null, "Apellido de  la persona"));
                        
                        if (null==persona.getApellido() || "".equals(persona.getApellido())) {
                            JOptionPane.showMessageDialog(null, "No puede haber espacios en blanco");
                        } else {
                            try {
                                persona.setDni(Integer.parseInt(JOptionPane.showInputDialog(null, "DNI de la persona")));
                            } catch (HeadlessException | NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Solo numeros y de 8 digitos");
                                break;
                            }
                            if (persona.getDni() <10000000 || persona.getDni() > 100000000 ) {
                                JOptionPane.showMessageDialog(null, "Solo numeros de 8 digitos");
                            } else {
                                System.out.println(persona.getDni());
                                try {
                                    persona.setFechaNacimiento(fecha.parse(JOptionPane.showInputDialog(null, "Fecha de nacimiento de la persona en formato dd/MM/yyyy")));
                                } catch (HeadlessException | ParseException e) {
                                    JOptionPane.showMessageDialog(null, "Fecha en formato incorrecto");
                                    break;
                                }
                                Date fechaActual = new Date();
                                if (!(persona.getFechaNacimiento().before(fechaActual))) {
                                    JOptionPane.showMessageDialog(null, "Fecha anterior a la actual");
                                } else {
                                    listaPersona.add(persona);
                                }

                            }
                        }
                    }
                    break;
                case "2":
                    String mostrar = "";
                    for (Persona pe : listaPersona) {
                        mostrar += pe.dato() + "\n";
                    }
                    JOptionPane.showMessageDialog(null, "Lista de alquileres\n\n" + mostrar);
                    break;
                default:
            }
        } while (!"3".equals(opcion));
    }
}
