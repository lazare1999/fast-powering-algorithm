import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by Lazo on 2021-10-21
 */

public class Main
{
    public static void main(String[] args) {

        Scanner myObj = new Scanner(System.in);
        System.out.print("Enter number : ");
        int g = Integer.parseInt(myObj.nextLine());

        System.out.print("Enter pow : ");
        int A = Integer.parseInt(myObj.nextLine());

        System.out.print("Enter mod : ");
        int mod = Integer.parseInt(myObj.nextLine());

        System.out.print("answer is: " + fastPoweringAlgorithm(g, A,  mod) + " (mod " + mod + ")");

    }

    private static List<Character> convertStringToCharList(String str) {
        return str.chars().mapToObj(e -> (char)e).collect(Collectors.toList());
    }

    private static long fastPoweringAlgorithm(long g, long A, long mod) {
        List<Character> reversedA = convertStringToCharList(Long.toBinaryString(A));
        List<Long> aList = new ArrayList<>();
        aList.add(g);

        var ans = 1L;
        var index = 1;
        for(int i = 0; i < reversedA.size(); i++) {

            if (i < reversedA.size()-1)
                aList.add((aList.get(i) * aList.get(i)) % mod);

            index = reversedA.size() - (i +1);
            if (Integer.parseInt(String.valueOf(reversedA.get(index))) == 0)
                continue;

            ans = (ans * aList.get(i)) % mod;

        }

        return ans;
    }
}
