package cl.chilepost.ejemplo_1.vistas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import cl.chilepost.ejemplo_1.R;

public class PicassoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picasso);
        showImage();
    }
    public void showImage()
    {
        ImageView imageView =(ImageView)findViewById(R.id.imageview);
        //Picasso.with(this).load("http://www.manosenelcodigo.com/public/news/cursos/php.jpg").into(imageView);
        Picasso.get()
                .load("http://www.manosenelcodigo.com/public/news/cursos/php.jpg")
                .placeholder(R.drawable.ic_launcher_web)
                .error(R.drawable.ic_launcher_web)
                .into(imageView);
    }
}
