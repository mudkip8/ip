package Duke;

import Tasks.Deadline;
import Tasks.Event;
import Tasks.Task;
import Tasks.Todo;

import java.util.ArrayList;

public class TaskManager {
    private static ArrayList<Task> tasks = new ArrayList<>();
    private int numTask = 0;

    public static final String TASK_ADDED_MESSAGE = "The task has been added: \n";
    public static final String NO_SUCH_TASK_MESSAGE = "There is no task by that number \n";
    public static final String TASK_COMPLETE_MESSAGE = "Congrats on finishing a task! Have a cookie!\n";
    public static final String NO_TASKS_MESSAGE = "No Tasks\n";
    public static final String TASK_DELETED_MESSAGE = "The following task has been deleted:\n";


    public TaskManager() {
    }

    public String addTodoTask(String description) {
        tasks.add(new Todo(description));
        numTask++;
        return TASK_ADDED_MESSAGE + tasks.get(numTask - 1) + "\n";
    }

    public String addDeadlineTask(String task) {
        String[] separator = task.split("/by");
        String description = separator[0].trim();
        String deadline = separator[1].trim();
        tasks.add(new Deadline(description, deadline));
        numTask++;
        return TASK_ADDED_MESSAGE + tasks.get(numTask - 1) + "\n";
    }

    public String addEventTask(String task) {
        String[] separator = task.split("/at");
        String description = separator[0].trim();
        String timing = separator[1].trim();
        tasks.add(new Event(description, timing));
        numTask++;
        return TASK_ADDED_MESSAGE + tasks.get(numTask - 1) + "\n";
    }

    public String listTasks() {
        if (numTask == 0) {
            return NO_TASKS_MESSAGE;
        }
        String infoForUser = "Task List:\n";
        for (int i = 0; i < numTask; i++) {
            infoForUser += (i + 1) + ". " + tasks.get(i) + "\n";
        }

        return infoForUser;
    }

    public String markAsDone(int number) {
        if (number > numTask) {
            return NO_SUCH_TASK_MESSAGE;
        }
        tasks.get(number - 1).markAsDone();
        return TASK_COMPLETE_MESSAGE + tasks.get(number - 1) + "\n";
    }

    public String deleteTask(int number) {
        if (number > numTask) {
            return NO_SUCH_TASK_MESSAGE;
        }
        Task removedTask = tasks.get(number - 1);
        tasks.remove(number - 1);
        numTask--;
        return TASK_DELETED_MESSAGE + removedTask + "\n";
    }

    public String showCommandHelp() {
        return "The following is the list of commands: \n" +
                "list \nDisplays the current tasks. \n" +
                "todo <task> \nAdds <task> to the task list \n" +
                "deadline <task> /by <date>\nAdds <task> to task list with deadline <date> \n" +
                "event <task> /at <time>\nAdds <task> to task list with time <time> \n" +
                "done <task index>\nMarks task number <task index> as done. <task index> should be an integer\n" +
                "exit\nExits the program\n";
    }
}
