package vessels;
import java.util.List;
import java.util.ArrayList;

public abstract class Vessel {
    public int width;
    public char orientation;
    public boolean destroyed = false;
    public List<Integer> busyLine = new ArrayList<Integer>();
    public List<Integer> busyColumn = new ArrayList<Integer>();

    public Vessel(int width, char orientation, int startLine, int endLine) {
        this.width = width; 
        this.orientation = orientation;
         
        if(orientation == 'v') {
            if(startLine < endLine) {
                for (int i = startLine; i <= endLine; i++) {
                    busyLine.add(i);
                }
            } else {
                for (int i = startLine; i >= endLine; i--) {
                    busyLine.add(i);
                }
            }
        } else {
            if(startLine < endLine) {
                for (int i = startLine; i <= endLine; i++) {
                    busyColumn.add(i);
                }
            } else {
                for (int i = startLine; i >= endLine; i--) {
                    busyColumn.add(i);
                }
            }
        }
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public abstract void destroy();
}
