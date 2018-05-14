package cl.chilepost.ejemplo_1.modelos;

public class TarjetaModel
{
    private String tarjeta_titulo,tarjeta_detalle,tarjeta_imagen;


    public TarjetaModel(String tarjeta_titulo, String tarjeta_detalle, String tarjeta_imagen) {
        this.tarjeta_titulo = tarjeta_titulo;
        this.tarjeta_detalle = tarjeta_detalle;
        this.tarjeta_imagen = tarjeta_imagen;
    }


    public String getTarjeta_titulo() {
        return tarjeta_titulo;
    }

    public void setTarjeta_titulo(String tarjeta_titulo) {
        this.tarjeta_titulo = tarjeta_titulo;
    }

    public String getTarjeta_detalle() {
        return tarjeta_detalle;
    }

    public void setTarjeta_detalle(String tarjeta_detalle) {
        this.tarjeta_detalle = tarjeta_detalle;
    }

    public String getTarjeta_imagen() {
        return tarjeta_imagen;
    }

    public void setTarjeta_imagen(String tarjeta_imagen) {
        this.tarjeta_imagen = tarjeta_imagen;
    }
}
