package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static console.Input.*;
import static console.Output.printProfitRate;
import static console.Output.printresult;

public class Program {

    public void play() {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Lotto> lottos = new ArrayList<>();
        int[] result = new int[5];

        //로또 금액 입력
        int num = inputMoney(scanner);
        //발행 및 발행한 로또 번호 출력
        publishLotto(lottos, num);
        //당첨 번호 입력
        List<Integer> integers = inputLottoNum(scanner);

        //보너스 번호 입력
        Integer addtionalNum = inputAddtionalNum(scanner);

        //당첨 내역 확인
        computeLottoResult(lottos, result, integers, addtionalNum);

        //당첨 내역 출력
        printresult(result);

        //수익률 연산
        float profitRate = computePercent(result, num);

        //수익률 출력
        printProfitRate(profitRate);
    }

    private void publishLotto(ArrayList<Lotto> lottos, int num) {
        for (int i = 0; i < num /1000; i++) {
            lottos.add(new Lotto());
        }
    }

    private void computeLottoResult(ArrayList<Lotto> lottos, int[] result, List<Integer> integers, Integer addtionalNum) {
        for (Lotto lotto : lottos) {
            int i = lotto.checkLotto(integers);
            result[i - 3]++;

            if (lotto.checkAddtionalNum(addtionalNum)) {
                result[4] = result[2] + 1;        //추가 값이 포함되는 경우는 가장 마지막에 저장
            }
        }
    }

    private float computePercent(int[] result, int num) {
        int totalMoney = 0;
        totalMoney += result[0] * 5000;
        totalMoney += result[1] * 50000;
        totalMoney += result[2] * 1500000;
        totalMoney += result[3] * 30000000;
        totalMoney += result[4] * 2000000000;

        return totalMoney / num;
    }
}
