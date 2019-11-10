package ui;

import entity.ContactEntity;
import services.ContactService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MainForm extends JFrame {
    private static int PANEL_WIDTH = 500;
    private static int PANEL_HEIGHT = 250;
    private static Boolean PANEL_VISIBILITY = true;

    private JPanel rootPanel;
    private JButton newContactButton;
    private JButton removeContactButton;
    private JTable contactsTable;

    private ContactService contactService;

    public MainForm() {
        setContentPane(rootPanel);
        setSize(PANEL_WIDTH, PANEL_HEIGHT);
        setVisible(PANEL_VISIBILITY);

        Dimension screenDimension = getScreenDimension();

        setLocation(calculateHorizontalLocation(screenDimension), calculateVerticalLocation(screenDimension));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        contactService = new ContactService();

        setListeners();
        loadContacts();
    }

    private void setListeners() {
        newContactButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new ContactForm();
                dispose();
            }
        });

        removeContactButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
    }

    private void loadContacts() {
        List<ContactEntity> contactEntityList = contactService.getContactList();
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
