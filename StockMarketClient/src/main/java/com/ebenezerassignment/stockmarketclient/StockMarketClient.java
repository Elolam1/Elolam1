/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.ebenezerassignment.stockmarketclient;

import StockmarketApp.Stockmarket;
import StockmarketApp.StockmarketHelper;
import java.util.Scanner;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

/**
 *
 * @author ja185278
 */
public class StockMarketClient {

    public static void main(String[] args) {
        try
        {
        ORB orb = ORB.init(args, null);
           
        org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
        NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
        
        Stockmarket smeObj = (Stockmarket) StockmarketHelper.narrow(ncRef.resolve_str("StockExchange"));
        
        Scanner c = new Scanner(System.in);
        
        System.out.println("Welcome to the client side of the Stock Market Exchange");
        for(;;)
        {
           System.out.println("Enter the stock market name to retrieve the rate");
           String aa = c.nextLine();
           double res = smeObj.retrieveSME(aa);
           
           System.out.println("Exchange rate is " + res);
           
        }
        }
        catch(Exception ex)
        {
             System.out.println("Error: " + ex);
        }
    }
}
