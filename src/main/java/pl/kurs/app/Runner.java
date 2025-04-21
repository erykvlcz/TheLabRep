package pl.kurs.app;

import pl.kurs.service.Laboratory;

public class Runner {
    public static void main(String[] args) {
        Laboratory lab = new Laboratory("TheLab");
        lab.makeSubstance("Etanol");
        lab.makeSubstance("kwassiarkowy");
    }
}
