package algorithms.ai;

import processing.core.PApplet;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class AStar extends PApplet {
    final int cols = 50, rows = 50;
    float w, h;
    Spot[][] grid = new Spot[50][50];
    List<Spot> openList = new ArrayList<>();
    List<Spot> closedList = new ArrayList<>();
    Spot start;
    Spot end;
    List<Spot> path;

    boolean isSolutionPossible = true;

    private class Spot {
        private final ArrayList<Spot> neighbors;
        private final int i;
        private final int j;
        private  float f;
        private  float g;
        private  float h;
        private Spot previous;
        private boolean obstacle = false;

        public Spot(int i, int j) {
            this.i = i;
            this.j = j;
            this.f = 0;
            this.g = 0;
            this.h = 0;
            this.neighbors = new ArrayList<>();
            this.previous = null;

            if (Math.random() < 0.4) {
                this.obstacle = true;
            }
        }

        public void showSpot(PApplet sketch, int spotColor) {
            if (this.obstacle) {
                sketch.fill(spotColor);
                sketch.noStroke();
                sketch.ellipse(this.i * w + w / 2, this.j * h + h / 2, w / 2, h / 2);
            }
        }

        public void addNeighbors(Spot[][] grid) {
            var i = this.i;
            var j = this.j;

            if (i < cols - 1) {
                this.neighbors.add(grid[i + 1][j]);
            }
            if (i > 0) {
                this.neighbors.add(grid[i - 1][j]);
            }
            if (j < rows - 1) {
                this.neighbors.add(grid[i][j + 1]);
            }
            if (j > 0) {
                this.neighbors.add(grid[i][j - 1]);
            }
            if (i > 0 && j > 0) {
                this.neighbors.add(grid[i - 1][j - 1]);
            }
            if (i < cols - 1 && j < rows - 1) {
                this.neighbors.add(grid[i + 1][j + 1]);
            }
            if (i > 0 && j < rows - 1) {
                this.neighbors.add(grid[i - 1][j + 1]);
            }
            if (i < cols - 1 && j > 0) {
                this.neighbors.add(grid[i + 1][j - 1]);
            }
        }

    }
    public void showSpot(Spot spot, int spotColor) {
        if (spot.obstacle) {
            fill(spotColor);
            noStroke();
            ellipse(spot.i * w + w / 2, spot.j * h + h / 2, w / 2, h / 2);
        }
    }

    @Override
    public void setup() {
        size(700, 600, P2D);
        h = height / rows;
        w = width / cols;
        System.out.println("A*");
        this.background(255);

        for (var i = 0; i < cols; i++) {
            for (var j = 0; j < rows; j++) {
                grid[i][j] = new Spot(i, j);
            }
        }

        for (var i = 0; i < cols; i++) {
            for (var j = 0; j < rows; j++) {
                grid[i][j].addNeighbors(grid);
            }
        }

        start = grid[0][0];
        end = grid[cols - 1][rows - 1];

        openList.add(start);
        start.obstacle = false;
        end.obstacle = false;


    }

    @Override
    public void draw() {
        background(255);
        Spot current = null;

        //A* algorithm
        if (!openList.isEmpty()) {
            var winner = 0;
            for (var i = 0; i < openList.size(); i++) {
                if (openList.get(i).f < openList.get(winner).f) {
                    winner = i;
                }
            }

            current = openList.get(winner);

            if (current.equals(end)) {
                noLoop();
                System.out.println("Done!");
            }

            openList.remove(current);
            closedList.add(current);

            var neighbors = current.neighbors;
            for (var i = 0; i < neighbors.size(); i++) {
                var neighbor = neighbors.get(i);

                if (!closedList.contains(neighbor) && !neighbor.obstacle) {
                    var tempG = current.g + 1;

                    var isNewPath = false;
                    if (openList.contains(neighbor)) {
                        if (tempG < neighbor.g) {
                            neighbor.g = tempG;
                            isNewPath = true;
                        }
                    } else {
                        neighbor.g = tempG;
                        openList.add(neighbor);
                        isNewPath = true;
                    }
                    if (isNewPath) {
                        neighbor.h = heuristic(neighbor, end);
                        neighbor.f = neighbor.g + neighbor.h;
                        neighbor.previous = current;
                    }
                }

            }


        } else {
            System.out.println("no solution");
            isSolutionPossible = false;
            noLoop();
        }

        //A* ends




        for (var i = 0; i < cols; i++) {
            for (var j = 0; j < rows; j++) {
               showSpot(grid[i][j], color(0));
            }
        }

        if (isSolutionPossible && current!=null) {
            //find the path
            path = new ArrayList<>();
            var temp = current;
            path.add(temp);
            while (temp.previous != null) {
                path.add(temp.previous);
                temp = temp.previous;
            }
        }

        // for (var i = 0; i < path.length; i++) {
        //      path[i].show(color(61, 90, 254));
        // }

        noFill();
        stroke(255, 0, 200);
        strokeWeight(w / 2);
        beginShape();
        for (var i = 0; i < path.size(); i++) {
            vertex(path.get(i).i * w + w / 2, path.get(i).j * h + h / 2);
        }
        endShape();

    }

    private float heuristic(Spot neighbor, Spot end) {
        //Manhatten
        return abs(neighbor.i - end.i)  + abs(neighbor.j - end.j);
    }

    public static void main(String... args) {
        PApplet.main("algorithms.ai.AStar");
    }
}
