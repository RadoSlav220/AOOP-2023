public class MonetaryCoin extends Coin{
    private final int value;

    public MonetaryCoin(int value, Face face) {
        super(face);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Coin with value " + value + " and face " + getFace();
    }
}
