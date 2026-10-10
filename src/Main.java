import model.Inventario;
import prototype.Personaje;
import registry.RegistroPrototipos;

public class Main {

    public static void main(String[] args) {
        RegistroPrototipos registro = new RegistroPrototipos();

        Inventario invGuerrero = new Inventario();
        invGuerrero.agregarItem("Poción de vida");
        registro.registrarPrototipo("Guerrero", new Personaje("Guerrero", "Guerrero", invGuerrero));

        Inventario invMago = new Inventario();
        invMago.agregarItem("Bastón arcano");
        invMago.agregarItem("Poción de maná");
        registro.registrarPrototipo("Mago", new Personaje("Mago", "Mago", invMago));

        Personaje guerreroCopia = registro.obtenerCopia("Guerrero");
        guerreroCopia.setNombre("Guerrero-Copia");

        Personaje magoCopia = registro.obtenerCopia("Mago");
        magoCopia.setNombre("Mago-Copia");

        System.out.println("***  Después de clonar *** ");
        System.out.println(guerreroCopia);
        System.out.println(magoCopia);

        guerreroCopia.getInventario().agregarItem("Escudo");

        System.out.println("\n***  Después de agregar 'Escudo' a Guerrero-Copia *** ");
        System.out.println(guerreroCopia);
        System.out.println(registro.consultarPrototipo("Guerrero") + "  <- prototipo original");
        System.out.println(registro.consultarPrototipo("Mago") + "  <- prototipo original");

        System.out.println("\n***  Prototipo inexistente *** ");
        try {
            registro.obtenerCopia("Arquero");
        } catch (IllegalArgumentException e) {
            System.out.println("Error controlado: " + e.getMessage());
        }
    }
}