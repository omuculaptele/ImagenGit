package institute.immune.imagengit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.VideoView;

public class Camara extends AppCompatActivity {

    VideoView vdView;
    ImageView imgView;
    Button foto, video;
    Bundle bundle = new Bundle();
    FragVideo fragVideo = new FragVideo();
    FragFoto fragFoto = new FragFoto();
    FragmentTransaction transaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camara);
        foto =  findViewById(R.id.buttonCamara);
        video = findViewById(R.id.buttonVideo);

        foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openCamara = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(openCamara, 1);
            }
        });

        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openCamara = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivityForResult(openCamara, 2);
            }
        });
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        transaction = getSupportFragmentManager().beginTransaction();
        if(requestCode == 1 && resultCode == RESULT_OK){
            Bundle extras = data.getExtras();

            Bitmap imgBitmap = (Bitmap) extras.get("data");

            bundle.putParcelable("foto",imgBitmap);
            fragFoto.setArguments(bundle);
            transaction.replace(R.id.fragment_container, fragFoto).commit();

            //imgView.setImageBitmap(imgBitmap);

        }
        else if(requestCode == 2 && resultCode == RESULT_OK){

            Uri videoUri = data.getData();
            bundle.putParcelable("video",videoUri);
            fragVideo.setArguments(bundle);
            transaction.replace(R.id.fragment_container, fragVideo).commit();

            //vdView.start();

            }
        }

}
