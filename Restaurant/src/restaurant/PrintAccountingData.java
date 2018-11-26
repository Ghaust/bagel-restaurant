package restaurant;

public class PrintAccountingData implements Operation{
    @Override
    public void launchOp() {

    }

    @Override
    public String name() {
        return "PrintAccountingData";
    }

    @Override
    public String instruction() {
        return "Afficher les données comptables - accounting";
    }

}
