package Location;

import java.util.Arrays;

public class Restaurant extends Location{
    private String[] characteristics;

    public Restaurant(String name, double[] coordinates, String description, String[] characteristics) {
        super(name, coordinates, description);
        this.characteristics = characteristics;
    }

    @Override
    public String toString() {
        return super.toString() +
        "characteristics=" + Arrays.toString(characteristics) +
                '}';
    }
}
