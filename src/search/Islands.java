package search;

public class Islands {

    public static int solution(int[][] map){
        if (map == null){
            return 0;
        }
        int n = map.length, m = map[0].length, res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1){
                    res++;
                    infect(i, j, n, m, map);
                }
            }
        }
        return res;
    }

    private static void infect(int i, int j, int n, int m, int[][] map) {
        if ((i < 0 || i >= n) || (j < 0 || j >= m) || map[i][j] != 1){
            return;
        }
        map[i][j] = 2;
        infect(i, j + 1, n, m, map);
        infect(i, j - 1, n, m, map);
        infect(i + 1, j, n, m, map);
        infect(i - 1, j, n, m, map);
    }

    public static void main(String[] args) {
        int[][] map = new int[4][6];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = (int) (Math.random() * 2);
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(solution(map));
    }
}
