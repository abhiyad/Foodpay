package abs.bigapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

public class Main3Activity extends AppCompatActivity {

   private WebView wv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        wv=(WebView)findViewById(R.id.webView);
        String s="http://api.qrserver.com/v1/create-qr-code/?color=000000&bgcolor=FFFFFF&data=Amount+",s2="&qzone=1&margin=0&size=400x400&ecc=L";

        wv.loadUrl("http://www.google.com");
    }
}
