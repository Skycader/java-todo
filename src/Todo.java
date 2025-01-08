import java.util.ArrayList;

public class Todo {
    private final ArrayList<String> todos = new ArrayList<String>();

    public void addTodo(String title) {
        this.todos.add(title);
    }

    public void editTodo(int index, String title) {
        this.todos.set(index,title);
    }

    public void removeTodo(int index) {
        this.todos.remove(index);
    }

    public void printTodos() {
         for (int i = 0; i < todos.size(); i++) {
             System.out.println(i + ": " + todos.get(i));
         }

         if (todos.isEmpty()) System.out.println("No todos yet");
    }
}
