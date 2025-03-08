import com.GameHub.*;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        MySqlDB.createMyConn(); // Creates connection with DB MySQL
        MySqlDB.createNewTable(); // Creates DB Table for user information

        try {
            Object[] options = {"Login", "Signup"};
            int choice = JOptionPane.showOptionDialog(null,
                    "Choose Login or Signup",
                    "Welcome to Game Hub",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);

            if (choice == JOptionPane.YES_OPTION) {
                Login loginDialog = new Login();
                loginDialog.setLocationRelativeTo(null);
                loginDialog.pack();
                loginDialog.setVisible(true);

                if (loginDialog.isLoginSuccessful()) {
                    showMainFrame();
                } else {
                    JOptionPane.showMessageDialog(null, "Login failed. Sign up for a membership", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } else if (choice == JOptionPane.NO_OPTION) {
                Signup signupDialog = new Signup();
                signupDialog.setLocationRelativeTo(null);
                signupDialog.pack();
                signupDialog.setVisible(true);

                if (signupDialog.isSignupSuccessful()) {
                    showMainFrame();
                } else {
                    JOptionPane.showMessageDialog(null, "Signup failed.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showMainFrame() {
        JFrame mainFrame = new JFrame("Game Hub"); // Creates new frame
        mainFrame.setContentPane(new GameHubUI().framePanel); // Adds frame panel to the frame

        mainFrame.setResizable(false); // Disable maximize button

        mainFrame.setLocationRelativeTo(null); // Set Frame to the middle of the screen

        mainFrame.setJMenuBar(MenuBar.createMenu()); // Add Menu to the Frame

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close application when the closed button is clicked
        mainFrame.pack();
        mainFrame.setVisible(true); // Makes frame visible to see on the screen
    }
}