package qa.solid.dependency_inversion_principle.dip.dependencyInversion;

import java.util.List;

@SuppressWarnings("All")
public interface ProductRepository {

    List<String> getAllProductNames();
}
