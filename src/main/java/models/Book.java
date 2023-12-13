package models;

import java.io.*;
import java.util.Date;
import java.util.Scanner;
import java.io.Serializable;

public class Book implements Serializable {
    @Serial
    private static final long serialVersionUID = -2850370911775880690L;
    private String ISBN;
    private String title;
    private Category category;
    private String supplier;

    private Date purchasedDate;
    private double purchasedPrice;
    private double originalPrice;
    private double sellingPrice;
    private String  author;
    private int stock;
    private String categoryName;

    private static double totalCost;
    private String costFileName = "cost.txt";

    public Book(String ISBN, String title, Category category, String supplier,  double purchasedPrice, double originalPrice, double sellingPrice, String author, int stock) {
        this.ISBN = ISBN;
        this.title = title;
        this.supplier = supplier;
        this.purchasedPrice = purchasedPrice;
        this.originalPrice = originalPrice;
        this.sellingPrice = sellingPrice;
        this.author = author;
        this.stock = stock;
        this.category = category;
        this.categoryName = category.getCategoryName();
        category.addBookToCategory(this);
        readFromFile(costFileName);
        totalCost+=this.purchasedPrice*this.stock;
        writeToFile(costFileName);
    }

    public Book(String ISBN, String title, Category category, String supplier,  double purchasedPrice, double originalPrice, double sellingPrice, String author, int stock, String costFileName) {
        this.costFileName = costFileName;
        this.ISBN = ISBN;
        this.title = title;
        this.supplier = supplier;
        this.purchasedPrice = purchasedPrice;
        this.originalPrice = originalPrice;
        this.sellingPrice = sellingPrice;
        this.author = author;
        this.stock = stock;
        this.category = category;
        this.categoryName = category.getCategoryName();
        category.addBookToCategory(this);
        readFromFile(costFileName);
        totalCost+=this.purchasedPrice*this.stock;
        writeToFile(costFileName);
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public Date getPurchasedDate() {
        return purchasedDate;
    }

    public void setPurchasedDate(Date purchasedDate) {
        this.purchasedDate = purchasedDate;
    }

    public double getPurchasedPrice() {
        return purchasedPrice;
    }

    public void setPurchasedPrice(double purchasedPrice) {
        this.purchasedPrice = purchasedPrice;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void decreaseStock(int quantity)
    {
        this.stock -=quantity;
    }

    public void increaseStock(int quantity)
    {
        this.stock += quantity;
        totalCost +=this.purchasedPrice*quantity;
        writeToFile("cost.txt");
    }


    public String getCategoryName() {
        return categoryName;
    }

    public static void writeToFile(String filename)
    {
        try(PrintWriter writer = new PrintWriter(filename))
        {
            writer.println(totalCost);
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("Relative path to file not found");

        }
    }

    public static double readFromFile(String filename)
    {
        File file = new File(filename);
        try (Scanner scanner = new Scanner(file))
        {
            totalCost = 0;
            totalCost+=scanner.nextDouble();

        }
        catch (FileNotFoundException ex)
        {
            System.out.println("Relative path not found");
        }
        return totalCost;
    }

    public static double getTotalCost() {
        readFromFile("cost.txt");
        return totalCost;
    }

    public String getCostFileName() {
        return costFileName;
    }

    public void setCostFileName(String costFileName) {
        this.costFileName = costFileName;
    }

    @Override
    public boolean equals(Object obj){
        Book book = (Book) obj;
        return (
                this.ISBN.equals(book.getISBN())
                && this.title.equals(book.getTitle())
                && this.category.equals(book.getCategory())
                && this.supplier.equals(book.getSupplier())
                && this.purchasedPrice == book.getPurchasedPrice()
                && this.originalPrice == book.getOriginalPrice()
                && this.sellingPrice == book.getSellingPrice()
                && this.stock == book.getStock()
                && this.author.equals(book.getAuthor())
                );
    }
}
