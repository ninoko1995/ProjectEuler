public class q4 {

    public static boolean is_palindromic(int num){
        boolean res = false;
        
        StringBuffer sb = new StringBuffer(String.valueOf(num));
        int reverse = Integer.parseInt(sb.reverse().toString());

        if(num%reverse==0&&num/reverse==1)res=true;
        return res;
    }

    public static void main(String[] args) {
        int start=100;
        int end  =999;
        int product;
        int max_palindromic = 0;

        for(int i=start;i<=end;i++){
            for(int t=start;t<=end;t++){
                product = i*t;
                if(is_palindromic(product)&&product>max_palindromic){
                    max_palindromic=product;
                }
            }
        }
        System.out.println(max_palindromic);
    }
}