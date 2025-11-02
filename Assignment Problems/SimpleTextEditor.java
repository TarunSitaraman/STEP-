
import java.util.Stack;

public class SimpleTextEditor {

    private StringBuilder currentText;
    private Stack<String> history;

    public SimpleTextEditor() {
        currentText = new StringBuilder();
        history = new Stack<>();
    }

    // Append text and save state to history stack
    public void append(String text) {
        history.push(currentText.toString()); // Save current state before change
        currentText.append(text);
        System.out.println("After append: " + currentText);
    }

    // Undo last action by restoring previous state
    public void undo() {
        if (!history.isEmpty()) {
            currentText = new StringBuilder(history.pop());
            System.out.println("After undo: " + currentText);
        } else {
            System.out.println("Nothing to undo.");
        }
    }

    // Display current state
    public void display() {
        System.out.println("Current text: " + currentText);
    }

    public static void main(String[] args) {
        SimpleTextEditor editor = new SimpleTextEditor();

        editor.append("Hello");
        editor.append(" World");
        editor.display();

        editor.undo();  // Undo last append (" World")
        editor.display();

        editor.undo();  // Undo "Hello"
        editor.display();

        editor.undo();  // Nothing to undo
    }
}
