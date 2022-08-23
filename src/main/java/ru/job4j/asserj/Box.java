package ru.job4j.asserj;

public class Box {
    private static final String UNKNOWN = "Unknown Object";
    private int vertex;
    private int edge;
    private String type = "";

    public Box(int vertex, int edge) {
        this.vertex = vertex;
        this.edge = edge;
        init();
    }

    private void init() {
        type =  switch (vertex) {
            case 0 -> "Sphere";
            case 4 -> "Tetrahedron";
            case 8 -> "Cube";
            default -> UNKNOWN;
        };
        if (UNKNOWN.equals(type)) {
            vertex = -1;
        }
        if (edge <= 0) {
            vertex = -1;
            type = UNKNOWN;
        }
    }

    public String whatsThis() {
        return this.type;
    }

    public int getNumberOfVertices() {
        return this.vertex;
    }

    public boolean isExist() {
        return this.vertex != -1;
    }

    public double getArea() {
         return switch (vertex) {
            case 0 -> 4 * Math.PI * (edge * edge);
            case 4 -> Math.sqrt(3) * (edge * edge);
            case 8 -> 6 * (edge * edge);
            default -> 0;
        };
    }
}