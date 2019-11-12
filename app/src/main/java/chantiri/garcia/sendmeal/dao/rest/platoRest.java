package chantiri.garcia.sendmeal.Dao.rest;

import java.util.List;

import chantiri.garcia.sendmeal.Plato;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface platoRest {

    @GET("platos/")
    Call<List<Plato>> buscarTodas();

    @GET("platos/")
    Call<List<Plato>> filtrarPlatos(@Query("tituto_plato_like") String tituto_plato,
                                    @Query("precio_plato_gte") Integer precioMin,
                                    @Query("precio_plato_lte") Integer precioMax);

    @DELETE("platos/{id_plato}")
    Call<Void> borrar(@Path("id_plato") Integer id_plato);

    @PUT("platos/{id}")
    Call<Plato> actualizar(@Path("id") Integer id, @Body Plato plato);

    @POST("platos/")
    Call<Plato> crear(@Body Plato plato);

}
