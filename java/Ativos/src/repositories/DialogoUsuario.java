package repositories;

import javax.swing.JOptionPane;

public class DialogoUsuario {


	public boolean confirmarAcao(String msg) {
		int resposta = JOptionPane.showConfirmDialog(null, msg, "Responda",JOptionPane.YES_NO_OPTION);
		
		if( resposta == 0 ) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean confirmarEncerrarApp() {
		int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente encerrar a aplicação??","Responda",JOptionPane.YES_NO_OPTION);
		
		if(resposta == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean confirmarLog0ff() {
		int resposta = JOptionPane.showConfirmDialog(null, "Deseja realizar logoff??","Responda",JOptionPane.YES_NO_OPTION);
		
		if(resposta == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public void campoNaoInformado(String nomeCampo) {
		JOptionPane.showMessageDialog(null, "Atenção, o campo "+nomeCampo+" não foi informado...","Aviso",JOptionPane.WARNING_MESSAGE);
	}
	
	public void sucesso(String msg) {
		JOptionPane.showMessageDialog(null, msg,"Informação",JOptionPane.INFORMATION_MESSAGE);
	}
	public void acaoNaoConcluida(String msg) {
		JOptionPane.showMessageDialog(null, msg,"Aviso",JOptionPane.WARNING_MESSAGE);
	}
	
	public void aviso(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Aviso",JOptionPane.WARNING_MESSAGE);
	}
	
}
