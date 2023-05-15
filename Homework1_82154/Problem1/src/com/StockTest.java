package com;

public class StockTest {
    public static void main(String[] args) {
        Stock stock = new Stock("sym", "Something");
        stock.setPreviousClosingPrice(36.8);
        stock.setCurrentPrice(27.6);
        System.out.printf("Symbol: %s, Name: %s, Previous price: %.2f, Current price: %.2f, Change percentage: %.1f%%",
                stock.getSymbol(), stock.getName(), stock.getPreviousClosingPrice(),
                stock.getCurrentPrice(), stock.changePercent());
    }
}
