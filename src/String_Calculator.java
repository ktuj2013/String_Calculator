
import java.util.Scanner;

public class String_Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Main result = new Main();
        String answer = result.calc(str);
        System.out.print(answer);

    }

}
class Main {
    public static String calc(String str) {
        String result = "";
        String sign = "";
        if (str.contains("\" + \"") && str.startsWith("\"") && str.endsWith("\"") && str.length() <= 27) {
            sign = "+";
        } else if (str.contains("\" - \"") && str.startsWith("\"") && str.endsWith("\"") && str.length() <= 27) {
            sign = "-";
        } else if (str.contains("\" * ") && str.startsWith("\"") && str.length() <= 16) {
            str = str.replaceAll("\"", "");
            str = str.replace(" * ", "F");
            String[] a = str.split("F");
            if (a[1].matches("[-+]?\\d+")) {
                sign = "*";
            }
        } else if (str.contains("\" / ") && str.startsWith("\"") && str.length() <= 16) {
            str = str.replaceAll("\"", "");
            str = str.replace(" / ", "F");
            String[] b = str.split("F");
            if (b[1].matches("[-+]?\\d+")) {
                sign = "/";
            }
        } else {
            throw new NumberFormatException("Throws exception");
        }

        switch(sign) {
            case "+":
                str = str.replace("\" + \"", "");
                result = str;
                break;
            case "-":
                str = str.replaceAll("\"", "");
                String[] c = str.split(" - ");
                if (c[0].contains(c[1])) {
                    c[0] = c[0].replace(c[1], "");
                    result = "\"" + c[0] + "\"";
                } else {
                    result = "\"" + c[0] + "\"";
                }
                break;
            case "*":
                String[] d = str.split("F");
                int e = Integer.valueOf(d[1]);
                if (e > 10 || e < 1) {
                    throw new NumberFormatException("Throws exception");
                }
                String g = "";
                for (int i = 0; i < e; i++) {
                    g = g.concat(d[0]);
                }
                    if (g.length() <= 40) {
                        result = "\"" + g + "\"";
                        break;
                    } else {
                        result = "\"" + g.substring(0,40) + "..." + "\"";
                        break;
                    }


            case "/":
                String[] f = str.split("F");

                int k = Integer.valueOf(f[1]);
                if (k > 10 || k < 1) {
                    throw new NumberFormatException("Throws exception");
                }
                k = str.length() / k;
                f[0] = f[0].substring(0, k - 1);
                result = "\"" + f[0] + "\"";
                break;
            default:
                throw new NumberFormatException("Throws exception");
        }

    return result;
    }
}