
import java.util.Scanner;

public class StringCalculator {
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
            if (a[1].matches("[-+]?\\d+") && Integer.valueOf(a[1]) <= 10 || Integer.valueOf(a[1]) >= 1) {
                sign = "*";
            }
        } else if (str.contains("\" / ") && str.startsWith("\"") && str.length() <= 16) {
            str = str.replaceAll("\"", "");
            str = str.replace(" / ", "F");
            String[] b = str.split("F");
            if (b[1].matches("[-+]?\\d+") && Integer.valueOf(b[1]) <= 10 || Integer.valueOf(b[1]) >= 1) {
                sign = "/";
            } else {
                throw new NumberFormatException("Throws exception");
            }
        } else {
            throw new NumberFormatException("Throws exception");
        }

        switch(sign) {
            case "+":
                str = str.replace("\" + \"", "");
                System.out.println(str);
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
                String h = "";
                int e = Integer.valueOf(d[1]);
                String g = "";
                for (int i = 0; i < e; i++) {
                    g = g.concat(d[0]);
                    if (g.length() == 40){
                        h = g;
                    }
                    if (g.length() <= 40 && i == e - 1) {
                        result = "\"" + g + "\"";
                        break;
                    } else if (g.length() >= 40 && i == e - 1){
                        result = "\"" + h + "..." + "\"";
                        break;
                    }
                }
                break;

            case "/":
                String[] f = str.split("F");
                int k = Integer.valueOf(f[1]);
                f[0] = f[0].substring(0, k);
                result = "\"" + f[0] + "\"";
                break;
            default:
                throw new NumberFormatException("Throws exception");
        }

    return result;
    }
}