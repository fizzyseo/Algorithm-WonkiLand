package WonkiLand;

import java.util.Arrays;
import java.util.Comparator;

public class Frame_Quest03_Algorithm {

    private int numberOfVillages;   // 마을의 수
    private int numberOfPaths;      // 연결할 도로의 수
    private int[][][] roadCosts;    // 도로 비용 정보 (출발지, 목적지, 비용)

    public Frame_Quest03_Algorithm(int numberOfVillages, int numberOfPaths, int[][][] roadCosts) {
        this.numberOfVillages = numberOfVillages;
        this.numberOfPaths = numberOfPaths;
        this.roadCosts = roadCosts;
    }

    /*
     Kruskal 알고리즘을 사용하여 모든 마을을 연결하는 최소 비용을 계산
     return 최소 비용
     */
    public int calculate() {
        // 도로를 비용에 따라 정렬
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

            // 두 마을이 서로 다른 집합에 속해 있으면 연결하고 비용을 총 비용에 추가
            if (sourceParent != destinationParent) {
                totalCost += cost;
                union(parent, sourceParent, destinationParent);
            }
        }

        return totalCost;
    }

    /*
     주어진 마을이 속한 집합의 부모를 찾는 메서드
     parent  부모를 찾을 마을 배열
     village 부모를 찾을 마을
     return 마을이 속한 집합의 부모
     */
    private int find(int[] parent, int village) {
        if (parent[village] == -1) {
            return village;
        }
        return find(parent, parent[village]);
    }

    /*
     두 마을을 서로 연결하는 메서드
     parent    부모를 찾을 마을 배열
     village1  연결할 첫 번째 마을
     village2  연결할 두 번째 마을
     */
    private void union(int[] parent, int village1, int village2) {
        int village1Parent = find(parent, village1);
        int village2Parent = find(parent, village2);

        parent[village1Parent] = village2Parent;
    }
}