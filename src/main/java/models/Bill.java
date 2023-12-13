package models;

import javafx.collections.ObservableList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Bill {
    private List<Book> books;
    private ArrayList<Integer> quantities;
    private double total;
    private static double revenues;

    public static int billNo;

    private String billFileName;
    private String revenueFileName = "revenues.txt";
    private Date dateOfTransaction;
    public Bill(ObservableList <Book> books, ArrayList <Integer> quantities)
    {

        dateOfTransaction = new Date();
        readRevenues(revenueFileName);
        this.books = books;
        this.quantities = quantities;
        billNo++;
        this.billFileName = "Bills\\bill"+billNo+".txt";
        writeBillToFile();
    }

    public Bill(List <Book> books, ArrayList <Integer> quantities, String billFileName, String revenueFileName)
    {
        this.billFileName = billFileName;
        this.revenueFileName = revenueFileName;
        dateOfTransaction = new Date();
        readRevenues(revenueFileName);
        this.books = books;
        this.quantities = quantities;
        billNo++;
        writeBillToFile();
    }



    public double CalculateTotal()
    {
        for (int i =0;i< books.size();i++)
        {
            total += books.get(i).getSellingPrice()* quantities.get(i);
        }
        revenues+=total;
        writeRevenueToFile();
        return total;
    }

    public static double getRevenues(String revenueFileName) {

        readRevenues(revenueFileName);
        return revenues;
    }

    public void writeBillToFile()
    {
        try(PrintWriter writer = new PrintWriter(new File(billFileName)))
        {
            writer.println("Bill NO."+billNo);
            writer.println("ISBN\t\tTitle\t\tPrice\t\tQuantity");
            for(int i = 0;i<books.size();i++)
            {
                writer.println(books.get(i).getISBN()+"\t\t"+books.get(i).getTitle()+"\t\t"+books.get(i).getSellingPrice()+"\t\t"+quantities.get(i));
            }
            writer.println("\nDate:"+dateOfTransaction.toString()+"\tTotal is:"+ total);

        }
        catch (FileNotFoundException ex)
        {
            System.out.println("Bill file not found");
        }

    }

    public void writeRevenueToFile()
    {

        try(PrintWriter writer = new PrintWriter(revenueFileName))
        {
            writer.println(revenues);
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("Revenue file not found");
        }


    }

    public static double readRevenues(String revenueFileName)
    {
        File file = new File(revenueFileName);
        revenues = 0;
        try (Scanner reader = new Scanner(file)){

            revenues+=reader.nextDouble();
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("File not found");
        }
        return revenues;
    }

    public double getTotal() {

        return CalculateTotal();
    }
}
