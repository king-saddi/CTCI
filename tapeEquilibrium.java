
public class tapeEquilibrium {
	
    public static int sol(int[] A) {
		
        int sumright = 0;
    	int [] B = new int[A.length];
    	
    	
        for (int i =0;i<A.length;i++)
            sumright += A[i];
        
        int sumleft = A[0];
        
        
        for(int i = 1; i<A.length; i++){
        	int x = sumleft - (sumright - sumleft);
        	if(x < 0)
        		B[i] = -1 * x; 
        	else
        		B[i] = x;
        	
        	sumleft = sumleft +A[i];
        }
        
        int temp = B[1];
        for(int i = 2; i<B.length; i++){
        	if (temp>B[i])
        		temp = B[i];
        }
    	return temp;
    	
    	
    	
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {3,1,2,4,3};
		System.out.println(sol(array));
	}

}
