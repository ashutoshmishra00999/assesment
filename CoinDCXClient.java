import javax.websocket.*;
import java.net.URI;

@ClientEndpoint
public class CoinDCXClient {
    @OnOpen
    public void onOpen(Session session) {
        System.out.println("Connected to server");
        session.getAsyncRemote().sendText("{\"type\":\"subscribe\", \"channel\":\"market_data\"}");
    }

    @OnMessage
    public void onMessage(String message) {
        System.out.println("Received: " + message);
    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        System.out.println("Connection closed: " + closeReason);
    }

    public static void main(String[] args) {
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        try {
            URI uri = URI.create("wss://api.coindcx.com/streaming/v1/market_data");
            container.connectToServer(CoinDCXClient.class, uri);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
