package restaurant;

public class Quit implements Operation {


    @Override
    public void launchOp() {
        System.exit(0);
    }

    @Override
    public String name() {
        return "Quit";
    }

    @Override
    public String instruction() {
        return "Quitter le programme - quit";
    }
}
