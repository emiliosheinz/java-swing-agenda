package ui;

import javax.swing.*;
import java.awt.*;

public class MainForm extends JFrame {
    private static int PANEL_WIDTH = 500;
    private static int PANEL_HEIGHT = 250;
    private static Boolean PANEL_VISIBILITY = true;

    private JPanel rootPanel;
    private JButton newContactButton;
    private JButton removeContactButton;
    private JTable contactsTable;

    public MainForm() {
        setContentPane(rootPanel);
        setSize(PANEL_WIDTH, PANEL_HEIGHT);
        setVisible(PANEL_VISIBILITY);

        Dimension screenDimension = getScreenDimension();

        setLocation(calculateHorizontalLocation(screenDimension), calculateVerticalLocation(screenDimension));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private Dimension getScreenDimension() {
        return Toolkit.getDefaultToolkit().getScreenSize();
    }

    private int calculateHorizontalLocation(Dimension screenDimension) {
        return screenDimension.width / 2 - getSize().width / 2;
    }

    private int calculateVerticalLocation(Dimension screenDimension) {
        return screenDimension.height / 2 - getSize().height / 2;
    }
}
