import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
  }

  public void calculerItineraireMinimisantNombreRoutes(String source, String destination) {
    Queue<Integer> file = new LinkedList<>();
    Set<Integer> villesVisitees = new HashSet<>();
    Map<Integer, Integer> origine = new HashMap<>();

    int villeActuelle = citiesToInt.get(source);
    boolean arrive = false;

    while (!arrive) {
      for (int i : roads.get(villeActuelle)) {
        if (!file.contains(i) && !villesVisitees.contains(i)) {
          file.add(i);
          origine.put(i, villeActuelle);
        }
      }
      int villeSuivante = file.poll();
      villesVisitees.add(villeSuivante);

      if (!intToCities.get(villeSuivante).equals(destination)) {
        if (file.isEmpty()) {
          throw new RuntimeException();
        }
        villeActuelle = villeSuivante;
      }
      else {
        arrive = true;
      }
    }

    int to = citiesToInt.get(destination);
    int from;
    boolean revenu = false;
    String s = "";
    int nbRoutes = 0;
    double nbKm = 0;

    while(!revenu){
      from = origine.get(to);
      double distance = Util.distance(coordinates.get(from).get(0), coordinates.get(from).get(1),
          coordinates.get(to).get(0), coordinates.get(to).get(1));

      s = intToCities.get(from) + " -> " + intToCities.get(to) + " (" + String.format("%.2f", distance) + " km)\n" + s;

      nbRoutes++;
      nbKm += distance;

      to = from;
      if(from == citiesToInt.get(source))
        revenu = true;
    }
    s = "Itinéraire de " + source + " à " + destination + ": " + nbRoutes + " routes et " + nbKm + " km\n" + s;
    System.out.println(s);
  }

  public void calculerItineraireMinimisantKm(String source, String destination){

  }


}
