package qa.solid.dependency_inversion_principle.dip.dependencyInjection;

import java.util.List;

@SuppressWarnings("All")
public class ProductCatalog {

    ProductRepository productRepository;

    public ProductCatalog(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void listAllProducts() {
        productRepository = ProductFactory.create();
        List<String> allProducts = productRepository.getAllProductNames();
        System.out.println(allProducts);
    }

}
