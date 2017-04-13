package com.example.mohitmalhotra.calci;

import java.util.Stack;

/**
 * This class <b>Conversion </b> perfroms the conversion of the infix expression to postfix expression.
 * Class is public and has 2 functions : convert() and prior()
 * @author MOHIT MALHOTRA
 *
 */
public class Conversions {

    public Stack<String> s=new Stack<>();

    public String convert(String infix){
        /**
         * This convert() function takes the infix expression as its argument
         * and converts the infix expression to the postfix expression through stack operations.
         *
         */
        String operator,post="";
        infix=infix.trim();

        if(infix.trim().length()!=0){

            for(int i=0;i<infix.length();i++){

                operator=String.valueOf(infix.charAt(i));

                if(Character.isDigit(infix.charAt(i)))
                    post=post+infix.charAt(i);

                else {

                    if(s.empty())
                        s.push(operator);

                    else{
                        if(prior(operator)!=-1){
                            if(prior(operator) <= prior(s.peek())){
                                post=post+s.pop().toString();
                                s.push(operator);
                            }

                            else
                                s.push(operator);

                        }
                    }

                }
            }

            while(!s.empty())
                post=post+s.pop();

            return post;
        }

        else
            return "null";


    }

    private int prior(String operator){
        /**
         * This prior() function takes the operator character in the infix expression as its argument.
         * It returns a priority value depending on the priority table of operators logic.
         * prior() returns a int value;
         * This function is private to the class <b>Conversion</b> .
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
