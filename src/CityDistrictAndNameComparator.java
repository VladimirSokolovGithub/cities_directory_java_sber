import java.util.Comparator;

public class CityDistrictAndNameComparator implements Comparator<City> {
    @Override
    public int compare(City city1, City city2) {
        int result = city1.district.compareTo(city2.district);
        if (result == 0){
            result = city1.name.compareTo(city2.name);
        }
        return result;
    }

}
