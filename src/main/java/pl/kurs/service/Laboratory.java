package pl.kurs.service;

import pl.kurs.models.Substance;

import java.util.ArrayList;
import java.util.List;

public class Laboratory {
    private String name;
    private List<Substance> substancesList = new ArrayList<>();

    public Laboratory(String name) {
        this.name = name;
    }

    public void makeSubstance(String name){
        substancesList.add(Substance.create(name));

    }

    @Override
    public String toString() {
        return "Laboratory{" +
                "name='" + name + '\'' +
                ", substancesList=" + substancesList +
                '}';
    }
}
