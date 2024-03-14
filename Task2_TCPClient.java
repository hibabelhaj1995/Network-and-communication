//TcpClient 1
package tcpclient;
import java.net.*;
import java.io.*;

public class TCPClient {

    boolean shutdown;
    Integer timeout;
    Integer limit;

    public TCPClient(boolean shutdown, Integer timeout, Integer limit) {
        this.shutdown = shutdown;
        this.timeout = timeout;
        this.limit = limit;
    }
    public byte[] askServer(String hostname, int port, byte [] bytesToServer) throws IOException {
        Socket socketClient = new Socket(hostname, port);
        ByteArrayOutputStream bytesToClient = new ByteArrayOutputStream();

        try {
            socketClient.getOutputStream().write(bytesToServer); 
            byte[] buffer= new byte[1024];

            if (timeout != null) {
                socketClient.setSoTimeout(timeout);
            }

            if (shutdown) {
                socketClient.shutdownOutput();
                return bytesToServer;
            }
            int i;
            if (limit != null) {
                buffer = new byte[limit];
                
                while ((i=socketClient.getInputStream().read(buffer)) != -1) {
                    bytesToClient.write(buffer,0,limit);
                    if (limit <= i ) {
                        break;
                     }
                }

            }
            if (limit == null){
                while ((i=socketClient.getInputStream().read(buffer)) != -1) {
                bytesToClient.write(buffer,0,i);
                }
            }

        } 
        catch (SocketTimeoutException e) {
        }
        socketClient.close();
        return bytesToClient.toByteArray();
    }
}
