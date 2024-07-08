package qa.design.template;

public abstract class ShoppingTemplate {

    public abstract void launch();

    public abstract void searchProduct();

    public abstract void selectProduct();

    public abstract void checkout();

    public void purchase(){
        launch();
        searchProduct();
        selectProduct();
        checkout();
    }

}
