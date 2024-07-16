package qa.design.factory.google;

public abstract class GooglePage {

    public abstract void launch();

    public abstract void search(String keyword);

    public abstract int getResultCount();

}
