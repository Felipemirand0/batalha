package vessels;

public class Submarine extends Vessel {
    public Submarine(String name, char orientation, int startLine, int endLine) {
        super(2, name, orientation, startLine, endLine);
    }

    @Override
    public void destroy() {
        this.destroyed = true;
    }

    public String toString() {
        return "s";
    }
    
     
}