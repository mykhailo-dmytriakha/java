package _hackerrank.java.oop;

import java.io.IOException;
import java.security.Permission;
import java.util.Scanner;

/**
 * Created by Михаил on 26.02.2016.
 * <b>task description: https://www.hackerrank.com/challenges/calculating-volume</b>
 */
public class CalculatingVolume {
    public static void main(String[] args) {
        Do_Not_Terminate.forbidExit();
        try {
            Calculate cal = new Calculate();
            int T = cal.getINTVal();
            while (T-- > 0) {
                double volume = 0.0d;
                int ch = cal.getINTVal();
                if (ch == 1) { // represents the volume of a cube
                    int a = cal.getINTVal();
                    volume = Calculate.get_Vol().main(a);
                } else if (ch == 2) { // represents the volume of a cuboid
                    int l = cal.getINTVal();
                    int b = cal.getINTVal();
                    int h = cal.getINTVal();
                    volume = Calculate.get_Vol().main(l, b, h);
                } else if (ch == 3) { // represents the volume of a cuboid
                    double r = cal.getDoubleVal();
                    volume = Calculate.get_Vol().main(r);
                } else if (ch == 4) { // represents the volume of a cylinder
                    double r = cal.getDoubleVal();
                    double h = cal.getDoubleVal();
                    volume = Calculate.get_Vol().main(r, h);
                }
                cal.output.display(volume);
            }

        } catch (NumberFormatException e) {
            System.out.print(e);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Do_Not_Terminate.ExitTrappedException e) {
            System.out.println("Unsuccessful Termination!!");
        }
    }
}

class Calculate {
    private final Scanner in;
    public Printer output = new Printer();

    public Calculate() {
        in = new Scanner(System.in);
    }

    public int getINTVal() throws IOException {
        return in.nextInt();
    }

    public double getDoubleVal() throws IOException {
        return Double.parseDouble(in.next());
    }

    public static Volume get_Vol() {
        return new Volume();
    }

    class Printer {

        public void display(double volume) {
            System.out.printf("%.3f\n", volume);
        }
    }
}

class Volume {

    public double main(int a) {
        if (a <= 0) throw new NumberFormatException("All the values must be positive");
        return a * a * a;
    }

    public double main(int l, int b, int h) {
        if (l <= 0 || b <= 0 || h <= 0) throw new NumberFormatException("All the values must be positive");
        return l * b * h;
    }

    public double main(double r) {
        if (r <= 0) throw new NumberFormatException("All the values must be positive");
        return 2.0 / 3.0 * (Math.PI * r * r * r);
    }

    public double main(double r, double h) {
        if (r <= 0 || h <= 0) throw new NumberFormatException("All the values must be positive");
        return Math.PI * r * r * h;
    }
}

/**
 * This class prevents the user from using System.exit(0)
 * from terminating the program abnormally.
 */
class Do_Not_Terminate {

    public static class ExitTrappedException extends SecurityException {
    }

    public static void forbidExit() {
        final SecurityManager securityManager = new SecurityManager() {
            @Override
            public void checkPermission(Permission permission) {
                if (permission.getName().contains("exitVM")) {
                    throw new ExitTrappedException();
                }
            }
        };
        System.setSecurityManager(securityManager);
    }
}//end of Do_Not_Terminate


