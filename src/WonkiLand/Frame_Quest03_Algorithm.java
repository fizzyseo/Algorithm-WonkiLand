package WonkiLand;

import java.util.Arrays;
import java.util.Comparator;

public class Frame_Quest03_Algorithm {

    private int numberOfVillages;   // the number of villages
    private int numberOfPaths;      // Number of roads to connect
    private int[][][] roadCosts;    // Road cost information (starting point, destination, cost)

    public Frame_Quest03_Algorithm(int numberOfVillages, int numberOfPaths, int[][][] roadCosts) {
        this.numberOfVillages = numberOfVillages;
        this.numberOfPaths = numberOfPaths;
        this.roadCosts = roadCosts;
    }

    /*
	Calculate the minimum cost of connecting all towns using the Kruskal algorithm
	return minimum cost
     */
    public int calculate() {
    	// Sorting roads according to cost
        Arrays.sort(roadCosts, Comparator.comparingInt(a -> a[2][0]));

        int[] parent = new int[numberOfVillages];
        Arrays.fill(parent, -1);

        int totalCost = 0;

        for (int i = 0; i < numberOfPaths; i++) {
            int source = roadCosts[i][0][0];
            int destination = roadCosts[i][1][0];
            int cost = roadCosts[i][2][0];

            int sourceParent = find(parent, source);
            int destinationParent = find(parent, destination);

         // If two villages belong to different sets, connect and add the cost to the total cost
            if (sourceParent != destinationParent) {
                totalCost += cost;
                union(parent, sourceParent, destinationParent);
            }
        }

        return totalCost;
    }

    /*
    Method of finding the parent of the set to which a given town belongs
    parent : arrangement of villages to find parents
    Village: Village to find parents
    return : the parent of the set to which the village belongs
         */
    private int find(int[] parent, int village) {
        if (parent[village] == -1) {
            return village;
        }
        return find(parent, parent[village]);
    }

    /*
    a way to link two villages together
    parent : arrangement of villages to find parents
    Village1: The first town to connect to
    Village2: the second town to connect to
         */
    private void union(int[] parent, int village1, int village2) {
        int village1Parent = find(parent, village1);
        int village2Parent = find(parent, village2);

        parent[village1Parent] = village2Parent;
    }
}