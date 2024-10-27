package Hash;

import java.io.BufferedReader;
import java.io.FileReader;

public class Zip {

    Area[] postnr;
    int max = 9675;

    public class Area {
        private String zipCode;
        private String area;
        private Integer population;

        public Area(String zipCode, String area, Integer population) {
            this.zipCode = zipCode;
            this.area = area;
            this.population = population;
        }

        public String getZipCode() {
            return zipCode;
        }

        public String getArea() {
            return area;
        }

        public Integer getPopulation() {
            return population;
        }

    }

    public Zip(String file) {

        this.postnr = new Area[this.max];

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null && i < this.max) {
                String[] row = line.split(",");
                postnr[i++] = new Area(row[0], row[1], Integer.valueOf(row[2]));
            }

            this.max = i;

        } catch (Exception e) {

            System.out.println(" file " + file + " not found");
        }
    }

    public boolean findAreaLinear(String zipCode) {
        for (int i = 0; i < this.max; i++)
            if (postnr[i].zipCode.equals(zipCode)) {
                return true;
            }

        return false;
    }

    public boolean findAreaBinary(String zipCode) {

        int first = 0;
        int last = postnr.length - 1;

        while (true) {
            // jump to the middle
            int index = (last + first) / 2;
            int compare = postnr[index].getZipCode().compareTo(zipCode);

            if (first > last) {
                return false;
            }

            if (compare == 0) {
                return true;
            }

            if (compare < 0) {
                // what is the first possible page?
                first = index + 1;
            }

            if (compare > 0) {
                // what is the last possible page?
                last = index - 1;
            }
        }

    }

}
