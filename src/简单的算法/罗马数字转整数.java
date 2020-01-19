package 简单的算法;

public class 罗马数字转整数 {
    public static void main(String[] args) {
        System.out.println(soultion_1("MCMXCIV"));
        System.out.println(soultion_1("MCM"));
    }


    public static int soultion_1(String string) {
        char[] arr = string.toCharArray();
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1) {
                if (arr[i] == 'I' && (arr[i + 1] == 'V' || arr[i + 1] == 'X')) {
                    result += (getValue(arr[i + 1]) - 1);
                    i++;
                    continue;
                }
                if (arr[i] == 'X' && (arr[i + 1] == 'L' || arr[i + 1] == 'C')) {
                    result += (getValue(arr[i + 1]) - 10);
                    i++;
                    continue;
                }
                if (arr[i] == 'C' && (arr[i + 1] == 'D' || arr[i + 1] == 'M')) {
                    result += (getValue(arr[i + 1]) - 100);
                    i++;
                    continue;
                }
            }
            result += getValue(arr[i]);
        }
        return result;
    }

    public static int getValue(char c) {
        int value = 0;
        switch (c) {
            case 'I':
                value = 1;
                break;
            case 'V':
                value = 5;
                break;
            case 'X':
                value = 10;
                break;
            case 'L':
                value = 50;
                break;
            case 'C':
                value = 100;
                break;
            case 'D':
                value = 500;
                break;
            case 'M':
                value = 1000;
                break;
            default:
                break;
        }
        return value;
    }
}
