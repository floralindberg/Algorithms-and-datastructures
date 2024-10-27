package Hash;

public class Main {
    public static void main(String[] args) {
        Zip zip = new Zip("Hash/postnummer.csv");
        Zip2 zip2 = new Zip2("Hash/postnummer.csv");
        // HashTable hashTable = new HashTable("Hash/postnummer.csv");
        ImprovedHash improvedHashTable = new ImprovedHash(11000, "Hash/postnummer.csv");

        // String zipToFind = "111 15";
        int zipToFind = 11115;

        System.out.println("Result for Zip Code: " + zipToFind);

        // System.out.println(zip.findAreaLinear(zipToFind));
        // System.out.println(zip.findAreaBinary(zipToFind));

        String zipToFind2 = "984 99";

        System.out.println(zip.findAreaLinear(zipToFind2));
        System.out.println(zip.findAreaBinary(zipToFind2));
        // zip2.collisions(10000);
        // zip2.collisions(20000);
        // zip2.collisions(12345);
        // zip2.collisions(17389);
        // zip2.collisions(13513);
        // zip2.collisions(13600);
        // zip2.collisions(14000);
        // zip2.collisions(11357); // bra resultat
        // zip2.collisions(10007);

        ImprovedHash.Node node = improvedHashTable.lookUp(zipToFind);

        if (node != null) {
            System.out.println("Found: " + node.getCode() + ", " + node.getName() + "," + node.getPopulation());
        } else {
            System.out.println("Zip code " + zipToFind + " not found.");
        }

    }
}
