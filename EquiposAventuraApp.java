package equiposaventuraapp;

import controlador.GestorEquipos;
import datos.InventarioEquipos;
import vista.VistaEquipos;

public class EquiposAventuraApp {

    public static void main(String[] args) {

        InventarioEquipos inventario = new InventarioEquipos();
        GestorEquipos gestor = new GestorEquipos(inventario);

        javax.swing.SwingUtilities.invokeLater(() -> {
            new VistaEquipos(gestor).setVisible(true);
        });
    }
}
