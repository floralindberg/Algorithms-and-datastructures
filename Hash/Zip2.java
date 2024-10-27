package Hash;

import java.io.BufferedReader;
import java.io.FileReader;

public class Zip2 {

    Node[] data;
    int[] keys;
    int max = 9675;
    int max2 = 1000000;

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

    public boolean lookup(int zip) {

        if (data[zip] != null && zip == (data[zip].code)) {
            return true;
        } else {
            return false;
        }
    }

    public Zip2(String file) {

        this.data = new Node[this.max2];
        this.keys = new int[this.max];

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s", ""));
                data[code] = new Node(code, row[1], Integer.valueOf(row[2]));
                keys[i++] = code;
            }

        } catch (Exception e) {

            System.out.println(" file " + file + " not found");
        }

    }

    public boolean findNodeLinear(Integer zipCode) {
        for (int i = 0; i < this.max; i++)
            if (data[i].code.intValue() == zipCode) {
                return true;
            }

        return false;
    }

    public boolean findNode(Integer zipCode) {

        int first = 0;
        int last = data.length - 1;

        while (true) {
            // jump to the middle
            int index = (last + first) / 2;
            int zip = data[index].code.intValue();

            if (first > last) {
                return false;
            }

            if (zip == zipCode) {
                return true;
            }

            if (data[index].code < zipCode) {
                // what is the first possible page?
                first = index + 1;
            }

            if (data[index].code > zipCode) {
                // what is the last possible page?
                last = index - 1;
            }
        }
    }

    public void collisions(int mod) {

        int mx = 20;

        int[] data = new int[mod];
        int[] cols = new int[mx];

        // keys[] are the zip codes
        for (int i = 0; i < max; i++) {
            Integer index = keys[i] % mod;
            data[index]++;
        }
        for (int i = 0; i < mod; i++) {
            if (data[i] < mx)
                cols[data[i]]++;
        }
        System.out.print(mod + ": ");
        for (int i = 1; i < mx; i++) {

            System.out.print("\t" + cols[i]);
        }
        System.out.println();
    }

}
