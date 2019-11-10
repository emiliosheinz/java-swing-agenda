package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        Dimension screenDimension = getScreenDimension();

        setLocation(calculateHorizontalLocation(screenDimension), calculateVerticalLocation(screenDimension));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setListeners();
    }

    private void setListeners() {
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new MainForm();
                dispose();
            }
        });
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
