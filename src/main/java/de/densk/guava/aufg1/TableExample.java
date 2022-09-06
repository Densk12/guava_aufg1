package de.densk.guava.aufg1;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class TableExample {
    public static void run() {
        Table<Vertex, Vertex, Integer> weightedGraph = HashBasedTable.create();

        final Vertex v1 = new Vertex(1.0, 2.0, 3.0);
        final Vertex v2 = new Vertex(3.0, 5.0, 10.2);
        final Vertex v3 = new Vertex(2.0, 5.0, 10.2);

        weightedGraph.put(v1, v2, 4);
        weightedGraph.put(v1, v3, 20);
        weightedGraph.put(v2, v3, 5);

        System.out.println("Table Example:");
        System.out.println(weightedGraph.row(v1));
        System.out.println(weightedGraph.column(v3));
        System.out.println();
    }
}
