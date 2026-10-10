package registry;

import prototype.Personaje;

import java.util.HashMap;
import java.util.Map;

public class RegistroPrototipos {

    private final Map<String, Personaje> prototipos = new HashMap<>();

    public void registrarPrototipo(String clave, Personaje personaje) {
        prototipos.put(clave, personaje);
    }

    public Personaje obtenerCopia(String clave) {
        Personaje prototipo = prototipos.get(clave);
        if (prototipo == null) {
            throw new IllegalArgumentException("No existe un prototipo con la clave: " + clave);
        }
        return prototipo.clonar();
    }

    // Solo para consulta/verificación del prototipo original
    public Personaje consultarPrototipo(String clave) {
        return prototipos.get(clave);
    }
}
