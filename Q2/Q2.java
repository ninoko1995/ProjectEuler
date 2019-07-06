public class Q2 {
  public static boolean is_even(int num){
    boolean even = true;
    if(num % 2 != 0){
        even = false;
    }
    return even;
  }

  public static void main(String[] args) {
    int sum=0;
    int prev = 1;
    int now = 2;
    int next;
    final int LIMIT = 4000000;
    
    while(true){
        if(now>LIMIT)break;
        if(is_even(now))sum+=now;
        next = now+prev;
        prev=now;
        now=next;   
    }
    System.out.println(sum);
  }
}