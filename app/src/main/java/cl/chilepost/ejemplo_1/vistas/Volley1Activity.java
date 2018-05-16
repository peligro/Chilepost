package cl.chilepost.ejemplo_1.vistas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import cl.chilepost.ejemplo_1.R;
import cl.chilepost.ejemplo_1.adaptadores.Tarjeta2Adapter;
import cl.chilepost.ejemplo_1.constantes.Constantes;
import cl.chilepost.ejemplo_1.modelos.ParametrosModel;
import cl.chilepost.ejemplo_1.singleton.MySingleton;

public class Volley1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley1);
        showToolbar("ejemplo volley 1",true);
        showVolleyDefinitivo();
    }
    public void showVolleyDefinitivo()
    {
        final ArrayList<ParametrosModel> arrayList=new ArrayList<>();
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        final JsonArrayRequest jsonArrayRequest=new JsonArrayRequest
                (
                        Request.Method.GET,
                        Constantes.RUTA1,
                        null,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                int count=0;
                                while(count<response.length())
                                {
                                    try
                                    {
                                        JSONObject jsonObject=response.getJSONObject(count);
                                        ParametrosModel parametrosModel=new ParametrosModel
                                                (
                                                        jsonObject.getString("orden"),
                                                        jsonObject.getString("par_tabla"),
                                                        "",
                                                        jsonObject.getString("par_descripcion"),
                                                        "",
                                                        "",
                                                        "",
                                                        "",
                                                        ""
                                                );
                                        arrayList.add(parametrosModel);
                                        Tarjeta2Adapter tarjeta2Adapter=new Tarjeta2Adapter(arrayList);
                                        recyclerView.setAdapter(tarjeta2Adapter);
                                        count++;
                                    }catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        NetworkResponse networkResponse = error.networkResponse;
                        String jsonError="nada";
                        if (networkResponse != null && networkResponse.data != null) {
                            jsonError = new String(networkResponse.data);
                            // Print Error!
                        }
                        Log.d( "error volley cesar: ", ""+jsonError);
                    }
                }
                );
        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(jsonArrayRequest);
    }
    public void showVolley2()
    {
        final ArrayList<ParametrosModel> arrayList=new ArrayList<>();
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);



         JsonArrayRequest jsonArrayRequest =new JsonArrayRequest
                (
                        Request.Method.GET,
                        Constantes.RUTA1,
                        null,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                int count=0;

                                while(count<response.length())
                                {
                                    try
                                    {
                                        JSONObject jsonObject=response.getJSONObject(count);
                                        ParametrosModel parametrosModel=new ParametrosModel
                                                (
                                                        jsonObject.getString("order"),
                                                        jsonObject.getString("order"),
                                                        jsonObject.getString("order"),
                                                        jsonObject.getString("order"),
                                                        jsonObject.getString("order"),
                                                        jsonObject.getString("order"),
                                                        jsonObject.getString("order"),
                                                        jsonObject.getString("order"),
                                                        jsonObject.getString("order")
                                                );
                                        arrayList.add(parametrosModel);
                                        Tarjeta2Adapter tarjeta2Adapter=new Tarjeta2Adapter(arrayList);
                                        recyclerView.setAdapter(tarjeta2Adapter);
                                        count++;
                                    }catch (JSONException e) {
                                        e.printStackTrace();
                                        //Toast.makeText(Volley1Activity.this, "hola lala", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        NetworkResponse networkResponse = error.networkResponse;
                        String jsonError="nada";
                        if (networkResponse != null && networkResponse.data != null) {
                            jsonError = new String(networkResponse.data);
                            // Print Error!
                        }
                        Log.d( "error volley cesar: ", ""+jsonError);
                    }
                }
                );
        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(jsonArrayRequest);
    }
    public void showVolley1()
    {
        StringRequest stringRequest =new StringRequest
                (
                        Request.Method.GET,
                        "http://www.manosenelcodigo.cl/soporte_android/rest/gerardo",
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                //ssss
                                Toast.makeText(Volley1Activity.this, "resultado="+response, Toast.LENGTH_LONG).show();
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        error.printStackTrace();
                        NetworkResponse networkResponse = error.networkResponse;
                        String jsonError="nada";
                        if (networkResponse != null && networkResponse.data != null) {
                            jsonError = new String(networkResponse.data);
                            // Print Error!
                        }
                        Log.d( "error volley cesar: ", ""+jsonError);
                    }
                }
                )
            /**ésto es para enviar parámetros**/
         /*
            {

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headersSys = super.getHeaders();
                Map<String, String> headers = new HashMap<String, String>();
                headers.put("Token", "123456");
                headers.putAll(headersSys);
                return headers;
            }

        }
         */
                /** cierre ésto es para enviar parámetros**/
        ;
        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
    }
    public void showVolley_solo()
    {
        StringRequest stringRequest =new StringRequest
                (
                        Request.Method.GET,
                        "http://www.manosenelcodigo.cl/soporte_android/rest/gerardo_solo",
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                //ssss
                                Gson gson=new Gson();
                                ParametrosModel parametrosModel=gson.fromJson(response,ParametrosModel.class);
                                Toast.makeText(Volley1Activity.this, "resultado="+parametrosModel.getPar_descripcion(), Toast.LENGTH_LONG).show();
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        error.printStackTrace();
                        NetworkResponse networkResponse = error.networkResponse;
                        String jsonError="nada";
                        if (networkResponse != null && networkResponse.data != null) {
                            jsonError = new String(networkResponse.data);
                            // Print Error!
                        }
                        Log.d( "error volley cesar: ", ""+jsonError);
                    }
                }
                )
                /**ésto es para enviar parámetros**/
         /*
             @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String,String> params=new HashMap<String,String>();
                    params.put("clave","valor);
                    return params;
                }
            {

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headersSys = super.getHeaders();
                Map<String, String> headers = new HashMap<String, String>();
                headers.put("Token", "123456");
                headers.putAll(headersSys);
                return headers;
            }

        }
         */
                /** cierre ésto es para enviar parámetros**/
                ;
        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
    }
    public void showToolbar(String tittle, boolean upButton){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);

    }
}
