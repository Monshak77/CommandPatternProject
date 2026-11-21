public class DrawShapeCommand implements Command {
    private CanvasReceiver canvas;
    private ShapeData shape;

    public DrawShapeCommand(
            CanvasReceiver canvas,
            ShapeData shape) {
        this.canvas = canvas;
        this.shape = shape.copy();
    }

    @Override
    public void execute() {
        canvas.draw(shape);
    }

    @Override
    public void undo() {
        canvas.delete(shape.id);
    }
}
