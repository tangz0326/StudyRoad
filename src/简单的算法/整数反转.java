package 简单的算法;

public class 整数反转 {
    public static void main(String[] args) {
        reverse(6252);
    }

    /**
     *将数字转变为字符串的方法
     * 无需考虑溢出问题
     */
    public static int reverse(int x){
        char[] arr=String.valueOf(x).toCharArray();
        char[] arr2=new char[arr.length];
        if(arr[0]=='-'){
            arr2[0]=arr[0];
            for(int i=arr.length-1;i>0;i--){
                arr2[arr.length-i]=arr[i];
            }
        }else{
            for(int i=arr.length-1;i>=0;i--){
                arr2[arr.length-1-i]=arr[i];
            }
        }
        String str=String.valueOf(arr2);
        int result=Integer.parseInt(str);
        System.out.println(result);
        return result;
    }


    /**
     *官方题解（数学思想）
     * 溢出条件有两个，一个是大于整数最大值MAX_VALUE，另一个是小于整数最小值MIN_VALUE，设当前计算结果为ans，下一位为pop。
     * 从ans * 10 + pop > MAX_VALUE这个溢出条件来看
     *     当出现 ans > MAX_VALUE / 10 且 还有pop需要添加 时，则一定溢出
     *     当出现 ans == MAX_VALUE / 10 且 pop > 7 时，则一定溢出，7是2^31 - 1的个位数
     *
     * 从ans * 10 + pop < MIN_VALUE这个溢出条件来看
     *     当出现 ans < MIN_VALUE / 10 且 还有pop需要添加 时，则一定溢出
     *     当出现 ans == MIN_VALUE / 10 且 pop < -8 时，则一定溢出，8是-2^31的个位数
     */
    public int solution(int x) {
        int ans = 0;
        while (x != 0) {
            int pop = x % 10;
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;
            ans = ans * 10 + pop;
            x /= 10;
        }
        return ans;
    }
}
