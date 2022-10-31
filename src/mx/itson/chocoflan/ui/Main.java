/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mx.itson.chocoflan.ui;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import mx.itson.chocoflan.entidades.Impuesto;
import mx.itson.chocoflan.entidades.Producto;
import mx.itson.chocoflan.entidades.Servicio;

/**
 *
 * @author chiqu
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Introduza el nombre:");
        String nombre = in.nextLine();

        System.out.println("Introduza la descripcion:");
        String descripcion = in.nextLine();

        System.out.println("Introduza el precio:");
        double precio = in.nextDouble();

        System.out.println("Indique 1 si es producto o 2 si es servicio");
        int tipo = in.nextInt();

        Locale local = new Locale("es", "MX");
        NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(local);

        if (tipo == 1) {
            System.out.println("Introduza la cantidad");
            int cantidad = in.nextInt();

            Producto p = new Producto();
            p.setNombre(nombre);
            p.setDescripcion(descripcion);
            p.setPrecio(precio);
            p.setCantidad(cantidad);

            System.out.println("**********************************");
            System.out.println(p.toString());

            System.out.println("SUBTOTAL: " + formatoMoneda.format(p.calcularTotal()));

            List<Impuesto> impuestos = p.calcularImpuestos();

            for (Impuesto i : impuestos) {
                System.out.println(i.getNombre() + " = " + formatoMoneda.format(i.getMonto()));
            }

            System.out.println("TOTAL: " + formatoMoneda.format(p.calcularTotal(impuestos)));
        } else {

            Servicio s = new Servicio();
            s.setNombre(nombre);
            s.setDescripcion(descripcion);
            s.setPrecio(precio);

            System.out.println("**********************************");
            System.out.println(s.toString());

            System.out.println("SUBTOTAL: " + formatoMoneda.format(s.getPrecio()));

            List<Impuesto> impuestos = s.calcularImpuestos();
            for (Impuesto i : impuestos) {
                System.out.println(i.getNombre() + " = " + formatoMoneda.format(i.getMonto()));
            }
            System.out.println("TOTAL: " + formatoMoneda.format(s.calcularTotal(impuestos)));

        }

    }
}
