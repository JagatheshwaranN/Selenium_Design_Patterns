package qa.solid.liskov_substitution_principle.lsp;

import java.util.ArrayList;

public class PriceUtil {

    public static void main(String[] args) {

        Product product1 = new Product();
        Product product2 = new Product();
        Product product3 = new InHouseProduct();

        ArrayList<Product> productArrayList = new ArrayList<>();
        productArrayList.add(product1);
        productArrayList.add(product2);
        productArrayList.add(product3);

        for (Product product : productArrayList) {
            System.out.println(product.getDiscount());
        }

    }
}
