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
import cl.chilepost.ejemplo_1.modelos.TarjetaModel;

public class TarjetaAdapter extends RecyclerView.Adapter<TarjetaAdapter.MyViewHolder>
{
    private List<TarjetaModel> tarjetaModels;

    public TarjetaAdapter(List<TarjetaModel> tarjetaModels)
    {
        this.tarjetaModels = tarjetaModels;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.tarjeta,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder,final int position)
    {
        holder.tarjeta_titulo.setText(tarjetaModels.get(position).getTarjeta_titulo());
        holder.tarjeta_detalle.setText(tarjetaModels.get(position).getTarjeta_detalle());
        Picasso.get().load(tarjetaModels.get(position).getTarjeta_imagen()).into(holder.tarjeta_imagen);

        holder.tarjeta_imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(activity.getApplicationContext(),"se hizo click en la foto: "+noticias.get(position).getTitulo(),Toast.LENGTH_LONG).show();
                Log.w("cesar","se hizo clic en la noticia : "+tarjetaModels.get(position).getTarjeta_titulo());
            }
        });
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
