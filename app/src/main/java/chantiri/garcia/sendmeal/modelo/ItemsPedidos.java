package chantiri.garcia.sendmeal.modelo;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Relation;

import chantiri.garcia.sendmeal.Plato;

@Entity
public class ItemsPedidos {

    @PrimaryKey(autoGenerate = true)
    private Integer Id;


    private Pedido PedidoP;
    private Plato PlatoP;
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

    public Pedido getPedidoP() {
        return PedidoP;
    }

    public void setPedidoP(Pedido pedidoP) {
        PedidoP = pedidoP;
    }

    public Plato getPlatoP() {
        return PlatoP;
    }

    public void setPlatoP(Plato platoP) {
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
