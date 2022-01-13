package tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import loadbalance.RoundRobin;

public class TCPLoadBalancer {
	private ServerSocket serverSocket;
    private ExecutorService executorService;
    private final int POOL_SIZE = 20;
    TCP tcp;

    public TCPLoadBalancer(Integer porta) throws IOException {
        serverSocket = new ServerSocket(porta);
        executorService = Executors.newFixedThreadPool(Runtime.getRuntime()
                .availableProcessors() * POOL_SIZE);
        tcp = new TCP();
    }

    public void iniciar() {
    	System.out.println("TCP: Load Balancer inicializado!");
        while(true) {
            Socket socket = null;
            try {
                socket = serverSocket.accept();
                Integer portaServico = RoundRobin.getPorta(); 
                Socket socketEnviar = tcp.conectar(portaServico);
                if(socketEnviar == null) {
                	portaServico = RoundRobin.getPorta(); 
                }
                executorService.execute(new TCP(socket, portaServico, false));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
