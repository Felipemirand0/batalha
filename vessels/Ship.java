package vessels;

public class Ship extends Vessel {
    public Ship(char orientation, int startLine, int endLine) {
        super(3, orientation, startLine, endLine);
    }
    
    @Override
    public void destroy() {
        this.destroyed = true;
    }
    public String toString() {
        return "";
    }
}