package alumnos;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class alumno {
    private String nombre;
    private String apaterno;
    private String amaterno;
    private String CURP;
    private String telefono;
    private String correo;
    private boolean discapacidad;
    private String sexo;
    private int edad;

    public alumno(String nombre, String apaterno, String amaterno, String CURP, String telefono, String correo, String sexo
    , boolean discapacidad) {
        this.nombre = nombre;
        this.apaterno = apaterno;
        this.amaterno = amaterno;
        this.CURP = CURP;
        this.telefono = telefono;
        this.correo = correo;
        this.sexo = sexo;
        this.discapacidad = discapacidad;
    }



    public String getNombre() {
        return nombre;
    }

    public String getApaterno(){
        return apaterno;
    }

    public String getAMaterno() {
        return amaterno;
    }

    public String getCURP() {
        return CURP;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public String getDiscapacidad() {
        if(discapacidad==true)
            return "Si";
        else
            return "No";
    }

    public String getSexo(){
        return sexo;
    }

    public int getEdad(){
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String curp = getCURP();

        String año = curp.substring(4,6);
        String mes = curp.substring(6,8);
        String dia = curp.substring(8,10);

        int años = Integer.parseInt(año);

        if(años >= 0 &&  años <= 23){
            año = "20" + año;
        }else{
            año = "19" + año;
        }

        String fechaCurp = dia + "/" + mes + "/" + año;

        LocalDate fechaNac = LocalDate.parse(fechaCurp, fmt);
        LocalDate ahora = LocalDate.now();

        Period edad = Period.between(fechaNac, ahora);
        return edad.getYears();
    }

}
