package institute.immune.imagengit;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class Musica extends AppCompatActivity {

    private static Integer count = 0;
    private Button buttonPlay, buttonPause, buttonStop, buttonAnterior, buttonSiguiente;
    private MediaPlayer music;
    private ImageView iv;
    private ArrayList<Muzic> lista = new ArrayList<Muzic>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonPlay = findViewById(R.id.buttonPlay);
        buttonPause = findViewById(R.id.buttonPause);
        buttonStop = findViewById(R.id.buttonStop);
        buttonAnterior = findViewById(R.id.buttonAnterior);
        buttonSiguiente = findViewById(R.id.buttonSiguiente);
        iv = findViewById(R.id.simpleImageView);

        lista.add(new Muzic(R.raw.classic_hurt,R.drawable.hurt_photo));
        lista.add(new Muzic(R.raw.sad_violin, R.drawable.sad_violin));
        lista.add(new Muzic(R.raw.sitcom_laugh, R.drawable.sitcom_laugh));

        music = MediaPlayer.create(this, lista.get(count).getCancion());
        iv.setImageResource(lista.get(count).getImagen());

        buttonAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(count == 0){ count = lista.size()-1;}
                    else{
                    count = (--count % lista.size());
                    count = Math.abs(count);
                }
                setPicMus();
                }

        });

        buttonSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = ++count % lista.size();
                setPicMus();
            }
        });

        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast play = Toast.makeText(getApplicationContext(), "Play", Toast.LENGTH_LONG);
                play.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
                play.show();
                System.out.println("El Play: "+ count);
                music.start();
            }
        });

        buttonPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast pause = Toast.makeText(getApplicationContext(), "Pause", Toast.LENGTH_LONG);
                pause.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
                pause.show();
                music.pause();
            }
        });

        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast stop = Toast.makeText(getApplicationContext(), "Stop", Toast.LENGTH_LONG);
                stop.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
                stop.show();
                music.reset();
            }
        });
    }
    public void setPicMus(){
        music = MediaPlayer.create(Musica.this, lista.get(count).getCancion());
        iv.setImageResource(lista.get(count).getImagen());
    }

}