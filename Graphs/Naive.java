package Graphs;

public class Naive {

    public static void main(String[] args) {
        Map map = new Map("Graphs/trains.csv");
        String from = args[0];
        String to = args[1];
        Integer max = 300; // Integer.valueOf(args[2]);
        long t0 = System.nanoTime();
        Integer dist = shortest(map.lookup(from), map.lookup(to), max);
        long time = (System.nanoTime() - t0) / 1_000_000;
        System.out.println("shortest: " + dist + " min (" + time + " ms)");
    }

    private static Integer shortest(City from, City to, Integer max) {
        if (max < 0) {
            return null;
        }
        if (from == to) {
            return 0;
        }

        Integer shrt = null;

        for (int i = 0; i < from.connections.length; i++) {
            if (from.connections[i] != null) {
                Connection conn = from.connections[i];
                Integer temp = shortest(conn.city, to, max - conn.distance);

                if (temp != null && (shrt == null || shrt > temp + conn.distance)) {
                    shrt = temp + conn.distance;
                }
            }
        }
        return shrt;
    }

}
