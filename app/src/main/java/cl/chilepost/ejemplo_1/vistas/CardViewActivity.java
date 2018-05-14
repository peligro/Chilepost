package cl.chilepost.ejemplo_1.vistas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import cl.chilepost.ejemplo_1.R;
import cl.chilepost.ejemplo_1.adaptadores.TarjetaAdapter;
import cl.chilepost.ejemplo_1.modelos.TarjetaModel;

public class CardViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);
        showToolbar("Ejemplo de Card VIew",true);
        showDatos();
    }
    public void showDatos()
    {
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        TarjetaAdapter tarjetaAdapter=new TarjetaAdapter(getDatos());
        recyclerView.setAdapter(tarjetaAdapter);

    }

    public List<TarjetaModel> getDatos()
    {
        ArrayList<TarjetaModel> datos=new ArrayList<>();
        datos.add(new TarjetaModel("Título 1","Sub título 1","https://www.manosenelcodigo.com/public/news/cursos/php.jpg"));
        datos.add(new TarjetaModel("Título 2","Sub título 2","https://www.manosenelcodigo.com/public/news/cursos/php.jpg"));
        datos.add(new TarjetaModel("Título 3","Sub título 3","https://www.manosenelcodigo.com/public/news/cursos/php.jpg"));
        datos.add(new TarjetaModel("Título 4","Sub título 4","https://www.manosenelcodigo.com/public/news/cursos/php.jpg"));
        return datos;
    }
    public void showToolbar(String tittle, boolean upButton){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);

    }
}
