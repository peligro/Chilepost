package cl.chilepost.ejemplo_1.vistas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import cl.chilepost.ejemplo_1.R;

public class RepartoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reparto);
        showToolbar("TÍtulo del toolbar",true);
        CargarDatos();
    }
    public void CargarDatos()
    {
        TextView codigo_valor = (TextView) findViewById(R.id.codigo_valor);
        //String campania_id=getIntent().getExtras().getString("campania_id");
        String dato=getIntent().getExtras().getString("dato");
        codigo_valor.setText("el valor es : "+dato);

    }
    public void showToolbar(String tittle, boolean upButton){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);

    }
}
