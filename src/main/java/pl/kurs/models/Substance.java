package pl.kurs.models;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Substance {
    private String name;
    private Map<Ingredient, Integer> integersrMap = new HashMap<>();

    private Substance(String name) {
        this.name = name;
    }

    public static Substance create(String name){
        Substance substance = new Substance(name);
        substance.addIngredientToMap(name);
        return substance;
    }

    private void addIngredientToMap(String name){
        try (Scanner scanner = new Scanner(new File("substance_composition.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ", 2);
                if (parts.length == 2 && parts[0].equalsIgnoreCase(name)) {
                    String ingredientsPart = parts[1];
                    String[] separatedWords = ingredientsPart.split(",");
                    for (int i = 0; i < separatedWords.length; i++) {
                        String ingredientName = separatedWords[i].trim();
                        int quantity = Integer.parseInt(separatedWords[++i].trim());
                        integersrMap.put(new Ingredient(ingredientName), quantity);
                    }
                    return;
                }
            }
            throw new IllegalArgumentException("Nie znaleziono substancji: " + name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public String toString() {
        return "Substance{" +
                "name='" + name + '\'' +
                ", integersrMap=" + integersrMap +
                '}';
    }

    public static class Ingredient{
        private String name;

        public Ingredient(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Ingredient{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}