package com.example.mohitmalhotra.calci;

import android.view.View.OnClickListener;
import android.widget.Toast;
import java.lang.Exception;
import java.lang.Math;

/**
 * Created by MOHIT MALHOTRA on 27-12-2016.
 */

public class Calculate extends MainActivity implements OnClickListener{
    public Double calc(int sign,Double num)
    {
        if((num != 0) || (num != null)) {
            try {
                switch (sign) {
                    case R.id.add:
                        field.setText("0");
                        num = num + Double.valueOf(String.valueOf(field.getText()));
                        return num;
                    case R.id.sub:
                        field.setText("0");
                        num = num - Double.valueOf(String.valueOf(field.getText()));
                        return num;

                    case R.id.mul:
                        field.setText("0");
                        num = num * Double.valueOf(String.valueOf(field.getText()));
                        return num;
                    case R.id.div:
                        field.setText("0");
                        if (String.valueOf(field.getText()) == "0")
                            num = num / Double.valueOf(String.valueOf(field.getText()));
                        else
                            Toast.makeText(getBaseContext(), "Mathematicallyb inappropriate operation", Toast.LENGTH_LONG).show();
                        return num;
                    case R.id.pwr:
                        field.setText("0");
                        num = Math.pow(num, Double.valueOf(String.valueOf(field.getText())));
                        return num;

                    case R.id.sin : num = Math.toDegrees(num);
                        return Math.sin(num);

                    case R.id.sinh :    num = Math.toDegrees(num);
                        return Math.sinh(num);

                    case R.id.cos : num = Math.toDegrees(num);
                        return Math.cos(num);

                    case R.id.cosh :    num = Math.toDegrees(num);
                        return Math.cosh(num);

                    case R.id.tan : num = Math.toDegrees(num);
                        return Math.tan(num);

                }

            } catch (Exception err) {
                Toast.makeText(getBaseContext(), "ERROR : " + err.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
    return 0.0;
    }

}

