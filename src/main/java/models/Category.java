package models;

import Auxilaries.HeaderlessObjectOutputStream;

import java.io.*;
import java.util.ArrayList;
import java.io.Serializable;

public class Category implements Serializable {

    @Serial
    private static final long serialVersionUID = 7618221196278240693L;
    private final File booksOfCategoryBinaryFile;
    private String categoryName;
    private final ArrayList<Book> booksOfCategory = new ArrayList<>();


    public Category(String categoryName, String booksOfCategoryBinaryFileName) {
        this.categoryName = categoryName;
        this.booksOfCategoryBinaryFile = new File(booksOfCategoryBinaryFileName);
    }
    public Category(String categoryName){
        this.categoryName = categoryName;
        this.booksOfCategoryBinaryFile = new File(this.categoryName+"Books.data");
    }

    //reads the books of the category

    //mock checkoutController
    public ArrayList<Book> readBooks() {
        booksOfCategory.clear();
        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(booksOfCategoryBinaryFile)) )
        {
            int count = -1000000000;
            do {
//            while(true){
                Book book = (Book)inputStream.readObject();
//                booksOfCategory.add((Book) inputStream.readObject());
                booksOfCategory.add(book);
                count++;

            } while (count <= 999999999);
//        }
        }
        catch (EOFException e)
        {
            System.out.println("End of file exception in reading categories");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Class not found in reading categories");
        }
        catch (IOException e)
        {
            System.out.println("IOException in reading categories");
        }
        return this.booksOfCategory;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }



    //mock suuplyBooksController
    public void addBookToCategory(Book book)
    {
        booksOfCategory.add(book);
        writeBookToBinaryFile(book);
    }

    public int numOfBooks()
    {
        return booksOfCategory.size();
    }

    //mock
    public ArrayList<Book> getBooksOfCategory() {
        return booksOfCategory;
    }


    //adds the new added book to the category books binary file
    public void writeBookToBinaryFile(Book book)
    {
        ObjectOutputStream outputStream;
        try(FileOutputStream output = new FileOutputStream(booksOfCategoryBinaryFile,true);)
        {
            if(booksOfCategoryBinaryFile.length()<=0)
            {
                outputStream = new ObjectOutputStream(output);
            }
            else
            {
                outputStream = new HeaderlessObjectOutputStream(output);
            }

            outputStream.writeObject(book);
            outputStream.close();
        }
        catch (IOException e) {
            System.out.println("IOException in writing books");
        }
    }



    //updates the books of this category binary file

    //mock
    public void updateBinaryFile()
    {
        ObjectOutputStream outputStream;
        try(FileOutputStream output = new FileOutputStream(booksOfCategoryBinaryFile,false);)
        {

            outputStream = new ObjectOutputStream(output);

            for (int i=0 ;i< booksOfCategory.size();i++)
            {
                outputStream.writeObject(booksOfCategory.get(i));
            }


            outputStream.close();
        }
        catch (IOException e)
        {
            System.out.println("IOException in writing books");

        }

    }

    public Book getBookOfCategory(String ISBN)
    {
        for (int i = 0;i<booksOfCategory.size();i++)
        {
            if(booksOfCategory.get(i).getISBN().equals(ISBN))
            {
                return booksOfCategory.get(i);
            }
        }
        return null;
    }


    @Override
    public boolean equals(Object obj){
        if(obj instanceof Category){
            return this.categoryName.equals((((Category)obj).getCategoryName()));
        }
        return false;
    }

    public File getBooksOfCategoryBinaryFile() {
        return booksOfCategoryBinaryFile;
    }
    public void updateBooksOfCategory(int index, Book book){
        for(int i=0; i<booksOfCategory.size(); i++){
            if(index == i){
                booksOfCategory.set(i,book);
            }
        }
    }

}
