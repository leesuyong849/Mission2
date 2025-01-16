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

    // TODO: 추가 기능 구현
    public Lotto() {
        //랜덤 값 생성
        this.numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
                .stream()
                .sorted()
                .collect(Collectors.toList());
        //출력
        System.out.print("[");
        this.numbers.forEach(number -> System.out.print(number + " "));
        System.out.println("]"); //
    }

    public int checkLotto(List<Integer> input) {
        return (int) this.numbers.stream()
                .filter(input::contains)
                .distinct()
                .count();
    }

    public boolean checkAddtionalNum(Integer addtionslNum) {
        return this.numbers.contains(addtionslNum);
    }
}
