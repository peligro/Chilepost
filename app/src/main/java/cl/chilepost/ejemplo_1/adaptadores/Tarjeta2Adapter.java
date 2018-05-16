package cl.chilepost.ejemplo_1.adaptadores;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import cl.chilepost.ejemplo_1.R;
import cl.chilepost.ejemplo_1.modelos.ParametrosModel;

public class Tarjeta2Adapter extends RecyclerView.Adapter<Tarjeta2Adapter.MyViewHolder> {


   private List<ParametrosModel> tarjetaModels;


    public Tarjeta2Adapter(List<ParametrosModel> tarjetaModels)
    {
        this.tarjetaModels = tarjetaModels;
    }
    @NonNull
    @Override
    public Tarjeta2Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.tarjeta,parent,false);
        return new Tarjeta2Adapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Tarjeta2Adapter.MyViewHolder holder, final int position)
    {
        holder.tarjeta_titulo.setText(tarjetaModels.get(position).getPar_tabla());
        holder.tarjeta_detalle.setText(tarjetaModels.get(position).getPar_descripcion());
        Picasso.get().load("http://www.manosenelcodigo.com/public/news/cursos/laravel.jpg").into(holder.tarjeta_imagen);


    }

    @Override
    public int getItemCount() {
        return tarjetaModels.size();
    }

    /************************************************/
    public static class MyViewHolder extends RecyclerView.ViewHolder
            //public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        private TextView tarjeta_titulo,tarjeta_detalle;
        private ImageView tarjeta_imagen;
        public MyViewHolder(View view)
        {
            super(view);
            tarjeta_titulo=(TextView)view.findViewById(R.id.tarjeta_titulo);
            tarjeta_detalle=(TextView)view.findViewById(R.id.tarjeta_detalle);
            tarjeta_imagen=(ImageView)view.findViewById(R.id.tarjeta_imagen);
        }
    }
}
