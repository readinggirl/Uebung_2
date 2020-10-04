/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hue2.Bsp3;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Teresa
 */
public class NumberTester {

    private NumberTest oddEvenTester;
    private NumberTest primeTester;
    private NumberTest palindromeTester;
    private File file;
    private String[] lines;

    public static void main(String[] args) {
        NumberTester nt = new NumberTester("datei.txt");

        nt.oddEvenTester = (int n) -> {
            return n % 2 == 0;
        };

        nt.primeTester = (int n) -> {
            int factors = 0;
            int j = 1;

            while (j <= n) {
                if (n % j == 0) {
                    factors++;
                }
                j++;
            }
            return (factors == 2);

        };

        nt.palindromeTester = (int n) -> {
            String line = Integer.toString(n);
            int length = line.length();
            int front = 0;
            int back = length - 1;

            while (back > front) {
                char frontChar = line.charAt(front++);
                char backChar = line.charAt(back--);
                if (frontChar != backChar) {
                    return false;
                }
            }

            return true;
        };

        nt.testFile();

    }

    public NumberTester(String fileName) {
        this.file = new File(fileName);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            String line = br.readLine();
            lines = new String[Integer.parseInt(line) + 1];
            int i = 0;
            while (i < lines.length) {
                lines[i] = line;
                line = br.readLine();
                i++;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(NumberTester.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(NumberTester.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void setOddEvenTester(NumberTest oddTester) {
        this.oddEvenTester = oddTester;

    }

    public void setPrimeTester(NumberTest primeTester) {
        this.primeTester = primeTester;

    }

    public void setPalindromeTester(NumberTest palindromeTester) {
        this.palindromeTester = palindromeTester;
    }

    public void testFile() {
        for (int i = 0; i < lines.length; i++) {
            int[] line = deserialize(lines[i]);

            switch (line[0]) {
                case 1:
                    boolean erg = oddEvenTester.testNumber(line[1]);
                    if (erg) {
                        System.out.println("EVEN");
                    } else {
                        System.out.println("ODD");
                    }
                    break;
                case 2:
                    boolean erg2 = primeTester.testNumber(line[1]);
                    if (erg2) {
                        System.out.println("PRIME");
                    } else {
                        System.out.println("NO PRIME");
                    }
                    break;
                case 3:
                    boolean erg3 = palindromeTester.testNumber(line[1]);
                    if (erg3) {
                        System.out.println("PALINDROME");
                    } else {
                        System.out.println("NO PALINDROME");
                    }
                    break;
                default:
                    break;
            }
        }
    }

    private static int[] deserialize(String line) {
        String[] val = line.split(" ");
        int[] lineItems = new int[val.length];

        for (int i = 0; i < lineItems.length; i++) {
            lineItems[i] = Integer.parseInt(val[i]);
        }

        return lineItems;
    }

    public interface NumberTest {

        boolean testNumber(int number);
    }

}
