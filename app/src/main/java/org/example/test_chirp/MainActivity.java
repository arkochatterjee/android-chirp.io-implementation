package org.example.test_chirp;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.charset.Charset;

import io.chirp.connect.ChirpConnect;
import io.chirp.connect.interfaces.ConnectEventListener;
import io.chirp.connect.interfaces.ConnectSetConfigListener;
import io.chirp.connect.models.ChirpError;
import io.chirp.connect.models.ConnectState;



public class MainActivity extends AppCompatActivity {


    String KEY = "F33eB46c707F4CC38Ecc6BD27";
    String SECRET = "FfFe7fEBdA0b165005258448B52Da74bb4B29EFFD6BEaf2b84";
    String CONFIG = "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";
    ChirpConnect chirpConnect = new ChirpConnect(this, KEY, SECRET);
    private static final int RESULT_REQUEST_RECORD_AUDIO = 1;
//    EditText thetext=findViewById(R.id.thetext);
//    TextView recieved=findViewById(R.id.recieved);




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //*****************************************************************************************//
        chirpConnect.setConfig(CONFIG, new ConnectSetConfigListener() {

            @Override
            public void onSuccess() {
                Log.i("setConfig", "Config successfully set.");
                chirpConnect.setListener(connectEventListener);
            }

            @Override
            public void onError(ChirpError setConfigError) {
                Log.e("setConfig", setConfigError.getMessage());
            }
        });

        chirpConnect.start();









    }

    ConnectEventListener connectEventListener = new ConnectEventListener() {

        @Override
        public void onSending(byte[] payload, byte channel) {
            Log.v("MYTAG--", "This is called when a payload is being sent " + payload + " on channel: " + channel);
        }

        @Override
        public void onSent(byte[] payload, byte channel) {
            Log.v("MYTAG--", "This is called when a payload has been sent " + payload  + " on channel: " + channel);
        }

        @Override
        public void onReceiving(byte channel) {
            Log.v("MYTAG--", "This is called when the SDK is expecting a payload to be received on channel: " + channel);
        }

        @Override
        public void onReceived(byte[] payload, byte channel) {
            Log.v("MYTAG--", "This is called when a payload has been received " + payload  + " on channel: " + channel);
//            final String str=new String(payload);
//            Toast.makeText(MainActivity.this, "Chirp Recieved !", Toast.LENGTH_LONG).show();
//            runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                recieved.setText(str);
//            }
//        });
        }

        @Override
        public void onStateChanged(byte oldState, byte newState) {
            Log.v("MYTAG--", "This is called when the SDK state has changed " + oldState + " -> " + newState);
        }

        @Override
        public void onSystemVolumeChanged(int old, int current) {
            Log.d("MYTAG--", "This is called when the Android system volume has changed " + old + " -> " + current);
        }

    };


//    public void h(View view)
//    {
//        send();
//    }
//    protected void send()
//    {
//        String str=thetext.getText().toString();
//        chirpConnect.send(str.getBytes(Charset.forName("UTF-8")));
//    }

    @Override
    protected void onResume() {
        super.onResume();

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.RECORD_AUDIO}, RESULT_REQUEST_RECORD_AUDIO);
        }
        else {
            chirpConnect.start();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case RESULT_REQUEST_RECORD_AUDIO: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    chirpConnect.start();
                }
                return;
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        chirpConnect.stop();
    }
}
