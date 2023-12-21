package mockFiles;

import models.Book;
import models.Category;

import java.util.ArrayList;

public class MockCategory extends Category {

    ArrayList<Book>bookList = new ArrayList<>();

    public MockCategory(String categoryName, String booksOfCategoryBinaryFile){
        super(categoryName, booksOfCategoryBinaryFile);
    }
    public MockCategory(String categoryName){
        super(categoryName);
    }

    @Override
    public void addBookToCategory(Book book){
        bookList.add(book);
    }


    @Override
    public ArrayList<Book> readBooks(){
        return bookList;
    }

    @Override
    public ArrayList<Book> getBooksOfCategory(){
        return bookList;
    }

    @Override
    public void updateBinaryFile(){

    }

    @Override
    public void updateBooksOfCategory(int index, Book book){

    }

    @Override
    public Book getBookOfCategory(String ISBN)
    {
        for (int i = 0;i<bookList.size();i++)
        {
            if(bookList.get(i).getISBN().equals(ISBN))
            {
                return bookList.get(i);
            }
        }
        return null;
    }

}
