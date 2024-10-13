package qa.solid.interface_segregation_principle.without_isp;

@SuppressWarnings("All")
public class HPPrinterScanner implements  IMultiFunction {

    @Override
    public void print() {
        // Print code starts here
        //
        // Print code ends here
    }

    @Override
    public void getPrintSpoolDetails() {
        // PrintSpoolDetails code starts here
        //
        // PrintSpoolDetails code ends here
    }

    @Override
    public void scan() {
        // Scan code starts here
        //
        // Scan code ends here
    }

    @Override
    public void scanPhoto() {
        // ScanPhoto code starts here
        //
        // ScanPhoto code ends here
    }

    @Override
    public void fax() {

    }

    @Override
    public void internetFax() {

    }

}
