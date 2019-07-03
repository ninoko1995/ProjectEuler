public class q7 {
    public static boolean is_prime(int num){
        boolean res = true;
        for(int i=2;i<=num/2;i++){
            if(num%i==0&&i!=num){
                res=false;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int num=10001;
        //int num=6;
        int now=0;
        int target=0;
        int i = 2;
        while(true){
            if(is_prime(i)){
                now++;
                //System.out.println(i);
            }
            if(now==num){
                target = i;
                break;
            }
            i++;
        }
        System.out.println(target);
    }
}