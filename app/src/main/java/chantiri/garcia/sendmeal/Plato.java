package chantiri.garcia.sendmeal;

public class Plato {

    Integer id_plato;
    String tituto_plato, descripcion_plato;
    Double precio_plato;
    Integer calorias_plato;

    public Plato(Integer id_plato, String tituto_plato, String descripcion_plato, Double precio_plato, Integer calorias_plato) {
        this.id_plato = id_plato;
        this.tituto_plato = tituto_plato;
        this.descripcion_plato = descripcion_plato;
        this.precio_plato = precio_plato;
        this.calorias_plato = calorias_plato;
    }

    @Override
    public String toString() {
        return
                 id_plato +
                " '" + tituto_plato + '\n' +
                " " + descripcion_plato + '\n' +
                " " + precio_plato;
    }

    public Integer getId_plato() {
        return id_plato;
    }

    public void setId_plato(Integer id_plato) {

        this.id_plato = id_plato;
    }

    public String getTituto_plato() {

        return tituto_plato;
    }

    public void setTituto_plato(String tituto_plato) {

        this.tituto_plato = tituto_plato;
    }

    public String getDescripcion_plato() {

        return descripcion_plato;
    }

    public void setDescripcion_plato(String descripcion_plato) {
        this.descripcion_plato = descripcion_plato;
    }

    public Double getPrecio_plato() {
        return precio_plato;
    }

    public void setPrecio_plato(Double precio_plato) {

        this.precio_plato = precio_plato;
    }

    public Integer getCalorias_plato()
    {
        return calorias_plato;
    }

    public void setCalorias_plato(Integer calorias_plato)
    {
        this.calorias_plato = calorias_plato;
    }
}
