package models;

import Auxilaries.HeaderlessObjectOutputStream;

import java.io.*;
import java.util.ArrayList;

public class Category implements Serializable {

    @Serial
    private static final long serialVersionUID = 7618221196278240693L;
    private final File binaryFile;
    private String categoryName;
    private ArrayList<Book> booksOfCategory = new ArrayList<>();


    public Category(String categoryName) {


        this.categoryName = categoryName;
        binaryFile = new File("books"+categoryName+".dat");


    }

    public void updateCategory()
    {
        booksOfCategory.clear();
        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(binaryFile)))
        {
            int count = -1000000000;
            do {
                booksOfCategory.add((Book) inputStream.readObject());
                System.out.println("Category " + categoryName + "is updating");
                count++;

            } while (count <= 999999999);
        }
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
        writeToBinaryFile(book);
    }

    public int numOfBooks()
    {
        return booksOfCategory.size();
    }

    public ArrayList<Book> getBooksOfCategory() {
        return booksOfCategory;
    }

    public void writeToBinaryFile(Book book)
    {

        ObjectOutputStream outputStream;
        try(FileOutputStream output = new FileOutputStream(binaryFile,true);)
        {
            if(binaryFile.length()<=0)
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
            System.out.println("Not seralizable");
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

    public void updateBinaryFile()
    {
        ObjectOutputStream outputStream;
        try(FileOutputStream output = new FileOutputStream(binaryFile,false);)
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
            System.out.println("Not seralizable");
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


    public void setBooksOfCategory(ArrayList<Book> booksOfCategory) {
        this.booksOfCategory = booksOfCategory;
    }
}
