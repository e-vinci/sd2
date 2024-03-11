import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Graph {

  private Map<Integer, String> intToCities;
  private Map<String, Integer> citiesToInt;
  private Map<Integer, List<Double>> coordinates;
  private Map<Integer, Set<Integer>> roads;

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

        String[] road = roadLine.split(",");
        if(this.roads.get(Integer.parseInt(road[0])) == null)
          this.roads.put(Integer.parseInt(road[0]), new HashSet<>());
        this.roads.get(Integer.parseInt(road[0])).add(Integer.parseInt(road[1]));
        if(this.roads.get(Integer.parseInt(road[1])) == null)
          this.roads.put(Integer.parseInt(road[1]), new HashSet<>());
        this.roads.get(Integer.parseInt(road[1])).add(Integer.parseInt(road[0]));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println(this.roads);
  }

  public void calculerItineraireMinimisantNombreRoutes(String source, String destination){
    // UNE FILE ET UN ENSEMBLE DES SOMMETS DEJA VISITES
    Queue<Integer> aVisiter = new LinkedList<>();
    Set<Integer> villesVisitees = new HashSet<>();

    villesVisitees.add(citiesToInt.get(source));
    int villeActuelle = citiesToInt.get(source);
    boolean arrive = false;
    int nombreRoutes = 0;
    while(!arrive){
      //aVisiter.addAll(roadsSourceDestination.get())
    }
  }

  public void calculerItineraireMinimisantKm(String source, String destination){
    double[] chemins = new double[intToCities.size()];
    double[] etiquettes = new double[intToCities.size()];

    int numSource = citiesToInt.get(source);
    chemins[numSource] = 0;
    etiquettes[numSource] = 0;

    double latSource = coordinates.get(citiesToInt.get(source)).get(1);
    double lonSource = coordinates.get(citiesToInt.get(source)).get(0);


  }


}
