package tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import loadbalance.RoundRobin;

public class TCPServico {
	private ServerSocket serverSocket;
    private ExecutorService executorService;
    private final int POOL_SIZE = 20;
    TCP tcp;
    
    public TCPServico(Integer porta) throws IOException {
        serverSocket = new ServerSocket(porta);
        executorService = Executors.newFixedThreadPool(Runtime.getRuntime()
                .availableProcessors() * POOL_SIZE);
        tcp = new TCP();
    }

    public void iniciar() {
    	System.out.println("TCP: Serviço inicializado!");
        while(true) {
        	Socket socket = null;
            try {
                socket = serverSocket.accept();
                Integer portaBanco = 8084; 
                Socket socketEnviar = tcp.conectar(portaBanco);
                if(socketEnviar == null) {
                	portaBanco = 8085; 
                }
                executorService.execute(new TCP(socket, portaBanco, false));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
