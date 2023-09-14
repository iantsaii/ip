package rocket;

public class FindCommand extends Command {
    private String stringToFind;

    public FindCommand (String stringToFind) {
        super(false);
        this.stringToFind  = stringToFind;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        TaskList matchingTasks = getMatchingTasks(tasks, stringToFind);

        String response = "";
        response += "    Here are the matching tasks in your list:\n";
        response += tasklistToString(matchingTasks);

        System.out.println(response);
        ui.setLastResponse(response);

    }

    private TaskList getMatchingTasks(TaskList tasks, String stringToFind) {
        TaskList matchingTasks = new TaskList();
        for (int i = 0; i < tasks.size(); i++) {
            if (String.valueOf(tasks.get(i)).contains(stringToFind)) {
                matchingTasks.add(tasks.get(i));
            }
        }
        return matchingTasks;
    }

    private String tasklistToString(TaskList tasks) {
        String result = "";
        for (int i = 0; i < tasks.size(); i++) {
            result += "    " + (i + 1) + ". " + tasks.get(i) + "\n";
        }
        return result;
    }
}
