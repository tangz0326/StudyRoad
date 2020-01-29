package 简单的算法;

public class 整数反转 {
    public static void main(String[] args) {
        reverse(6252);
    }

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
}
