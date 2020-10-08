/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hue2.Bsp4;

import java.util.Scanner;

/**
 *
 * @author Teresa
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "Windows-1252");

        //add
        RationalCalculator rc = new RationalCalculator((a, b) -> {
            double zaehler = a.getA() * b.getB() + b.getA() * a.getB();
            double nenner = a.getB() * b.getB();
            Number num = new Number();
            num.setA(zaehler);
            num.setB(nenner);
            return num;
        },
                //sub
                (a, b) -> {
                    double zaehler = a.getA() * b.getB() - b.getA() * a.getB();
                    double nenner = a.getB() * b.getB();
                    Number num = new Number();
                    num.setA(zaehler);
                    num.setB(nenner);
                    return num;
                },
                //multiply
                (a, b) -> {
                    double zaehler = a.getA() * b.getA();
                    double nenner = a.getB() * b.getB();
                    Number num = new Number();
                    num.setA(zaehler);
                    num.setB(nenner);
                    return num;
                }, //divide
                (a, b) -> {
                    double zaehler = a.getA() * b.getB();
                    double nenner = a.getB() * b.getA();
                    Number num = new Number();
                    num.setA(zaehler);
                    num.setB(nenner);
                    return num;
                }
        );

    }
}
