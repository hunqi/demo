package tij.ch5.exercise;

//the least_valuable types of paper currency
public enum Currency {
    ZIMBABWE_DOLLAR(25000000),
    VIETNAMESE_DONG(23315),
    INDONESIAN_RUPIAH(9090),
    MYANMAR_KYAT(1600),
    KOREA_WON(1100),
    SOMALI_SHILLING(600);

    int exchange;

    private Currency(int e){
        exchange = e;
    }

    public int getExchange() {
        return exchange;
    }

    public static void main(String[] args) {

        for (Currency c : Currency.values())
            System.out.println(c.ordinal() + ": " + c + " exchange " + c.exchange);
    }
}
