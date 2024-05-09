/*
 * There are n cities numbered from 0 to n-1. Given the array edges where
 * edges[i] = [fromi, toi, weighti] represents a bidirectional and weighted edge
 * between cities fromi and toi, and given the integer distanceThreshold.
 * 
 * Return the city with the smallest number of cities that are reachable through
 * some path and whose distance is at most distanceThreshold, If there are
 * multiple such cities, return the city with the greatest number.
 * 
 * Notice that the distance of a path connecting cities i and j is equal to the
 * sum of the edges' weights along that path.
 */

class FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance {

    // Time -> O(n^3) //
    // Space -> O(n^2) //

    private static int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int m = edges.length;

        int[][] dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];

            dist[u][v] = wt;
            dist[v][u] = wt;
        }

        for (int i = 0; i < n; i++) {
            dist[i][i] = 0;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE) {
                        continue;
                    }
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int countCities = n;
        int cityNo = -1;

        for (int city = 0; city < n; city++) {
            int count = 0;

            for (int adjCity = 0; adjCity < n; adjCity++) {
                if (dist[city][adjCity] <= distanceThreshold) {
                    count++;
                }
            }

            if (count <= countCities) {
                countCities = count;
                cityNo = city;
            }
        }

        return cityNo;
    }

    public static void main(String[] args) {
        int n = 4;

        int[][] edges = {
                { 0, 1, 3 },
                { 1, 2, 1 },
                { 1, 3, 4 },
                { 2, 3, 1 },
        };

        int distanceThreshold = 4;

        System.out.println(findTheCity(n, edges, distanceThreshold));
    }
}