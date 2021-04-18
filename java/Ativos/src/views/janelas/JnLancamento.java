package views.janelas;

import java.awt.EventQueue;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.text.ParseException;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.border.SoftBevelBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;

import java.util.ArrayList;

import controllers.CtAporte;
import repositories.Numero;
import repositories.DialogoUsuario;
import repositories.Data;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class JnLancamento extends JInternalFrame {
	
	private JTextField txtValor;
	private JTextField txtQtde;
	private JTextField txtSubTotal;
	private JTextField txtTxRetorno;
	private JFormattedTextField txtData;
	private JComboBox cbxAtivo;
	
	private CtAporte ctAporte;
	private Numero numero;
	private DialogoUsuario dialogo;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JnLancamento frame = new JnLancamento();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public JnLancamento() throws ParseException {
		
		dialogo = new DialogoUsuario();
		ctAporte = new CtAporte();
		numero = new Numero();
		
		setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		setTitle("Lançar Aportes");
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 306, 251);
		getContentPane().setLayout(null);
		
		JLabel lblAtivo = new JLabel("Ativo");
		lblAtivo.setBounds(12, 12, 95, 15);
		getContentPane().add(lblAtivo);
		
		cbxAtivo = new JComboBox();
		cbxAtivo.setBounds(114, 7, 161, 24);
		getContentPane().add(cbxAtivo);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(12, 39, 95, 15);
		getContentPane().add(lblValor);
		
		txtValor = new JTextField();
		txtValor.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				txtValor.setText( numero.getNumero( txtValor.getText() ) );
				calcularSubTotal();
			}
		});
		txtValor.setBounds(114, 37, 161, 19);
		getContentPane().add(txtValor);
		txtValor.setColumns(10);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(12, 66, 95, 15);
		getContentPane().add(lblQuantidade);
		
		txtQtde = new JTextField();
		txtQtde.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				txtQtde.setText( numero.getNumero( txtQtde.getText() ) );
				calcularSubTotal();
			}
		});
		txtQtde.setBounds(114, 62, 161, 19);
		getContentPane().add(txtQtde);
		txtQtde.setColumns(10);
		
		JLabel lblSubtotal = new JLabel("SubTotal");
		lblSubtotal.setBounds(12, 93, 95, 15);
		getContentPane().add(lblSubtotal);
		
		txtSubTotal = new JTextField();
		txtSubTotal.setEnabled(false);
		txtSubTotal.setBounds(114, 91, 161, 19);
		getContentPane().add(txtSubTotal);
		txtSubTotal.setColumns(10);
		
		JLabel lblData = new JLabel("Data");
		lblData.setBounds(12, 120, 95, 15);
		getContentPane().add(lblData);
		
		txtData = new JFormattedTextField(new MaskFormatter("##/##/####"));
		txtData.setBounds(114, 120, 161, 19);
		getContentPane().add(txtData);
		
		JLabel lblTxRetorno = new JLabel("Tx. Retorno");
		lblTxRetorno.setBounds(12, 147, 95, 15);
		getContentPane().add(lblTxRetorno);
		
		txtTxRetorno = new JTextField();
		txtTxRetorno.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				txtTxRetorno.setText( numero.getNumero( txtTxRetorno.getText() ) );
			}
		});
		
		txtTxRetorno.setBounds(114, 145, 161, 19);
		getContentPane().add(txtTxRetorno);
		txtTxRetorno.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvar();
			}
		});
		btnSalvar.setBounds(158, 174, 117, 25);
		getContentPane().add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar(true);
			}
		});
		btnCancelar.setBounds(39, 174, 117, 25);
		getContentPane().add(btnCancelar);
		
		listarComboAtivo();
		
	}
	
	public void listarComboAtivo() {
		ArrayList<String[]> lista = ctAporte.listarComboAtivo();
		
		cbxAtivo.addItem("");
		
		for(int i=0; i<lista.size(); i++) {
			cbxAtivo.addItem( lista.get(i)[0]+" - "+lista.get(i)[1] );
		}
		
	}
	
	public void calcularSubTotal() {
		try {
			Double valor = Double.parseDouble( txtValor.getText().replace(",",".") );
			Double qtde = Double.parseDouble( txtQtde.getText().replace(",",".") );
			Double subTotal = valor * qtde;
			
			txtSubTotal.setText( numero.getNumero( subTotal.toString() ) );
			
		}catch(Exception e) {}
	}
	
	public void limpar(boolean confirmar) {
		if( confirmar ) {
			if( dialogo.confirmarAcao("Deseja Cancelar e Limpar os dados do lançamento em andamento??") ) {
				cbxAtivo.setSelectedItem("");
				txtValor.setText("");
				txtQtde.setText("");
				txtSubTotal.setText("");
				txtData.setText("");
				txtTxRetorno.setText("");
				
				cbxAtivo.requestFocus();
			}
		}else {
			cbxAtivo.setSelectedItem("");
			txtValor.setText("");
			txtQtde.setText("");
			txtSubTotal.setText("");
			txtData.setText("");
			txtTxRetorno.setText("");
			
			cbxAtivo.requestFocus();
		}
	}
	
	public void salvar() {

		String[] arrAtivo = cbxAtivo.getSelectedItem().toString().split("-");
		
		Data dt = new Data(txtData.getText());
		String paramData = txtData.getText().replace("/","").trim();
		
		String[] params = new String[] {
			arrAtivo[0].toString(),
			txtValor.getText().replace(",","."),
			txtQtde.getText().replace(",","."),
			txtSubTotal.getText().replace(",","."),
			( paramData.isEmpty() ) ? "" : dt.getData(),
			txtTxRetorno.getText().replace(",",".")
		};
		
		boolean vazio = false;
		
		for( String param : params ) {
			if( param.isEmpty() ) {
				vazio = true;
				break;
			}
		}
		
		if( !vazio ) {
			ctAporte.salvar(params);
			JnHistoricoAportes.listar();
			limpar(false);
		}else {
			dialogo.aviso("Existem um ou mais campos vazio, por favor verifique...");
			cbxAtivo.requestFocus();
		}
		
	}
	
}
