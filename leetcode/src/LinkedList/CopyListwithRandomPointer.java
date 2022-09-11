package LinkedList;

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class CopyListwithRandomPointer {
    public Node copyRandomList(Node head) {

        if(head == null)return null;

        Node curr = head;

        while(curr != null){

            Node next = curr.next;
            Node nn = new Node(curr.val);
            curr.next = nn;
            nn.next = next;
            curr = next;
        }

        curr = head;

        //Set Random Pointer

        while(curr != null){

            Node Random = curr.random;

            if(Random != null){
                curr.next.random = Random.next;
            }

            curr = curr.next.next;
        }

        //Update Pointer

        Node dummy = new Node(-1);
        Node p = dummy;
        curr = head;

        while(curr != null){
            p.next = curr.next;
            p = p.next;
            curr.next = p.next;
            curr = curr.next;
        }

        return dummy.next;

    }
}