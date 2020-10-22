package Location;

public class Hotel extends Location{
    private int stars;

    public Hotel(String name, double[] coordinates, String description, int stars) {
        super(name, coordinates, description);
        this.stars = stars;
    }

    @Override
    public String toString() {
        return super.toString()  +
                "stars=" + stars +
                '}';
    }
}
