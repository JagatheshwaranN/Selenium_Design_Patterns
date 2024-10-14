package qa.solid.dependency_inversion_principle.dip.dependencyInversion;

public class ProductFactory {

    public static ProductRepository create() {
        return new SQLProductRepository();
    }
}
