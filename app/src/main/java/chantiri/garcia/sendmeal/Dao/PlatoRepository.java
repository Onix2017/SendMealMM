package chantiri.garcia.sendmeal.Dao;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import chantiri.garcia.sendmeal.Dao.rest.PlatoRest;
import chantiri.garcia.sendmeal.Plato;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PlatoRepository {

    public static String _SERVER = "http://192.168.43.133:5000/";
    private List<Plato> listaPlatos;

    public static final int _ALTA_PLATO =1;
    public static final int _UPDATE_PLATO =2;
    public static final int _BORRADO_PLATO =3;
    public static final int _CONSULTA_PLATO =4;
    public static final int _ERROR_PLATO =9;
//
    private static PlatoRepository _INSTANCE;

    private PlatoRepository(){}

    public static PlatoRepository getInstance(){
        if(_INSTANCE==null){
            _INSTANCE = new PlatoRepository();
            _INSTANCE.configurarRetrofit();
            _INSTANCE.listaPlatos = new ArrayList<>();
        }
        return _INSTANCE;
    }

    private Retrofit rf;

    private PlatoRest platoRest;

    private void configurarRetrofit(){
        this.rf = new Retrofit.Builder()
                .baseUrl("http://192.168.43.133:5000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Log.d("APP_2","INSTANCIA CREADA");

        this.platoRest = this.rf.create(PlatoRest.class);
    }

    public void actualizarObra(final Plato o, final Handler h){
        Call<Plato> llamada = this.platoRest.actualizar(o.getId_plato(),o);
        llamada.enqueue(new Callback<Plato>() {
            @Override
            public void onResponse(Call<Plato> call, Response<Plato> response) {
                Log.d("APP_2","Despues que ejecuta"+ response.isSuccessful());
                Log.d("APP_2","COdigo"+ response.code());

                if(response.isSuccessful()){
                    Log.d("APP_2","EJECUTO");
                    listaPlatos.remove(o);
                    listaPlatos.add(response.body());
                    Message m = new Message();
                    m.arg1 = _UPDATE_PLATO;
                    h.sendMessage(m);
                }
            }

            @Override
            public void onFailure(Call<Plato> call, Throwable t) {
                Log.d("APP_2","ERROR "+t.getMessage());
                Message m = new Message();
                m.arg1 = _ERROR_PLATO;
                h.sendMessage(m);
            }
        });
    }

    public void crearObra(Plato o, final Handler h){
        Call<Plato> llamada = this.platoRest.crear(o);
        llamada.enqueue(new Callback<Plato>() {
            @Override
            public void onResponse(Call<Plato> call, Response<Plato> response) {
                Log.d("APP_2","Despues que ejecuta"+ response.isSuccessful());
                Log.d("APP_2","COdigo"+ response.code());

                if(response.isSuccessful()){
                    Log.d("APP_2","EJECUTO");
                    listaPlatos.add(response.body());
                    Message m = new Message();
                    m.arg1 = _ALTA_PLATO;
                    h.sendMessage(m);
                }
            }

            @Override
            public void onFailure(Call<Plato> call, Throwable t) {
                Log.d("APP_2","ERROR "+t.getMessage());
                Message m = new Message();
                m.arg1 = _ERROR_PLATO;
                h.sendMessage(m);
            }
        });
    }

    public void listarObra(final Handler h){
        Call<List<Plato>> llamada = this.platoRest.buscarTodas();
        llamada.enqueue(new Callback<List<Plato>>() {
            @Override
            public void onResponse(Call<List<Plato>> call, Response<List<Plato>> response) {
                if(response.isSuccessful()){
                    listaPlatos.clear();
                    listaPlatos.addAll(response.body());
                    Message m = new Message();
                    m.arg1 = _CONSULTA_PLATO;
                    h.sendMessage(m);
                }
            }

            @Override
            public void onFailure(Call<List<Plato>> call, Throwable t) {
                Message m = new Message();
                m.arg1 = _ERROR_PLATO;
                h.sendMessage(m);
            }
        });
    }

    public void borrarObra(final Plato o, final Handler h){
        final Call<Void> llamada = this.platoRest.borrar(o.getId_plato());
        llamada.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Log.d("APP_2","Despues que ejecuta"+ response.isSuccessful());
                Log.d("APP_2","COdigo"+ response.code());

                if(response.isSuccessful()){
                    Log.d("APP_2","EJECUTO");
                    for(Plato o : listaPlatos){
                        Log.d("APP_2","Obra "+o.getId_plato());
                    }
                    Log.d("APP_2","BORRA Obra "+o.getId_plato());
                    listaPlatos.remove(o);
                    for(Plato o : listaPlatos){
                        Log.d("APP_2","Obra "+o.getId_plato());
                    }
                    Message m = new Message();
                    m.arg1 = _BORRADO_PLATO;
                    h.sendMessage(m);
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.d("APP_2","ERROR "+t.getMessage());
                Message m = new Message();
                m.arg1 = _ERROR_PLATO;
                h.sendMessage(m);
            }
        });
    }
    public List<Plato> getListaObras() {
        return listaPlatos;


    }
}
