package lotto;

import org.assertj.core.internal.Integers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static console.Input.*;
import static console.Output.printresult;

public class Program {

    public void play() {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Lotto> lottos = new ArrayList<>();
        int[] result = new int[5];

        //로또 금액 입력
        int num = inputMoney(scanner);
        //발행 및 발행한 로또 번호 출력
        for (int i = 0; i < num/1000; i++) {
            lottos.add(new Lotto());
        }
        //당첨 번호 입력
        List<Integer> integers = inputLottoNum(scanner);

        //보너스 번호 입력
        Integer addtionalNum = inputAddtionalNum(scanner);

        //당첨 내역 확인
        for (Lotto lotto : lottos) {
            int i = lotto.checkLotto(integers);
            result[i - 3]++;

            if (lotto.checkAddtionalNum(addtionalNum)) {
                result[4]++;        //추가 값이 포함되는 경우는 가장 마지막에 저장
            }
        }

        //당첨 내역 출력
        printresult(result);

        //수익률 출력


    }

    private float computePercent(int[] result) {
        int totalMoney = 0;
        for (int i = 0; i < result.length; i++) {

        }
    }
}
