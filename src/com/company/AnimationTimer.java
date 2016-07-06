package com.company;
// Found online. TODO: check for licensing
/** The thread class that periodically calls the animate() method */
public class AnimationTimer extends Thread {
    Animation animation;  // The animation object we're serving as timer for
    int delay;            // How many milliseconds between "animation frames"
    public AnimationTimer(Animation animation, int delay) {
        this.animation = animation;
        this.delay = delay;
    }
    public void
    start_animation() {
        if (isAlive()) super.resume();
        else start();
    }
    public void
    pause_animation() { suspend(); }
    public void
    run() {
        for(;;) {
            animation.animate();
            try { Thread.sleep(delay); } catch (InterruptedException e) { ; }
        }
    }
}
