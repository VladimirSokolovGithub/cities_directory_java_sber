import java.util.Comparator;

public class CityDistrictAndNameComparator implements Comparator<City> {
    @Override
    public int compare(City city1, City city2) {
        int result = city1.getDistrict().compareTo(city2.getDistrict());
        if (result == 0){
            result = city1.getName().compareTo(city2.getName());
        }
        return result;
    }

}
