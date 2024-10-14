package qa.solid.dependency_inversion_principle.dip.dependencyInjection;

import java.util.List;

@SuppressWarnings("All")
public interface ProductRepository {

    List<String> getAllProductNames();
}
