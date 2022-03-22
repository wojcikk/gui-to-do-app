import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GUIEnterTaskPanel implements ActionListener {

    JTextField textField;
    JButton button;

    private final TasksList tasksList;
    private final GUITaskSettingsPanel guiTaskSettingsPanel;
    private final GUIMainPage guiMainPage;
    private final GUITasksListPanel guiTasksListPanel;

    public GUIEnterTaskPanel(TasksList tasksList, GUITaskSettingsPanel guiTaskSettingsPanel, GUIMainPage guiMainPage, GUITasksListPanel guiTasksListPanel) {
        this.tasksList = tasksList;
        this.guiTaskSettingsPanel = guiTaskSettingsPanel;
        this.guiMainPage = guiMainPage;
        this.guiTasksListPanel = guiTasksListPanel;
    }

    public JPanel createEnterTaskPanel() {
        JPanel panel = new JPanel();

        panel.setMinimumSize(new Dimension(200, 75));
        panel.setPreferredSize(new Dimension(800, 75));
        panel.setMaximumSize(new Dimension(10000, 75));


        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(0, 75, 0, 75));

        createTaskText();
        createConfirmButton();

        setAppearance(panel);

        panel.add(textField);
        panel.add(button);

        return panel;
    }

    private void createTaskText() {
        textField = new JTextField();

        textField.setMinimumSize(new Dimension(200, 50));
        textField.setPreferredSize(new Dimension(600, 50));
        textField.setMaximumSize(new Dimension(10000, 50));

        textField.setBorder(BorderFactory.createEmptyBorder(10, 20, 0, 0));

        MouseAdapter mouseAdapter = new MyMouseAdapter();
        textField.addMouseListener(mouseAdapter);

        KeyListenerTester keyListenerTester = new KeyListenerTester();
        textField.addKeyListener(keyListenerTester);


        textField.setText("Enter task");
    }

    private void createConfirmButton() {
        button = new JButton();

        ImageIcon addIcon = new ImageIcon(new ImageIcon("add.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        button.setIcon(addIcon);

        button.setFocusable(false);


        button.setPreferredSize(new Dimension(50, 50));
        button.setMaximumSize(new Dimension(50, 50));

        button.addActionListener(this);
    }

    private void setAppearance(JPanel panel){
        panel.setBackground(new Color(238, 238, 238));

        textField.setBackground(Color.white);
        textField.setForeground(Color.lightGray);
        textField.setCaretColor(Color.white);
        textField.setFont(new Font("Consolas", Font.PLAIN, 30));

        System.out.println(Color.darkGray);




        button.setBorderPainted(false);
        button.setBorder(null);
        button.setBackground(new Color(250, 250, 250));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == button && !textField.getText().isEmpty() && !textField.getText().equals("Enter task")) {

            Task task = new Task();


            task.setName(textField.getText());
            if(guiTaskSettingsPanel.getLow().isSelected()) task.setPrioritize(guiTaskSettingsPanel.getLow().getText());
            else if(guiTaskSettingsPanel.getMedium().isSelected()) task.setPrioritize(guiTaskSettingsPanel.getMedium().getText());
            else if(guiTaskSettingsPanel.getImportant().isSelected()) task.setPrioritize(guiTaskSettingsPanel.getImportant().getText());
            task.setDeadlineHour(guiTaskSettingsPanel.getHoursField().getText());
            task.setDeadlineMinutes(guiTaskSettingsPanel.getMinutesField().getText());

            task.setIndex(tasksList.getTasks().size());

            tasksList.getTasks().add(task);
            tasksList.printListOfTasks();



            guiTasksListPanel.addTaskPanel(task.getIndex(), task.getName(), task.getPrioritize(), task.getDeadlineHour(), task.getDeadlineMinutes());

            guiTaskSettingsPanel.getGroup().clearSelection();
            guiTaskSettingsPanel.getHoursField().setText("12");
            guiTaskSettingsPanel.getMinutesField().setText("00");
            guiTaskSettingsPanel.setHours(12);
            guiTaskSettingsPanel.setMinutes(0);

            textField.setText("Enter task");
            textField.setForeground(Color.LIGHT_GRAY);


        }
    }

    private class MyMouseAdapter extends MouseAdapter {
        final JTextField textField = GUIEnterTaskPanel.this.textField;

        public void mouseEntered(MouseEvent e) {
            if(textField.getText().equals("Enter task")) {
                textField.setText("");
                textField.setForeground(Color.DARK_GRAY);
            }


        }


//        public void mousePressed(MouseEvent e) {
//            System.out.println("MouseListenerDemo.mousePressed");
//        }
//
//        public void mouseReleased(MouseEvent e) {
//            System.out.println("MouseListenerDemo.mouseReleased");
//        }
//
//        public void mouseEntered(MouseEvent e) {
//            System.out.println("MouseListenerDemo.mouseEntered");
//        }
//
//        public void mouseExited(MouseEvent e) {
//            System.out.println("MouseListenerDemo.mouseExited");
//        }
    }
    private class KeyListenerTester implements KeyListener {

        final JTextField textField = GUIEnterTaskPanel.this.textField;
        @Override
        public void keyTyped(KeyEvent e) {
            int key = e.getKeyChar();

            if((((key>=65)&&(key<=90))||((key>=97)&&(key<=122))||((key>=48)&&(key<=57))))
                if(textField.getText().equals("Enter task")) {
                    textField.setText("");
                    textField.setForeground(Color.DARK_GRAY);
                }
        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }

    }
}
