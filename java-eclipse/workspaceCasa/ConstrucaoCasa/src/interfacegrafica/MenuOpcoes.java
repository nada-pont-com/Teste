package interfacegrafica;


import classesobjetoscasa.Casa;
import classesobjetoscasa.Janela;
import classesobjetoscasa.Porta;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;

public class MenuOpcoes {
	//Declare��o do m�todo din�mico ExibirMenu().
	public void exibirMenu() {
		//Criando o objeto casa e instanciando-o para a classe Casa.
		Casa casa = new Casa();
		//Criando o menu de op��es
		while (true) {
			int acao = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma das op��o : \n"
					+ "1 - Construir Casa \n"
					+ "2 - Pintar Casa \n"
					+ "3 - Mover Porta(s) \n"
					+ "4 - Mover Janela(s) \n"
					+ "5 - Informa��es da Casa \n"
					+ "6 - Sair"));
			switch(acao) {
			/*
			 * Caso a op��o escolhida seja 1, chamar o m�todo que permitir� fazermos as entradas
			 * necess�rias para a constru��o da casa. 
			 */
			case 1:
				dadosConstCasa(casa);
			break;
			case 2:
				pintarCasa(casa);
			break;
			case 3:
				moverPorta(casa);
			break;
			case 4:
				moverJanela(casa);
			break;
			case 5:
				informacoesCasa(casa);
			break;
			case 6:
				System.exit(0);
			break;
			default:
				JOptionPane.showMessageDialog(null,"Op��o Inexistente","Erro",JOptionPane.ERROR_MESSAGE);
			break;
			}//T�rmino do switch()
		}//T�rmino do while()
	}//T�rmino m�todo exibirMenu()
	private void dadosConstCasa(Casa casa) {
		//Entrada de dados
		String descricao = JOptionPane.showInputDialog("Descri��o da casa: ");
		String cor = JOptionPane.showInputDialog("Informe a cor da casa: ");
		int quantidadePortas = Integer.parseInt(JOptionPane.showInputDialog("Informe quantas portas: "));
		int quantidadeJanelas = Integer.parseInt(JOptionPane.showInputDialog("Informe quantas janelas"));
		//Declara��o do array listaDeJanelas
				List<Janela> listaDeJanelas = new ArrayList<Janela>();
		for (int i = 0; i < quantidadeJanelas;i++) {
				listaDeJanelas.add(solicitarJanelas(i));
		}
		
		//Declera��o do arry listaDePortas
				List<Porta> listaDePortas = new ArrayList<Porta>();
		for (int c = 0; c < quantidadePortas;c++) {
			listaDePortas.add(solicitarPortas(c));
		}
		
		//Armazena os valores das entradas nos atributos do objeto casa
		casa.construirCasa(descricao,cor,listaDeJanelas,listaDePortas);
		
		//Imprime no controe os valores dos atributos do objeto casa
		
	}//T�rmino do m�todo dadosConstCasa()
	
	/*
	 * Om�todo pintarCasa() produz uma entrada de dados para receber a cor 
	 * que o usu�rio deseja para casa. Na segqu�cia, repassa essa cor para
	 * o m�todo pirtarCasa, localizado na classe Casa, por meio do objeto casa.  
	 */
	private void pintarCasa(Casa casa) {
		if(casa.getCor()==null) {
			JOptionPane.showMessageDialog(null, "N�o tem uma casa!");
		}else {
			String cor = JOptionPane.showInputDialog("Digite a cor da casa: ");
			casa.pintarCasa(cor);
		}
	}
	
	private void moverPorta(Casa casa) {
		if ((casa.getListaDePortas()== null)||(casa.getListaDePortas().isEmpty())) {
			JOptionPane.showMessageDialog(null,"A casa n�o tem porta(s)!","Erro",JOptionPane.ERROR_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "A casa tem porta(s)!","Ok",JOptionPane.INFORMATION_MESSAGE);
			List list = new ArrayList();
			
			for (Porta porta : casa.getListaDePortas()) {
				list.add(porta.getIdentificacao());
			}
			
			JComboBox field1 = new JComboBox(list.toArray());
			String[] listStatus = {"Aberta", "Fechada"};
			JComboBox field2 = new JComboBox(listStatus);
			
			Object[] message = {"Porta: ", field1, "Status: ",field2};
			int option = JOptionPane.showConfirmDialog(null,message, "Porta",JOptionPane.OK_CANCEL_OPTION);
			
			if(option == JOptionPane.OK_OPTION) {
				int status;
				if(field2.getSelectedIndex() == 0) {
					status = 1;
				}else {
					status = 2;
				}
				casa.movimentarPorta(field1.getSelectedIndex(),status);
			}
			
		}
	}
	private void moverJanela(Casa casa) {
		if ((casa.getListaDeJanelas()== null)||(casa.getListaDeJanelas().isEmpty())) {
			JOptionPane.showMessageDialog(null,"A casa n�o tem janela(s)!","Erro",JOptionPane.ERROR_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "A casa tem janela(s)!","Ok",JOptionPane.INFORMATION_MESSAGE);
			List list = new ArrayList();
			
			for (Janela janela : casa.getListaDeJanelas()) {
				list.add(janela.getIdentificacao());
			}
			
			JComboBox field1 = new JComboBox(list.toArray());
			String[] listStatus = {"Aberta", "Fechada"};
			JComboBox field2 = new JComboBox(listStatus);
			
			Object[] message = {"Janela: ", field1, "Status: ",field2};
			int option = JOptionPane.showConfirmDialog(null,message, "Janela",JOptionPane.OK_CANCEL_OPTION);
			
			if(option == JOptionPane.OK_OPTION) {
				int status;
				if(field2.getSelectedIndex() == 0) {
					status = 1;
				}else {
					status = 2;
				}
				casa.movimentarJanela(field1.getSelectedIndex(),status);
			}
			
		}
	}
	
	private void informacoesCasa(Casa casa) {
		if((casa.getListaDeJanelas()==null)||(casa.getListaDePortas()==null)) {
			JOptionPane.showMessageDialog(null,"A casa n�o tem janela(s) ou porta(s)!","Erro",JOptionPane.ERROR_MESSAGE);
		}else {
			String tudo = "";
			int cont = 0;
			tudo += "Descri��o da casa: "+casa.getDescricao()+"\n"+"Cor da casa: "+casa.getCor()+"\n";
			for (Janela janela : casa.getListaDeJanelas()) {
				cont ++;
				tudo += "Descri��o da "+cont+"� janela: "+janela.getIdentificacao()+"\n";
				if(janela.getStatus()==1)
				tudo += "Status da "+cont+"� janela: Aberta\n";
				else
					tudo += "Status da "+cont+"� janela: Fechada\n";
			}
			cont = 0;
			for (Porta porta: casa.getListaDePortas()) {
				cont++;
				tudo += "Descri��o da "+cont+"� porta: "+porta.getIdentificacao()+"\n";
				if(porta.getStatus()==1)
					tudo += "Status da "+cont+"� porta: Aberta\n";
				else
					tudo += "Status da "+cont+"� porta: Fechada\n";

			}
			JOptionPane.showMessageDialog(null,tudo);
				
		}
	}
	
	
	private Janela solicitarJanelas(int i) {
		//Crai o objeto apontando para a instancia da classe Janela
		Janela janela = new Janela();
		//Incremanta a vari�vel i de i
		i = i+1;
		String identificacao = JOptionPane.showInputDialog("Digite a descri��o da janela " + (i) + ": ");
		int status = Integer.parseInt(JOptionPane.showInputDialog("Digite o status da janela " + identificacao
				+ "\n 1 para aberta \n 2 Para fechada: "));
		
		/*
		 * Chama o m�todo setIdenticacao, passando como par�metro a descri��o
		 * recebida da janela atual para que ela seja armasenada no atributo
		 * identificacao da classe Janela
		 */
		janela.setIdentificacao(identificacao);
		/*
		 * Chama o m�todo setStatus de acordo com o status informado pelo usuario,
		 * repassando como par�metro o valor a ser armazenado no atributo status
		 * da classe Janela
		 */
		if (status == 1) {
			janela.setStatus(1);
		}else {
			janela.setStatus(2);
		}
		
		
		
	
		return janela;
	}//T�rmino do m�todo solicitarJanelas()
	private Porta solicitarPortas(int c) {
		Porta porta = new Porta();
		c++;
		String identificacao = JOptionPane.showInputDialog("Digite a descri��o da porta " + (c) + ": ");
		int status = Integer.parseInt(JOptionPane.showInputDialog("Digite o status da porta " + identificacao
				+ "\n 1 para aberta \n 2 Para fechada: "));
		porta.setIdentificacao(identificacao);
		if(status==1)
			porta.setStatus(1);
		else
			porta.setStatus(2);

		return porta;
	}//T�rmino do m�todo solicitarPortas()
}//T�rmino classe MenuOpcoes
