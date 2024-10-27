package Graphs;

import java.io.BufferedReader;
import java.io.FileReader;

public class Map {

    private City[] cities;
    private final int mod = 10000;

    private static Integer hash(String name, int mod) {
        int hash = 0;
        for (int i = 0; i < name.length(); i++) {
            hash = (hash * 31 + name.charAt(i)) % mod;
        }
        return hash;
    }

    public City lookup(String name) {
        int i = hash(name, mod);

        while (cities[i] != null) {
            if (cities[i].name.equals(name)) {
                return cities[i];
            } else {
                i++;
            }
        }

        City newCity = new City(name);
        cities[i] = newCity;
        return newCity;
    }

    public Map(String file) {

        cities = new City[mod];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                City one = lookup(row[0]);
                City two = lookup(row[1]);
                Integer dist = (Integer.valueOf(row[2]));
                one.connect(two, dist);
                two.connect(one, dist);
            }
        } catch (Exception e) {
            System.out.println(" file " + file + " not found or corrupt");
        }
    }

}
