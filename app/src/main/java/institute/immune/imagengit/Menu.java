package institute.immune.imagengit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {


    Button btnCamara, btnVideo, btnMusic, btnRecorder;
    Intent camaraIntent, videoIntent, musicIntent, recorderIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        btnCamara = findViewById(R.id.buttonCamara);
        btnVideo = findViewById(R.id.btnVideo);
        btnMusic = findViewById(R.id.btnMusic);
        btnRecorder = findViewById(R.id.buttonRegistar);
        camaraIntent = new Intent(this, Camara.class);
        videoIntent = new Intent(this,Video.class);
        musicIntent = new Intent(this, MainActivity.class);
        recorderIntent = new Intent(this, Recorder.class);


        btnCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(camaraIntent);
            }
        });

        btnVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(videoIntent);
            }
        });

        btnMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(musicIntent);
            }
        });
        btnRecorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(recorderIntent);
            }
        });
    }

}