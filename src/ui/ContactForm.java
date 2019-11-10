package ui;

import javax.swing.*;

public class ContactForm extends JFrame {
    private static int PANEL_WIDTH = 500;
    private static int PANEL_HEIGHT = 250;
    private static Boolean PANEL_VISIBILITY = true;
    private JPanel rootPanel;
    private JLabel nameLabel;
    private JTextField nameInput;
    private JLabel numberLabel;
    private JTextField numberInput;
    private JPanel footerButtons;
    private JButton cancelButton;
    private JButton saveButton;

    public ContactForm() {
        setContentPane(rootPanel);
        setSize(PANEL_WIDTH, PANEL_HEIGHT);
        setVisible(PANEL_VISIBILITY);
    }
}
