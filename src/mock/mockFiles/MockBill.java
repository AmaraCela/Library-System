package mockFiles;

import models.Bill;

public class MockBill extends Bill {

    double total;
    public MockBill( double total) {
        super(null, null,"TestFiles//bill.txt" , "TestFiles//revenues.txt");
        this.total = total;
    }

    @Override
    public double CalculateTotal()
    {
        return this.total;
    }
}
