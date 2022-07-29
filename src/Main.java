import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<City> list = new ArrayList<>();
        Scanner scanner = null;

        try {
            scanner = new Scanner(new FileReader(new File
                    ("C:\\Users\\Dell\\Desktop\\JavaTrainee\\Задача ВС Java Сбер.csv")));

            while (scanner.hasNext()) {
                String word = scanner.nextLine();
                String[] array = word.split(";");

                if (array.length == 6) {
                    list.add(new City(array[1], array[2], array[3], Integer.parseInt(array[4]), array[5]));
                } else {
                    System.out.println(Arrays.toString(array) + " ????? The integrity of the template is broken");
                }
            }
            for (City cityList : list) {
                System.out.println(cityList);
            }
        } catch (FileNotFoundException e) {
            System.out.println("We have a problem! File Not Found.");
            e.printStackTrace();
        } finally {
            scanner.close();
        }


        //sort by city name, case-insensitive.
        list.sort((citi1, citi2) ->  citi1.getName().compareToIgnoreCase(citi2.getName()));
        System.out.println("\n After sorting by city name \n");
        list.forEach(System.out::println);


        //sorting by federal district and city name, case-sensitive.
        Collections.sort(list, new CityDistrictAndNameComparator());
        System.out.println("\n After sorting by federal district and city name \n");
        for (City cityList : list) {
            System.out.println(cityList);
        }
        System.out.println();


        //search for the city with the largest number of population
        City[] array = list.toArray(City[]::new);
        int max = array[0].getPopulation();
        int index;
        for (index = 0; index < array.length; index++) {
            if (array[index].getPopulation() > max) {
                max = array[index].getPopulation();
            }
        }
        System.out.println("[" + index + "]" + " = " + max);
        System.out.println();


        //find the number of cities in each region
        int cityCount = 1;
        String region = null;
        list.sort((region1, region2) -> region1.getRegion().compareTo(region2.getRegion()));
        for (int i = 0; i < list.size()-1; i++) {
            region = list.get(i).getRegion();
            if(list.get(i).getRegion().equals(list.get(i+1).getRegion())) {
                cityCount ++;
            }
            else {
                System.out.println(region + " - " + cityCount);
                cityCount = 1;
            }
        }
        System.out.println(region + " - " + cityCount);

    }
}
