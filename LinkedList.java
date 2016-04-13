class LinkedList {

    static Node head;

    static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    /* Function to remove duplicates from a unsorted linked list */
    void remove_duplicates() {
        Node ptr1 = null, ptr2 = null, dup = null;
        ptr1 = head;

        /* Pick elements one by one */
        while (ptr1 != null && ptr1.next != null) {
            ptr2 = ptr1;

            /* Compare the picked element with rest of the elements */
            while (ptr2.next != null) {

                /* If duplicate then delete it */
                if (ptr1.data == ptr2.next.data) {

                    /* sequence of steps is important here */
                    dup = ptr2.next;
                    ptr2.next = ptr2.next.next;
                    System.gc();
                } else /* This is tricky */ {
                    ptr2 = ptr2.next;
                }
            }
            ptr1 = ptr1.next;
        }
    }

    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    
    public static int nthLast(Node list, int n){
    	int length = 0;
    	Node tmp = null;
    	tmp = list;
    	
    	while(tmp != null){
    		length++;
    		tmp = tmp.next;
    	}
    

    	int nth = length -n;
    	for(int j =0; j<nth; j++){
    		list = list.next;
    	}
    	
    	System.out.println(list.data);
    		return list.data;
    }
    
    public static void delete(Node c){
    	if(c == null || c.next == null)
    		System.out.println("Can not delete the last node in a linked list");
    	else{
    	c.data = c.next.data;
    	
    	c.next = c.next.next;
    	}
    }

    static Node addTwoLists(Node first, Node second) {
        Node res = null; // res is head node of the resultant list
        Node prev = null;
        Node temp = null;
        int carry = 0;
        int sum = 0;
 
        while (first != null || second != null) //while both lists exist
        {
           
        	if(first != null){
        		sum = sum + first.data;
        	}
        	if(second != null){
        		sum = sum + second.data;
        	}
 
            sum = sum + carry;
            System.out.println(sum);
            carry = (sum >= 10) ? 1 : 0;
            sum = sum % 10;
 
            // Create a new node with sum as data
            temp = new Node(sum);
            sum = 0;
            if (res == null) {
                res = temp;
            } else 
            {
                prev.next = temp;
            }
            prev = temp;
 
            // Move first and second pointers to next nodes
            if (first != null) {
                first = first.next;
            }
            if (second != null) {
                second = second.next;
            }
            
        }
 
        if (carry > 0) {
            temp.next = new Node(carry);
        }
 
        // return head of the resultant list
        return res;
    }
    
    
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.head = new Node(10);
        list.head.next = new Node(12);
        list.head.next.next = new Node(11);
        list.head.next.next.next = new Node(11);
        list.head.next.next.next.next = new Node(12);
        list.head.next.next.next.next.next = new Node(11);
        list.head.next.next.next.next.next.next = new Node(10);

        
        
        System.out.println("Linked List before removing duplicates ");
        list.printList(head);
        list.remove_duplicates();
        System.out.println("");
        System.out.println("Linked List after removing duplicates");
        list.printList(head);
        System.out.println();
        
        System.out.println("The nth to last node is: ");
        nthLast(head, 2);
        
        System.out.println();
        delete(head.next);
        System.out.println("After calling delete: ");
        list.printList(head);
        System.out.println();
        System.out.println("After adding the two lists: ");
        
        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next= new Node(8);
        
        Node head3 = head2;
        
        list.printList(addTwoLists(head3, head2));
    }
}