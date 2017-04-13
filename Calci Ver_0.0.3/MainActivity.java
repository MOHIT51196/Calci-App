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
import java.util.ArrayList;
import java.util.List;

//import android.view.Menu;
//import android.view.MenuItem;

/**
 * @author MOHIT MALHOTRA
 * @version 0.0.3
 * @since 08 Jan 2017
 */

public class MainActivity extends AppCompatActivity implements OnClickListener {


    EditText field;
    Button but1,but2,but3,but4,but5,but6,but7,but8,but9,but0;
    Button add,sub,mul,div,pwr,sin,sinh,cos,cosh,tan,equi;
    Button clear,backspace,dot;
    TextView tv;
    public  int num=0;

     public List<String> infix=new ArrayList<>();

    Boolean track=true;
    int clearcount=0;
    String msg="LOG : ";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(getApplicationContext(), "Welcome to the test version of Calci", Toast.LENGTH_LONG).show();
        //downcasting
        field =(EditText)findViewById(R.id.editText);
        tv=(TextView) findViewById(R.id.textView);

        but1=(Button) findViewById(R.id.one);
        but2=(Button) findViewById(R.id.two);
        but3=(Button) findViewById(R.id.three);
        but4=(Button) findViewById(R.id.four);
        but5=(Button) findViewById(R.id.five);
        but6=(Button) findViewById(R.id.six);
        but7=(Button) findViewById(R.id.seven);
        but8=(Button) findViewById(R.id.eight);
        but9=(Button) findViewById(R.id.nine);
        but0=(Button) findViewById(R.id.zero);

        //operational buttons

        clear=(Button) findViewById(R.id.clear);
        backspace=(Button) findViewById(R.id.backspace);
        dot=(Button) findViewById(R.id.dot);

        add=(Button) findViewById(R.id.add);
        sub=(Button) findViewById(R.id.sub);
        mul=(Button) findViewById(R.id.mul);
        div=(Button) findViewById(R.id.div);
        sin=(Button) findViewById(R.id.sin);
        cos=(Button) findViewById(R.id.cos);
        tan=(Button) findViewById(R.id.tan);
        sinh=(Button) findViewById(R.id.sinh);
        cosh=(Button) findViewById(R.id.cosh);
        pwr=(Button) findViewById(R.id.pwr);
        equi=(Button) findViewById(R.id.equi);

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
//        if(field.getText().toString().trim().length()==0)
            field.setText("0");
            tv.setText("");

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

        // Clear Button Listener
        clear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                field.setText("0");
                track=false;
                        if(clearcount==0)
                            clearcount++;
                        //double click functionality
                        else{
                            tv.setText("");
                            clearcount=0;
                        }

            }
        });

        //Backspace Button Listener
        backspace.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view ){

                if(field.getText().toString().trim().length()!=0&&(!field.getText().toString().equals("0"))) {
                    field.setText(field.getText().toString().substring(0, field.getText().toString().length() - 1));
                    tv.setText(tv.getText().toString().substring(0, tv.getText().toString().length() - 1));
                }

                else
                    field.setText("0");



            }
        });

        //Dot Button Listener
        dot.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View view){

                    if(!field.getText().toString().contains(".")){
                        field.setText(field.getText().toString()+".");
                        tv.setText(tv.getText().toString()+".");

                    }
            }
        });

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

        if(String.valueOf(field.getText()).trim().length()!=0) {

            try {
                switch (v.getId()) {
                    case R.id.zero:
                        if (Double.parseDouble(field.getText().toString().trim()) == 0.0)
                            field.setText(String.valueOf(but0.getText()));
                        else
                            field.setText(String.valueOf(field.getText()) + String.valueOf(but0.getText()));

                        tv.setText(tv.getText().toString()+but0.getText().toString());
                        track = true;
                        break;
                    case R.id.one:
                        if (Double.parseDouble(field.getText().toString().trim()) == 0.0)
                            field.setText(String.valueOf(but1.getText()));
                        else
                            field.setText(String.valueOf(field.getText()) + String.valueOf(but1.getText()));

                        tv.setText(tv.getText().toString()+but1.getText().toString());
                        track = true;
                        break;
                    case R.id.two:
                        if (Double.parseDouble(field.getText().toString().trim()) == 0.0)
                            field.setText(String.valueOf(but2.getText()));
                        else
                            field.setText(String.valueOf(field.getText()) + String.valueOf(but2.getText()));

                        tv.setText(tv.getText().toString()+but2.getText().toString());
                        track = true;
                        break;
                    case R.id.three:
                        if (Double.parseDouble(field.getText().toString().trim()) == 0.0)
                            field.setText(String.valueOf(but3.getText()));
                        else
                            field.setText(String.valueOf(field.getText()) + String.valueOf(but3.getText()));

                        tv.setText(tv.getText().toString()+but3.getText().toString());
                        track = true;
                        break;
                    case R.id.four:
                        if (Double.parseDouble(field.getText().toString().trim()) == 0.0)
                            field.setText(String.valueOf(but4.getText()));
                        else
                            field.setText(String.valueOf(field.getText()) + String.valueOf(but4.getText()));

                        tv.setText(tv.getText().toString()+but4.getText().toString());
                        track = true;
                        break;
                    case R.id.five:
                        if (Double.parseDouble(field.getText().toString().trim()) == 0.0)
                            field.setText(String.valueOf(but5.getText()));
                        else
                            field.setText(String.valueOf(field.getText()) + String.valueOf(but5.getText()));

                        tv.setText(tv.getText().toString()+but5.getText().toString());
                        track = true;
                        break;
                    case R.id.six:
                        if (Double.parseDouble(field.getText().toString().trim()) == 0.0)
                            field.setText(String.valueOf(but6.getText()));
                        else
                            field.setText(String.valueOf(field.getText()) + String.valueOf(but6.getText()));

                        tv.setText(tv.getText().toString()+but6.getText().toString());
                        track = true;
                        break;
                    case R.id.seven:
                        if (Double.parseDouble(field.getText().toString().trim()) == 0.0)
                            field.setText(String.valueOf(but7.getText()));
                        else
                            field.setText(String.valueOf(field.getText()) + String.valueOf(but7.getText()));

                        tv.setText(tv.getText().toString()+but7.getText().toString());
                        track = true;
                        break;
                    case R.id.eight:
                        if (Double.parseDouble(field.getText().toString().trim()) == 0.0)
                            field.setText(String.valueOf(but8.getText()));
                        else
                            field.setText(String.valueOf(field.getText()) + String.valueOf(but8.getText()));

                        tv.setText(tv.getText().toString()+but8.getText().toString());
                        track = true;
                        break;
                    case R.id.nine:
                        if (Double.parseDouble(field.getText().toString().trim()) == 0.0)
                            field.setText(String.valueOf(but9.getText()));
                        else
                            field.setText(String.valueOf(field.getText()) + String.valueOf(but9.getText()));

                        tv.setText(tv.getText().toString()+but9.getText().toString());
                        track = true;
                        break;


                    case R.id.equi:

                        infix.add(field.getText().toString());
                        Conversions conv=new Conversions();
                        String[] post=conv.convert((ArrayList<String>)infix);


                        Evaluate eval=new Evaluate();
                        String result=eval.evaluate(post);
                        track = false;
                        field.setText(result);
                        tv.setText(result);

                        break;
                    case R.id.add:
                        if (track) {


                            infix.add(field.getText().toString());

                            tv.setText(tv.getText().toString() + String.valueOf(add.getText()));
                            infix.add(add.getText().toString());

                            field.setText("0");
                        } else
                            Toast.makeText(getBaseContext(), "Accessing Invalid Operation\n\tPress some value first", Toast.LENGTH_LONG).show();

                        track = false;
                        break;

                    case R.id.sub:
                        if (track) {

                            infix.add(field.getText().toString());

                            tv.setText(tv.getText().toString() + String.valueOf(sub.getText()));
                            infix.add(sub.getText().toString());
                            field.setText("0");
                        } else
                            Toast.makeText(getBaseContext(), "Accessing Invalid Operation\n\tPress some value first", Toast.LENGTH_LONG).show();

                        track = false;
                        break;

                    case R.id.mul:
                        if (track) {

                            infix.add(field.getText().toString());

                            tv.setText(tv.getText().toString() + String.valueOf(mul.getText()));
                            infix.add("*");
                            field.setText("0");
                        } else
                            Toast.makeText(getBaseContext(), "Accessing Invalid Operation\n\tPress some value first", Toast.LENGTH_LONG).show();

                        track = false;
                        break;

                    case R.id.div:
                        if (track) {

                            infix.add(field.getText().toString());

                            tv.setText(tv.getText().toString() + String.valueOf(div.getText()));
                            infix.add(div.getText().toString());
                            field.setText("0");
                        } else
                            Toast.makeText(getBaseContext(), "Accessing Invalid Operation\n\tPress some value first", Toast.LENGTH_LONG).show();

                        track = false;
                        break;

        case R.id.pwr:
            if (track) {
                tv.setText(tv.getText().toString()+field.getText().toString());
                infix.add(field.getText().toString());

                tv.setText(tv.getText().toString() + "^");
                infix.add("^");
                field.setText("0");
            } else
                Toast.makeText(getBaseContext(), "Accessing Invalid Operation\n\tPress some value first", Toast.LENGTH_LONG).show();

            track = false;
            break;

        case R.id.sin:
            if (track) {
                double num = Math.sin(Math.toDegrees(Double.parseDouble(field.getText().toString())));
                tv.setText("Sin("+num+")");
                field.setText(String.valueOf(num));


            } else
                Toast.makeText(getBaseContext(), "Accessing Invalid Operation\n\tPress some value first", Toast.LENGTH_LONG).show();

            track = false;
            break;



        case R.id.sinh:
            if (track) {
                double num = Math.sinh(Double.parseDouble(field.getText().toString()));
                tv.setText("Sinh("+num+")");
                field.setText(String.valueOf(num));

            } else
                Toast.makeText(getBaseContext(), "Accessing Invalid Operation\n\tPress some value first", Toast.LENGTH_LONG).show();

            track = false;
            break;


        case R.id.cos:
            if (track) {
                double num = Math.cos(Math.toDegrees(Double.parseDouble(field.getText().toString())));
                tv.setText("Cos("+num+")");
                field.setText(String.valueOf(num));

            } else
                Toast.makeText(getBaseContext(), "Accessing Invalid Operation\n\tPress some value first", Toast.LENGTH_LONG).show();

            track = false;
            break;


        case R.id.cosh:
            if (track) {
                double num = Math.cosh(Double.parseDouble(field.getText().toString()));
                tv.setText("Cosh("+num+")");
                field.setText(String.valueOf(num));

            } else
                Toast.makeText(getBaseContext(), "Accessing Invalid Operation\n\tPress some value first", Toast.LENGTH_LONG).show();

            track = false;
            break;

        case R.id.tan:
            if (track) {
                double num = Math.tan(Math.toDegrees(Double.parseDouble(field.getText().toString())));
                tv.setText("Tan("+num+")");
                field.setText(String.valueOf(num));

            } else
                Toast.makeText(getBaseContext(), "Accessing Invalid Operation\n\tPress some value first", Toast.LENGTH_LONG).show();

            track = false;
            break;


                }
            } catch (Exception err) {
                Toast.makeText(getBaseContext(), "ERROR : " + err.getMessage(), Toast.LENGTH_LONG).show();
            }
        }

        else
            Toast.makeText(getBaseContext(),"ERROR : "+"Enter a value",Toast.LENGTH_LONG).show();

    }

}
