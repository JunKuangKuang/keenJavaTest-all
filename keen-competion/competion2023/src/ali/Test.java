package ali;

/*
* 翻转单向链表
* */

public class Test {
    /**单向链表定义**/
    static class Node<T> {
        private T value;    //节点值
        private Node<T> next;   //后继节点

        public Node() {
        }
        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Node head=new Node<Integer>(1,null);
        head.next=new Node<Integer>(3,null);
        System.out.println(head.next.value);
        Node<Integer> res =reverse(head);

        while(res!=null){
            System.out.println(res.value);
            res=res.next;
        }

    }

    public static Node reverse(Node head){
        if(head==null||head.next==null){
            return head;
        }
        Node temp=new Node<Integer>((Integer) head.value,null);
        head=head.next;
        return temp;
    }


}
