package com.nagarro.taxcalculation.model;

import com.nagarro.taxcalculation.enums.*;

public class ItemDetail 
{
    private String name, type;
    private double price,saleTax,finalPrice;
    private long quantity;
    public void setName(String name)
    {
        this.name = name;
    }
    
    public void setPrice(double price) 
    {
        this.price= price;
    }
    
    public void setQuantity(long quantity) 
    {
        this.quantity = quantity;
    }
    
    public void setType(String type) 
    {
        this.type = type;
    }
    
    public void taxCalulation()
    {
        if(ItemType.Raw.toString().equalsIgnoreCase(type)) 
        {
            saleTax = this.price*(0.125); 
        }
        else if(ItemType.Manufactured.toString().equalsIgnoreCase(type)) 
        {
            saleTax = (price*(0.125)) + ((0.02)*((price*(0.125)) + price));
        }
        else if(ItemType.Import.toString().equalsIgnoreCase(type)) 
        {
            saleTax = price*(0.1);
            if(saleTax<100)
                saleTax = saleTax+5;
            else if(saleTax>100 && saleTax<=200)
                saleTax = saleTax+10;
            else
                saleTax =saleTax+saleTax*(0.05);
        }
        else
        {
        	System.out.println("You have entered wrong choice");
        }
        finalPrice = price + saleTax;
    }
    
    public void getDetails() 
    {
    	taxCalulation();
        System.out.println("\tItem Name: "+name);
        System.out.println("\tItem Price: "+price);
        System.out.println("\tsales tax liability per item: "+saleTax);
        System.out.println("\tfinal price: "+finalPrice);
    }
}
