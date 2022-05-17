public class Persona {
    private String nombre;
    private String poblacion;
    private Integer edad;


    public Persona(String nombre, String poblacion, Integer edad){
        this.nombre = nombre;
        this.poblacion = poblacion;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public Integer getEdad() {
        return edad;
    }
}
