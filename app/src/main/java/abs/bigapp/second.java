package abs.bigapp;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class second extends AppCompatActivity {
    String s, s1, s2, sumstr, URL;
    int sum = 0;
    int roll = 0;
    Button but1;
    public Button but;
    public EditText ed;
    public WebView w;


    public void init()
    {
        but = (Button) findViewById(R.id.button);
        ed = (EditText) findViewById(R.id.editText);
        w = (WebView) findViewById(R.id.wv);
        but1 = (Button) findViewById(R.id.but1);
    }

    public void retreat(View v)
    {
        Intent toy=new Intent(second.this,first.class);
        startActivity(toy);
    }


    public void cal(View v)
    {
    s=ed.getText().toString();
        try {
            FileInputStream fileIn=openFileInput("mytextfile.txt");
            InputStreamReader InputRead= new InputStreamReader(fileIn);

            char[] inputBuffer= new char[20];
            String s="";
            int charRead;

            while ((charRead=InputRead.read(inputBuffer))>0) {
                // char to string conversion
                String readstring=String.copyValueOf(inputBuffer,0,charRead);
                s +=readstring;
            }
            InputRead.close();
            sum+=Integer.parseInt(s);

        } catch (Exception e) {
            e.printStackTrace();
        }
        int num=Integer.parseInt(s);
        sum+=num;
        try {
            FileOutputStream fileout=openFileOutput("mytextfile.txt", MODE_PRIVATE);
            OutputStreamWriter outputWriter=new OutputStreamWriter(fileout);
            outputWriter.write(Integer.toString(sum));
            outputWriter.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

    s1="http://api.qrserver.com/v1/create-qr-code/?color=000000&bgcolor=FFFFFF&data=Roll+160055%0AAmount+";
    s2="&qzone=1&margin=0&size=250x250&ecc=L";
    URL=s1.concat(s);
    w.loadUrl(URL);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        init();
    }
}
