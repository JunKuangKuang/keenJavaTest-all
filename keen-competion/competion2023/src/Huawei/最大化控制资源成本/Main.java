package Huawei.最大化控制资源成本;

import java.util.Scanner;
import java.util.*;

class Main {
	public static void main(String[] args) {
        // 输入信息并保存成为数据
        Scanner in = new Scanner(System.in);
        int taskNum = in.nextInt();
        int[][] tasks = new int[taskNum][3];
        for (int i = 0; i < taskNum; i++) {
            tasks[i][0] = in.nextInt();
            tasks[i][1] = in.nextInt();
            tasks[i][2] = in.nextInt();
        }

        // 按照开始时间从小到大进行冒泡排序
        Arrays.sort(tasks, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        // 调用后输出结果
        System.out.println(controlOfResourceCosts(tasks));
	}

    public static int controlOfResourceCosts(int[][] tasks) {
        // 从小到大的空的优先级队列
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // 结果数
        int res = 0;
        int temp_res = 0;

        for (int i = 0; i < tasks.length; i++) {
            while (pq.size() > 0) {
                Integer[] top = pq.peek();
                /*
                * 用正运行着的任务的结束时间点，来比对是否有下一个任务需要运行
                * 如果没有在运行的任务就减少服务器数量，如果有就继续运行，
                * */
                if (top[0] < tasks[i][0]) {
                    Integer[] poll = pq.poll();
                    temp_res -= poll[1];
                } else {
                    break;
                }
            }

            pq.offer(new Integer[] {tasks[i][1], tasks[i][2]});
            temp_res += tasks[i][2];

            // 更新结果
            if (temp_res > res) {
                res = temp_res;
            }
        }
        return res;
    }

}