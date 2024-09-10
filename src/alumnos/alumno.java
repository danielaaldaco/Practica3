package alumnos;

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

}
