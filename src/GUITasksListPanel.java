import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;

public class GUITasksListPanel implements ActionListener {

    private ArrayList<JPanel> tasksPanel;
    private final TasksList tasksList;

    private int deletedTasksCount = 0;

    public GUITasksListPanel(TasksList tasksList) {
        this.tasksList = tasksList;
    }

    public JPanel createTasksListPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        //panel.setPreferredSize(new Dimension(800, 450));

        tasksPanel = new ArrayList<>();
        createTasksPanel();

        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
        int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;

        JScrollPane scrollFrame = new JScrollPane(container, v, h);
        scrollFrame.setPreferredSize(new Dimension(0, 450));

        for(int i = 0; i < 100; i++) {
            container.add(tasksPanel.get(i));
            tasksPanel.get(i).setVisible(false);
        }

        scrollFrame.setBorder(null);
        container.setBackground(Color.WHITE);
        panel.add(scrollFrame);

        return panel;
    }

    public void createTasksPanel() {
        for(int i = 0; i < 100; i++) {
            JPanel panel = new JPanel();

            panel.setMinimumSize(new Dimension(700, 75));
            panel.setPreferredSize(new Dimension(700, 75));
            panel.setMaximumSize(new Dimension(10000, 75));

            panel.setBorder(BorderFactory.createLineBorder(Color.white, 10));
            panel.setBackground(new Color(248, 248, 248));

            tasksPanel.add(panel);

        }
    }

    private ArrayList<ArrayList<JButton>> listTaskButtons = new ArrayList<>();
    private JButton deleteButton;

    private int index;

    public void addTaskPanel(int passedIndex, String name, String prioritize, String hours, String minutes) {
        //index += deletedTasksCount;
        index = passedIndex;

        tasksPanel.get(index).setLayout(new BoxLayout(tasksPanel.get(index), BoxLayout.LINE_AXIS));
        //tasksPanel.get(index).setLayout(new FlowLayout());

        ArrayList<JButton> actionButtons = new ArrayList<>();

        JPanel doneField = new JPanel();
        JPanel taskName = new JPanel();
        JPanel taskPrioritize = new JPanel();
        JPanel taskDeadline = new JPanel();
        JPanel deleteField = new JPanel();


        doneField.setOpaque(true);
        taskName.setOpaque(true);
        taskPrioritize.setOpaque(true);
        taskDeadline.setOpaque(true);
        deleteField.setOpaque(true);

        doneField.setBackground(new Color(0,0,0,0));
        taskName.setBackground(new Color(0,0,0,0));
        taskPrioritize.setBackground(new Color(0,0,0,0));
        taskDeadline.setBackground(new Color(0,0,0,0));
        deleteField.setBackground(new Color(0,0,0,0));


        doneField.setPreferredSize(new Dimension(100, 75));
        taskName.setPreferredSize(new Dimension(250, 75));
        taskPrioritize.setPreferredSize(new Dimension(200, 75));
        taskDeadline.setPreferredSize(new Dimension(200, 75));
        deleteField.setPreferredSize(new Dimension(40, 75));


        JLabel priorityText = new JLabel("Priority:");
        JLabel deadlineText = new JLabel("Deadline:");

        JButton doneButton = new JButton();
        JButton crossButton = new JButton();
        JLabel taskNameText = new JLabel(name);
        JLabel taskPrioritizeText = new JLabel(prioritize);
        JLabel taskDeadlineText = new JLabel(hours + ":" + minutes);
        deleteButton = new JButton();

        ImageIcon doneIcon = new ImageIcon(new ImageIcon("done.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        ImageIcon crossIcon = new ImageIcon(new ImageIcon("cross.png").getImage().getScaledInstance(18, 18, Image.SCALE_DEFAULT));
        ImageIcon deleteIcon = new ImageIcon(new ImageIcon("delete.png").getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT));


        doneButton.setIcon(doneIcon);
        doneButton.setBorder(null);
        doneButton.setBorderPainted(false);
        doneButton.setContentAreaFilled(false);
        doneButton.setOpaque(true);
        doneButton.setBorder(null);
        doneButton.setBackground(new Color(248, 248, 248));
        doneButton.addActionListener(this);

        crossButton.setIcon(crossIcon);
        crossButton.setBorder(null);
        crossButton.setBorderPainted(false);
        crossButton.setContentAreaFilled(false);
        crossButton.setOpaque(true);
        crossButton.setFocusable(false);
        crossButton.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        crossButton.setBackground(new Color(248, 248, 248));
        crossButton.addActionListener(this);

        doneField.setBorder(BorderFactory.createEmptyBorder(12, 0, 0, 0));

        deleteButton.setIcon(deleteIcon);
        deleteButton.setBorder(null);
        deleteButton.setBorderPainted(false);
        deleteButton.setContentAreaFilled(false);
        deleteButton.setOpaque(true);
        deleteButton.setBorder(null);
        deleteButton.setBackground(new Color(248, 248, 248));
        deleteButton.addActionListener(this);

        deleteField.setBorder(BorderFactory.createEmptyBorder(12, 0, 0, 15));

        ArrayList<JLabel> taskTextLabels = new ArrayList<>();
        taskTextLabels.add(priorityText);
        taskTextLabels.add(deadlineText);
        taskTextLabels.add(taskNameText);
        taskTextLabels.add(taskPrioritizeText);
        taskTextLabels.add(taskDeadlineText);

        for(int i = 0; i < taskTextLabels.size(); i++) {
            taskTextLabels.get(i).setForeground(Color.darkGray);
            if(i == 0 || i == 1) taskTextLabels.get(i).setFont(new Font("Consolas", Font.PLAIN, 15));
            else taskTextLabels.get(i).setFont(new Font("Consolas", Font.PLAIN, 20));
        }

        taskName.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
        taskPrioritize.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
        taskDeadline.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));

        if(prioritize == null) priorityText.setText(" ");





        actionButtons.add(doneButton);
        actionButtons.add(crossButton);
        actionButtons.add(deleteButton);

        listTaskButtons.add(actionButtons);

        doneField.add(doneButton);
        doneField.add(crossButton);
        taskName.add(taskNameText);
        taskPrioritize.add(priorityText);
        taskPrioritize.add(taskPrioritizeText);
        taskDeadline.add(deadlineText);
        taskDeadline.add(taskDeadlineText);
        deleteField.add(deleteButton);

        tasksPanel.get(index).add(doneField);
        tasksPanel.get(index).add(taskName);
        tasksPanel.get(index).add(taskPrioritize);
        tasksPanel.get(index).add(taskDeadline);
        tasksPanel.get(index).add(deleteField);

        tasksPanel.get(index).setVisible(true);

    }

    public int findByValue(String value) {
        for(int i = 0; i < tasksList.getTasks().size(); i++) {
            if (tasksList.getTasks().get(i).getName().equals(value)) {
                return i;
            }
        }
        return 0;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < listTaskButtons.size(); i++) {
            if (e.getSource() == listTaskButtons.get(i).get(0)) {
                tasksPanel.get(i).setBackground(new Color(184, 255, 168));

                listTaskButtons.get(i).get(0).setBackground(new Color(184, 255, 168));
                listTaskButtons.get(i).get(1).setBackground(new Color(184, 255, 168));
                listTaskButtons.get(i).get(2).setBackground(new Color(184, 255, 168));
            } else if (e.getSource() == listTaskButtons.get(i).get(1)){
                tasksPanel.get(i).setBackground(new Color(255, 194, 194));
                listTaskButtons.get(i).get(0).setBackground(new Color(255, 194, 194));
                listTaskButtons.get(i).get(1).setBackground(new Color(255, 194, 194));
                listTaskButtons.get(i).get(2).setBackground(new Color(255, 194, 194));
            } else if (e.getSource() == listTaskButtons.get(i).get(2)) {
                tasksPanel.get(i).setVisible(false);
                index++;
                //deletedTasksCount++;
                //tasksPanel.remove(i);

                //for(int j = i; j < tasksList.getTasks().size(); j++)
                    //tasksList.getTasks().get(j).setIndex(i++);

//                if(i == tasksList.getTasks().size()) tasksList.getTasks().remove(i-1);
//                else tasksList.getTasks().remove(i);
                tasksList.getTasks().get(i).setName(null);
            }
        }
        tasksList.printListOfTasks();
    }
}
