package Graphs;

public class City {

    String name;
    Connection[] connections;

    public City(String name) {
        this.name = name;
        this.connections = null;
    }

    public void connect(City next, int distance) {

        if (connections == null) {
            connections = new Connection[1];
            connections[0] = new Connection(next, distance);
        } else {
            Connection[] newConnections = new Connection[connections.length + 1]; // ANVÄNDA LinkedList IST??
            for (int i = 0; i < connections.length; i++) {
                newConnections[i] = connections[i];
            }
            newConnections[connections.length] = new Connection(next, distance);
            connections = newConnections;
        }
    }
}
