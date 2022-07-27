import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

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
                    list.add(new City(array[1], array[2], array[3], array[4], array[5]));
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

    }
}
