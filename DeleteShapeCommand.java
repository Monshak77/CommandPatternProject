public class DeleteShapeCommand implements Command {
    private CanvasReceiver canvas;
    private String id;
    private ShapeData deletedShape;

    public DeleteShapeCommand(
            CanvasReceiver canvas,
            String id) {
        this.canvas = canvas;
        this.id = id;
    }

    @Override
    public void execute() {
        deletedShape = canvas.delete(id);
    }

    @Override
    public void undo() {
        canvas.restore(deletedShape);
    }
}
