package vessels;

public class AircraftCarrier extends Vessel {
    public AircraftCarrier(String name, char orientation, int startLine, int endLine) {
        super(4, name, orientation, startLine, endLine);
    }

    @Override
    public void destroy() {
        this.destroyed = true;
    }
    public String toString() {
        return "p";
    }
}