package com.example.mohitmalhotra.calci;

import android.app.Activity;
import android.widget.Toast;
import java.util.Stack;

/**
 *
 * This <b>I2pEval</b> class is to evalute the so obtained postfix expression
 * from the <b>I2pConversion</b> class .
 * Class is public and has 2 functions : evaluate() and mathLog()
 * @author MOHIT MALHOTRA
 *
 */
public class Evaluate extends Activity{

    private Stack<String> is=new Stack<>();

    public String evaluate(String postfix[]){
        /**
         * This evaluate() function takes the postfix expression as its argument
         * and perform stack evaluation operations over the postfix expression evaluted by functions of class <b>I2pConversion</b> .
         * evaluate() function returns a String value .
         */

        String res="0";


        if(postfix[0]!=null){

            for(int i=0;i<postfix.length;i++){


                if(postfix[i].matches(".*[0-9].*"))
                    is.push(postfix[i]);

                else{
                    res=mathLog(postfix[i].trim());
                    is.push(res);
                }


            }

            return is.pop();

        }

        else
            return "null";


    }


    private String mathLog(String operator){

        /**
         * This mathLog() function takes the operators present in the postfix expression as its argumnent
         * It performs arithematic operations over the stacked elements using the operators.
         * mathLog() returns a int value.
         * Function is private to the class <b>I2pEval</b>
         */

        double result=0;
        String firstpop=is.pop();
        String secondpop=is.pop();

        try{

            double firstval=Double.parseDouble(firstpop);
            double secondval=Double.parseDouble(secondpop);


            switch(operator){

                //last pop from the stack will be the second value of the post fix expression

                case "+" :	result=secondval+firstval;
                    break;

                case "-" :	result=secondval-firstval;
                    break;

                case "*" :	result=secondval*firstval;
                    break;

                case "/" :
                    if(firstval!=0.0&&(!firstpop.equals("0")))
                        result=secondval/firstval;
                    else
                        Toast.makeText(getBaseContext(),"Inappropriate Division",Toast.LENGTH_LONG).show();
                    break;

                case "^" :	result=Math.pow(secondval,firstval);
                    break;

                case "%" :	result=secondval%firstval;
                    break;

            }
        }

        catch (ArithmeticException err){
            Toast.makeText(getBaseContext(),"ERROR : "+err.getMessage(), Toast.LENGTH_LONG).show();
        }


        if(firstpop.contains(".")||secondpop.contains("."))
            return String.valueOf(result);
        else
            return String.valueOf((long)result);

    }

}




