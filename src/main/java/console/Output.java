package console;

public class Output {

    public static void printresult(int[] result) {

        System.out.println("3개 일치 (5,000원) - "+ result[0] + "개");
        System.out.println("4개 일치 (50,000원) - "+ result[1] + "개");
        System.out.println("5개 일치 (1,500,000원) - "+ result[2] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+ result[4] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - "+ result[3] + "개");
    }
}
