package projcalcversao3; 

public class Calculadora {
	//Declara��o do objeto oper no corpo da classe.
	static Operacoes oper = new Operacoes();
	
	public static void main(String[] args) {
		while(true) {
			int numero1 = EntradaSaida.infonum1();
			int numero2 = EntradaSaida.infonum2();
			int acao  = EntradaSaida.infop();
			
			String msg = oper.calcular(numero1,numero2,acao);
			
			EntradaSaida.mostraResultado(msg);
			
		}//t�rmino do while()
		
		
	} 

}
