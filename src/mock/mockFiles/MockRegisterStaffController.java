package mockFiles;

import Controllers.RegisterStaffController;
import models.Person;

import java.io.File;
import java.util.ArrayList;

public class MockRegisterStaffController extends RegisterStaffController {

    ArrayList<Person> accounts = new ArrayList<>();
    public MockRegisterStaffController(File binaryFile, File textFile, int choice) {
        super(binaryFile, textFile, choice);
    }


}
