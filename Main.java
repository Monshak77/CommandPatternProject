import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        CanvasReceiver canvas = new CanvasReceiver();
        CommandInvoker invoker = new CommandInvoker();

        System.out.println("1. DrawShape");
        invoker.executeCommand(
                new DrawShapeCommand(
                        canvas,
                        new ShapeData("1", "Circle", 10, 20)
                )
        );
        canvas.showState();

        System.out.println("2. DrawShape");
        invoker.executeCommand(
                new DrawShapeCommand(
                        canvas,
                        new ShapeData("2", "Rectangle", 30, 40)
                )
        );
        canvas.showState();

        System.out.println("3. MoveShape");
        invoker.executeCommand(
                new MoveShapeCommand(canvas, "1", 50, 60)
        );
        canvas.showState();

        System.out.println("4. UNDO");
        invoker.undo();
        canvas.showState();

        System.out.println("5. UNDO");
        invoker.undo();
        canvas.showState();

        System.out.println("6. REDO");
        invoker.redo();
        canvas.showState();

        System.out.println("7. DeleteShape");
        invoker.executeCommand(
                new DeleteShapeCommand(canvas, "2")
        );
        canvas.showState();

        System.out.println("8. MacroCommand");

        MacroCommand macro = new MacroCommand(
                Arrays.asList(
                        new DrawShapeCommand(
                                canvas,
                                new ShapeData("3", "Triangle", 70, 80)
                        ),
                        new MoveShapeCommand(canvas, "1", 100, 120)
                )
        );

        invoker.executeCommand(macro);
        canvas.showState();

        System.out.println("9. Macro UNDO");
        invoker.undo();
        canvas.showState();
    }
}