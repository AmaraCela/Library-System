package mockFiles;

import models.Book;
import models.Category;

import java.util.ArrayList;

public class MockCategory extends Category {

    ArrayList<Book>books = new ArrayList<>();
    public MockCategory(String categoryName, String booksOfCategoryBinaryFileName) {
        super(categoryName, booksOfCategoryBinaryFileName);
    }

    @Override
    public void addBookToCategory(Book book){
        books.add(book);
    }

    @Override
    public ArrayList<Book> readBooks(){
        return books;
    }

    @Override
    public ArrayList<Book> getBooksOfCategory(){
        return books;
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
        for (int i = 0;i<books.size();i++)
        {
            if(books.get(i).getISBN().equals(ISBN))
            {
                return books.get(i);
            }
        }
        return null;
    }

}
