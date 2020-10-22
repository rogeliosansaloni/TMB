package Location;

public class Monument extends Location {
    private String architect;
    private int inauguration;

    public Monument(String name, double[] coordinates, String description, String architect, int inauguration) {
        super(name, coordinates, description);
        this.architect = architect;
        this.inauguration = inauguration;
    }

    @Override
    public String toString() {
        return super.toString() +
                "architect='" + architect + '\'' +
                ", inauguration=" + inauguration;
    }
}
