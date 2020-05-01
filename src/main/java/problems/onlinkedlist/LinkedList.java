package problems.onlinkedlist;
import java.lang.*;
import java.util.*;

public class LinkedList {

static class Node {
    public Node next;
    public int value;
}
static Node head = null;
static int size = 0;
public static void insert_node(int position, int value) {
    if (!(position > 0 && position <= size+1)) return;
    // @params position, integer
    // @params value, integer
    if(head == null){
        head = new Node();
        head.value = value;
    } else {
        int pos = position;
        Node iter = head;
        while(--position > 1)iter = iter.next;

        Node newNode = new Node();
        newNode.value = value;
        if (pos == 1) {
            newNode.next = head;
            head=newNode;
        } else {
            newNode.next = iter.next;
            iter.next = newNode;
        }
    }
    size++;
}

public static void delete_node(int position) {
    if (!(position > 0 && position <= size)) return;

    // @params position, integer
    if(position == 1){
        head = head.next;
    } else {
        Node iter = head;
        while(--position > 1)iter = iter.next;

        iter.next = iter.next.next;
    }
    size--;
}

    public static void print_ll() {
        // Output each element followed by a space
        Node iter = head;
        while(iter != null){
            System.out.print(iter.value);
            if (iter.next!=null){
                System.out.print(" ");
                iter=iter.next;
            } else {
                break;
            }
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int cases=0, position=0, value=0;
        cases = s.nextInt();
        for(int i=0; i<cases; i++) {
            char ch = s.next().charAt(0);
            switch(ch) {
                case 'i':
                    position = s.nextInt();
                    value = s.nextInt();
                    insert_node(position, value);
                    break;
                case 'd':
                    position = s.nextInt();
                    delete_node(position);
                    break;
                case 'p':
                    print_ll();
                    System.out.println();
                    break;
                default:
                    System.out.println("Check Your Input");
            }
        }
    }
}
