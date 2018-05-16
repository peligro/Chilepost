package cl.chilepost.ejemplo_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import cl.chilepost.ejemplo_1.vistas.CardViewActivity;
import cl.chilepost.ejemplo_1.vistas.PicassoActivity;
import cl.chilepost.ejemplo_1.vistas.RepartoActivity;
import cl.chilepost.ejemplo_1.vistas.Volley1Activity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



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
}
