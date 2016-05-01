import java.util.HashSet;

// Java program to remove duplicates from unsorted linked list
 
class LinkedList {
 
    Node head;
 
    static class Node {
 
        int data;
        Node next;
 
        Node(int d) {
            data = d;
            next = null;
        }
    }
 
     /* Function to remove duplicates from a unsorted linked list */
    static void remove_duplicates(Node n) {
    	HashSet<Integer> set = new HashSet<Integer>();
    	Node previous = null;
    	while(n != null){
    		if(set.contains(n.data)){
    			previous.next = n.next;
    		}
    		else{
    			set.add(n.data);
    			previous = n;
    		}
    		
    		n=n.next;
    	}
    }
 
    public int kthToLast(Node n, int k){
    	int length = 0;
    	Node top = n;
    	while(n != null){
    		length++;
    		n = n.next;
    	}
    	n = top;
    	
    	int kth = length -k;
    	for(int j =0; j<kth; j++){
    		n = n.next;
    	}
    	return n.data;
    }
    
    public static void deleteNode(Node n){
    	n.data = n.next.data;
    	n.next = n.next.next;
    }
    
    public static Node partition(Node n, int partition){
    	Node left = new Node(0);
    	Node placeHolderLeft = left;
    	Node right = new Node(0);
    	Node placeHolderRight = right;
    	
    	while(n != null){
    		if(n.data < partition){
    			left.next = new Node(n.data);
    			left = left.next;
    		}
    		else{
    			right.next = new Node(n.data);
    			right = right.next;
    		} 		
    		n = n.next;
    	}
    	left.next = placeHolderRight.next;
    	
    	return placeHolderLeft.next;
    	
    	
    }
    
    public static Node sumLists(Node a, Node b){
    	
    	Node result = new Node(0);
    	Node placeHolder = result;
    	int carry = 0;
    	int sum = 0;
    	while((a != null) || (b != null)){
    		if (a == null){
    			sum = b.data + carry;
    			b = b.next;
    		}
    		else if (b == null){
    			sum = a.data + carry;
    			a = a.next;
    		}
    		else{
    			sum = a.data + b.data + carry;
    			a = a.next;
    			b = b.next;
    		}
    		
			if (sum>=10){
				int append = sum %10;
				result.next = new Node(append);
				result = result.next;
				carry = 1;
			}
			else{
				result.next = new Node(sum);
				result = result.next;
				carry = 0;
			}
			
			
    	}
    	if(carry == 1){
    		result.next = new Node(carry);
    	}

    	return placeHolder.next;
    }
    
    public static boolean palindrome(Node node){
    	Node opposite = null;
    	Node placeHolder = node;
    	
    	while(node != null){
    		Node temp =opposite;
    		opposite = new Node(node.data);
    		opposite.next = temp;
    		
    		node = node.next;
    	}
    	
    	while(placeHolder != null){
    		if(placeHolder.data == opposite.data){
    			placeHolder = placeHolder.next;
    			opposite = opposite.next;
    		}
    		else
    			return false;
    	}
    	
    	return true;
    }
/*  //Unoptimal O(A+B) 
    public static Node intersection(Node a, Node b){
    	Node temp = b;
    	while(a != null){
    		while(b != null){
    			if(a == b){
    				return a;
    			}
    			else b = b.next;
    		}
    		a = a.next;
    		b = temp;
    	}
    	
    	return null;
    }
*/
    
    // works if there is no circular list as input,
    // more optimal than above: O(A+B)
    public static Node intersection(Node a, Node b){
    	HashSet<Node> match = new HashSet<Node>();
    	while(a != null){
    		match.add(a);
    		a = a.next;
    	}
    	
    	while(b != null){
    		if (match.contains(b)){
    			return b;
    		}
    		else {
    			match.add(b);
    		};
    		b = b.next;
    	}
    	
    	return null;
    }
    public static int circular(Node a){
    	
    	Node slow = a.next;
    	Node fast = a.next.next;
    	while(fast != null){
    		if(slow == fast){
    			break;
    		}
    		else{
    			slow = slow.next;
    			fast = fast.next.next;
    		}
    	}
    	
    	// not a circular loop input
    	if (fast == null){
    		return 0;
    	}
    	
    	slow = a;
    	while(slow != null){
    		if (slow == fast){
    			return fast.data;
    		}
    		else{
    			slow = slow.next;
    			fast = fast.next;
    		}
    	}
    	
    	return 0;
    	
    }
    
    
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
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
        printList(list.head);
        System.out.println();
        System.out.println("The kth to last element is: " + list.kthToLast(list.head, 7));
        System.out.println("");
        System.out.println("Linked List after removing duplicates");
        remove_duplicates(list.head);
        printList(list.head);
        
        Node n = new Node(3);
        n.next = new Node(5);
        n.next.next = new Node(8);
        n.next.next.next = new Node(5);
        n.next.next.next.next = new Node(10);
        n.next.next.next.next.next = new Node(2);
        n.next.next.next.next.next.next = new Node(1);
        
        System.out.println();
        printList(n);
        //deleteNode(n.next.next);
        n = partition(n, 5);
        
        System.out.println();
        printList(n);
        System.out.println();
        Node a = new Node(7);
        a.next = new Node(1);
        a.next.next = new Node(7);
        
        Node b = new Node(5);
        b.next = new Node(9);
        b.next.next = new Node(2);
        
        
        Node result = sumLists(a, b);
        System.out.println("The sum is: ");
        printList(result);
        System.out.println();
        
        Node c = new Node(5);
        c.next = new Node(9);
        c.next.next = new Node(6);
        System.out.println("The palindrome is: " + palindrome(c));
        System.out.println();
        
        System.out.println("The intersecting node is: ");
        
        Node d = new Node(5);
        d.next = new Node(9);
        d.next.next = c;
        
        Node intersect = intersection(d, c);
        printList(intersect);
        
        Node circle = new Node(5);
        circle.next = new Node(9);
        circle.next.next = new Node(6);
        circle.next.next.next = new Node(7);
        circle.next.next.next.next = new Node(8);
        circle.next.next.next.next.next = circle.next.next.next;
        System.out.println("The start of the circle is: " + circular(circle));
        
    }
}