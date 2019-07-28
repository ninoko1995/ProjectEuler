public class Q95 {
  public static void main(String[] args) {
    final int LIMIT = 1000;

    int sum = 0;
    int i = 1;
    
    while(i<LIMIT){
        if(i%3==0 || i%5==0){
            sum+=i;
        }
        i++;	    	
    }
    
    System.out.println(sum);
  }
}