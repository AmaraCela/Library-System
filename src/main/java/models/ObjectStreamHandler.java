package models;

import models.Book;

import java.io.IOException;

public interface ObjectStreamHandler  {
    void writeObject(Book book) throws IOException;
    Book readObject() throws IOException, ClassNotFoundException;
    void close() throws IOException;
}
