//Ejercicio 1
//Leer este fichero de texto separado por dos puntos (:). Tener en cuenta que es posible que falte el ultimo campo o que cualquier campo pueda estar vacío.
//Los campos serán los siguientes:
//Nombre:Población:Edad
//
//Contenido fichero:
//Jesús:Logroño:41
//Andres:Madrid:19
//Angel Mari:Valencia
//Laura Saenz::23
//Maria Calvo::38
//
//Se deben meter todas las líneas en un objeto tipo: List<Persona>, donde Persona será una clase con estos campos: nombre, población y edad.
//Usando Streams, mostrar en pantalla los datos de las personas que sean menores de 25 años. Usar Optional (la clase) para controlar si el valor de un campo está vacío (null)
//Salida esperada;
//Línea 1. Nombre: Andres. Población: Madrid. Edad: 19
//Línea 2: Nombre: Laura Sáenz. Población: Desconocida Edad:23
//
//Importante: Para realizar este ejercicio NO se debe utilizar ningún bucle, excepto cuando estemos leyendo el archivo que se puede utilizar un while.

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class LectorFichero {

    public static void main(String[] args) {
        System.out.println("Ejercicio 1");

        List<List<String>> datosPersonas = leerFichero(Path.of("src/fichero.txt"));
        List<Optional<Persona>> personas = new ArrayList<>();
        datosPersonas.forEach(d -> {
            String nombre = d.get(0);
            String poblacion = d.get(1);
            Integer edad;
            if(d.get(2) != null) {
                edad = Integer.parseInt(d.get(2).trim());
            }else{
                edad = null;
            }
            personas.add(
                    Optional.of(new Persona(
                            nombre,
                            poblacion,
                            edad
                    ))
            );
        });

        personas.stream()
                .filter(oP -> oP.filter(persona -> persona.getEdad() != null && persona.getEdad() > 25).isPresent())
                .forEach(oP -> {
            System.out.print("Nombre: " + oP.map(Persona::getNombre).orElse("Sin nombre"));
            System.out.print(". Población: " + oP.map(Persona::getPoblacion).orElse("Desconocida"));
            System.out.print(". Edad: " + oP.map(Persona::getEdad).orElse(0));
            System.out.println();
        });

    }

    private static List<List<String>> leerFichero(Path rutaFichero) {
        File fichero = null;
        FileReader fr = null;
        BufferedReader br = null;
        List<List<String>> datos = new ArrayList<>();
        try{
            fichero = new File(rutaFichero.toUri());
            fr = new FileReader(fichero);
            br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null){
                List<String> datosLinea = new ArrayList<>();

                Arrays.asList(linea.split(":")).forEach(i ->{
                    if(i.isEmpty()) i = null;
                    datosLinea.add(i);
                });

                if(datosLinea.size() == 2) datosLinea.add(null);

                datos.add(datosLinea);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  datos;
    }
}
