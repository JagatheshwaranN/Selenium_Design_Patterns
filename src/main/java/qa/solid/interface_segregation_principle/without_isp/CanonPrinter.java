package qa.solid.interface_segregation_principle.without_isp;

@SuppressWarnings("All")
public class CanonPrinter implements IMultiFunction {

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

    }

    @Override
    public void scanPhoto() {

    }

    @Override
    public void fax() {

    }

    @Override
    public void internetFax() {

    }

}
