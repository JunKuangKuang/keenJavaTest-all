package leetcode.两数相加2;

import java.util.ArrayDeque;
import java.util.Deque;

/*提供两个链表，非空且链表节点的值为非负整数。
数字最高位位于链表开始位置，每个节点只存储一位数字，
即0~9, 如l1=[3,5,5,8], 链表表示为3->5->5->8

请将两个链表的数相加返回一个新的链表。如下示例：

提示：假设除了数字0之外，这两个数字都不会以零开头。

示例1：
        输入：l1 = [9,3,6,8], l2 = [2,5,1]
        输出：[9,6,1,9]

        示例2：
        输入：l1 = [3,4,2], l2 = [1,6,6]
        输出：[5,0,8]

        示例3：
        输入：l1 = [0], l2 = [0]
        输出：[0]

        提示：
        链表的长度范围为 [1, 100]
        0 <= node.val <= 9
        输入数据保证链表代表的数字无前导 0

*/
public class Main {
    // 数字最高位位于链表开始位置，每个节点只存储一位数字，
    // 即0~9, 如l1=[3,5,5,8], 链表表示为3->5->5->8
    public static void main(String[] args) {
        // System.out.println("123");
        ListNode l1 = new ListNode(3);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(2);
        // l1.next.next.next = new ListNode(8);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(6);

        ListNode sum = sum(l1, l2);
        while (sum != null) {
            System.out.print(sum.val);
            sum = sum.next;
        }


    }

    public static ListNode sum(ListNode l1, ListNode l2) {
        Deque<Integer> d1 = new ArrayDeque<>();
        Deque<Integer> d2 = new ArrayDeque<>();

        while (l1 != null) {
            d1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            d2.push(l2.val);
            l2 = l2.next;
        }
        // 完成了压入队列
        ListNode res = new ListNode(-1);
        ListNode resTemp = res;

        int add = 0;

        int a = 0;
        int b = 0;
        while (!d1.isEmpty() || !d2.isEmpty()) {
            ListNode temp = new ListNode();
            resTemp.next = temp;

            a = 0;
            if (!d1.isEmpty()) {
                a = d1.pop();
            }

            b = 0;
            if (!d2.isEmpty()) {
                b = d2.pop();
            }

            int sumTemp = a + b + add;
            if (sumTemp >= 10) {
                sumTemp = sumTemp - 10;
                temp.val = sumTemp;
                add = 1;
            } else {
                temp.val = sumTemp;
                add = 0;
            }

            // 链表后移一位
            resTemp = temp;
        }

        ListNode newRes = null;
        ListNode newResTemp = newRes;
        res=res.next;
        while (res != null) {
            newRes=new ListNode(res.val,newRes);
            res=res.next;
        }


        return newRes;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}