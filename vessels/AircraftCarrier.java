package vessels;

public class AircraftCarrier extends Vessel {
    public AircraftCarrier(char orientation, int startLine, int endLine) {
        super(4, orientation, startLine, endLine);
    }

    @Override
    public void destroy() {
        this.destroyed = true;
    }
    public String toString() {
        return "";
    }
}