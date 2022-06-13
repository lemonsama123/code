/**
 * @author
 */
public class Main {
    public static void main(String[] args) {
        int x = 0xffff_ff9f;
        System.out.println(Integer.toHexString(x));
        System.out.println(Integer.toHexString(x >> 2));
        System.out.println(Integer.toHexString(x >>> 2));
    }
}