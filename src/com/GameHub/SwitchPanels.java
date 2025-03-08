package com.GameHub;

import javax.swing.*;
import java.awt.*;

/**
 * The {@SwitchPanels} class provides utility methods for managing and switching
 * panels within a {@JLayeredPane}. It simplifies the process of replacing
 * the currently displayed panel with a new one.
 *
 * <p>This class uses a static {@JLayeredPane} reference, which must be set
 * using the {@setLayeredPane(JLayeredPane)} method before any panel switching
 * operations can be performed.</p>
 */
public class SwitchPanels {
    private static JLayeredPane layeredPane;

    /**
     * Sets the JLayeredPane that will be used for switching panels.
     * This method must be called before using the switchPanels method.
     *
     * @param layeredPane The JLayeredPane to use for switching panels.
     */
    public static void setLayeredPane(JLayeredPane layeredPane) {
        SwitchPanels.layeredPane = layeredPane;
    }

    /**
     * Switches the currently displayed panel in the layered pane with the given panel.
     *
     * @param panel The JPanel to display.
     * @throws IllegalStateException if the layeredPane has not been set.
     */
    public static void switchPanels(JPanel panel) {
        if (layeredPane == null) {
            throw new IllegalStateException("LayeredPane has not been set. Call setLayeredPane() first.");
        }

        layeredPane.removeAll();
        layeredPane.add(panel, JLayeredPane.DEFAULT_LAYER); // Add to the default layer
        layeredPane.repaint();
        layeredPane.revalidate();
    }

    /**
     * Creates a JLayeredPane to use for switching panels.
     * @param preferredSize The preferred size of the JLayeredPane
     * @return a JLayeredPane to use for panel switching.
     */
    public static JLayeredPane createLayeredPane(Dimension preferredSize) {
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(preferredSize);
        return layeredPane;
    }
}