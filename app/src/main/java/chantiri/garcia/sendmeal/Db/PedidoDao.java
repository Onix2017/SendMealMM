package chantiri.garcia.sendmeal.Db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import chantiri.garcia.sendmeal.modelo.Pedido;

@Dao
public interface PedidoDao {
    @Query("SELECT * FROM Pedido")
    List<Pedido> getAll();

    @Insert
    void insert(Pedido pedido);

    @Insert
    void insertAll(Pedido... pedidos);

    @Delete
    void delete(Pedido pedido);

    @Update
    void actualizar(Pedido pedidos);
}
