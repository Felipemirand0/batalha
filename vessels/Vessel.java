package vessels;

import java.util.List;
import java.util.ArrayList;

public abstract class Vessel {
    public int width;
    public int endLine;
    public String name;
    public int startLine;
    public char orientation;
    public boolean destroyed = false;
    public List<Integer> busyLine = new ArrayList<Integer>();
    public List<Integer> busyColumn = new ArrayList<Integer>();

    public Vessel(int width, String name, char orientation, int startLine, int endLine) {
        this.name = name;
        this.width = width;
        this.endLine = endLine;
        this.startLine = startLine;
        this.orientation = orientation;

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
