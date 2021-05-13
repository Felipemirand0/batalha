package vessels;

public class Submarine extends Vessel {
    public Submarine(char orientation, int startLine, int endLine) {
        super(2, orientation, startLine, endLine);
    }

    @Override
    public void destroy() {
        this.destroyed = true;
    }

    public String toString() {
        return "";
    }
    
     
}