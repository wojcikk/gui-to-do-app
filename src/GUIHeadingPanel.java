import javax.swing.*;
import java.awt.*;

public class GUIHeadingPanel {

    public JPanel createHeadingPanel() {
        JPanel panel = new JPanel();

        panel.setPreferredSize(new Dimension(800, 50));
        panel.setMinimumSize(new Dimension(200, 50));
        panel.setMaximumSize(new Dimension(10000, 50));
        panel.setBackground(new Color(238,238,238));

        JLabel heading = new JLabel("TODO APP");
        heading.setFont(new Font("Consolas", Font.BOLD, 35));
        heading.setForeground(Color.DARK_GRAY);

        heading.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));

        panel.add(heading);


        return panel;
    }
}
