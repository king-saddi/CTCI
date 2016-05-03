	import java.util.EmptyStackException;

	public class MyStack {
		private static class StackNode<T> {
			private Integer data;
			private StackNode<Integer> next;
			
			public StackNode(Integer data) {
				this.data = data;
			}
			
			public Integer getData() {
				return data;
			}
		}
		
		private StackNode<Integer> top;
		private StackNode<Integer> minimum;		// needed for minimum stack

		public Integer pop() {
			if (top == null) throw new EmptyStackException();
			Integer item = top.getData();
			top = top.next;
			return item;
		}

		public void push(Integer item) { 
			StackNode<Integer> t = new StackNode<Integer>(item);
			t.next = top;
			top = t;
			
			if(minimum == null){
				StackNode<Integer> m = new StackNode<Integer>(item);
				m.next = minimum;
				minimum = t;
			}
			else if((int)top.data < (int)minimum.data){
				StackNode<Integer> m = new StackNode<Integer>(top.data);
				m.next = minimum;
				minimum = m;
			}
			else{
				StackNode<Integer> m = new StackNode<Integer>(minimum.data);
				m.next = minimum;
				minimum = m;
			}
		} 

		public Integer peek() {
			if (top == null) throw new EmptyStackException();
			return top.data;
		}
		
		public boolean isEmpty() {
			return top == null;
		}
		
		public Integer minimum(){
			if (minimum == null) throw new EmptyStackException();
			return minimum.data;
		}
		
	}