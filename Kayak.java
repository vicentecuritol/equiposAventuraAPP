package modelo;

public class Kayak extends EquipoAventura {

    private String tipoAgua;   // Rápido, Lago, Mar

    public Kayak(String codigo, String marca, String modelo,
                 int anio, String sucursal, String estado,
                 int precioDia, String tipoAgua) {

        super(codigo, marca, modelo, anio, sucursal, estado, precioDia);
        this.tipoAgua = tipoAgua;
    }

    public String getTipoAgua() { return tipoAgua; }

    public void setTipoAgua(String tipoAgua) { this.tipoAgua = tipoAgua; }

    @Override
    public String getTipoEquipo() {
        return "Kayak";
    }

    @Override
    public String toString() {
        return super.toString() + ", Agua=" + tipoAgua;
    }
}
