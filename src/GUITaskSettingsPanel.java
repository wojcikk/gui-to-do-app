import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUITaskSettingsPanel implements ActionListener {

    ButtonGroup group;
    JRadioButton low;
    JRadioButton medium;
    JRadioButton important;
    JLabel text;
    JPanel priorityPanel;
    JPanel deadlinePanel;

    public JPanel createTaskSettingsPanel() {
        JPanel panel = new JPanel();

        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        panel.setMinimumSize(new Dimension(200, 50));
        panel.setPreferredSize(new Dimension(800, 50));
        panel.setMaximumSize(new Dimension(10000, 50));

        panel.setBackground(new Color(248, 248, 248));

        panel.setBorder(BorderFactory.createEmptyBorder(8, 0, 0, 0));

        createRadioButtons();

        createDeadlineField();

        panel.add(priorityPanel);
        panel.add(Box.createVerticalStrut(5));

        panel.add(deadlinePanel);

        return panel;
    }

    private void createRadioButtons() {
        priorityPanel = new JPanel();

        text = new JLabel("Priority: ");

        text.setForeground(Color.darkGray);
        text.setFont(new Font("Consolas", Font.PLAIN, 15));

        low = new JRadioButton("Low");
        medium = new JRadioButton("Medium");
        important = new JRadioButton("Important");

        ArrayList<JRadioButton> radioButtons = new ArrayList<>();
        radioButtons.add(low);
        radioButtons.add(medium);
        radioButtons.add(important);

        for(int i = 0; i < radioButtons.size(); i++) {
            radioButtons.get(i).setForeground(Color.darkGray);
            radioButtons.get(i).setFont(new Font("Consolas", Font.PLAIN, 15));
            radioButtons.get(i).setOpaque(false);
            radioButtons.get(i).setContentAreaFilled(false);
            radioButtons.get(i).setBorderPainted(false);
            radioButtons.get(i).setFocusable(false);
        }


        group = new ButtonGroup();
        group.add(low);
        group.add(medium);
        group.add(important);


        priorityPanel.setOpaque(false);
        priorityPanel.setBackground(new Color(0,0,0,0));

        priorityPanel.add(text);
        priorityPanel.add(low);
        priorityPanel.add(medium);
        priorityPanel.add(important);
    }

    JButton upHours;
    JButton downHours;
    JButton upMinutes;
    JButton downMinutes;
    Integer hours;
    Integer minutes;
    JLabel hoursField;
    JLabel minutesField;
    private void createDeadlineField() {
        JLabel text = new JLabel("Deadline: ");

        text.setForeground(Color.darkGray);
        text.setFont(new Font("Consolas", Font.PLAIN, 15));

        deadlinePanel = new JPanel();
        deadlinePanel.setOpaque(false);

        JPanel hoursButtons = new JPanel();
        JPanel minutesButtons = new JPanel();

        setDeadlineButtonsFieldAppearance(hoursButtons, minutesButtons);

        upHours = new JButton();
        downHours = new JButton();
        upMinutes = new JButton();
        downMinutes = new JButton();

        setDeadlineButtonsAppearance();

        setDeadlineTextAppearance();

        JLabel colon = new JLabel(":");
        colon.setForeground(Color.darkGray);
        colon.setFont(new Font("Consolas", Font.PLAIN, 15));

        deadlinePanel.add(text);
        hoursButtons.add(upHours);
        hoursButtons.add(downHours);
        deadlinePanel.add(hoursButtons);
        deadlinePanel.add(hoursField);
        deadlinePanel.add(colon);
        deadlinePanel.add(minutesField);
        minutesButtons.add(upMinutes);
        minutesButtons.add(downMinutes);
        deadlinePanel.add(minutesButtons);
    }

    private void setDeadlineTextAppearance() {
        hours = 12;
        hoursField = new JLabel(hours.toString());

        hoursField.setForeground(Color.darkGray);
        hoursField.setFont(new Font("Consolas", Font.PLAIN, 15));

        minutes = 0;
        minutesField = new JLabel("0" + minutes.toString());

        minutesField.setForeground(Color.darkGray);
        minutesField.setFont(new Font("Consolas", Font.PLAIN, 15));
    }

    private void setDeadlineButtonsFieldAppearance(JPanel hoursButtons, JPanel minutesButtons) {
        ArrayList<JPanel> deadlineButtonsField = new ArrayList<>();
        deadlineButtonsField.add(hoursButtons);
        deadlineButtonsField.add(minutesButtons);

        for(int i = 0; i < deadlineButtonsField.size(); i++) {
            deadlineButtonsField.get(i).setPreferredSize(new Dimension(30,30));
            deadlineButtonsField.get(i).setLayout(new GridLayout(2, 1));
            deadlineButtonsField.get(i).setOpaque(false);
            deadlineButtonsField.get(i).setBackground(new Color(0,0,0,0));
        }

    }
    private void setDeadlineButtonsAppearance() {
        ImageIcon plusIcon = new ImageIcon(new ImageIcon("plus.png").getImage().getScaledInstance(10, 10, Image.SCALE_DEFAULT));
        ImageIcon minusIcon = new ImageIcon(new ImageIcon("minus.png").getImage().getScaledInstance(8, 10, Image.SCALE_DEFAULT));

        upHours.setIcon(plusIcon);
        upMinutes.setIcon(plusIcon);
        downHours.setIcon(minusIcon);
        downMinutes.setIcon(minusIcon);

        ArrayList<JButton> deadlineButtons = new ArrayList<>();
        deadlineButtons.add(upHours);
        deadlineButtons.add(downHours);
        deadlineButtons.add(upMinutes);
        deadlineButtons.add(downMinutes);

        for(int i = 0; i < deadlineButtons.size(); i++) {
            deadlineButtons.get(i).setFont(new Font("Consolas", Font.PLAIN, 20));
            deadlineButtons.get(i).addActionListener(this);
            deadlineButtons.get(i).setOpaque(false);
            deadlineButtons.get(i).setContentAreaFilled(false);
            deadlineButtons.get(i).setBorderPainted(false);
            deadlineButtons.get(i).setForeground(Color.lightGray);
            deadlineButtons.get(i).setPreferredSize(new Dimension(15, 15));
            deadlineButtons.get(i).setMargin(new Insets(0, 0, 0, 0));
            deadlineButtons.get(i).setFocusable(false);

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == upHours) {
            if(hours == 23) hours = 0;
            else hours++;

            if(hours < 10) hoursField.setText("0" + hours.toString());
            else hoursField.setText(hours.toString());
        } else if (e.getSource() == downHours) {
            if(hours == 0) hours = 23;
            else hours--;

            if(hours < 10) hoursField.setText("0" + hours.toString());
            else hoursField.setText(hours.toString());
        } else if(e.getSource() == upMinutes) {
            if(minutes == 45) minutes = 0;
            else minutes += 15;
            if(minutes < 10) minutesField.setText("0" + minutes.toString());
            else minutesField.setText(minutes.toString());
        } else if (e.getSource() == downMinutes) {
            if(minutes == 0) minutes = 45;
            else minutes -= 15;
            if(minutes < 10) minutesField.setText("0" + minutes.toString());
            else minutesField.setText(minutes.toString());
        }
    }

    public ButtonGroup getGroup() {
        return group;
    }

    public JRadioButton getLow() {
        return low;
    }

    public JRadioButton getMedium() {
        return medium;
    }

    public JRadioButton getImportant() {
        return important;
    }

    public JPanel getDeadlinePanel() {
        return deadlinePanel;
    }

    public JLabel getHoursField() {
        return hoursField;
    }

    public JLabel getMinutesField() {
        return minutesField;
    }

    public Integer getHours() {
        return hours;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }
}
