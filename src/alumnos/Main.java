package alumnos;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.sql.SQLOutput;

//para que haya comunicacion entre el frm y el main se necesita un interface
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                frmAlumnos pantalla = new frmAlumnos();
                pantalla.setVisible(true);


                pantalla.setBotonGuardarListener(new BotonGuardarListener() {
                    @Override
                    public void guardando(alumno persona) {
                        System.out.println("Nombre: " + persona.getNombre());
                        System.out.println("A. Paterno: " + persona.getApaterno());
                        System.out.println("A. Materno: " + persona.getAMaterno());
                        System.out.println("CURP: " + persona.getCURP());
                        System.out.println("Telefono: " + persona.getTelefono());
                        System.out.println("Correo: " + persona.getCorreo());
                        System.out.println("Sexo: " + persona.getSexo());
                        System.out.println("Discapacidad: " + persona.getDiscapacidad());
                        System.out.println("Edad: " + persona.getEdad() + " años");

                        Path path = Path.of("C:\\repos\\daniela.txt");

                        String contenido = "Nombre: " + persona.getNombre() + "\nA. Paterno: "+ persona.getApaterno() + "\nA. Materno: "+ persona.getAMaterno()
                                + "\nCURP: " +persona.getCURP() + "\nTelefono:" +persona.getTelefono() + "\nCorreo: " +persona.getCorreo() + "\nSexo: " +persona.getSexo()
                                +"\nDiscapacidad: " +persona.getDiscapacidad() + "\nEdad: "+ persona.getEdad() + " años" + "\n";

                        try(FileWriter archivo = new FileWriter(path.toFile() , true)) {
                            PrintWriter pw = new PrintWriter(archivo);
                            pw.println(contenido);
                            //archivo.write(contenido);


                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }


                });
            }
        });
    }
}