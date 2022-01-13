package tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import loadbalance.RoundRobin;

public class TCPBanco  {
	private ServerSocket serverSocket;
    private ExecutorService executorService;
    private final int POOL_SIZE = 20;
    TCP tcp;

    public TCPBanco(Integer porta, Integer... backups) throws IOException {
        serverSocket = new ServerSocket(porta);
        executorService = Executors.newFixedThreadPool(Runtime.getRuntime()
                .availableProcessors() * POOL_SIZE);
		tcp = new TCP();
    }

    public void iniciar() {
    	System.out.println("TCP: Banco inicializado!");
        while(true) {
        	Socket socket = null;
            try {
                socket = serverSocket.accept();
                Integer portaBanco = 8085; 
                Socket socketEnviar = tcp.conectar(portaBanco);
                if(socketEnviar == null) {
                	portaBanco = null;
                }
                this.executorService.execute(new TCP(socket, portaBanco, true));
            } catch (Exception e) {
                e.printStackTrace();
            }
        	
        }
    }
}
