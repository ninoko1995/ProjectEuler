public class q1 {
  public static void main(String[] args) {
    int sum = 0;
    int max = 1000;
    int x1 = 3;
    int x2 = 5;

    int multiple = 0;
    int x  = x1;
    int i=0;

    while(true){
    	i++;
    	multiple = i*x;
    	if(multiple>=max)break;
    	sum+=multiple;
    	
    }

    multiple = 0;
    x=x2;
    i=0;

    while(true){
    	i++;
    	multiple=i*x;
    	if(multiple>=max)break;
    	if(multiple%x1!=0){
    		sum+=multiple;
    	}
    	
    }
    System.out.println(sum);
  }
}