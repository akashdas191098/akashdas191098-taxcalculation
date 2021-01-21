package com.nagarro.taxcalculation;

import com.nagarro.taxcalculation.constants.*;

import com.nagarro.taxcalculation.model.*;

import java.util.Scanner;

public class TaxCalculationApp 
{
    public static void main(String[] args) 
    {
    	try
    	{
        Scanner scanner = new Scanner(System.in);
        while(true)
        {
        int count=0;
        String choice="";
        ItemDetail itemdetail = new ItemDetail();
        System.out.print(Constants.NAME);
        itemdetail.setName(scanner.nextLine());
        System.out.print(Constants.PRICE);
        itemdetail.setPrice(scanner.nextDouble());
        System.out.print(Constants.QUANTITY);
        itemdetail.setQuantity(scanner.nextLong());
        while(true)
        {
            System.out.print(Constants.ITEM_TYPE);
            if(count==0)
            {
            	scanner.nextLine();
            }
            choice=scanner.nextLine();
            count++;
            if(choice.length()>0)
            {
            	break;
            }
            else
            {
            	System.out.println(Constants.TYPE_MANDATORY);
            }
        }
        itemdetail.setType(choice);
        itemdetail.getDetails();
        System.out.print(Constants.REPEAT);
        if(scanner.nextLine().equalsIgnoreCase(Constants.N)) 
        {
            break;
        }
        }
        scanner.close();
    	}
    	catch(Exception e)
    	{
    		System.out.println(Constants.ERROR);
    	}
    	finally
    	{
    		System.out.println(Constants.END);
    	}
    }
}
