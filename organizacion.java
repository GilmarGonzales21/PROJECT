public abstract class organizacion {

    // Atributos
    private String nombre;
    private String correoElectronico;
    private String ubicacion;

    // Constructor
    public organizacion(String nombre, String correoElectronico, String ubicacion) {
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.ubicacion = ubicacion;
    }

    // Métodos Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    // Métodos abstractos
    public abstract String queEs();
    public abstract String aQueSeDedica();

    @Override
    public String toString() {
        return "Entidad{" +
                "nombre='" + nombre + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                '}';
    }
}
