package com.GameHub;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The {@GameHubUI} class represents the user interface structure for the GameHub application.
 * It holds references to the main panels used in the application, such as login, signup, home, and admin panels.
 * This class is primarily intended to organize and provide access to the various UI components.
 */
public class GameHubUI extends JPanel{
    public JPanel framePanel;
    private JPanel signupPanel;
    private JPanel loginPanel;
    private JPanel homePanel;
    private JPanel adminPanel;
    private JPanel signupBgPanel;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton signupBTN;
    private JTextField studentIDField;

    String firstName, lastName, email, password, studentID;

    public GameHubUI() {
        signupBTN.addActionListener(new ActionListener() {
            /**
             * Handles the action performed event when the signup button is clicked.
             *
             * <p>This method retrieves user inputs from the respective fields: firstName, lastName,
             * email, studentID, and password. It then validates the inputs to ensure that no
             * field is empty. If any field is empty, an error message is displayed. Otherwise,
             * a success message is shown, and all the input fields are cleared.</p>
             *
             * @param e The action event triggered by clicking the signup button.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get user inputs
                firstName = firstNameField.getText();
                lastName = lastNameField.getText();
                email = emailField.getText();
                studentID = studentIDField.getText();
                password = new String(passwordField.getPassword());

                // check if user submitted any empty field or nat and set and
                if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || studentID.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "All fields has to be filled.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                else {
                    JOptionPane.showMessageDialog(null, "Account created successfully!!", "Success", JOptionPane.INFORMATION_MESSAGE);
                }

                firstNameField.setText("");
                lastNameField.setText("");
                emailField.setText("");
                studentIDField.setText("");
                passwordField.setText("");
            }
        });
    }
}