import java.io.IOException;
import java.util.Scanner;

public class Main  {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Todo todo = new Todo();

        boolean run = true;
        while(run) {
            System.out.println(":: Todo App v0.0.1 by Skycader");
            System.out.println(":: Type help for actions");
            System.out.println(":: My Todos");
            todo.printTodos();
            System.out.println(":: > ");

            String line = scanner.nextLine();
            String command = line.split("\\s")[0];
            String data = line.contains(" ") ? line.substring(line.indexOf(" ") + 1) : "";
            switch(command) {
                case "help":
                    System.out.println(":: Commands");
                    System.out.println(":: add something to do - adds a new todo");
                    System.out.println(":: edit <id> - edit existing todo");
                    System.out.println(":: rem <id> - removes existing todo");
                    System.out.println(":: exit - quit the app");
                    System.out.println(":: Press <Enter> to continue");
                    scanner.nextLine();
                    break;
                case "add":
                    System.out.println(":: adding " + data);
                    todo.addTodo(data);
                    break;
                case "edit":
                    try {
                        int index = Integer.parseInt(data.split("\\s")[0]);
                        String title = data.split("\\s")[1];
                        todo.editTodo(index,title);
                    } catch(Exception e) {
                        System.out.println(":: Failed to edit todo");
                        System.out.println(":: Press <Enter to continue>");
                        scanner.nextLine();
                    }
                    break;
                case "rem":
                    try {
                        todo.removeTodo(Integer.parseInt(data));
                    } catch (Exception e) {
                        System.out.println(":: Failed to remove todo");
                        System.out.println(":: Press <Enter> to continue");
                        scanner.nextLine();
                    }
                    break;
                case "exit":
                    run = false;
                    break;
                default:
                    System.out.println(":: Unknown command");
                    System.out.println(":: Press <Enter> to continue");
                    scanner.nextLine();
                    break;
            }

            System.out.print("\033[H\033[2J");
            System.out.flush();

        }


    }
}