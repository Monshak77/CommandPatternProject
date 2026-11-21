public class ShapeData {
    String id;
    String type;
    int x;
    int y;

    public ShapeData(String id, String type, int x, int y) {
        this.id = id;
        this.type = type;
        this.x = x;
        this.y = y;
    }

    public ShapeData copy() {
        return new ShapeData(id, type, x, y);
    }

    @Override
    public String toString() {
        return type + " (" + x + ", " + y + ")";
    }
}