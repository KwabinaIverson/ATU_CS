package com.GameHub;

import javax.swing.*;
import java.awt.event.*;

public class Login extends JDialog {
    private JPanel loginPanel;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField emailField;
    private JPasswordField passwordField;

    private boolean loginSuccessful = false;

    String email, password;
    public Login() {
        setContentPane(loginPanel);
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
                email = emailField.getText();
                password = new String(passwordField.getPassword());

                if (email.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "All fields has to be filled.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                else {
                    JOptionPane.showMessageDialog(null, "Account created successfully!!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    loginSuccessful = true;
                }
                emailField.setText("");
                passwordField.setText("");
            }
        });
    }
    // Handles success of logins
    public boolean isLoginSuccessful() {
        return loginSuccessful;
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
