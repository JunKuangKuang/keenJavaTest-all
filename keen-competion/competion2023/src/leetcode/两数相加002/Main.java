package leetcode.两数相加002;

import java.util.List;

public class Main {

    static class Solution {
        public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode res = new ListNode();

            ListNode resTemp = res; //定义头节点的副本node3
            // 记录进位
            // boolean flag=false;
            int add = 0;
            int a = 0;
            int b = 0;
            while (l1 != null || l2 != null) {
                ListNode temp = new ListNode(-1); //定义node的后继节点
                resTemp.next = temp;

                a = 0;
                if (l1 != null) {
                    a = l1.val;
                }

                b = 0;
                if (l2 != null) {
                    b = l2.val;
                }
                int c = a + b + add;

                //进行判断；若c >= 10 则产生进位值
                if (c >= 10) {
                    c = c - 10;
                    temp.val = c;
                    add = 1;
                } else {
                    temp.val = c;
                    add = 0;
                }

                //各节点往后走一步
                resTemp = resTemp.next;
                if (l1 != null) {
                    l1 = l1.next;
                }
                if (l2 != null) {
                    l2 = l2.next;
                }

            }

            if (add == 1) {
                resTemp.next = new ListNode(add);
            }

            // 不能直接返回res，因为头结点的值为0
            return res.next;
        }
    }

    /*
     * Definition for singly-linked list.
     * */
    public static class ListNode {
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

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode res = Solution.addTwoNumbers(l1, l2);
        // ListNode res = l1;
        while (res != null) {
            System.out.print(res.val);
            res = res.next;
        }


    }
}