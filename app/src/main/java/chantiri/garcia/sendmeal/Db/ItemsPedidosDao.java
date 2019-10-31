package chantiri.garcia.sendmeal.Db;

import android.content.ClipData;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import chantiri.garcia.sendmeal.modelo.ItemsPedidos;

@Dao
public interface ItemsPedidosDao {
    @Query("SELECT * FROM ItemsPedidos")
    List<ItemsPedidos> getAll();

    @Insert
    void insert(ItemsPedidos itemPedido);

    @Insert
    void insertAll(ItemsPedidos... itemsPedidos);

    @Delete
    void delete(ItemsPedidos itemPedido);

    @Update
    void actualizar(ItemsPedidos itemPedido);
}
