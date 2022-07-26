import java.util.Comparator;

public class CityNameComparator implements Comparator<City> {
    @Override
    public int compare(City city1, City city2) {
        return city1.name.compareTo(city2.name);
    }
}
