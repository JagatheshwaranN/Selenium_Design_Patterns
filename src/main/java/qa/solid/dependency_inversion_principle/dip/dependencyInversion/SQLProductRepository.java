package qa.solid.dependency_inversion_principle.dip.dependencyInversion;

import java.util.Arrays;
import java.util.List;

@SuppressWarnings("All")
public class SQLProductRepository  implements ProductRepository {

    public List<String> getAllProductNames() {
        return Arrays.asList("Shampoo", "Toothpaste");
    }

}
