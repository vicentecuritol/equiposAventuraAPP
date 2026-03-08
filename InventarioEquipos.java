package datos;

import java.util.ArrayList;
import modelo.EquipoAventura;

public class InventarioEquipos {

    private ArrayList<EquipoAventura> equipos;

    public InventarioEquipos() {
        equipos = new ArrayList<>();
    }

    public void agregar(EquipoAventura e) {
        equipos.add(e);
    }

    public String listarTodo() {
        if (equipos.isEmpty()) {
            return "No hay equipos registrados.\n";
        }
        StringBuilder sb = new StringBuilder();
        for (EquipoAventura e : equipos) {
            sb.append(e.toString()).append("\n");
        }
        return sb.toString();
    }

    public String listarPorTipo(String tipoBuscado) {
        StringBuilder sb = new StringBuilder();
        for (EquipoAventura e : equipos) {
            if (e.getTipoEquipo().equalsIgnoreCase(tipoBuscado)) {
                sb.append(e.toString()).append("\n");
            }
        }
        if (sb.length() == 0) {
            sb.append("No hay equipos del tipo ").append(tipoBuscado).append(".\n");
        }
        return sb.toString();
    }
}
