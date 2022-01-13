package ufrn.br.samuSpring.model;

public enum PortPool {
	LOAD_BALANCER(8081), SERVICO_A(8082), SERVICO_B(8083), BANCO_A(8084), BANCO_BACKUP(8085);
	
	public Integer porta;
	
	PortPool(Integer porta) {
		this.porta = porta;
	}
}
