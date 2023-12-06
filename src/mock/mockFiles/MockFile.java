package mockFiles;

import models.Book;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class MockFile extends File {

    File file;
    ArrayList<Book>books = new ArrayList<>();
    public MockFile(String pathname) {
        super(pathname);
    }

    public void setFile(String pathname){
        file = new File(pathname);
    }
    public File getFile(){
        return file;
    }
    public ObjectInputStream createObjectInputStream() throws IOException{
        return new ObjectInputStream(new FileInputStream(file));
    }
}
