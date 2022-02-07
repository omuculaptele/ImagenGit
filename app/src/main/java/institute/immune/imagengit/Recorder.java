package institute.immune.imagengit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

public class Recorder extends AppCompatActivity {


    private MediaRecorder mediaRecorder;
    private MediaPlayer mediaPlayer;
    private TextView tvInfo;
    private Button btnGrabar, btnReproducir, btnParar;
    private File fichero;
    Toast toast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recorder);

        bindings();

    }

    /**
     * Bindings de la actividad
     */
    private void bindings(){
        btnGrabar = findViewById(R.id.btnGrabar);
        btnReproducir = findViewById(R.id.btnReproducir);
        btnParar = findViewById(R.id.btnParar);

        tvInfo = findViewById(R.id.tvInfo);
    }

    /**
     * Grabar un audio
     */
    public void grabar(){
        //funcionalidad que graba
        //grabacion
        mediaRecorder = new MediaRecorder();

        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

        File path = null;

        try{
            path = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
            fichero = File.createTempFile("audioTemporal",".3gp", path);
            mediaRecorder.setOutputFile(fichero.getAbsolutePath());
            mediaRecorder.prepare();
        } catch (IOException e){
            Log.e("IO",e.getMessage());
        }

        mediaRecorder.start();
        //if (Activity)
    }

    /**
     * Boton para grabar
     */
    public void onClickGrabar(View view){
        try {
            if(ActivityCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECORD_AUDIO}, 0);

            }
            else{
                grabar();
                mostrarMensaje(getString(R.string.grabando));
            }

        }
        catch (Exception e) {
            mostrarMensaje(getString(R.string.error));
            Log.e("Error de entrada/salida", e.getMessage());
        }
    }

    private void parar(){
        mediaRecorder.stop();
        mediaRecorder.release();
    }

    private void reproducir(){
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mostrarMensaje("Audio Reproducido");
            }
        });

        try{
            mediaPlayer.setDataSource(fichero.getAbsolutePath());
            mediaPlayer.prepare();

        }catch(IOException e){
            Log.e("IO",e.getMessage());
        }
        mediaPlayer.start();
    }

    /**
     * Boton para parar
     */
    public void onClickParar(View view){
        try {
            parar();
            mostrarMensaje(getString(R.string.parando));
        }
        catch (Exception e) {
            mostrarMensaje(getString(R.string.error));
            Log.e("Error de entrada/salida", e.getMessage());
        }

    }


    /**
     * Boton para reproducir
     */
    public void onClickReproducir(View view){
        try {
            reproducir();
            mostrarMensaje(getString(R.string.reproduciendo));
        }
        catch (Exception e) {
            mostrarMensaje(getString(R.string.error));
            Log.e("Error de entrada/salida", e.getMessage());
        }

    }

    /**
     *
     * @param text, el mensaje que aparece por pantalla
     */
    public void mostrarMensaje(String text){
        toast.makeText(this, text,Toast.LENGTH_SHORT).show();
        tvInfo.setText(text);

    }

}