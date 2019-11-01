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

public interface PlatoRest {

    @GET("Platos/")
    Call<List<Plato>> buscarTodas();

    @DELETE("Platos/{id}")
    Call<Void> borrar(@Path("id") Integer id);

    @PUT("Platos/{id}")
    Call<Plato> actualizar(@Path("id") Integer id, @Body Plato plato);

    @POST("Platos/")
    Call<Plato> crear(@Body Plato plato);
}
