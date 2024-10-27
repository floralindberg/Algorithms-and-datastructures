package Hash;

import java.io.BufferedReader;
import java.io.FileReader;

public class ImprovedHash {

    Node[] data;
    int max;
    int nrOfElementsChecked;

    public class Node {

        private Integer code;
        private String name;
        private Integer population;

        public Node(Integer zipCode, String area, Integer population) {
            this.code = zipCode;
            this.name = area;
            this.population = population;
        }

        public Integer getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

        public Integer getPopulation() {
            return population;
        }

    }

    private void addNode(Node node) {

        int index = node.getCode() % max;
        int orgIndex = index;

        if (data[index] == null) {
            data[index] = node;
            return;
        }

        while (data[index] != null) {
            index = (index + 1) % max;
            if (index == orgIndex) {

                throw new RuntimeException("HashTable is full!");
            }
        }

        data[index] = node;
    }

    public ImprovedHash(int max, String file) {

        this.max = max;

        this.data = new Node[max];

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s", ""));
                Node node = new Node(code, row[1], Integer.valueOf(row[2]));
                addNode(node);
            }

        } catch (Exception e) {

            System.out.println(" file " + file + " not found");
        }

    }

    public Node lookUp(int code) {

        int index = code % this.max;
        int orgIndex = index;
        nrOfElementsChecked = 0;

        if (data[index] != null && data[index].getCode().equals(code)) {
            return data[index];
        }

        while (data[index] != null) {

            if (data[index].getCode().equals(code)) {

                return data[index];

            } else {
                index = (index + 1) % max;

            }

            if (index == orgIndex) {
                return null;
            }

            nrOfElementsChecked++; // mätning av antalet gånger den måste flytta fram ett index

        }

        // System.out.println(nrOfElements);
        return null;
    }
}