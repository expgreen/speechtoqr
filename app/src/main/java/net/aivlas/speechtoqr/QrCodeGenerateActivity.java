package net.aivlas.speechtoqr;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.util.Hashtable;

public class QrCodeGenerateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_code_generate);

        Intent intent = getIntent();


        String data = intent.getStringExtra("word");


        Hashtable encodeHint = new Hashtable();
        encodeHint.put(EncodeHintType.CHARACTER_SET,"UTF-8");

        Button button = (Button)findViewById(R.id.buttonShift);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(),QrCodeReadActivity.class);
                startActivity(intent);
            }
        });



        //String data = "http://osa030.hatenablog.com/";
        int size = 500;
        try {
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.encodeBitmap(data, BarcodeFormat.QR_CODE, size, size,encodeHint);

            ImageView imageView = (ImageView) findViewById(R.id.imageView);
            imageView.setImageBitmap(bitmap);

        } catch (WriterException e) {
            throw new AndroidRuntimeException("Barcode Error.", e);
        }

    }
}