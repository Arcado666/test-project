package socket;

import java.net.URISyntaxException;

public class SocketClientEngine{  
  
  
    public static void main(String[] args) {  
        try {  
            WebClientEnum.CLIENT.initClient(new MsgWebSocketClient("ws://121.40.165.18:8088"));  
        } catch (URISyntaxException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
    }  
}  