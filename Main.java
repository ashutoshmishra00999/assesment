import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter trigger price: ");
        double triggerPrice = scanner.nextDouble();
        
        // Display real-time market data
        // Here you should call the WebSocket client and fetch data
        double marketPrice = 50000.0; // Mock market price

        OrderPayload orderPayload = new OrderPayload("buy", triggerPrice, marketPrice);
        System.out.println(orderPayload.preparePayload());
    }
}
