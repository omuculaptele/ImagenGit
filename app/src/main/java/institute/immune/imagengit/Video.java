package institute.immune.imagengit;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import java.util.ArrayList;

public class Video extends AppCompatActivity {

    private Button btnPlay, btnPause, btnStop, btnAnterior, btnSiguiente;
    private VideoView vvVideo;
    private String videoPath;
    private Uri uri;
    private ArrayList<String> videos = new ArrayList<>();
    private static Integer x = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        videos.add("android.resource://" + getPackageName() + "/" + R.raw.jujutsu);
        videos.add("android.resource://" + getPackageName() + "/" + R.raw.enemy);
        videos.add("android.resource://" + getPackageName() + "/" + R.raw.one_piece);
        findViewsById();


        uri  = Uri.parse(videos.get(x));

        MediaController mediaController = new MediaController(this);
        vvVideo.setMediaController(mediaController);
        mediaController.setAnchorView(vvVideo);

        vvVideo.setVideoURI(uri);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vvVideo.start();
                btnPlay.setEnabled(false);
                btnPause.setEnabled(true);
                btnStop.setEnabled(true);
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vvVideo.stopPlayback();
                vvVideo.setVisibility(View.GONE);
                vvVideo.setVisibility(View.VISIBLE);
                btnStop.setEnabled(false);
                btnPause.setEnabled(false);
                btnPlay.setEnabled(true);
            }
        });
        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vvVideo.pause();
                btnPause.setEnabled(false);
                btnPlay.setEnabled(true);
            }
        });

        btnAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(x == 0){ x = videos.size()-1;}
                else{
                    x = (--x % videos.size());
                    x = Math.abs(x);
                }
                uri  = Uri.parse(videos.get(x));
                vvVideo.setVideoURI(uri);
            }
        });

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                x = ++x %videos.size();
                uri  = Uri.parse(videos.get(x));
                vvVideo.setVideoURI(uri);
            }
        });



    }

    public void findViewsById(){
        btnPlay = findViewById(R.id.btnPlay);
        btnPause = findViewById(R.id.btnPause);
        btnStop = findViewById(R.id.btnStop);
        btnAnterior = findViewById(R.id.btnAnterior);
        btnSiguiente = findViewById(R.id.btnSiguiente);
        vvVideo = findViewById(R.id.vvVideo);
    }






}