public class Q9 {
  public static void main(String[] args) {
    final int SUM = 1000;
    
    for(int a=1;a<SUM;a++){
        for(int b=a+1;b<SUM;b++){
            for(int c=b+1;c<SUM;c++){
                if(a*a+b*b==c*c&&a+b+c==SUM){
                    System.out.println(a*b*c);
                    break;
                }
            }
        }
    }   
  }
}