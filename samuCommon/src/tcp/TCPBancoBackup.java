package tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TCPBancoBackup  {
	private ServerSocket serverSocket;
    private ExecutorService executorService;
    private final int POOL_SIZE = 20;
    TCP tcp;

    public TCPBancoBackup(Integer porta) throws IOException {
        serverSocket = new ServerSocket(porta);
        executorService = Executors.newFixedThreadPool(Runtime.getRuntime()
                .availableProcessors() * POOL_SIZE);
        tcp = new TCP();
    }

    public void iniciar() {
    	System.out.println("TCP: Banco Backup inicializado!");
        while(true) {
            try {
            	Socket socket = serverSocket.accept();
                Integer portaBanco = 8084; 
                Socket socketEnviar = tcp.conectar(portaBanco);
                if(socketEnviar == null) {
                	executorService.execute(new TCP(socket, null, true));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
