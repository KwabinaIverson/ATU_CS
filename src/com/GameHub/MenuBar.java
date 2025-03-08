package com.GameHub;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

/**
 * The {@MenuBar} class provides a utility method to create a standard menu bar
 * for a Swing application. This menu bar includes "File" and "Help" menus with
 * common menu items.
 */
public class MenuBar {
    /**
     * Creates and returns a {@link JMenuBar} instance with predefined menus and menu items.
     *
     * <p>The menu bar contains two main menus:</p>
     * <ul>
     * <li><strong>File</strong>: Includes "New" and "Exit" menu items.</li>
     * <li><strong>Help</strong>: Includes an "About" menu item.</li>
     * </ul>
     *
     * @return A {@link JMenuBar} instance configured with "File" and "Help" menus.
     *
     * <p>
     * Example usage:
     * </p>
     * <pre>
     * JMenuBar menuBar = MenuBar.createMenu();
     * JFrame frame = new JFrame("My Application");
     * frame.setJMenuBar(menuBar);
     * frame.setVisible(true);
     * </pre>
     */
    public static JMenuBar createMenu() {
        JMenuBar menuBar = new JMenuBar(); // Create JMenuBar instance

        // Menus to add to menubar
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);

        JMenu helpMenu = new JMenu("Help");
        helpMenu.setMnemonic(KeyEvent.VK_H);

        // File Menu Items
        JMenuItem openMenuItem = new JMenuItem("New");
        openMenuItem.setMnemonic(KeyEvent.VK_O);
        openMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));

        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.setMnemonic(KeyEvent.VK_D);
        exitMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK));

        JMenuItem aboutMenuItem = new JMenuItem("About");  // Help Menu Items
        aboutMenuItem.setMnemonic(KeyEvent.VK_A);
        aboutMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));

        // Add File items to fileMenu
        fileMenu.add(openMenuItem);
        fileMenu.add(exitMenuItem);
        helpMenu.add(aboutMenuItem);

        // Add Menus to menu bar
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);

        // Handles key CTRL+O from user
        openMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Alert user with a dialog message window
                JOptionPane.showMessageDialog(null, "U clicked CTRL+O", "Success", JOptionPane.INFORMATION_MESSAGE );
            }
        });

        // The program terminates when the CTRL+D is pressed
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Exit the program without error
            }
        });

        // Handles CTRL+A from user
        aboutMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show a JWindow with application information
                JOptionPane.showMessageDialog(null, "U clicked CTRL+A", "Success", JOptionPane.INFORMATION_MESSAGE );

            }
        });
        return menuBar;
    }
}
