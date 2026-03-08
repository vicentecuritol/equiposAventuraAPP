package modelo;

public abstract class EquipoAventura {

    private String codigo;
    private String marca;
    private String modelo;
    private int anio;
    private String sucursal;
    private String estado;
    private int precioDia;

    public EquipoAventura(String codigo, String marca, String modelo,
                          int anio, String sucursal, String estado,
                          int precioDia) {
        this.codigo = codigo;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.sucursal = sucursal;
        this.estado = estado;
        this.precioDia = precioDia;
    }

    public String getCodigo() { return codigo; }

    public String getMarca() { return marca; }

    public String getModelo() { return modelo; }

    public int getAnio() { return anio; }

    public String getSucursal() { return sucursal; }

    public String getEstado() { return estado; }

    public int getPrecioDia() { return precioDia; }

    public void setEstado(String estado) { this.estado = estado; }

    public void setPrecioDia(int precioDia) { this.precioDia = precioDia; }

    public abstract String getTipoEquipo();

    @Override
    public String toString() {
        return "Código=" + codigo +
                ", Tipo=" + getTipoEquipo() +
                ", Marca=" + marca +
                ", Modelo=" + modelo +
                ", Año=" + anio +
                ", Sucursal=" + sucursal +
                ", Estado=" + estado +
                ", PrecioDia=" + precioDia;
    }
}
