package cl.chilepost.ejemplo_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.firebase.iid.FirebaseInstanceId;

import cl.chilepost.ejemplo_1.vistas.CardViewActivity;
import cl.chilepost.ejemplo_1.vistas.MapaActivity;
import cl.chilepost.ejemplo_1.vistas.PicassoActivity;
import cl.chilepost.ejemplo_1.vistas.RepartoActivity;
import cl.chilepost.ejemplo_1.vistas.Volley1Activity;
import cl.chilepost.ejemplo_1.vistas.WebviewActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Log.d("mama=", FirebaseInstanceId.getInstance().getToken());


    }
    public void reparto(View view)
    {
        Intent intent = new Intent(this , RepartoActivity.class);
        intent.putExtra("dato","anita lava la tina");
        startActivity(intent);
        //startActivity(new Intent(this , RepartoActivity.class));

    }
    public void get_picasso(View view)
    {
        startActivity(new Intent(this, PicassoActivity.class));
    }
    public void get_card_view(View view)
    {
        startActivity(new Intent(this, CardViewActivity.class));
    }
    public void get_volley1(View view)
    {
        startActivity(new Intent(this, Volley1Activity.class));
    }
    public void get_webview(View view)
    {
        startActivity(new Intent(this, WebviewActivity.class));
    }
    public void get_mapa(View view)
    {
        startActivity(new Intent(this, MapaActivity.class));
    }
}
