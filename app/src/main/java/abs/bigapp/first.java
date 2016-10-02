package abs.bigapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class first extends AppCompatActivity {
    TextView textView2;
    String s;
    public Button but1;
    public void init()
    {


        try {
            FileInputStream fileIn=openFileInput("mytextfile.txt");
            InputStreamReader InputRead= new InputStreamReader(fileIn);

            char[] inputBuffer= new char[20];
            s="";
            int charRead;

            while ((charRead=InputRead.read(inputBuffer))>0) {
                // char to string conversion
                String readstring=String.copyValueOf(inputBuffer,0,charRead);
                s +=readstring;
            }
            InputRead.close();



        } catch (Exception e) {
            e.printStackTrace();
        }


        but1=(Button)findViewById(R.id.but1) ;
        but1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent toy=new Intent(first.this,second.class);
                startActivity(toy);
            }
        });
    }


    public void clear(View v)
    {
        try {
            FileOutputStream fileout=openFileOutput("mytextfile.txt", MODE_PRIVATE);
            OutputStreamWriter outputWriter=new OutputStreamWriter(fileout);
            outputWriter.write(Integer.toString(0));
            outputWriter.close();


        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        init();
        textView2=(TextView)findViewById(R.id.textmsg);
        textView2.setText(s);
//textView2=(EditText)findViewById(R.id.textView2);

    }
}