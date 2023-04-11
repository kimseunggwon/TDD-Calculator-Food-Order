package restful.demo.calculate.object;

/**
 * 해당하는 값을 넣었을때, 음수면 예외를 터트리고, 양수면 객체가 만들어진다.
 * 즉 PositiveNumber 객체가 만들어 진거면 음수가 아닌 양수라는 것을 보장한다.
 */
public class PositiveNumber {

    private final int value;

    public PositiveNumber(int value) {
        this.value = value;
    }

    private void validate(int value){
        if (isNegativeNumber(value)){
            throw new IllegalArgumentException("0또는 음수를 전달할 수 없습니다.");
        }
    }

    private boolean isNegativeNumber(int value) {
        return value <= 0;
    }

    public int toInt() {
        return value;
    }


}
