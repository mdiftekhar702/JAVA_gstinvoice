import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.border.DashedBorder;
import com.itextpdf.layout.border.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Tab;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GeneratePdf {
    public static void main(String[] args) throws FileNotFoundException {
//code-
        Scanner sc = new Scanner(System.in);
//code-

        String path="invoice.pdf"; //format of the file

//        pdfwriter is class used to creat a new pdf
        PdfWriter pdfWriter= new PdfWriter(path);                //parameter is used for path=location of the pdfpp
        PdfDocument pdfDocument=new PdfDocument(pdfWriter);            //pdfdoc generator doc parameter=name of pdf
        pdfDocument.setDefaultPageSize(PageSize.A4);   //size of the pdf

        Document document = new Document(pdfDocument); //used to display the document;

        float threecol=190f;
        float twocol=285f;
        float twocol150=twocol+150f;
        float twocolumnWidth[]={twocol150,twocol};//widths of 1st column
        float threeColumnWidth[]={threecol,threecol,threecol};
        float fullwidth[]={threecol*3};  //border array
        Paragraph onespace=new Paragraph("\n");

        Table table= new Table(twocolumnWidth); // table method parameter =arr of  width

        table.addCell(new Cell().add("Areksoft Technologies\n(INVOICE)").setFontSize(20f).setBorder(Border.NO_BORDER).setBold());  //adding content to particular column
        Table nestedtable = new Table(new float[]{twocol/2,twocol/2});
//        nestedtable.addCell(new Cell().add("Invoice no: ").setBold().setBorder(Border.NO_BORDER));
//        nestedtable.addCell(new Cell().add("1234").setBorder(Border.NO_BORDER));
//        nestedtable.addCell(new Cell().add("Invoice Date:").setBold().setBorder(Border.NO_BORDER));
//        nestedtable.addCell(new Cell().add("1/22/3333").setBorder(Border.NO_BORDER));

        nestedtable.addCell(getHeaderTextCell("Invoice No: "));
        nestedtable.addCell(getHeaderTextCellValue("RK356748"));
        nestedtable.addCell(getHeaderTextCell("Invoice Date: "));
        nestedtable.addCell(getHeaderTextCellValue("1/22/3333"));




        table.addCell(new Cell().add(nestedtable).setBorder(Border.NO_BORDER));

        Border gb=new SolidBorder(Color.GRAY,2f);
        Table divider=new Table(fullwidth);
        divider.setBorder(gb);

        document.add(table); //added to document 1st come 1st serve
        document.add(onespace);
        document.add(divider);
        document.add(onespace);

        Table twoTable=new Table(twocolumnWidth);
        twoTable.addCell(getBillingandShippingCell("Billing Information"));
        twoTable.addCell(getBillingandShippingCell("Shipping Information"));
        document.add(twoTable.setMarginBottom(12f));

        Table twoColTable2=new Table(twocolumnWidth);
        twoColTable2.addCell(getCell10fLeft("Company",true));
        twoColTable2.addCell(getCell10fLeft("Name",true));
        twoColTable2.addCell(getCell10fLeft("comp xyz",false));
        twoColTable2.addCell(getCell10fLeft("name xyz",false));

        document.add(twoColTable2);




        Table twoColTable3=new Table(twocolumnWidth);
        twoColTable3.addCell(getCell10fLeft("Name",true));
        twoColTable3.addCell(getCell10fLeft("Address",true));
        twoColTable3.addCell(getCell10fLeft("John",false));
        twoColTable3.addCell(getCell10fLeft("xyz,uppal,\nhyderabd,\ntelangana-50013",false));

        document.add(twoColTable3);


        float oneColumnwidth[]={twocol150};

        Table oneColTable1=new Table(oneColumnwidth);
        oneColTable1.addCell(getCell10fLeft("Addresss",true));
        oneColTable1.addCell(getCell10fLeft("customar address,23-street,\nhyderabad,\ntelangana",false));
        oneColTable1.addCell(getCell10fLeft("Email:",true));
        oneColTable1.addCell(getCell10fLeft("example@gmail.com",false));
        document.add(oneColTable1.setMarginBottom(10f));

        Table tableDivider2= new Table(fullwidth); //dotted border
        Border dgb=new DashedBorder(Color.GRAY,0.5f);
        document.add(tableDivider2.setBorder(dgb));

        Paragraph productpara=new Paragraph("Products");
        document.add(productpara.setBold());

        Table threeColTable1=new Table(threeColumnWidth);
        threeColTable1.setBackgroundColor(Color.BLACK,0.7f);
        threeColTable1.addCell(new Cell().add("Description").setBold().setFontColor(Color.WHITE).setBorder(Border.NO_BORDER));
        threeColTable1.addCell(new Cell().add("Quantity").setBold().setFontColor(Color.WHITE).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
        threeColTable1.addCell(new Cell().add("Price").setBold().setFontColor(Color.WHITE).setTextAlignment(TextAlignment.RIGHT).setBorder(Border.NO_BORDER).setMarginRight(15f));

        document.add(threeColTable1);

        List<Product> productList=new ArrayList<>();
//        productList.add(new Product("Product 1", 2, 100));
//        productList.add(new Product("Product 1", 2, 100));
//        productList.add(new Product("Product 1", 2, 100));
//        productList.add(new Product("Product 1", 2, 100));
//        productList.add(new Product("Product 1", 2, 100));
//        productList.add(new Product("Product 1", 2, 100));
//        productList.add(new Product("Product 1", 2, 100));
//        productList.add(new Product("Product 1", 2, 100));
//        code-
            boolean b=true;
        int total_qty=0;
        int total_price=0;
        while(b){
            System.out.print("Product name : ");
            String namee=sc.next();

            System.out.print("Quantity :  ");
            int quantityy=sc.nextInt();
            total_qty+=quantityy;

            System.out.print("Price: ");
            int pricee=sc.nextInt();
            total_price+=pricee;

//        productList.add(new Product(namee, quantityy, pricee));
            Product p1=new Product(namee,quantityy,pricee);
            productList.add(p1);
            System.out.println(p1);

            System.out.println();
            System.out.print("1:Nextitem 0:Enditem= ");
            int sta = sc.nextInt();

            if(sta==0){
                b=false;
            }
        }

//        code-


        Table threeColTable2=new Table(threeColumnWidth);


        float totalsum=0;
        for(Product product:productList){

            float total=product.getQuatity()*product.getPriceperpiece();
            totalsum+=total;
            threeColTable2.addCell(new Cell().add(product.getPname()).setBorder(Border.NO_BORDER)).setMarginLeft(10f);
            threeColTable2.addCell(new Cell().add(String.valueOf(product.getQuatity())).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
            threeColTable2.addCell(new Cell().add(String.valueOf(total)).setTextAlignment(TextAlignment.RIGHT).setBorder(Border.NO_BORDER).setMarginRight(15f));
        }
        document.add(threeColTable2.setMarginBottom(20f));

        float onetwo[]={threecol+125f,threecol*2};
        Table threeColTable4=new Table(onetwo);
        threeColTable4.addCell(new Cell().add("").setBorder(Border.NO_BORDER));
        threeColTable4.addCell(new Cell().add(tableDivider2).setBorder(Border.NO_BORDER));
        document.add(threeColTable4);


        Table threeColTable3=new Table(threeColumnWidth);
        threeColTable3.addCell(new Cell().add("").setBorder(Border.NO_BORDER)).setMarginLeft(10f);
        threeColTable3.addCell(new Cell().add("No of products").setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
        threeColTable3.addCell(new Cell().add(String.valueOf(total_qty)).setTextAlignment(TextAlignment.RIGHT).setBorder(Border.NO_BORDER)).setMarginLeft(15f);

        Table threeColTable3_1=new Table(threeColumnWidth);
        threeColTable3.addCell(new Cell().add("").setBorder(Border.NO_BORDER)).setMarginLeft(10f);
        threeColTable3.addCell(new Cell().add("Total").setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
        threeColTable3.addCell(new Cell().add(String.valueOf(totalsum)).setTextAlignment(TextAlignment.RIGHT).setBorder(Border.NO_BORDER)).setMarginLeft(15f);

        Table threeColTable3_2=new Table(threeColumnWidth);
        threeColTable3.addCell(new Cell().add("").setBorder(Border.NO_BORDER)).setMarginLeft(10f);
        threeColTable3.addCell(new Cell().add("Gst 18%").setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
        int f=gstprice(total_price);
        threeColTable3.addCell(new Cell().add(String.valueOf(f)).setTextAlignment(TextAlignment.RIGHT).setBorder(Border.NO_BORDER)).setMarginLeft(15f);

        Table threeColTable3_3=new Table(threeColumnWidth);
        threeColTable3.addCell(new Cell().add("").setBorder(Border.NO_BORDER)).setMarginLeft(10f);
        threeColTable3.addCell(new Cell().add("Total Amount").setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
        float l=f+totalsum;
        threeColTable3.addCell(new Cell().add(String.valueOf(l)).setTextAlignment(TextAlignment.RIGHT).setBorder(Border.NO_BORDER)).setMarginLeft(15f);


        document.add(threeColTable3);
        document.add(tableDivider2);
        document.add(new Paragraph("\n"));
        document.add(divider.setBorder(new SolidBorder(Color.GRAY,1)).setMarginBottom(15f));


        System.out.println("successful");
        document.close();
    }

    public static int gstprice(int price) {

        return 18*price/100;
    }

    static Cell getHeaderTextCell(String textValue)
    {

        return new Cell().add(textValue).setBold().setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT);

    }

    static Cell getHeaderTextCellValue(String textValue)
    {

        return new Cell().add(textValue).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.LEFT);

    }

    static Cell getBillingandShippingCell(String textValue) //values of the all address,name etc;
    {

        return new Cell().add(textValue).setFontSize(12f).setBold().setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.LEFT);

    }

    static Cell getCell10fLeft(String textValue,Boolean isBold){ //replace all NAME/ADDRESS etc to actual name with bold
        Cell mycell= new Cell().add(textValue).setFontSize(10f).setBold().setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.LEFT);
        return isBold ?mycell.setBold():mycell;
    }

    static class Product {
        private String pname;
        private int quatity;
        private float priceperpiece;

        public Product(String pname, int quatity, float priceperpiece) {
            this.pname = pname;
            this.quatity = quatity;
            this.priceperpiece = priceperpiece;
        }

        public String getPname() {
            return pname;
        }

        public void setPname(String pname) {
            this.pname = pname;
        }

        public int getQuatity() {
            return quatity;
        }

        public void setQuatity(int quatity) {
            this.quatity = quatity;
        }

        public float getPriceperpiece() {
            return priceperpiece;
        }

        public void setPriceperpiece(float priceperpiece) {
            this.priceperpiece = priceperpiece;
        }

        public String toString() {
            return "~~ Productname : " + pname + "    QTY : " + quatity + "    ₹ " + priceperpiece * quatity;
        }


    }
}
