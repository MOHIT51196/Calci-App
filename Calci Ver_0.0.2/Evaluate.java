package com.example.mohitmalhotra.calci;

import android.app.Activity;
import android.widget.Toast;

import java.util.Stack;

/**
 *
 * This <b>I2pEval</b> class is to evalute the so obtained postfix expression
 * from the <b>Conversions</b> class .
 * Class is public and has 2 functions : evaluate() and mathLog()
 * @author MOHIT MALHOTRA
 *
 */
public class Evaluate extends Activity{

    private Stack<Integer> is=new Stack<>();

    public String evaluate(String post){
        /**
         * This evaluate() function takes the postfix expression as its argument
         * and perform stack evaluation operations over the postfix expression evaluted by functions of class <b>Conversions</b> .
         * evaluate() function returns a String value .
         */

        int res=0;


        if(post.trim().length()!=0&&!"null".equals(post)){

            for(int i=0;i<post.length();i++){


                if(Character.isDigit(post.charAt(i)))
                    is.push(Integer.parseInt(String.valueOf(post.charAt(i))));

                else{
                    res=mathLog(post.charAt(i));
                    is.push(res);
                }


            }

            return String.valueOf(is.pop());

        }

        else
            return "null";


    }


    private int mathLog(char operator){

        /**
         * This mathLog() function takes the operators present in the postfix expression as its argumnent
         * It performs arithematic operations over the stacked elements using the operators.
         * mathLog() returns a int value.
         * Function is private to the class <b>I2pEval</b>
         */

        int result=0;
        int firstpop=is.pop();
        int secondpop=is.pop();


        try{
            switch(operator){

                //last pop from the stack will be the second value of the post fix expression

                case '+' :	result=secondpop+firstpop;
                    break;

                case '-' :	result=secondpop-firstpop;
                    break;

                case '*' :	result=secondpop*firstpop;
                    break;

                case '/' :	result=secondpop/firstpop;
                    break;

                case '^' :	result=secondpop^firstpop;
                    break;

                case '%' :	result=secondpop%firstpop;
                    break;

            }
        }

        catch (ArithmeticException err){
            Toast.makeText(getBaseContext(),"ERROR : "+err.getMessage(), Toast.LENGTH_LONG).show();
        }

        return result;
    }

}
