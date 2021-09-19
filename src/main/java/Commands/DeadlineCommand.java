package Commands;

import Duke.TaskList;
import Tasks.Deadline;

/**
 * Adds a deadline task to the task list
 */
public class DeadlineCommand extends Command {

    public String description;
    public String dueDate;
    public static final String SUCCESS_MESSAGE = "The following deadline task has been added\n";

    public DeadlineCommand(String input){
        String[] inputParts = input.split("/by");
        description = inputParts[0].trim();
        dueDate = inputParts[1].trim();
    }

    @Override
    public String execute(TaskList taskList){
        taskList.add(new Deadline(description, false, dueDate));
        return SUCCESS_MESSAGE + taskList.printTask(-1) + "\n";
    }
}
