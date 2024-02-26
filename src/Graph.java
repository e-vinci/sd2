import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

  private Map<Integer, String> cities;
  private Map<Integer, List<Double>> coordinates;
  private Map<Integer, Integer> roads;

  public Graph (File cities, File roads){

    this.cities = new HashMap<>();
    this.coordinates = new HashMap<>();
    this.roads = new HashMap<>();

    // Lire le fichier des villes
    try (BufferedReader brCities = new BufferedReader(new FileReader(cities))) {
      String cityLine;
      while ((cityLine = brCities.readLine()) != null) {

        String[] city = cityLine.split(",");
        this.cities.put(Integer.parseInt(city[0]), city[1]);
        this.coordinates.put(Integer.parseInt(city[0]), new ArrayList<>());
        coordinates.get(Integer.parseInt(city[0])).add(Double.parseDouble(city[2]));
        coordinates.get(Integer.parseInt(city[0])).add(Double.parseDouble(city[3]));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    // Lire le fichier des routes
    try (BufferedReader brRoads = new BufferedReader(new FileReader(roads))) {
      String roadLine;
      while ((roadLine = brRoads.readLine()) != null) {

        String[] city = roadLine.split(",");
        this.roads.put(Integer.parseInt(city[0]), Integer.parseInt(city[1]));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    System.out.println(this.cities);
    System.out.println(this.coordinates);
    System.out.println(this.roads);
  }

  public void calculerItineraireMinimisantNombreRoutes(String ville1, String ville2){

  }

  public void calculerItineraireMinimisantKm(String ville1, String ville2){

  }

}
