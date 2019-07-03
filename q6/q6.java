public class q6 {
    public static void main(String[] args) {
        int differ;
        int sum_suq=0;
        int suq_sum=0;
        int start = 1;
        int end = 100;

        for(int i=start;i<=end;i++){
            sum_suq+=i;
            suq_sum+=i*i;
        }
        sum_suq*=sum_suq;
        differ = sum_suq-suq_sum;
        System.out.println(differ);
    }
}