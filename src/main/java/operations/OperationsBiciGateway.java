package operations;

import models.bici.Bici;
import models.bici.gateway.BiciGateway;

import java.util.ArrayList;
import java.util.List;


public class OperationsBiciGateway implements BiciGateway {

    List<Bici> biciList = new ArrayList<>();
    Bici bici1 = new Bici("BIC-01", "Mountain", "red", true);
    Bici bici2 = new Bici("BIC-02", "Road", "blue", true);
    Bici bici3 = new Bici("BIC-03", "Mountain", "green", true);
    Bici bici4 = new Bici("BIC-04", "Mountain", "yellow", true);
    Bici bici5 = new Bici("BIC-05", "Road", "purple", true);
    Bici bici6 = new Bici("BIC-06", "Road", "red", true);
    Bici bici7 = new Bici("BIC-07", "Mountain", "red", true);
    Bici bici8 = new Bici("BIC-08", "Road", "blue", true);
    Bici bici9 = new Bici("BIC-09", "Mountain", "blue", true);
    Bici bici10 = new Bici("BIC-10", "Road", "purple", true);
    Bici bici11 = new Bici("BIC-11", "Road", "yellow", true);
    Bici bici12 = new Bici("BIC-12", "Mountain", "blue", true);
    Bici bici13 = new Bici("BIC-13", "Mountain", "blue", true);
    Bici bici14 = new Bici("BIC-14", "Mountain", "red", true);
    Bici bici15 = new Bici("BIC-15", "Road", "yellow", true);
    Bici bici16 = new Bici("BIC-16", "Road", "yellow", true);
    Bici bici17 = new Bici("BIC-17", "Road", "red", true);
    Bici bici18 = new Bici("BIC-18", "Mountain", "blue", true);
    Bici bici19 = new Bici("BIC-19", "Road", "blue", true);
    Bici bici20 = new Bici("BIC-20", "Mountain", "purple", true);
    Bici bici21 = new Bici("BIC-21", "Road", "red", true);
    Bici bici22 = new Bici("BIC-22", "Mountain", "yellow", true);
    Bici bici23 = new Bici("BIC-23", "Mountain", "red", true);
    Bici bici24 = new Bici("BIC-24", "Road", "green", true);
    Bici bici25 = new Bici("BIC-25", "Road", "red", true);

    @Override
    public List<Bici> getBiciesList() {
        biciList.add(bici1);
        biciList.add(bici2);
        biciList.add(bici3);
        biciList.add(bici4);
        biciList.add(bici5);
        biciList.add(bici6);
        biciList.add(bici7);
        biciList.add(bici8);
        biciList.add(bici9);
        biciList.add(bici10);
        biciList.add(bici11);
        biciList.add(bici12);
        biciList.add(bici13);
        biciList.add(bici14);
        biciList.add(bici15);
        biciList.add(bici16);
        biciList.add(bici17);
        biciList.add(bici18);
        biciList.add(bici19);
        biciList.add(bici20);
        biciList.add(bici21);
        biciList.add(bici22);
        biciList.add(bici23);
        biciList.add(bici24);
        biciList.add(bici25);
        return biciList;
    }
}
