/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hue2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Teresa
 */
public class HalloJavamitForEach {

    List<String> list = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HalloJavamitForEach hello = new HalloJavamitForEach();
        hello.print();
    }

    public void print() {
        //random zeugs hinzufuegen
        for (int i = 0; i < 10; i++) {
            list.add("1." + i);
        }

        for (String string : list) {
            System.out.println(list.get(list.indexOf(string)));
        }

        System.out.println("\nlist.forEach((String s) ...)");
        list.forEach((String s) -> System.out.println(s));

    }

}
