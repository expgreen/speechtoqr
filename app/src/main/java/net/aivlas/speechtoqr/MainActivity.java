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
        //findViewById(R.id.ButtonRead)
    }

    public void onClick(View view){
        Intent intent = new Intent(this, SpeechRecognizerEx.class);  //インテントの作成
        startActivity(intent);                                 //画面遷移
    }
}