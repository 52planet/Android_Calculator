//Luke Belch
//student number: 152944179
package com.example.map_a1;

import java.util.ArrayList;
import java.lang.Math;

public class Calculator
{

    ArrayList<String> operation_string = new ArrayList<String>();

    Calculator()
    {
        operation_string = new ArrayList<String>();
        operation_string.clear();
    }

    void push (String value)
    {
        if(value.equals("C"))
        {
            operation_string.clear();
        }
        else if(value.equals("="))
        {
            calculate();
        }
        else
        {

            if(operation_string.isEmpty() == false && value.equals("+") || operation_string.isEmpty() == false && value.equals("-") || operation_string.isEmpty() == false && value.equals("*") || operation_string.isEmpty() == false && value.equals("/") || operation_string.isEmpty() == false && value.equals("%") || operation_string.isEmpty() == false && value.equals("POW")|| operation_string.isEmpty() == false && value.equals("MAX")|| operation_string.isEmpty() == false && value.equals("MIN") ) //if an operator previous cant be an operator
            {
                String last = operation_string.get(operation_string.size() - 1);
                if(last.equals("+") || last.equals("-") || last.equals("*") || last.equals("/") || last.equals("*%") || last.equals("POW") || last.equals("MIN") || last.equals("MAX"))
                {
                    //error
                    operation_string.set(0, "failure two operators in a row");
                }
                else
                {
                    operation_string.add(value);
                }
            }

            else if(operation_string.isEmpty() == false) // its a number
            {
                String last = operation_string.get(operation_string.size() - 1);
                if(last.equals("1") || last.equals("2") || last.equals("3") || last.equals("4") || last.equals("5") || last.equals("6") || last.equals("7") || last.equals("8") || last.equals("9") || last.equals("0"))
                {
                    //error
                    operation_string.set(0, "failure, two numbers in a row");
                }
                else
                {
                    operation_string.add(value);
                }
            }

            else if(operation_string.isEmpty() == true)
            {
                if(value.equals("+") || value.equals("-") || value.equals("*") || value.equals("/") || value.equals("%")|| value.equals("POW")|| value.equals("MIN")|| value.equals("MAX"))
                {
                    operation_string.add("failure, operators cant be first");
                }
                else
                {
                    operation_string.add(value);
                }

            }

        }

    }

    int calculate()
    {
        //parse the array list
        int x = 0;
        int y = 0;

        if(operation_string.isEmpty() == true)
        {
            //error
            operation_string.add("failure, no equation to solve");
            return -1;
        }
        else if(operation_string.size() <= 2 && operation_string.isEmpty() == false)
        {
            //error
            operation_string.set(0, "failure, equation is incomplete");
            return -1;
        }


        for(int i =0; i < operation_string.size(); i++)
        {

            if(operation_string.get(i).equals("+"))
            {
                //turn next number to proper data type
                i++;
                y = Integer.parseInt(operation_string.get(i));
                //perform operation and loop again
                x = x + y;
            }
            else if(operation_string.get(i).equals("-"))
            {
                //turn next number to proper data type
                i++;
                y = Integer.parseInt(operation_string.get(i));
                //perform operation and loop again
                x = x - y;
            }
            else if(operation_string.get(i).equals("*"))
            {
                //turn next number to proper data type
                i++;
                y = Integer.parseInt(operation_string.get(i));
                //perform operation and loop again
                x = x * y;
            }
            else if(operation_string.get(i).equals("/"))
            {
                //turn next number to proper data type
                i++;
                y = Integer.parseInt(operation_string.get(i));
                //perform operation and loop again
                x = x / y;
            }
            else if(operation_string.get(i).equals("%"))
            {
                //turn next number to proper data type
                i++;
                y = Integer.parseInt(operation_string.get(i));
                //perform operation and loop again
                x = x % y;
            }
            else if(operation_string.get(i).equals("POW"))
            {
                //turn next number to proper data type
                i++;
                y = Integer.parseInt(operation_string.get(i));
                //perform operation and loop again
                double answer = Math.pow(x,y);
                x = (int)answer;
            }
            else if(operation_string.get(i).equals("MIN"))
            {
                //turn next number to proper data type
                i++;
                y = Integer.parseInt(operation_string.get(i));
                //perform operation and loop again

                if(x > y)
                {
                    x = y;
                }
            }
            else if(operation_string.get(i).equals("MAX"))
            {
                //turn next number to proper data type
                i++;
                y = Integer.parseInt(operation_string.get(i));
                //perform operation and loop again
                if(x < y)
                {
                    x = y;
                }

            }
            else //its a number
            {
                x = Integer.parseInt(operation_string.get(i));
            }

        }

        //calculate
        String s = String.valueOf(x);
        operation_string.clear();
        operation_string.add(s);
        return x;
    }


    String display()
    {
        if(operation_string.isEmpty() == true)
        {
            return "";
        }
        else if(operation_string.get(0).contains("failure"))
        {
            String message = operation_string.get(0);
            operation_string.clear();
            return message;
        }
        else
        {
            return operation_string.toString();
        }


    }

}
