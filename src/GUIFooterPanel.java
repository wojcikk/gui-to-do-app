import javax.swing.*;
import java.awt.*;

public class GUIFooterPanel {
    public JPanel createFooterPanel() {
        JPanel panel = new JPanel();

        panel.setPreferredSize(new Dimension(800, 25));
        panel.setMinimumSize(new Dimension(200, 25));
        panel.setMaximumSize(new Dimension(10000, 25));
        panel.setBackground(new Color(248,248,248));


        return panel;
    }
}
