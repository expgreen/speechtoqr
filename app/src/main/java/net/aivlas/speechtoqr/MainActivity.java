package net.aivlas.speechtoqr;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.ButtonRecog).setOnClickListener(this);
        findViewById(R.id.ButtonRead).setOnClickListener(this);
    }

    public void onClick(View view){
        if(view !=null) {
            switch (view.getId()) {
                case R.id.ButtonRecog :
                    Intent intentRecog = new Intent(this, SpeechRecognizerEx.class);  //インテントの作成
                    startActivity(intentRecog); //画面遷移
                    break;

                case R.id.ButtonRead :
                    Intent intentQrRead = new Intent(this, QrCodeReadActivity.class);  //インテントの作成
                    startActivity(intentQrRead); //画面遷移
                    break;
            }
        }
    }
}