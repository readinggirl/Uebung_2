/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hue2;

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
        nt.testFile();

        String[] texts = nt.lines.clone();

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
            char[] front = new char[String.valueOf(n).length()];
            char[] back = new char[String.valueOf(n).length()];

            //arrays befuellen
            for (int i = 0; i < front.length; i++) {
                front[i] = String.valueOf(i).charAt(i);
            }

            int count = 0;
            for (int i = back.length; i < -1; i++) {
                back[count] = String.valueOf(i).charAt(i);
                count++;
            }

            //check if front[0] gleich back[back.length-1], wenn true dann geh anch innen und wiederhole den vorgang
            count = back.length - 1;
            for (int i = 0; i < front.length; i++) {
                if (front[i] == back[count]) {
                    count--;
                } else {
                    return false;
                }
            }
            return true;

        };

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

    }

    public interface NumberTest {

        boolean testNumber(int number);
    }

}
