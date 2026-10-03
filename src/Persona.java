public class Persona {

    private String idPersona;
    private String nombre;
    private byte edad;
    private String correo;
    private String telefono;

    // Constructores
    public Persona() {
    }

    public Persona(String idPersona, String nombre) {
        this.idPersona = idPersona;
        this.nombre = nombre;
    }

    public Persona(String idPersona, String nombre, byte edad, String correo, String telefono) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
        this.telefono = telefono;
    }

    // Getters y Setters
    public String getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte getEdad() {
        return edad;
    }

    public void setEdad(byte edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // Métodos
    public String consultarDatos() {
        return "ID: " + idPersona
                + " | Nombre: " + nombre
                + " | Edad: " + edad
                + " | Correo: " + correo
                + " | Teléfono: " + telefono;
    }

    public void actualizarDatos(String correo, String telefono) {
        this.correo = correo;
        this.telefono = telefono;
    }
}
