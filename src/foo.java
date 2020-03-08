public class foo {

    public int sum_numbers(int n){
        int i, sum;
        i = 1;
        sum = 0;
        while(i <= n){
            sum = sum + i;
            i = i + 1;
        }
        return sum;
    }
}
