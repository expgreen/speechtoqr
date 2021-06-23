package net.aivlas.speechtoqr;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.ResultPoint;
import com.journeyapps.barcodescanner.BarcodeCallback;
import com.journeyapps.barcodescanner.BarcodeResult;
import com.journeyapps.barcodescanner.CompoundBarcodeView;

import java.util.List;

public class QrCodeReadActivity extends AppCompatActivity {
    String result;
    private CompoundBarcodeView mBarcodeView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_code_read);

        Button button = (Button)findViewById(R.id.ButtonSpeech);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(),TextSpeech.class);

                String word = result;
                if((word == null)||(word == "")){// qrcodeを読み込まない場合
                    word = "nocontent";
                }
                intent.putExtra("qrword",word);
                startActivity(intent);
            }
        });

        mBarcodeView = (CompoundBarcodeView)findViewById(R.id.barcodeView);
        mBarcodeView.decodeSingle(new BarcodeCallback() {
            @Override
            public void barcodeResult(BarcodeResult barcodeResult) {

                TextView textView = (TextView)findViewById(R.id.textView);

                result = barcodeResult.getText();



                textView.setText(result);
            }

            @Override
            public void possibleResultPoints(List<ResultPoint> list) {}
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        mBarcodeView.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mBarcodeView.pause();
    }
}