package TwoPointers;

public class ReorderList {

    /*
    EXPLANATION:-
Given a list  1 ->  2 -> 3 -> 4 -> 5
Now we need to reorder it like 1 -> 5 -> 2 -> 4 -> 3

How can we do this?
consider list elements as L1, L2, .... , Ln-1, Ln.
we need
L1 -> Ln -> L2 -> Ln-1 -> . . .
Now, if we maintain a pointer at each end,
then we can arrange them alternatively.
left = L1, right = Ln
Now 1st iteration
List => L1 -> Ln

2nd iteration
left = L2, right = Ln-1
List => L1 -> Ln -> L2 -> Ln-1

3rd iteration
left = l3, right = Ln-2
This process continues until all elements are processed.

Here, the problem is if we maintain a pointer at last element in the list
we can't move to it's previous element after
it is processed since it is single linked list.

So, to do this, we split the list in two halves and
reverse the second half.
List = 1 -> 2 -> 3 > 4 -> 5
After splitting:-
L1 = 1 -> 2
L2 = 3 -> 4 -> 5
Now, we need to reverse second list
So, L2 = 5 -> 4 -> 3

Now, insert each element in 2 lists alternatively.
1 -> 5 -> 2 -> 4 -> 3

This is how we can get the result.
     */

    public ListNode reverse(ListNode head){
        ListNode p1 = head;
        ListNode p2 = head.next;
        p1.next = null;
        while(p2 != null){
            ListNode temp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = temp;
        }
        return p1;
    }
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return ;
        ListNode slowPtr = head, fastPtr = head;
        ListNode prev = head;
        // splitting list
        while(fastPtr != null && fastPtr.next != null){
            prev = slowPtr;
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        prev.next = null;
        // reverse
        ListNode rev = reverse(slowPtr);
        ListNode ptr = head;
        // arrange alternatively
        while(ptr != null){
            ListNode t1 = ptr.next;
            ListNode t2 = rev.next;
            ptr.next = rev;
            if(t1 != null)
                rev.next = t1;
            ptr = t1;
            rev = t2;
        }
    }
    /*  Second Solution
    public void reorderList(ListNode head) {
        ListNode [] left =  new ListNode[1];// it will create in heap
        left[0]  =  head;
        reorder(left,head);

    }

    // left pointer will be created in heap and right pointer will be created in stack
    public void reorder(ListNode left[],ListNode right){
        if(right==null){
            return ;
        }
        reorder(left,right.next);

        // in post area of recursion right pointer coming back(because of function remove from recursion stack)
        // and we move left pointer forward
        if(left[0].next!=null){
            ListNode leftNext =  left[0].next;
            left[0].next =  right;
            right.next =  leftNext;
            left[0] =  leftNext;
        }

        // as we need to  merge till left pointer behind the right pointer
        if(left[0].next == right){
            left[0].next =  null;
        }
    }

     */
}
