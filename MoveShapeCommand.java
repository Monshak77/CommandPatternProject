public class MoveShapeCommand implements Command {
    private CanvasReceiver canvas;
    private String id;
    private int newX;
    private int newY;

    private int oldX;
    private int oldY;

    public MoveShapeCommand(
            CanvasReceiver canvas,
            String id,
            int newX,
            int newY) {
        this.canvas = canvas;
        this.id = id;
        this.newX = newX;
        this.newY = newY;
    }

    @Override
    public void execute() {
        ShapeData shape = canvas.getShape(id);

        if (shape != null) {
            oldX = shape.x;
            oldY = shape.y;

            canvas.move(id, newX, newY);
        }
    }

    @Override
    public void undo() {
        canvas.move(id, oldX, oldY);
    }
}
