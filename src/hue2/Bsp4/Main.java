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

        //add
        VectorCalculator vc = new VectorCalculator((a, b) -> {
            double x = a.getA() + b.getA();
            double y = a.getB() + b.getB();
            Number num = new Number();
            num.setA(x);
            num.setB(y);
            return num;
        },
                //sub
                (a, b) -> {
                    double x = a.getA() - b.getA();
                    double y = a.getB() - b.getB();
                    Number num = new Number();
                    num.setA(x);
                    num.setB(y);
                    return num;
                },
                //multiply
                (a, b) -> {
                    double zaehler = a.getA() * b.getB() + a.getB() * b.getA();
                    Number num = new Number();
                    num.setA(zaehler);
                    num.setB(1);
                    return num;
                }, //divide
                (a, b) -> {
                    double zaehler = a.getA() * b.getA() + a.getB() * b.getB();
                    Number num = new Number();
                    num.setA(zaehler);
                    num.setB(1);
                    return num;
                });

        //add
        ComplexCalculator cc = new ComplexCalculator((a, b) -> {
            double zaehler = a.getA() + b.getA();
            double nenner = a.getB() + b.getB();
            Number num = new Number();
            num.setA(zaehler);
            num.setB(nenner);
            return num;
        },
                //sub
                (a, b) -> {
                    double zaehler = a.getA() - b.getA();
                    double nenner = a.getB() - b.getB();
                    Number num = new Number();
                    num.setA(zaehler);
                    num.setB(nenner);
                    return num;
                },
                //multiply
                (a, b) -> {
                    double zaehler = a.getA() * b.getA() - a.getB() * b.getB();
                    double nenner = a.getA() * b.getB() + a.getB() * b.getA();
                    Number num = new Number();
                    num.setA(zaehler);
                    num.setB(nenner);
                    return num;
                }, //divide
                (a, b) -> {
                    double zaehler = (a.getA() * b.getA() - a.getB() * b.getB()) + (a.getA() * b.getB() + a.getB() * b.getA());
                    double nenner = b.getA() * b.getA() - b.getB() * b.getB();
                    Number num = new Number();
                    num.setA(zaehler);
                    num.setB(nenner);
                    return num;
                });

        menu1();
        int calc = Integer.parseInt(scanner.nextLine());

        System.out.println();
        System.out.println("Enter number x a>");
        double aA = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter number x b>");
        double aB = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter number y a>");
        double bA = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter number y b>");
        double bB = Double.parseDouble(scanner.nextLine());

        System.out.println();
        menu2();
        int option = Integer.parseInt(scanner.nextLine());

        while (option == 5) {

            menu2();
            option = Integer.parseInt(scanner.nextLine());

        }

        Number a = new Number();
        a.setA(aA);
        a.setB(bB);
        Number b = new Number();
        b.setA(bA);
        b.setB(bB);

        Number erg = new Number();
        switch (calc) {
            case 1: //rational
                switch (option) {
                    case 1:
                        erg = rc.add(a, b);
                        break;
                    case 2:
                        erg = rc.subtract(a, b);
                        break;
                    case 3:
                        erg = rc.multiply(a, b);
                        break;
                    case 4:
                        erg = rc.divide(a, b);
                        break;
                    default:
                        break;
                }
                break;

            case 2: //vector
                switch (option) {
                    case 1:
                        erg = vc.add(a, b);
                        break;
                    case 2:
                        erg = vc.subtract(a, b);
                        break;
                    case 3:
                        erg = vc.multiply(a, b);
                        break;
                    case 4:
                        erg = vc.divide(a, b);
                        break;
                    default:
                        break;
                }
                break;

            case 3: //complex
                switch (option) {
                    case 1:
                        erg = cc.add(a, b);
                        break;
                    case 2:
                        erg = cc.subtract(a, b);
                        break;
                    case 3:
                        erg = cc.multiply(a, b);
                        break;
                    case 4:
                        erg = cc.divide(a, b);
                        break;
                    default:
                        break;
                }
                break;

            case 4:
                System.exit(0);
            default:
                break;
        }

        double aErg = erg.getA();
        double bErg = erg.getB();

        System.out.println("________________________________ \n");
        System.out.println("           Solution");
        System.out.println("a = " + aErg);
        System.out.println("b = " + bErg);
        System.out.println("________________________________");

    }

    public static void menu1() {
        System.out.println("Choose calculator: \n 1 - Rational calculator\n 2 - Vector calculator\n 3 - Complex calculator\n 4 - Exit program");
    }

    public static void menu2() {
        System.out.println("Choose operation: \n 1 - add\n 2 - subtract\n 3 - multiply\n 4 - divide\n 5 - enter numbers again");
    }
}
