package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 중복되는 값이 있는지 확인하고 예외를 던진다.
     * @param list
     */
    public static void validateDupllicateNum(List<Integer> list) {
        long count = list.stream().distinct().count();
        if (count < list.size()) {
            throw new IllegalArgumentException("중복된 값이 입력되었습니다");
        }
    }

    // TODO: 추가 기능 구현
    public Lotto() {
        //랜덤 값 생성
        this.numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
                .stream()
                .sorted()
                .collect(Collectors.toList());

        validateDupllicateNum(this.numbers);
        //출력
        System.out.print("[");
        this.numbers.forEach(number -> System.out.print(number + " "));
        System.out.println("]"); //
    }

    public int checkLotto(List<Integer> input) {
        int a = (int) this.numbers.stream()
                .filter(input::contains)
                .distinct()
                .count();
        System.out.println(a);
        return a;
    }

    public boolean checkAddtionalNum(Integer addtionslNum) {
        return this.numbers.contains(addtionslNum);
    }
}
