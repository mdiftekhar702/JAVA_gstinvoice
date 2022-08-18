package com.codewithatif;

public class product {

    String pname;
    int pquatity;
    int pprice;

    product(String pname, int pquatity, int pprice){
        this.pname=pname;
        this.pquatity=pquatity;
        this.pprice=pprice;
    }

    public String getPname(){
        return pname;
    }
    public int getPquatity(){
        return pquatity;
    }
    public  int getPprice(){
        return  pprice;
    }
    public void setPname(String pname){
        this.pname=pname;
    }
    public void setPquatity(int pquatity){
        this.pquatity=pquatity;
    }
    public  void setPprice(int pprice){
        this.pprice=pprice;
    }
    product(){
        super();
    }

    public String toString(){
        return "~~ Productname : "+pname+"    QTY : "+pquatity+"    ₹ "+pprice*pquatity;
    }

}
