package coordinates;

/**
 * This class contains 2 sets of coordinates for a rectangle (the top left and bottom right corner)
 *
 * The first set of coordinates are (x1, y1)
 * The second set of coordinates of (x2, y2)
 */
public class RectCoordinates {

    private int x1, x2, y1, y2, width, height;

    private boolean x1flag = false;
    private boolean x2flag = false;
    private boolean y1flag = false;
    private boolean y2flag = false;

    public RectCoordinates() {}

    public void setX1(int x1) {
        this.x1 = x1;
        this.x1flag = true;
    }

    public void setX2(int x2) {
        this.x2 = x2;
        this.x2flag = true;
    }

    public void setY1(int y1) {
        this.y1 = y1;
        this.y1flag = true;
    }

    public void setY2(int y2) {
        this.y2 = y2;
        this.y2flag = true;
    }

    public int getX1() {
        return x1;
    }

    public int getX2() {
        return x2;
    }

    public int getY1() {
        return y1;
    }

    public int getY2() {
        return y2;
    }

    public boolean x1BeenSet() {
        return x1flag;
    }

    public boolean x2BeenSet() {
        return x2flag;
    }

    public boolean y1BeenSet() {
        return y1flag;
    }

    public boolean y2BeenSet() {
        return y2flag;
    }

    public int calculateHeight() {
        return y2 - y1;
    }

    public int calculateWidth() {
        return x2 - x1;
    }

    public void print() {
        System.out.println("(" + x1 + ", " + y1 + ") (" + x2 + ", " + y2 + ")");
    }

    @Override
    public String toString() {
        return ("(" + x1 + ", " + y1 + ") (" + x2 + ", " + y2 + ")");
    }
}
