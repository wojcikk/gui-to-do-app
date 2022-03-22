import javax.swing.*;
import java.awt.*;

public class GUIMainPage extends JFrame {

    private JPanel headingPanel;
    private JPanel enterTaskPanel;
    private JPanel taskSettingsPanel;
    private JPanel tasksListPanel;
    private JPanel footerPanel;

    TasksList tasksList = new TasksList();

    GUIHeadingPanel guiHeadingPanel = new GUIHeadingPanel();
    GUITaskSettingsPanel guiTaskSettingsPanel = new GUITaskSettingsPanel();
    GUITasksListPanel guiTasksListPanel = new GUITasksListPanel(tasksList);
    GUIEnterTaskPanel guiEnterTaskPanel = new GUIEnterTaskPanel(tasksList, guiTaskSettingsPanel, this, guiTasksListPanel);
    GUIFooterPanel guiFooterPanel = new GUIFooterPanel();


    GUIMainPage() {
        this.setMinimumSize(new Dimension(800, 400));
        this.setPreferredSize(new Dimension(800, 815));

        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        headingPanel = guiHeadingPanel.createHeadingPanel();
        enterTaskPanel = guiEnterTaskPanel.createEnterTaskPanel();
        taskSettingsPanel = guiTaskSettingsPanel.createTaskSettingsPanel();
        tasksListPanel = guiTasksListPanel.createTasksListPanel();
        footerPanel = guiFooterPanel.createFooterPanel();

        container.add(headingPanel);
        container.add(Box.createHorizontalStrut(5));
        container.add(enterTaskPanel);
        container.add(taskSettingsPanel);
        container.add(Box.createHorizontalStrut(5));
        container.add(tasksListPanel);
        container.add(Box.createHorizontalStrut(5));
        container.add(footerPanel);

        container.setBackground(Color.WHITE);

        this.add(container);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.pack();
        this.setVisible(true);
    }

    public JPanel getHeadingPanel() {
        return headingPanel;
    }

    public void setHeadingPanel(JPanel headingPanel) {
        this.headingPanel = headingPanel;
    }

    public JPanel getEnterTaskPanel() {
        return enterTaskPanel;
    }

    public void setEnterTaskPanel(JPanel enterTaskPanel) {
        this.enterTaskPanel = enterTaskPanel;
    }

    public JPanel getTaskSettingsPanel() {
        return taskSettingsPanel;
    }

    public void setTaskSettingsPanel(JPanel taskSettingsPanel) {
        this.taskSettingsPanel = taskSettingsPanel;
    }

    public JPanel getTasksListPanel() {
        return tasksListPanel;
    }

    public void setTasksListPanel(JPanel tasksListPanel) {
        this.tasksListPanel = tasksListPanel;
    }

    public JPanel getFooterPanel() {
        return footerPanel;
    }

    public void setFooterPanel(JPanel footerPanel) {
        this.footerPanel = footerPanel;
    }
}
