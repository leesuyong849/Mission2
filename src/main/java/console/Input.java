package console;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Input {

    public static int inputMoney(Scanner scanner) {
        System.out.print("로또 구입 금액울 입력하세요: ");
        int money = 0;

        try {
            money = scanner.nextInt();
            validateMoney(money);

        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }

        System.out.println( (money / 1000) + "개를 구매했습니다.\n");
        return money;
    }

    public static List<Integer> inputLottoNum(Scanner scanner) {
        System.out.println("당첨 번호를 입력하시오");

        String input = scanner.nextLine();

        String[] numbers = input.split(",");
        List<Integer> integers = null;

        try {
            integers = validateLottoNum(numbers);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }

        return integers;
    }

    public static Integer inputAddtionalNum(Scanner scanner) {
        System.out.println("보너스 번호를 입력 받는다");

        String input = scanner.nextLine();

        return validateAddtionalNum(input);
    }

    /**
     * 입력된 돈의 값에 대해 판단하는 메서드 모듬
     */
    private static void validateMoney(int money) {
        validatePositive(money);
        validateMultipleOfThousand(money);
    }

    /**
     * 값이 양수인지 판단
     */
    private static void validatePositive(int money) {
        if (money <= 0) {
            throw new IllegalArgumentException("입력은 양수이어야 합니다.");
        }
    }

    /**
     * 금액이 1000원 단위인지 검증
     */
    private static void validateMultipleOfThousand(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("로또는 1000원 단위로 구매할 수 있습니다.");
        }
    }

    /**
     * 입력된 로또값을 숫자로 변한한다.
     * @param nums
     * @return
     */
    private static List<Integer> validateLottoNum(String[] nums) {
        return Arrays.stream(nums)
                .map(Input::converterStringToInt)
                .collect(Collectors.toList())
                .stream()
                .map(Input::validateLottoNumRange)
                .collect(Collectors.toList());
    }

    private static int converterStringToInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 숫자가 포함되어 있습니다: " + str);
        }
    }

    private static Integer validateLottoNumRange(Integer num) {
        if (num > 45 || num < 1) {
            throw new IllegalArgumentException("범위를 벗어난 숫자가 있습니다: " + num);
        }
        return num;
    }

    /**
     * 로또에 대한 검증
     * @param str
     * @return
     */
    private static Integer validateAddtionalNum(String str) {
        int num = converterStringToInt(str);
        Integer integer = validateLottoNumRange(num);
        return integer;
    }
}
