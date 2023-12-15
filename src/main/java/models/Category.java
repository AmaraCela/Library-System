package models;

import Auxilaries.HeaderlessObjectOutputStream;

import java.io.*;
import java.util.ArrayList;
import java.io.Serializable;

public class Category implements Serializable {

    @Serial
    private static final long serialVersionUID = 7618221196278240693L;
    private File booksOfCategoryBinaryFile;
    private String categoryName;
    private ArrayList<Book> booksOfCategory = new ArrayList<>();


    public Category(String categoryName, String booksOfCategoryBinaryFileName) {
       this.categoryName = categoryName;
       this.booksOfCategoryBinaryFile = new File(booksOfCategoryBinaryFileName);
    }
    public Category(String categoryName){
        this.categoryName = categoryName;
        this.booksOfCategoryBinaryFile = new File(this.categoryName+"Books.data");
    }

//    public Category(String categoryName){
//        this.categoryName = categoryName;
//    }

    //reads the books of the category
    public ArrayList<Book> readBooks() {
        booksOfCategory.clear();
        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(booksOfCategoryBinaryFile)) )
        {
            while(true){
                Book book = (Book)inputStream.readObject();
                booksOfCategory.add(book);
                System.out.println();
        }}
        catch (EOFException e)
        {
            System.out.println("End of file exception in reading categories");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Class not found in reading categories");
        }

        catch (FileNotFoundException e)
        {
            System.out.println("File not found in reading categories");

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

    public void addBookToCategory(Book book)
    {
        booksOfCategory.add(book);
        writeBookToBinaryFile(book);
    }

    public int numOfBooks()
    {
        return booksOfCategory.size();
    }

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
        catch (NotSerializableException e)
        {
            System.out.println("Book not serializable");
        }
        catch (IOException e) {
            System.out.println("IOException in writing books");
        }
    }



    //updates the books of this category binary file
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
        catch (NotSerializableException e)
        {
            System.out.println("Not serializable");
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found in writing books");
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


//    public void setBooksOfCategory(ArrayList<Book> booksOfCategory) {
//        this.booksOfCategory = booksOfCategory;
//    }

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
    public ArrayList<Book> updateBooksOfCategory(int index, Book book){
        for(int i=0; i<booksOfCategory.size(); i++){
            if(index == i){
                booksOfCategory.set(i,book);
            }
        }
        return booksOfCategory;
    }

}
