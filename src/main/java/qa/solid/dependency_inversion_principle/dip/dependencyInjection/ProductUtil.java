package qa.solid.dependency_inversion_principle.dip.dependencyInjection;

public class ProductUtil {

    public static void main(String[] args) {

        ProductRepository productRepository = ProductFactory.create();

        ProductCatalog productCatalog = new ProductCatalog(productRepository);
        productCatalog.listAllProducts();
    }
}
