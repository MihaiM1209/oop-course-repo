package oop.practice.lab0;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.printf("Hello and welcome!\n");

        ObjectMapper mapper = new ObjectMapper();
        File inputFile = new File("src/main/resources/input.json");
        JsonNode data = mapper.readTree(inputFile).get("data");

        Universe starWars = new Universe("Star Wars");
        Universe hitchhikers = new Universe("Hitchhiker's Guide to the Galaxy");
        Universe marvel = new Universe("Marvel");
        Universe rings = new Universe("Rings");

        for (JsonNode entry : data) {
            int id = entry.get("id").asInt();
            boolean isHumanoid = entry.has("isHumanoid") && entry.get("isHumanoid").asBoolean();
            String planet = entry.has("planet") ? entry.get("planet").asText() : "Unknown Planet";
            List<String> traits = new ArrayList<>();
            if (entry.has("traits")) {
                for (JsonNode trait : entry.get("traits")) {
                    traits.add(trait.asText());
                }
            }

            // Classify based on conditions
            boolean classified = false;

            if (isHumanoid) {
                if (planet.equalsIgnoreCase("Earth")) {
                    marvel.addIndividual(entry.toString());
                    System.out.println("Added humanoid from Earth to Marvel: " + entry);
                    classified = true;
                } else if (planet.equalsIgnoreCase("Asgard")) {
                    rings.addIndividual(entry.toString());
                    System.out.println("Added humanoid from Asgard to Rings: " + entry);
                    classified = true;
                } else {
                    hitchhikers.addIndividual(entry.toString());
                    System.out.println("Added humanoid to Hitchhiker's Universe: " + entry);
                    classified = true;
                }
            } else {
                if (traits.contains("HAIRY") || traits.contains("TALL")) {
                    starWars.addIndividual(entry.toString());
                    System.out.println("Added non-humanoid (HAIRY/TALL) to Star Wars: " + entry);
                    classified = true;
                } else {
                    hitchhikers.addIndividual(entry.toString());
                    System.out.println("Added non-humanoid to Hitchhiker's Universe: " + entry);
                    classified = true;
                }
            }

            // If entry was not classified, you can log it
            if (!classified) {
                System.out.println("Entry cannot be classified: " + entry);
            }
        }

        // Write output files
        mapper.writeValue(new File("src/main/resources/output/starwars.json"), starWars);
        mapper.writeValue(new File("src/main/resources/output/hitchhikers.json"), hitchhikers);
        mapper.writeValue(new File("src/main/resources/output/marvel.json"), marvel);
        mapper.writeValue(new File("src/main/resources/output/rings.json"), rings);

        // Summary of classifications
        System.out.println("\nClassification Summary:");
        System.out.println("Star Wars Universe: " + starWars.getIndividuals().size() + " aliens");
        System.out.println("Hitchhiker's Universe: " + hitchhikers.getIndividuals().size() + " aliens");
        System.out.println("Marvel Universe: " + marvel.getIndividuals().size() + " aliens");
        System.out.println("Rings Universe: " + rings.getIndividuals().size() + " aliens");
    }
}

class Universe {
    private final String name;
    private final List<String> individuals;

    public Universe(String name) {
        this.name = name;
        this.individuals = new ArrayList<>();
    }

    public void addIndividual(String individual) {
        individuals.add(individual);
    }

    public List<String> getIndividuals() {
        return individuals;
    }

    public String getName() {
        return name;
    }
}
