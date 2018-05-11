package cl.chilepost.ejemplo_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import cl.chilepost.ejemplo_1.vistas.RepartoActivity;

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


}
