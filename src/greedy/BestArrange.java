package greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 一个会议室里要完成几个项目，每个项目有其开始时间和结束时间，如何安排能完成最多的项目？
 */
public class BestArrange {
    public static class Program{
        int start;
        int end;

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static int solution(Program[] programs, int cur){
        Arrays.sort(programs, Comparator.comparingInt(a -> a.end));
        int res = 0;
        for (Program program : programs){
            if (cur <= program.start){
                res++;
                cur = program.end;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] starts = new int[]{14,2,18,3,5,17,25,30,9,20};
        int[] ends = new int[]{17,5,20,4,10,19,30,32,11,24};
        Program[] programs = new Program[starts.length];
        for (int i = 0; i < starts.length; i++) {
            programs[i] = new Program(starts[i], ends[i]);
        }
        System.out.println(solution(programs, 1));
    }
}
