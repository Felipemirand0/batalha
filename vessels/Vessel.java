package vessels;

import java.util.List;
import java.util.ArrayList;

public abstract class Vessel {

    public int width;
    public char orientation;
    public boolean destroyed = false;
    public List<Integer> busyLine = new ArrayList<Integer>();
    public List<Integer> busyColumn = new ArrayList<Integer>();
    public int startLine;
    public int endLine;

    public Vessel(int width, char orientation, int startLine, int endLine) {
        this.width = width;
        this.orientation = orientation;
        this.startLine = startLine;
        this.endLine = endLine;

        if (endLine + width > 10) {

            // Virefid if position is valid
            System.out.print("Invalid position!");
        } else {

            char rep = Character.toLowerCase(orientation);

            if (rep == 'h') {
                for (int i = endLine; i < endLine + width; i++) {
                    this.busyLine.add(i);
                }
            } else {
                for (int i = startLine; i < startLine + width; i++) {
                    this.busyColumn.add(i);
                }
            }
        }

    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public abstract void destroy();
}
