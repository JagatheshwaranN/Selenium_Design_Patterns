package qa.solid.liskov_substitution_principle.without_lsp;

public class InHouseProduct extends Product {

    public void applyExtraDiscount() {
        discount = discount * 1.5;
    }
}
