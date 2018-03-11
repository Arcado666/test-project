package socket;

import java.net.URI;  
import java.net.URISyntaxException;  
  
import org.java_websocket.client.WebSocketClient;  
import org.java_websocket.drafts.Draft;  
import org.java_websocket.drafts.Draft_17;  
import org.java_websocket.handshake.ServerHandshake;  
  
public class WebSocketC extends WebSocketClient{  
      
    /** 
     * 接受websocket服务端的值. 
     */  
    private static String receiveData = null;  
      
    /** 
     * 判断WebSocket是否打开. 
     */  
    private static boolean isOpen = false;  
      
    public WebSocketC(URI serverURI){  
        super(serverURI,new Draft_17());  
    }  
      
    public WebSocketC(URI serverURI, Draft draft) {  
        super( serverURI, draft );  
    }  
  
    @Override  
    public void onClose( int code, String reason, boolean remote ) {  
        // The codecodes are documented in class org.java_websocket.framing.CloseFrame  
        System.out.println( "Connection closed by " + ( remote ? "remote peer" : "us" ) );  
        isOpen = false;  
    }  
  
    @Override  
    public void onError(Exception arg0) {  
        // TODO Auto-generated method stub  
        System.out.println("make mistakes");  
    }  
  
    @Override  
    public void onMessage(String message) {  
        // TODO Auto-generated method stub  
        System.out.println( "received: " + message );  
        isOpen = true;  
        setReceiveData(message);  
    }  
  
    @Override  
    public void onOpen(ServerHandshake arg0) {  
        // TODO Auto-generated method stub  
        System.out.println( "opened connection" );  
    }  
      
    public static String getReceiveData() {  
        return receiveData;  
    }  
  
    public void setReceiveData(String receiveData) {  
        WebSocketC.receiveData = receiveData;  
    }  
      
    public static boolean getWebSocketConnectionIsOpen(){  
        return isOpen;  
    }  
  
    public static void main( String[] args ) throws URISyntaxException, InterruptedException {  
        // more about drafts here: http://github.com/TooTallNate/Java-WebSocket/wiki/Drafts  
        WebSocketC websocket = new WebSocketC( new URI( "ws://121.40.165.18:8088" ));  
        if(!websocket.connectBlocking()){  
            System.err.println( "Could not connect to the server." );  
            return;  
        }  
          
//      while(true){  
//          String value = getReceiveData();  
//          if(value == null){  
//              value =getReceiveData();  
//          }else{  
//              System.out.println(value+"__________________");  
//              return;  
//          }  
//      }  
          
        // 2秒后关闭  
        websocket.send("asd");
        websocket.send("123456");
        Thread.sleep(2000);  
        websocket.closeBlocking();  
          
        boolean f = getWebSocketConnectionIsOpen();  
        if(!f){  
            WebSocketC websockets = new WebSocketC( new URI( "ws://121.40.165.18:8088" ));  
            websockets.connectBlocking();  
        }  
          
    }  
}  