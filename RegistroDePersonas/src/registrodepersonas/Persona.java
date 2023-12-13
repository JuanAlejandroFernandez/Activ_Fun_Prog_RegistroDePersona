/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registrodepersonas;

import java.awt.HeadlessException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class Persona {

    private String nombre;
    private String apellido;
    private int dni;
    private Date fechaNacimiento;
    SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
    
    public Persona(){}

    public Persona(String nombre, String apellido, int dni, Date fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String dato() {
        return "Nombre: " + nombre + " " + apellido + ", DNI: " + dni + ", fech. nac: " + fecha.format(fechaNacimiento) + ".";
    }

    

 

    
    //HeadlessException | NumberFormatException
    //
}
