package chantiri.garcia.sendmeal.Db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import chantiri.garcia.sendmeal.modelo.ItemsPedidos;
import chantiri.garcia.sendmeal.modelo.Pedido;


@Database(entities = {Pedido.class, ItemsPedidos.class}, version = 1)
public abstract class PedidosAppDB extends RoomDatabase {
public abstract ItemsPedidosDao itemsPedidosDao();
public abstract PedidoDao pedidoDao();
}
