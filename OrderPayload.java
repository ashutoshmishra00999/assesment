public class OrderPayload {
    private String type;
    private double triggerPrice;
    private double marketPrice;

    public OrderPayload(String type, double triggerPrice, double marketPrice) {
        this.type = type;
        this.triggerPrice = triggerPrice;
        this.marketPrice = marketPrice;
    }

    public String preparePayload() {
        if (type.equals("buy") && marketPrice <= triggerPrice) {
            return "Prepare BUY payload";
        } else if (type.equals("sell") && marketPrice >= triggerPrice) {
            return "Prepare SELL payload";
        } else {
            return "No action";
        }
    }
}
