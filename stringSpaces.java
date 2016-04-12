public class stringSpaces {
	
	public static void addTwenty(char[] str, int length){

        int spaceCount = 0, newLength = 0, i = 0;

        for(i = 0; i < length; i++) {
            if (str[i] == ' ') 
                spaceCount++;
        }
        newLength = length + (spaceCount * 2);
        char[] str2 = new char[newLength];
        str2[newLength-1] = '\0';
        
        for(i = length - 1; i >= 0; i--) {
        	if (str[i] == ' ') {
                str2[newLength - 1] = '0';
                str2[newLength - 2] = '2';
                str2[newLength - 3] = '%';
                newLength = newLength - 3;
            }
            else {
                str2[newLength - 1] = str[i];
                newLength = newLength - 1;
            }
        }
        System.out.println(str2);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String word = "The big dog";
		int length = word.length();
		char[] send = word.toCharArray();
		addTwenty(send, length);
	}

}
