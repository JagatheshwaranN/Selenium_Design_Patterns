package qa.solid.dependency_inversion_principle.dip.dependencyInversion;

@SuppressWarnings("All")
public class ProductCatalog {

    public void listAllProducts() {
        ProductRepository productRepository = ProductFactory.create();
        productRepository.getAllProductNames();
        //List all products here
    }

}
