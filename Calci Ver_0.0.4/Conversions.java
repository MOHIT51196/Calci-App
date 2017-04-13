package com.example.mohitmalhotra.calci;

import java.util.ArrayList;
import java.util.Stack;
/**
 * This class <b>I2pConversion </b> perfroms the conversion of the infix expression to postfix expression.
 * Class is public and has 2 functions : convert() and prior()
 * @author MOHIT MALHOTRA
 *
 */

public class Conversions {

    public Stack<String> s=new Stack<>();

    public String[] convert(ArrayList<String> infix){
        /**
         * This convert() function takes the infix expression as its argument
         * and converts the infix expression to the postfix expression through stack operations.
         *
         */
        String operator;
        String[] postfix=new String[infix.size()];

        int i=0;

        if(!infix.isEmpty()){

            while(!infix.isEmpty()){

                operator=infix.remove(0);


                if(operator.matches(".*[0-9].*"))
                    postfix[i++]=operator;

                else {

                    if(s.empty())
                        s.push(operator);

                    else{
                        if(prior(operator)!=-1){
                            if(prior(operator) <= prior(s.peek())){
                                postfix[i++]=s.pop();

                                s.push(operator);
                            }

                            else
                                s.push(operator);

                        }
                    }

                }

            }

            while(!s.empty()){
                postfix[i]=s.pop();
                i++;


            }


        }


        return postfix;


    }

    private int prior(String operator){
        /**
         * This prior() function takes the operator character in the infix expression as its argument.
         * It returns a priority value depending on the priority table of operators logic.
         * prior() returns a int value;
         * This function is private to the class <b>I2pConversion</b> .
         */

        switch(operator.trim()){

            case "*" :	return  5;

            case "/" :	return  6;

            case "+" :	return	4;

            case "-" :	return  3;

            case "^" :	return  7;

            case "%" :	return	2;

            default : 	return -1;

        }

    }

}
