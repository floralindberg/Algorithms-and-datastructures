package Hash;

import java.io.BufferedReader;
import java.io.FileReader;

public class HashTable {

    Node[][] data;
    int max = 11357;

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
        if (data[index] == null) {
            data[index] = new Node[1];
            data[index][0] = node;
        } else {
            Node[] bucket = data[index]; // detta görs för att skapa en referens till den bucket som finns och se vilka
                                         // andra det finns här redan för att kopiera över
            Node[] biggerBucket = new Node[bucket.length + 1];

            for (int i = 0; i < bucket.length; i++) {
                biggerBucket[i] = bucket[i];
            }

            biggerBucket[bucket.length] = node;

            data[index] = biggerBucket;
        }

    }

    public HashTable(int size, String file) {

        this.data = new Node[this.max][];

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s", ""));
                Node node = new Node(code, row[1], Integer.valueOf(row[2]));
                addNode(node);
            }

            // this.max = i;

        } catch (Exception e) {

            System.out.println(" file " + file + " not found");

        }

        for (int i = 0; i < 20; i++) {
            if (data[i] != null) {
                System.out.print(i + ": ");
                for (Node node : data[i]) {
                    System.out.print(node.getCode() + " ");
                }
                System.out.println();
            } else {
                System.out.println(i + ": null");
            }
        }

    }

    public Node lookUp(int code) {

        int index = code % max;

        if (data[index] != null) {
            for (Node node : data[index]) {
                if (node.getCode() == code) {
                    return node;
                }
            }
        }

        return null;
    }

}
