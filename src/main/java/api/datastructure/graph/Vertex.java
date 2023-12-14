package api.datastructure.graph;

import java.util.Objects;

public class Vertex {

    private Integer id;
    private String label;
    private boolean hasQueen;
    private Character color;

    public Vertex(Integer id, String label) {
        this.id = id;
        this.label = label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return Objects.equals(id, vertex.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean hasQueen() {
        return hasQueen;
    }

    public void setHasQueen(boolean hasQueen) {
        this.hasQueen = hasQueen;
    }

    public Character getColor() {
        return color;
    }

    public void setColor(Character color) {
        this.color = color;
    }
}
