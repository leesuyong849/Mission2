package console;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static validator.inputValidator.*;

public class Input {

    public static int inputMoney(Scanner scanner) {
        int money = 0;

        while (true) {
            System.out.print("로또 구입 금액울 입력하세요: ");
            try {
                money = scanner.nextInt();
                validateMoney(money);
                System.out.println( (money / 1000) + "개를 구매했습니다.\n");
                return money;

            } catch (IllegalArgumentException e) {
                printErrorMessage(e);
            }
        }
    }

    public static List<Integer> inputLottoNum(Scanner scanner) {

        while (true) {
            System.out.println("당첨 번호를 입력하시오");

            String input = scanner.nextLine();
            System.out.println(input);

            String[] numbers = input.split(",");
            List<Integer> integers;

            try {
                integers = validateLottoNum(numbers);
                return integers;

            } catch (IllegalArgumentException e) {
                printErrorMessage(e);
            }
        }

    }

    private static void printErrorMessage(IllegalArgumentException e) {
        System.out.println("[ERROR] " + e.getMessage());
    }

    /**
     * 추가적인 값 입력
     * @param scanner
     * @return
     */
    public static Integer inputAddtionalNum(Scanner scanner) {

        while (true) {
            System.out.println("보너스 번호를 입력해 주세요.");
            String input = scanner.nextLine();
            return validateAddtionalNum(input);
        }
    }
}
