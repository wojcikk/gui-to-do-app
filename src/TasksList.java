import java.util.ArrayList;
import java.util.LinkedList;

public class TasksList {
    private ArrayList<Task> tasks = new ArrayList<>();

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public void printListOfTasks() {
        int i;
        for(i = 0; i < tasks.size(); i++) {
            System.out.printf("%-5s %-15s %-15s %s:%s \n",
                    getTasks().get(i).getIndex(),
                    getTasks().get(i).getName(),
                    getTasks().get(i).getPrioritize(),
                    getTasks().get(i).getDeadlineHour(), getTasks().get(i).getDeadlineMinutes());

//            System.out.print(getTasks().get(i).getIndex());
//            System.out.print("\t\t" + getTasks().get(i).getName());
//            System.out.print("\t\t" + getTasks().get(i).getPrioritize());
//            System.out.println("\t\t" + getTasks().get(i).getDeadlineHour() + ":" + getTasks().get(i).getDeadlineMinutes());
        }
        System.out.println();
    }
}
