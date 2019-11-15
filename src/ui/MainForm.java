package ui;

import entity.ContactEntity;
import services.ContactService;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
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
    private JLabel contactsCountLabel;

    private String name = "";
    private String phoneNumber = "";

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

        contactsTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                if (listSelectionEvent.getValueIsAdjusting()) {
                    int selectedRow = contactsTable.getSelectedRow();

                    if(selectedRow != -1) {
                        name  = contactsTable.getValueAt(selectedRow, 0).toString();
                        phoneNumber = contactsTable.getValueAt(selectedRow, 1).toString();
                    }
                }
            }
        });

        removeContactButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    contactService.delete(name, phoneNumber);
                    loadContacts();

                    name = "";
                    phoneNumber = "";
                } catch (IllegalArgumentException exception) {
                    JOptionPane.showMessageDialog(new JFrame(), exception.getMessage());
                }
            }
        });
    }

    private void loadContacts() {
        List<ContactEntity> contactEntityList = contactService.getContactList();

        String[] columnNames = {"NAME", "NUMBER"};
        DefaultTableModel model = new DefaultTableModel(new Object[0][0], columnNames);

        for (ContactEntity c : contactEntityList) {
            Object[] contact = new Object[2];

            contact[0] = c.getName();
            contact[1] = c.getPhoneNumber();

            model.addRow(contact);
        }

        contactsTable.clearSelection();
        contactsTable.setModel(model);

        contactsCountLabel.setText(contactService.getContactCountDescription());
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
