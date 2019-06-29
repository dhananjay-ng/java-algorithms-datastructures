package problems.onsorting;

public class MergeTwoSortedLinkedListInReverseOrder {
    Node mergeResult(Node node1, Node node2)
    {
        Node sortAsc = merge(node1, node2);
        Node sortDsc = reverse(sortAsc);

        return sortDsc;

    }
    Node reverse(Node head) {
        Node sortDsc = new Node(-1);
        sortDsc.next = head;
        Node cur = head;
        while(cur!= null && cur.next!=null) {
            Node prevNxt = sortDsc.next;
            sortDsc.next = cur.next;
            cur.next = cur.next.next;
            sortDsc.next.next = prevNxt;
        }
        return sortDsc.next;
    }

    Node merge(Node node1, Node node2) {
        Node result;
        if(node1 == null) return node2;
        if(node2 == null) return node1;

        if(node1.data <= node2.data){
            result = node1;
            result.next = merge(node1.next, node2);
        } else{
            result = node2;
            result.next = merge(node1, node2.next);
        }
        return result;
    }
}
