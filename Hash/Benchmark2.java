package Hash;

public class Benchmark2 {
    public static void main(String[] args) {

        int[] sizes = { 4000, 10000, 11717, 11566, 12000, 12117, 20000 };

        // Integer zipToFind = 11115;
        // Integer zipToFind2 = 45176;
        // Integer zipToFind3 = 98499;

        for (int size : sizes) {

            // ImprovedHash improvedHash = new ImprovedHash(size, "Hash/postnummer.csv");

            // ImprovedHash.Node node;

            Zip2 zip = new Zip2("Hash/postnummer.csv");

            // node = improvedHash.lookUp(zipToFind);

            zip.collisions(size);
            System.out.println();
            /*
             * System.out.println("Zip code: " + zipToFind + ", Arraysize :" + size +
             * ", Number of checked elements: " +
             * improvedHash.nrOfElementsChecked);
             * System.out.println(improvedHash.lookUp(zipToFind));
             */

            /*
             * node = improvedHash.lookUp(zipToFind2);
             * System.out.println("Zip code: " + zipToFind2 + ", Arraysize :" + size +
             * ", Number of checked elements: " +
             * improvedHash.nrOfElementsChecked);
             * // System.out.println(improvedHash.lookUp(zipToFind2));
             * 
             * node = improvedHash.lookUp(zipToFind3);
             * System.out.println("Zip code: " + zipToFind3 + ", Arraysize :" + size +
             * ", Number of checked elements: " +
             * improvedHash.nrOfElementsChecked);
             * // System.out.println(improvedHash.lookUp(zipToFind3));
             * System.out.println();
             */
        }

    }
}
