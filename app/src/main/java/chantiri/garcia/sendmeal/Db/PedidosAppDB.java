package chantiri.garcia.sendmeal.Db;

import androidx.room.Database;
import androidx.room.RoomDatabase;


@Database(entities = {Pedido.class, ItemsPedidos.class}, version = 1)
public abstract class PedidosAppDB extends RoomDatabase {

}
