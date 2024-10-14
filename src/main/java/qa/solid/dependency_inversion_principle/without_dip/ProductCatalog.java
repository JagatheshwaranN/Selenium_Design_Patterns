package qa.solid.dependency_inversion_principle.without_dip;

@SuppressWarnings("All")
public class ProductCatalog {

    public void listAllProducts() {
        SQLProductRepository sqlProductRepository = new SQLProductRepository();
        sqlProductRepository.getAllProductNames();
        //List all products here
    }
}
