package mockFiles;

import models.Book;
import models.ObjectStreamHandler;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MockObjectStreamHandler extends ObjectOutputStream implements ObjectStreamHandler {
     List<Book> books = new ArrayList<>();
     int currentIndex = 0;

    public MockObjectStreamHandler() throws IOException, SecurityException {
    }

    public void writeObject(Book book) throws IOException {
        books.add(book);
    }

    public Book readObject() throws IOException, ClassNotFoundException{
        if(currentIndex >= books.size()){
            throw new IOException("Out of range index");
        }
        return books.get(currentIndex++);
    }

    public List<Book> getBooks(){
        return books;
    }

    public void close(){

    }
}
