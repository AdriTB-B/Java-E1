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

public class Main {
    public static void main(String[] args) {
        System.out.println("Ejercicio 1");
    }
}
