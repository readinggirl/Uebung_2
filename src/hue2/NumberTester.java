/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hue2;

import java.io.File;

/**
 *
 * @author Teresa
 */
public class NumberTester {

    private NumberTest oddEvenTester;
    private NumberTest primeTester;
    private NumberTest palindromeTester;
    private File file;

    public static void main(String[] args) {

    }

    public NumberTester(String fileName) {
        this.file = new File(fileName);
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
