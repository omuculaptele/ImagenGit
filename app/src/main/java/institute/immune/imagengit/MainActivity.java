package institute.immune.imagengit;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Integer x = 0;
    Button buttonPlay, buttonPause, buttonStop, buttonCambiar;
    MediaPlayer music;
    ArrayList<Muzic> lista = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonPlay = findViewById(R.id.buttonPlay);
        buttonPause = findViewById(R.id.buttonPause);
        buttonStop = findViewById(R.id.buttonStop);
        buttonCambiar = findViewById(R.id.buttonCambiar);

        Muzic m = new Muzic();
        Muzic m1 = new Muzic();
        Muzic m2 = new Muzic();

        m.setCancion(R.raw.classic_hurt);
        m1.setCancion(R.raw.sad_violin);
        m2.setCancion(R.raw.sitcom_laugh);
        //m.setNombre(String.valueOf(R.string.cancion1));
        //m.setImagen(R.drawable.fotico);
        //m.setCancion(R.raw.);
        //m.setCancion(R.raw.);

        lista.add(m);
        lista.add(m1);
        lista.add(m2);
        music = MediaPlayer.create(this, lista.get(x).getCancion());

        buttonCambiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (x<2) {
                    System.out.println("MEnor: "+x);
                    x+=1;
                }

                else{
                    System.out.println("Zero: "+x);
                    x = 0;
                }
                music = MediaPlayer.create(MainActivity.this, lista.get(x).getCancion());
            }

        });

        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast play = Toast.makeText(getApplicationContext(), "Play", Toast.LENGTH_LONG);
                play.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
                play.show();
                System.out.println("El Play: "+x);
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
                music.stop();

            }
        });


    }

}