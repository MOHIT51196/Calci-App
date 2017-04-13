package com.example.mohitmalhotra.calci;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//import android.view.Menu;
//import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements OnClickListener {


    EditText field =(EditText)findViewById(R.id.editText);

    TextView tv=(TextView) findViewById(R.id.textView);

    Calculate c=new Calculate();

    Button but1=(Button) findViewById(R.id.one);
    Button but2=(Button) findViewById(R.id.two);
    Button but3=(Button) findViewById(R.id.three);
    Button but4=(Button) findViewById(R.id.four);
    Button but5=(Button) findViewById(R.id.five);
    Button but6=(Button) findViewById(R.id.six);
    Button but7=(Button) findViewById(R.id.seven);
    Button but8=(Button) findViewById(R.id.eight);
    Button but9=(Button) findViewById(R.id.nine);
    Button but0=(Button) findViewById(R.id.zero);
    //operational buttons
    Button add=(Button) findViewById(R.id.add);
    Button sub=(Button) findViewById(R.id.sub);
    Button mul=(Button) findViewById(R.id.mul);
    Button div=(Button) findViewById(R.id.div);
    Button sin=(Button) findViewById(R.id.sin);
    Button cos=(Button) findViewById(R.id.cos);
    Button tan=(Button) findViewById(R.id.tan);
    Button sinh=(Button) findViewById(R.id.sinh);
    Button cosh=(Button) findViewById(R.id.cosh);
    Button pwr=(Button) findViewById(R.id.pwr);
    Button equi=(Button) findViewById(R.id.equi);

    public static Double res=0.0;
    String msg="LOG : ",oppress="Operator pressed",erro="ERROR : EMPTY VALUE DETECTED";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //field=null;

        //adding a snakebar to the application
        FloatingActionButton fl = (FloatingActionButton) findViewById(R.id.fab);
        fl.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "This is a calculator with sleak design", Snackbar.LENGTH_LONG).setAction("ACTION", null).show();
            }
        });

        Log.d(msg,"Activity started");
        if(field.getText()==null)
            field.setText("0");


        but0.setOnClickListener(this);
        but1.setOnClickListener(this);
        but2.setOnClickListener(this);
        but3.setOnClickListener(this);
        but4.setOnClickListener(this);
        but5.setOnClickListener(this);
        but6.setOnClickListener(this);
        but7.setOnClickListener(this);
        but8.setOnClickListener(this);
        but9.setOnClickListener(this);


        //operator functionality click listners

        add.setOnClickListener(this);
        equi.setOnClickListener(this);
        sub.setOnClickListener(this);
        mul.setOnClickListener(this);
        div.setOnClickListener(this);
        pwr.setOnClickListener(this);
        sin.setOnClickListener(this);
        cos.setOnClickListener(this);
        sinh.setOnClickListener(this);
        cosh.setOnClickListener(this);
        tan.setOnClickListener(this);
    }


    @Override
    public void onClick(View v){

        switch(v.getId()){
            case R.id.zero :
                    field.setText(String.valueOf(but0.getText() ) );
                break;
            case R.id.one :
                    field.setText(String.valueOf(but1.getText() ) );
                break;
            case R.id.two :
                    field.setText(String.valueOf(but2.getText() ) );
                break;
            case R.id.three :
                    field.setText(String.valueOf(but3.getText())  );
                break;
            case R.id.four :
                    field.setText(String.valueOf(but4.getText() ) );
                break;
            case R.id.five :
                    field.setText(String.valueOf(but5.getText() ) );
                break;
            case R.id.six :
                    field.setText(String.valueOf(but6.getText() ) );
                break;
            case R.id.seven :
                    field.setText(String.valueOf(but7.getText() ) );
                break;
            case R.id.eight :
                    field.setText(String.valueOf(but8.getText() ) );
                break;
            case R.id.nine :
                    field.setText(String.valueOf(but9.getText()));
                break;
            case R.id.equi :
                field.setText(String.valueOf(res));
                tv.setText(String.valueOf(res));
                break;

            default :   if(field.getText()!=null)
                            res=c.calc(v.getId()  ,Double.valueOf(String.valueOf(field.getText())));
                        else
                            Toast.makeText(getBaseContext(),erro,Toast.LENGTH_LONG).show();
                            Log.d(msg,oppress);
        }

    }

}
