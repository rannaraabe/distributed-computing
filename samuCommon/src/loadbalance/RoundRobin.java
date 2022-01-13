package loadbalance;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class RoundRobin {
	public static Integer posicao = 0;
	
	public static Integer getPorta() {
		Set<Integer> portas = IPPool.servicoIpMap.keySet();
        List<Integer> listaPortas = new ArrayList<>();
        listaPortas.addAll(portas);
        Integer resultado = null;

        synchronized (posicao) {
            if (posicao > listaPortas.size() - 1) {
                posicao = 0;
            }
            resultado = listaPortas.get(posicao); 
            posicao++;
        }
        return resultado;
	}

}
