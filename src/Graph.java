import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

  private Map<Integer, String> intToCities;
  private Map<String, Integer> citiesToInt;
  private Map<Integer, List<Double>> coordinates;
  private Map<Integer, Integer> roads;

  public Graph (File cities, File roads){

    this.intToCities = new HashMap<>();
    this.citiesToInt = new HashMap<>();
    this.coordinates = new HashMap<>();
    this.roads = new HashMap<>();

    // Lire le fichier des villes
    try (BufferedReader brCities = new BufferedReader(new FileReader(cities))) {
      String cityLine;
      while ((cityLine = brCities.readLine()) != null) {

        String[] city = cityLine.split(",");
        this.intToCities.put(Integer.parseInt(city[0]), city[1]);
        this.citiesToInt.put(city[1], Integer.parseInt(city[0]));
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

    System.out.println(this.intToCities);
    System.out.println(this.citiesToInt);
    System.out.println(this.coordinates);
    System.out.println(this.roads);
  }

  public void calculerItineraireMinimisantNombreRoutes(String source, String destination){

  }

  public void calculerItineraireMinimisantKm(String source, String destination){

  }

}
