import java.util.Arrays;
import java.util.Scanner;

public class anagrams {
static boolean isAnagram(String str1, String str2) {
// replacing special chars
String s1 = str1.replaceAll("\s", "");
String s2 = str2.replaceAll("\s", "");
boolean status = true;
// checking for lenth
if (s1.length() != s2.length()) {
status = false;
} else {
// converting it into char array
char[] ArrayS1 = s1.toLowerCase().toCharArray();
char[] ArrayS2 = s2.toLowerCase().toCharArray();
// sorting the array
Arrays.sort(ArrayS1);
Arrays.sort(ArrayS2);
// checking the equality of arrays
status = Arrays.equals(ArrayS1, ArrayS2);
}
return status;
}

public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
System.out.println("Enter 2 Strings");
String s1 = sc.nextLine();
String s2 = sc.nextLine();
System.out.println(isAnagram(s1, s2));
}
}