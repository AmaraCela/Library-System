package mock;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class MockPrintWriterTry extends PrintWriter {
    ArrayList<String> written = new ArrayList<>();
    public MockPrintWriterTry(File file) throws FileNotFoundException {
        super(file);
    }

    @Override
    public void println(String string)
    {
        System.out.println(string);
        written.add(string);
    }
}
