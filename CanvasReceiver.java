import java.util.LinkedHashMap;
import java.util.Map;

public class CanvasReceiver {
    private Map<String, ShapeData> shapes =
            new LinkedHashMap<>();

    public void draw(ShapeData shape) {
        shapes.put(shape.id, shape.copy());
    }

    public void move(String id, int x, int y) {
        ShapeData shape = shapes.get(id);

        if (shape != null) {
            shape.x = x;
            shape.y = y;
        }
    }

    public ShapeData delete(String id) {
        ShapeData shape = shapes.remove(id);

        return shape == null ? null : shape.copy();
    }

    public ShapeData getShape(String id) {
        ShapeData shape = shapes.get(id);

        return shape == null ? null : shape.copy();
    }

    public void restore(ShapeData shape) {
        if (shape != null) {
            shapes.put(shape.id, shape.copy());
        }
    }

    public void showState() {
        System.out.println("Canvas күйі:");

        if (shapes.isEmpty()) {
            System.out.println("Canvas бос");
        } else {
            for (ShapeData shape : shapes.values()) {
                System.out.println(
                        shape.id + ": " + shape
                );
            }
        }

        System.out.println("----------------------");
    }
}
