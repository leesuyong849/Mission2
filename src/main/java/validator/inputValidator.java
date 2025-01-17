package validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class inputValidator {

    /**
     * 입력된 돈의 값에 대해 판단하는 메서드 모듬
     */
    public static void validateMoney(int money) {
        validatePositive(money);
        validateMultipleOfThousand(money);
    }

    /**
     * 값이 양수인지 판단
     */
    public static void validatePositive(int money) {
        if (money <= 0) {
            throw new IllegalArgumentException("입력은 양수이어야 합니다.");
        }
    }

    /**
     * 금액이 1000원 단위인지 검증
     */
    public static void validateMultipleOfThousand(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("로또는 1000원 단위로 구매할 수 있습니다.");
        }
    }

    /**
     * 입력된 로또값을 숫자로 변한한다.
     * @param nums
     * @return
     */
    public static List<Integer> validateLottoNum(String[] nums) {

        List<Integer> list = Arrays.stream(nums)
                .map(inputValidator::converterStringToInt) // 문자열을 정수로 변환
                .peek(inputValidator::validateLottoNumRange1And45) // 1~45 범위 확인
                .collect(Collectors.toList());// 결과를 리스트로 수집
        return list;
    }

    /**
     * 입력된 값을 int 값으로 수정
     * @param str
     * @return
     */
    public static int converterStringToInt(String str) {
        try {
            return Integer.parseInt(str.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 숫자가 포함되어 있습니다: " + str);
        }
    }

    /**
     * 입력된 값이 로또의 범위 안에 있는지 확인한다.
     * 1~45 사이
     * @param num
     * @return
     */
    public static void validateLottoNumRange1And45(Integer num) {
        if (num > 45 || num < 1) {
            throw new IllegalArgumentException("범위를 벗어난 숫자가 있습니다: " + num);
        }
    }

    /**
     * 로또에 대한 검증 (1~45)
     * @param str
     * @return
     */
    public static Integer validateAddtionalNum(String str) {
        int num = converterStringToInt(str);
        validateLottoNumRange1And45(num);
        return num;
    }
}
