# Rental bike
## Diseño y desarrollo
Para realizar este ejercicio, usé el patrón de diseño template-method. Esto se ve en la clase abstracta Rental, que dado un tiempo se fija el precio de su subclase instanciada para ver por cuanto multiplicar. Además si en el dia de mañana se agrega un nuevo rental que no es solo multiplicar el tiempo por su valor, se puede overridear el método ```calculatePrice(int time)```. Por último, ```FamilyRental``` recibe una ```List<PairRentalTime>``` que basicamente es una tupla de ```Rental``` y un ```int``` indicando el tiempo de cada rental. Además, verifica que se le pase de 3 a 5 rentals tirando un ```IllegalArgumentException``` en caso contrario.

## Tests
Para los tests utilicé Mockito y testNG. Para correrlos, se necesita tener testNG instalado (o compilar con maven el proyecto) y desde un IDE correr el archivo run-all.xml dentro de la carpeta test/resources.
