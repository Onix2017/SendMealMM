package chantiri.garcia.sendmeal.modelo;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Relation;

import chantiri.garcia.sendmeal.Plato;

@Entity
public class ItemsPedidos {

    @PrimaryKey(autoGenerate = true)
    private Integer Id;


    private Integer PedidoP;
    private Integer PlatoP;
    private Integer Cantidad;
    private Integer Precio;

    public ItemsPedidos() {
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getPedidoP() {
        return PedidoP;
    }

    public void setPedidoP(Integer pedidoP) {
        PedidoP = pedidoP;
    }

    public Integer getPlatoP() {
        return PlatoP;
    }

    public void setPlatoP(Integer platoP) {
        PlatoP = platoP;
    }

    public Integer getCantidad() {
        return Cantidad;
    }

    public void setCantidad(Integer cantidad) {
        Cantidad = cantidad;
    }

    public Integer getPrecio() {
        return Precio;
    }

    public void setPrecio(Integer precio) {
        Precio = precio;
    }
}
