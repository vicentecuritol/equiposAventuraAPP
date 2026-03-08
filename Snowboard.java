package modelo;

public class Snowboard extends EquipoAventura {

    private String tipoNieve;   // Polvo, Compacta, Mezcla

    public Snowboard(String codigo, String marca, String modelo,
                     int anio, String sucursal, String estado,
                     int precioDia, String tipoNieve) {

        super(codigo, marca, modelo, anio, sucursal, estado, precioDia);
        this.tipoNieve = tipoNieve;
    }

    public String getTipoNieve() { return tipoNieve; }

    public void setTipoNieve(String tipoNieve) { this.tipoNieve = tipoNieve; }

    @Override
    public String getTipoEquipo() {
        return "Snowboard";
    }

    @Override
    public String toString() {
        return super.toString() + ", Nieve=" + tipoNieve;
    }
}
