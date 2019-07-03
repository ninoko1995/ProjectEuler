public class q5 {
    //please confirm "x<y"
    public static int greatest_common_deviser(int x,int y){
        int gcd = 1;
        for(int i=1;i<=x;i++){
            if(x%i==0&&y%i==0)gcd=i;
        }
        return gcd;
    }

    public static void main(String[] args) {
        int start = 1;
        int end = 20;
        int ans = 1;
        int gcd;

        for(int i=start;i<=end;i++){
            gcd=greatest_common_deviser(i,ans);
            if(gcd!=i){
                ans*=(i/gcd);
            }
        }
        System.out.println(ans);
    }
}