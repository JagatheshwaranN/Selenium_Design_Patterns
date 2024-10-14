package qa.solid.dependency_inversion_principle.without_dip;

import java.util.Arrays;
import java.util.List;

@SuppressWarnings("All")
public class SQLProductRepository {

    public List<String> getAllProductNames() {
        return Arrays.asList("Shampoo", "Toothpaste");
    }

}
