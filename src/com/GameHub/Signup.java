package com.GameHub;

import javax.swing.*;
import java.awt.event.*;

public class Signup extends JDialog {
    private JPanel signupPanel;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPanel signupForm;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField emailField;
    private JTextField studentIDField;
    private JPasswordField passwordField;

    String firstName, lastName, email, studentID, password;
    private static boolean signupSuccessful = false;

    public Signup() {
        setContentPane(signupPanel);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });


        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Program will terminate", "Success", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        });

        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstName = firstNameField.getText();
                lastName = lastNameField.getText();
                studentID = studentIDField.getText();
                email = emailField.getText();
                password = new String(passwordField.getPassword());

                if (email.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "All fields has to be filled.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                else {
//                    MySqlDB.insertData(firstName, lastName, email, studentID, password);
                    JOptionPane.showMessageDialog(null, "Account created successfully!!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    signupSuccessful = true;
                }

                firstNameField.setText("");
                lastNameField.setText("");
                studentIDField.setText("");
                emailField.setText("");
                passwordField.setText("");
            }
        });
    }

    public boolean isSignupSuccessful() {
        return signupSuccessful;
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
}
