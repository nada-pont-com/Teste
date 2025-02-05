package classesobjetoscasa;
import java.util.List;

public class Casa {
	//Declara��o dos atributos da classe.
	private String descricao;
	private String cor;
	private List<Porta> listaDePortas;
	private List<Janela> listaDeJanelas;

	//Armazenando o valor recebido para a descricao da casa
	public String getDescricao() {
		return this.descricao;
	}
	//Recebe o valor enviado para a descricao da casa
	public void setDescricao(String descricao) {
		this.descricao = descricao; 
	}
	//Aramazenando o valor recebidp para a cor da casa
	public String getCor() {
		return this.cor;
	}
	//Recebe o valor enviado para a cor da casa
	public void setCor(String cor) {
		this.cor = cor;
	}
	//Aramazenando o valor recebidp para a descri��o e status da(s) porta(s) da casa
	public List<Porta> getListaDePortas(){
		return this.listaDePortas;
	}
	//Recebe o valor enviado para a descri��o e status da(s) porta(s) da casa
	public void setListaDePortas(List<Porta> listaDePortas){
		this.listaDePortas = listaDePortas;
	}
	//Aramazenando o valor recebidp para a descri��o e status da(s) janela(s) da casa
	public List<Janela> getListaDeJanelas() {
		return this.listaDeJanelas;
	}
	//Recebe o valor enviado para a descri��o e status da(s) janela(s) da casa
	public void setListaDeJanelas(List<Janela> listaDeJanelas) {
		this.listaDeJanelas = listaDeJanelas;
	}
	/*
	 * O m�todo construirCasa() est� preparado para receber a lista de Janelas(descri��o,status),
	 * lista de portas(descri��o,status), cor e descri��o da casa. Observe que ap�s receber os
	 * valores da casa, estes s�o repassadas para os seus respectivos m�todos de armazenamento,
	 * setListaDeJanelas(), setListaDeJanelas(), setCor(), setDescricao().
	 */
	
	public void construirCasa(String descricao,String cor, List<Janela> listaDeJanelas, List<Porta> listaDePortas) {
		setDescricao(descricao);
		setCor(cor);
	 	setListaDeJanelas(listaDeJanelas);
	 	setListaDePortas(listaDePortas);
	}
	/*
	 * O m�todo abaixo recebe a cor informada pelo usu�rio e na aeguemcia
	 * o redireciona para o metodo setCor(), para que este o armazene no atributo cor.
	 */
	public void pintarCasa(String cor) {
		setCor(cor);
	}
	
	public void movimentarPorta(int index, int status) {
		Porta porta = listaDePortas.get(index);
		porta.setStatus(status);
		listaDePortas.set(index, porta);   //N�o � necessario
	}
	
	public void movimentarJanela(int index, int status) {
		listaDeJanelas.get(index).setStatus(status);   //Em uma linha!!! -------------------------- !!!
		/*
		Janela janela = listaDeJanelas.get(index);
		janela.setStatus(status);
		listaDeJanelas.set(index, janela);  //N�o � necessario
		 */
	}
	
}//T�rmino da classe Casa
