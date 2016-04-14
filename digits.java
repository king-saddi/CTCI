
public class digits {
	    public static int addDigits(int num) {
	        
	        int sum = 0;
	        while(num != 0){
	            sum = sum + num%10;
	            num = num/10;
	        }
	        if(sum > 9)
	            return(addDigits(sum));
	        else
	        	return sum;
	        
	        
	        
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(addDigits(38));
	}

}
