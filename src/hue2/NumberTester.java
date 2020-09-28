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
