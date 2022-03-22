public class Task {
    private int index = 0;
    private String name;
    private String prioritize;
    private String deadlineHour;
    private String deadlineMinutes;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrioritize() {
        return prioritize;
    }

    public void setPrioritize(String prioritize) {
        this.prioritize = prioritize;
    }

    public String getDeadlineHour() {
        return deadlineHour;
    }

    public void setDeadlineHour(String deadlineHour) {
        this.deadlineHour = deadlineHour;
    }

    public String getDeadlineMinutes() {
        return deadlineMinutes;
    }

    public void setDeadlineMinutes(String deadlineMinutes) {
        this.deadlineMinutes = deadlineMinutes;
    }
}
