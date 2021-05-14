package vessels;

public class Ship extends Vessel {
    public Ship(String name, char orientation, int startLine, int endLine) {
        super(3, name, orientation, startLine, endLine);
    }
    
    @Override
    public void destroy() {
        this.destroyed = true;
    }
    public String toString() {
        return "n";
    }
}