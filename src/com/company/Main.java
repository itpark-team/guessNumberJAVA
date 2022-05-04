package com.company;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        //1.загадать число компьютером
        //2.ввести число пользователем
        //3.проверить больше меньше или равно пользовательское число компьютерному
        //4.1.если число пользователя больше или меньше компьютерного, то вывести подсказку и перейти на шаг 2
        //4.2.если число пользователя равно компьютерному, то остановить игру и вывести сообщение о победе

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int level = 0;
        int minNumber = 0;
        int maxNumber = 0;
        int compNumber = 0;
        int userNumber = 0;
        int countTries = 0;
        int leftSide = 0;
        int rightSide = 0;
        int cheatNumber = 9999;
        int leftCountTries = 30;

        System.out.println("Игра угадай число, надо угадать загаданное компом число");

        System.out.println("Введите уровень игры");
        System.out.println("1. уровень (1-100)");
        System.out.println("2. уровень (1-500)");
        System.out.println("3. уровень (1-1000)");
        System.out.println("4. уровень (свой диапазон)");

        do {
            System.out.print("сделайте выбор: ");
            level = scanner.nextInt();
        } while (level < 1 || level > 4);

        switch (level) {
            case 1:
                minNumber = 1;
                maxNumber = 100;
                break;
            case 2:
                minNumber = 1;
                maxNumber = 500;
                break;
            case 3:
                minNumber = 1;
                maxNumber = 1000;
                break;
            case 4:
                System.out.print("введите нижнюю границу: ");
                minNumber = scanner.nextInt();

                System.out.print("введите верхнюю границу: ");
                maxNumber = scanner.nextInt();
                break;
        }

        compNumber = random.nextInt(maxNumber - minNumber + 1) + minNumber;
        leftSide = minNumber;
        rightSide = maxNumber;

        do {

            do {
                System.out.println("у вас осталось попыток: " + leftCountTries);
                System.out.print("введите число от " + leftSide + " до " + rightSide + ": ");

                //user input
                userNumber = scanner.nextInt();

                //simple bot input
                //userNumber = random.nextInt(rightSide - leftSide + 1) + leftSide;

                //clever bot input
                //userNumber = (leftSide + rightSide) / 2;

                //System.out.println(userNumber);//output comp variant

                //System.in.read();//wait press enter


            } while (userNumber < leftSide || userNumber > rightSide);

            if (userNumber == cheatNumber) {
                System.out.println("правильный ответ = " + compNumber);
            } else {
                countTries++;

                leftCountTries--;

                if (userNumber > compNumber) {
                    System.out.println("введите поменьше");
                    rightSide = userNumber;
                } else if (userNumber < compNumber) {
                    System.out.println("введите побольше");
                    leftSide = userNumber;
                }
            }

        } while (userNumber != compNumber && leftCountTries > 0);

        if (leftCountTries > 0) {
            System.out.print("вы угадали! за " + countTries + " попыток. ");

            if (countTries <= 3) {
                System.out.println("Вы гений");
            } else if (countTries >= 4 && countTries <= 6) {
                System.out.println("Вы мастер");
            } else if (countTries >= 7 && countTries <= 10) {
                System.out.println("играй лучше");
            } else {
                System.out.println("лошара");
            }
        } else {
            System.out.println("Вы проиграли у вас кончились попытки");
        }

    }
}
