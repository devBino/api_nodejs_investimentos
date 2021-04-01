package views.janelas;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;

public class JnLancamento extends JInternalFrame {
	private JTextField txtValor;
	private JTextField txtTotal;
	private JTextField txtSubTotal;
	private JTextField textField;

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
	 */
	public JnLancamento() {
		setTitle("Lançar Aportes");
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 306, 251);
		getContentPane().setLayout(null);
		
		JLabel lblAtivo = new JLabel("Ativo");
		lblAtivo.setBounds(12, 12, 95, 15);
		getContentPane().add(lblAtivo);
		
		JComboBox cbxAtivo = new JComboBox();
		cbxAtivo.setBounds(114, 7, 161, 24);
		getContentPane().add(cbxAtivo);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(12, 39, 95, 15);
		getContentPane().add(lblValor);
		
		txtValor = new JTextField();
		txtValor.setBounds(114, 37, 161, 19);
		getContentPane().add(txtValor);
		txtValor.setColumns(10);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(12, 66, 95, 15);
		getContentPane().add(lblQuantidade);
		
		txtTotal = new JTextField();
		txtTotal.setBounds(114, 62, 161, 19);
		getContentPane().add(txtTotal);
		txtTotal.setColumns(10);
		
		JLabel lblSubtotal = new JLabel("SubTotal");
		lblSubtotal.setBounds(12, 93, 95, 15);
		getContentPane().add(lblSubtotal);
		
		txtSubTotal = new JTextField();
		txtSubTotal.setBounds(114, 91, 161, 19);
		getContentPane().add(txtSubTotal);
		txtSubTotal.setColumns(10);
		
		JLabel lblData = new JLabel("Data");
		lblData.setBounds(12, 120, 95, 15);
		getContentPane().add(lblData);
		
		JFormattedTextField txtData = new JFormattedTextField();
		txtData.setBounds(114, 120, 161, 19);
		getContentPane().add(txtData);
		
		JLabel lblTxRetorno = new JLabel("Tx. Retorno");
		lblTxRetorno.setBounds(12, 147, 95, 15);
		getContentPane().add(lblTxRetorno);
		
		textField = new JTextField();
		textField.setBounds(114, 145, 161, 19);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(158, 174, 117, 25);
		getContentPane().add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(39, 174, 117, 25);
		getContentPane().add(btnCancelar);

		
	}
}
