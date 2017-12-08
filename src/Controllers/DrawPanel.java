package Controllers;

import java.awt.*;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel {
    private ModelObserver modelObserver;

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);


    }

    public void setModelObserver(ModelObserver modelObserver) {
        this.modelObserver = modelObserver;
    }


    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        modelObserver.actOnModelChange(g);
    }

}

