package pkg01;

class Node {

    int data;
    Node next;

    public Node(int x) {
        data = x;
        next = null;
    }
}

class LinkedList {

    Node head, tail;

    public LinkedList() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addTail(int x) {
        addAfter(new Node(x), tail);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Node t = head; t != null; t = t.next) {
            s.append(t.data).append("-");
        }
        return s.toString();
//        String s = "";
//        for(Node t = head; t!=null; t = t.next){
//            s += t+ "-";
//        }
//        return s.toString();
    }

    public void addHead(int x) {
        addAfter(new Node(x), null);
    }

    void addAfter(Node t, Node pred) {
        if (pred == null) { //Insert the head
            t.next = head;
            head = t;
        } else {
            t.next = pred.next;
            pred.next = t;
            if (pred == tail) {
                tail = t;
            }
        }
    }
    
     public void addIndex(int x, int k) {
        Node[] res = search(k);
        addAfter(new Node(x), res[0]);
    }

    public Node[] search(int k) {
        int i = 0;
        Node t = head;
        Node pred = null;
        while (i < k && t != null) {
            i++;
            pred = t;
            t = t.next;
        }
        return new Node[] { t, pred };
    }
}


public class Link_list {

    public static void main(String[] args) {
        LinkedList L = new LinkedList();
        L.addTail(5);
        L.addTail(2);
        L.addTail(3);
        L.addTail(6);
        System.out.println("The List " + L.toString());
        L.addHead(0);
        System.out.println("The List " + L.toString());
        L.addIndex(9, 2);
        System.out.println("The List " + L.toString());

    }
}
