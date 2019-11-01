package chantiri.garcia.sendmeal.modelo;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Relation;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
public class Pedido {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private Integer Id;

    private String Fecha;
    private Integer Estado;
    private Double Lat;
    private Double Lgn;

  //  @Relation(parentColumn = "Id", entityColumn = "PedidoP",
  //          entity = ItemsPedidos.class)
    private Integer Items;

    public Pedido() {
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public Integer getEstado() {
        return Estado;
    }

    public void setEstado(Integer estado) {
        Estado = estado;
    }

    public Double getLat() {
        return Lat;
    }

    public void setLat(Double lat) {
        Lat = lat;
    }

    public Double getLgn() {
        return Lgn;
    }

    public void setLgn(Double lgn) {
        Lgn = lgn;
    }

    public Integer getItems() {
        return Items;
    }

    public void setItems(Integer items) {
        Items = items;
    }

}
