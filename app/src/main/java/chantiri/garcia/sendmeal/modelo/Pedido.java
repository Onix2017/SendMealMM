package chantiri.garcia.sendmeal.modelo;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Relation;

import java.util.Date;
import java.util.List;

@Entity
public class Pedido {

    @PrimaryKey(autoGenerate = true)
    private Integer Id;
    private Date Fecha;
    private Integer Estado;
    private Double Lat;
    private Double Lgn;

    @Relation(parentColumn = "Id", entityColumn = "Id",  entity = "Pedido.class" )
    private List<ItemsPedidos> Items;

    public Pedido() {
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date fecha) {
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

    public List<ItemsPedidos> getItems() {
        return Items;
    }

    public void setItems(List<ItemsPedidos> items) {
        this.Items = items;
    }
}
