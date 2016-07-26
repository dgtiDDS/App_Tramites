package tutorials.hackro.com.prototipopagossfa.Models;

/**
 * Created by david on 26/07/16.
 */
public class responseGeneraReferencia {

    private int Secuencia;
    private String NumeroReferencia;
    private String Nombre;
    private String ClaveServicio;
    private String DescripcionCorta;
    private String Total;
    private String FechaVigencia;
    private String FechaEmision;
    private int Pagos;
    private String DescripcionServicio;
    private int Estatus;
    private String DescripcionEstatus;

    public responseGeneraReferencia(int secuencia, String numeroReferencia, String nombre, String claveServicio, String descripcionCorta, String total, String fechaVigencia, String fechaEmision, int pagos, String descripcionServicio, int estatus, String descripcionEstatus) {
        Secuencia = secuencia;
        NumeroReferencia = numeroReferencia;
        Nombre = nombre;
        ClaveServicio = claveServicio;
        DescripcionCorta = descripcionCorta;
        Total = total;
        FechaVigencia = fechaVigencia;
        FechaEmision = fechaEmision;
        Pagos = pagos;
        DescripcionServicio = descripcionServicio;
        Estatus = estatus;
        DescripcionEstatus = descripcionEstatus;
    }

    public responseGeneraReferencia() {
    }

    public int getSecuencia() {
        return Secuencia;
    }

    public void setSecuencia(int secuencia) {
        Secuencia = secuencia;
    }

    public String getNumeroReferencia() {
        return NumeroReferencia;
    }

    public void setNumeroReferencia(String numeroReferencia) {
        NumeroReferencia = numeroReferencia;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getClaveServicio() {
        return ClaveServicio;
    }

    public void setClaveServicio(String claveServicio) {
        ClaveServicio = claveServicio;
    }

    public String getDescripcionCorta() {
        return DescripcionCorta;
    }

    public void setDescripcionCorta(String descripcionCorta) {
        DescripcionCorta = descripcionCorta;
    }

    public String getTotal() {
        return Total;
    }

    public void setTotal(String total) {
        Total = total;
    }

    public String getFechaVigencia() {
        return FechaVigencia;
    }

    public void setFechaVigencia(String fechaVigencia) {
        FechaVigencia = fechaVigencia;
    }

    public String getFechaEmision() {
        return FechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        FechaEmision = fechaEmision;
    }

    public int getPagos() {
        return Pagos;
    }

    public void setPagos(int pagos) {
        Pagos = pagos;
    }

    public String getDescripcionServicio() {
        return DescripcionServicio;
    }

    public void setDescripcionServicio(String descripcionServicio) {
        DescripcionServicio = descripcionServicio;
    }

    public int getEstatus() {
        return Estatus;
    }

    public void setEstatus(int estatus) {
        Estatus = estatus;
    }

    public String getDescripcionEstatus() {
        return DescripcionEstatus;
    }

    public void setDescripcionEstatus(String descripcionEstatus) {
        DescripcionEstatus = descripcionEstatus;
    }

    @Override
    public String toString() {
        return "responseGeneraReferencia{" +
                "Secuencia=" + Secuencia +
                ", NumeroReferencia='" + NumeroReferencia + '\'' +
                ", Nombre='" + Nombre + '\'' +
                ", ClaveServicio='" + ClaveServicio + '\'' +
                ", DescripcionCorta='" + DescripcionCorta + '\'' +
                ", Total='" + Total + '\'' +
                ", FechaVigencia='" + FechaVigencia + '\'' +
                ", FechaEmision='" + FechaEmision + '\'' +
                ", Pagos=" + Pagos +
                ", DescripcionServicio='" + DescripcionServicio + '\'' +
                ", Estatus=" + Estatus +
                ", DescripcionEstatus='" + DescripcionEstatus + '\'' +
                '}';
    }
}
