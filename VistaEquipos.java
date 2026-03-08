package vista;

import controlador.GestorEquipos;
import javax.swing.*;
import java.awt.*;

public class VistaEquipos extends JFrame {

    private GestorEquipos gestor;

    // Campos de entrada (equivalentes al examen)
    private JTextField txtCodigo;
    private JComboBox<String> cbTipoEquipo;
    private JComboBox<String> cbMarca;
    private JTextField txtModelo;
    private JTextField txtAnio;
    private JTextField txtSucursal;
    private JComboBox<String> cbEstado;
    private JTextField txtPrecioDia;
    private JComboBox<String> cbTipoAgua;   // específico Kayak
    private JComboBox<String> cbTipoNieve;  // específico Snowboard

    private JButton btnRegistrar;
    private JButton btnLimpiar;
    private JButton btnMostrarTodo;
    private JButton btnMostrarKayaks;
    private JButton btnMostrarSnowboards;

    private JTextArea txtAreaSalida;

    public VistaEquipos(GestorEquipos gestor) {
        this.gestor = gestor;
        initComponents();
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        // Inicializar componentes
        txtCodigo = new JTextField(10);
        cbTipoEquipo = new JComboBox<>(new String[]{"Kayak", "Snowboard"});
        cbMarca = new JComboBox<>(new String[]{"Salomon", "Burton", "O'Neill", "Otro"});
        txtModelo = new JTextField(10);
        txtAnio = new JTextField(4);
        txtSucursal = new JTextField(10);
        cbEstado = new JComboBox<>(new String[]{"Disponible", "En mantención", "No operativo"});
        txtPrecioDia = new JTextField(6);

        cbTipoAgua = new JComboBox<>(new String[]{"Rápido", "Lago", "Mar"});
        cbTipoNieve = new JComboBox<>(new String[]{"Polvo", "Compacta", "Mezcla"});

        btnRegistrar = new JButton("Registrar");
        btnLimpiar = new JButton("Limpiar");
        btnMostrarTodo = new JButton("Mostrar Todo");
        btnMostrarKayaks = new JButton("Mostrar Kayaks");
        btnMostrarSnowboards = new JButton("Mostrar Snowboards");

        txtAreaSalida = new JTextArea(15, 45);
        txtAreaSalida.setEditable(false);

        // Listeners
        cbTipoEquipo.addActionListener(e -> actualizarCamposEspecificos());
        btnRegistrar.addActionListener(e -> registrarEquipo());
        btnLimpiar.addActionListener(e -> limpiarCampos());
        btnMostrarTodo.addActionListener(e -> txtAreaSalida.setText(gestor.reporteGeneral()));
        btnMostrarKayaks.addActionListener(e -> txtAreaSalida.setText(gestor.reporteKayaks()));
        btnMostrarSnowboards.addActionListener(e -> txtAreaSalida.setText(gestor.reporteSnowboards()));

        // Panel de ingreso (equivalente al panel izquierdo del examen)
        JPanel panelIngreso = new JPanel(new GridBagLayout());
        panelIngreso.setBorder(BorderFactory.createTitledBorder("Ingreso Nuevo Equipo"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        int fila = 0;

        // Código
        gbc.gridx = 0; gbc.gridy = fila;
        panelIngreso.add(new JLabel("Código Equipo"), gbc);
        gbc.gridx = 1;
        panelIngreso.add(txtCodigo, gbc);
        fila++;

        // Tipo equipo
        gbc.gridx = 0; gbc.gridy = fila;
        panelIngreso.add(new JLabel("Tipo Equipo"), gbc);
        gbc.gridx = 1;
        panelIngreso.add(cbTipoEquipo, gbc);
        fila++;

        // Marca
        gbc.gridx = 0; gbc.gridy = fila;
        panelIngreso.add(new JLabel("Marca"), gbc);
        gbc.gridx = 1;
        panelIngreso.add(cbMarca, gbc);
        fila++;

        // Modelo
        gbc.gridx = 0; gbc.gridy = fila;
        panelIngreso.add(new JLabel("Modelo"), gbc);
        gbc.gridx = 1;
        panelIngreso.add(txtModelo, gbc);
        fila++;

        // Año
        gbc.gridx = 0; gbc.gridy = fila;
        panelIngreso.add(new JLabel("Año"), gbc);
        gbc.gridx = 1;
        panelIngreso.add(txtAnio, gbc);
        fila++;

        // Sucursal
        gbc.gridx = 0; gbc.gridy = fila;
        panelIngreso.add(new JLabel("Sucursal"), gbc);
        gbc.gridx = 1;
        panelIngreso.add(txtSucursal, gbc);
        fila++;

        // Estado
        gbc.gridx = 0; gbc.gridy = fila;
        panelIngreso.add(new JLabel("Estado"), gbc);
        gbc.gridx = 1;
        panelIngreso.add(cbEstado, gbc);
        fila++;

        // Precio día
        gbc.gridx = 0; gbc.gridy = fila;
        panelIngreso.add(new JLabel("Precio Día"), gbc);
        gbc.gridx = 1;
        panelIngreso.add(txtPrecioDia, gbc);
        fila++;

        // Tipo agua (Kayak)
        gbc.gridx = 0; gbc.gridy = fila;
        panelIngreso.add(new JLabel("Tipo Agua (Kayak)"), gbc);
        gbc.gridx = 1;
        panelIngreso.add(cbTipoAgua, gbc);
        fila++;

        // Tipo nieve (Snowboard)
        gbc.gridx = 0; gbc.gridy = fila;
        panelIngreso.add(new JLabel("Tipo Nieve (Snowboard)"), gbc);
        gbc.gridx = 1;
        panelIngreso.add(cbTipoNieve, gbc);
        fila++;

        // Panel Informe (equivalente al panel derecho del examen)
        JPanel panelInforme = new JPanel(new BorderLayout());
        panelInforme.setBorder(BorderFactory.createTitledBorder("Inventario Equipos Aventura"));
        panelInforme.add(new JScrollPane(txtAreaSalida), BorderLayout.CENTER);

        // Botones inferiores (misma idea que en el examen)
        JPanel panelBotones = new JPanel();
        panelBotones.add(btnRegistrar);
        panelBotones.add(btnLimpiar);
        panelBotones.add(btnMostrarTodo);
        panelBotones.add(btnMostrarKayaks);
        panelBotones.add(btnMostrarSnowboards);

        // Layout principal
        setLayout(new BorderLayout());
        JPanel centro = new JPanel(new GridBagLayout());
        GridBagConstraints gbcMain = new GridBagConstraints();
        gbcMain.insets = new Insets(8, 8, 8, 8);
        gbcMain.fill = GridBagConstraints.BOTH;
        gbcMain.weighty = 1.0;

        gbcMain.gridx = 0; gbcMain.gridy = 0;
        gbcMain.weightx = 0.4;
        centro.add(panelIngreso, gbcMain);

        gbcMain.gridx = 1;
        gbcMain.weightx = 0.6;
        centro.add(panelInforme, gbcMain);

        add(centro, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Inventario Equipos Deportivos de Aventura");

        pack();
        actualizarCamposEspecificos();
    }

    private void actualizarCamposEspecificos() {
        String tipo = (String) cbTipoEquipo.getSelectedItem();
        if ("Kayak".equals(tipo)) {
            cbTipoAgua.setEnabled(true);
            cbTipoNieve.setEnabled(false);
        } else {
            cbTipoAgua.setEnabled(false);
            cbTipoNieve.setEnabled(true);
        }
    }

    private void limpiarCampos() {
        txtCodigo.setText("");
        cbTipoEquipo.setSelectedIndex(0);
        cbMarca.setSelectedIndex(0);
        txtModelo.setText("");
        txtAnio.setText("");
        txtSucursal.setText("");
        cbEstado.setSelectedIndex(0);
        txtPrecioDia.setText("");
        cbTipoAgua.setSelectedIndex(0);
        cbTipoNieve.setSelectedIndex(0);
        txtAreaSalida.setText("");
        txtCodigo.requestFocus();
        actualizarCamposEspecificos();
    }

    private void registrarEquipo() {
        if (gestor == null) {
            JOptionPane.showMessageDialog(this,
                    "Error interno: gestor no inicializado.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String codigo = txtCodigo.getText().trim();
        String tipo = (String) cbTipoEquipo.getSelectedItem();
        String marca = (String) cbMarca.getSelectedItem();
        String modelo = txtModelo.getText().trim();
        String anioStr = txtAnio.getText().trim();
        String sucursal = txtSucursal.getText().trim();
        String estado = (String) cbEstado.getSelectedItem();
        String precioStr = txtPrecioDia.getText().trim();

        int anio;
        int precio;

        try {
            anio = Integer.parseInt(anioStr);
            precio = Integer.parseInt(precioStr);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Año y precio deben ser numéricos.",
                    "Validación", JOptionPane.WARNING_MESSAGE);
            return;
        }

        boolean ok;

        if ("Kayak".equals(tipo)) {
            String agua = (String) cbTipoAgua.getSelectedItem();
            ok = gestor.registrarKayak(
                    codigo, marca, modelo, anio,
                    sucursal, estado, precio, agua
            );
        } else {
            String nieve = (String) cbTipoNieve.getSelectedItem();
            ok = gestor.registrarSnowboard(
                    codigo, marca, modelo, anio,
                    sucursal, estado, precio, nieve
            );
        }

        if (!ok) {
            JOptionPane.showMessageDialog(this,
                    "Datos inválidos. Revise los campos.",
                    "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(this,
                "Equipo registrado correctamente.",
                "Información", JOptionPane.INFORMATION_MESSAGE);

        limpiarCampos();
    }
}
