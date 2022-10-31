/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.chocoflan.entidades;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chiqu
 */
public class Servicio extends Concepto {
    
    @Override
    public List<Impuesto> calcularImpuestos(){
        List<Impuesto> impuestos = new ArrayList<>();
        
        Impuesto iva = new Impuesto();
        iva.setNombre("IVA");
        iva.setMonto(getPrecio() * 0.16);
        
        Impuesto isr = new Impuesto();
        isr.setNombre("ISR");
        isr.setMonto(getPrecio() * 0.30);
        
        impuestos.add(iva);
        impuestos.add(isr);
        
        return impuestos;
    }
    
    public double calcularTotal(){
        double precio = getPrecio();
        
        return precio;
    }
    
    public double calcularTotal(List<Impuesto> impuestos) {
        double precio = getPrecio();
        
        for(Impuesto i : impuestos) {
            precio += i.getMonto();
        }
        
        return precio;
    }
    
}
