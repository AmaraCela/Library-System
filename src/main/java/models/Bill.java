package models;

import javafx.collections.ObservableList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Bill {
    private ObservableList<Book> books;
    private ArrayList<Integer> quantities;
    private double total;
    private static double revenues;

    private static int billNo;
    private Date dateOfTransaction;
    public Bill(ObservableList <Book> books, ArrayList <Integer> quantities)
    {
        dateOfTransaction = new Date();
        readRevenues();
        this.books = books;
        this.quantities = quantities;
        billNo++;
        total=CalculateTotal();
        writeToFile();
    }

    public double CalculateTotal()
    {
        for (int i =0;i< books.size();i++)
        {
            total += books.get(i).getSellingPrice()* quantities.get(i);
        }
        revenues +=total;
        System.out.println("Revenue when adding a new bill:"+ revenues);
        writeRevenueToFile();
        return total;
    }

    public static double getRevenues() {

        readRevenues();
        return revenues;
    }

    public void writeToFile()
    {
        File folder = new File("Bills");

        System.out.println(folder.mkdir());

        File file = new File(folder+"\\bill"+billNo+".txt");

        try(PrintWriter writer = new PrintWriter(file)) {
            writer.println("Bill NO."+billNo);
            writer.println("ISBN\t\tTitle\t\tPrice\t\tQuantity");
            for(int i = 0;i<books.size();i++)
            {
                writer.println(books.get(i).getISBN()+"\t\t"+books.get(i).getTitle()+"\t\t"+books.get(i).getSellingPrice()+"\t\t"+quantities.get(i));
            }
            writer.println("\nDate:"+dateOfTransaction.toString()+"\tTotal is:"+ total);

        }
        catch (FileNotFoundException e)
        {
            System.out.println("File for bills not found");
        }
    }

    public void writeRevenueToFile()
    {
        File file = new File("revenues.txt");

        try(PrintWriter writer = new PrintWriter(file))
        {
            writer.println(revenues);
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("File not found");
        }
    }

    public static void readRevenues()
    {
        File file = new File("revenues.txt");
        revenues = 0;
        try (Scanner reader = new Scanner(file)){

            revenues+=reader.nextDouble();
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("File not found");
        }
    }

    public double getTotal() {
        return total;
    }
}
