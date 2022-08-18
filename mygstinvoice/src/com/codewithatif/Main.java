package com.codewithatif;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);
        int total_qty=0;
        int total_price=0;

        boolean start=true;
        while (start){
            System.out.println();
            System.out.println("----  Welcome To Arektechnologies  ----");
            System.out.println("    Address:Uppal,Hyd,Telangana-39");
            System.out.println("  info@areksoft.com | sales@areksoft.com");
            System.out.println();
            date.mydate();
            System.out.println("----------------------------------------");
            System.out.print("Customer name : ");
            String name=sc.next();
            System.out.print("Mobile number : ");
            int mobile=sc.nextInt();
            System.out.println();

            int a=1;
            boolean b=true;
            while(b){
                System.out.print("Product name : ");
                String namee=sc.next();

                System.out.print("Quantity :  ");
                int quantityy=sc.nextInt();
                total_qty+=quantityy;

                System.out.print("Price: ");
                int pricee=sc.nextInt();
                total_price+=pricee;

                product p1=new product(namee,quantityy,pricee);
                System.out.println(p1);

                System.out.println();
                System.out.print("1:Nextitem 0:Enditem= ");
                int sta = sc.nextInt();

                if(sta==0){
                    b=false;
                }
            }


            System.out.print("Number of products :    ");
            System.out.println(total_qty);
            System.out.print("Total :                 ");
            System.out.println(total_price);
            int f=gstprice(total_price);
            System.out.println("Gst 18% :               "+f);
            int l=f+total_price;
            System.out.println("----------------------------");
            System.out.println("Total amount:           "+l);
            System.out.println("----------------------------");


            System.out.println();
            System.out.println("      ----Thank you ----");

            System.out.println();
            System.out.println("Press: 1 for next bill:");
            System.out.println("Press: 0 to end bill");
            a=sc.nextInt();
            if(a==0){
                start=false;
            }
        }

    }

    public static int gstprice(int price) {

        return 18*price/100;
    }
}
