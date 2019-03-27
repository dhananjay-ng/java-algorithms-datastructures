package algorithms.recursion;

import processing.core.PApplet;

public class FractalPatterns extends PApplet {
    @Override
    public void setup() {
        size(1000, 1000, P2D);
    }

    @Override
    public void draw() {
        background(0);
        stroke(255);
        noFill();
        drawCircle(500,300,mouseX,mouseX);
    }

    public void drawCircle(float a, float b, float c, float d) {
        ellipse(a, b, c, d);
        if (d > 50) {
            drawCircle(a + d * 0.5f, b, d * 0.5f, d * 0.5f);
            drawCircle(a - d * 0.5f, b, d * 0.5f, d * 0.5f);
            drawCircle(a , b - d * 0.5f, d * 0.5f, d * 0.5f);
            drawCircle(a , b + d * 0.5f, d * 0.5f, d * 0.5f);
        }
    }
    public static void main(String[] args) {
        PApplet.main("algorithms.recursion.FractalPatterns");

    }
}
