package com.company;

import java.applet.Applet;
import java.awt.*;

// Found online. TODO: check for licensing
public class BouncingCircle extends Applet implements Animation {
    int x = 150, y = 50, r=50;    // position and radius of the circle
    int dx = 11, dy = 7;          // trajectory of circle
    AnimationTimer timer = new AnimationTimer(this, 100);
    public void
    paint(Graphics g) {
        g.setColor(Color.red);
        g.fillOval(x-r, y-r, r*2, r*2);
    }
    public void
    animate() {
        // Bounce if we've hit an edge.
        if ((x - r + dx < 0) || (x + r + dx > bounds().width)) dx = -dx;
        if ((y - r + dy < 0) || (y + r + dy > bounds().height)) dy = -dy;
        // Move the circle.
        x += dx;  y += dy;
        // Ask the browser to call our paint() method to draw the circle
        repaint();
    }
    public void
    start() {
        timer.start_animation();
    }
    public void
    stop() {
        timer.pause_animation();
    }
}
