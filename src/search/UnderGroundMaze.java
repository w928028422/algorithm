package search;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class UnderGroundMaze {

    public static LinkedList<Point> res = new LinkedList<>();

    public static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "[" + x + "," + y + "]";
        }
    }

    public static void search(LinkedList<Point> list, int[][] maze, int power, int row, int col){
        if (power < 0){
            return;
        }
        Point point = new Point(row,col);
        if (row >= 0 && row < maze.length && col >= 0 && col < maze[0].length
                && maze[row][col] == 1){
            list.offer(point);
            maze[row][col] = 0;
            if (row == 0 && col == maze.length - 1){
                res.addAll(list);
                return;
            }
            search(list, maze, power - 1, row, col + 1);
            search(list, maze, power - 1, row, col - 1);
            search(list, maze, power - 3, row - 1, col);
            search(list, maze, power, row + 1, col);
            list.removeLast();
            maze[row][col] = 1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt(), power = scanner.nextInt();
        int[][] maze = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maze[i][j] = scanner.nextInt();
            }
        }
        search(new LinkedList<>(), maze, power, 0, 0);
        if (res.size() == 0){
            System.out.println("Can not escape!");
        }else{
            System.out.print(res.getFirst());
            for (Point point : res){
                if (point != res.getFirst()) {
                    System.out.print("," + point);
                }
            }
            System.out.println();
        }
    }
}
