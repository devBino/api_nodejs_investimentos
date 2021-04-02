package views.janelas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class PesquisaAtivo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PesquisaAtivo frame = new PesquisaAtivo();
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
	public PesquisaAtivo() {
		setTitle("Pequisa de Ativos");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 558, 447);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton rdbtnPesquisarTiposDe = new JRadioButton("Pesquisar Tipos de Ativos");
		rdbtnPesquisarTiposDe.setBounds(71, 25, 207, 23);
		contentPane.add(rdbtnPesquisarTiposDe);
		
		JRadioButton rdbtnPesquisarAtivos = new JRadioButton("Pesquisar Ativos");
		rdbtnPesquisarAtivos.setBounds(288, 25, 207, 23);
		contentPane.add(rdbtnPesquisarAtivos);
		
		JLabel lblDescrioTipoativo = new JLabel("Descrição Tipo/Ativo");
		lblDescrioTipoativo.setBounds(12, 72, 150, 15);
		contentPane.add(lblDescrioTipoativo);
		
		textField = new JTextField();
		textField.setBounds(160, 70, 186, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(348, 70, 82, 19);
		contentPane.add(btnBuscar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 99, 524, 292);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(431, 70, 105, 19);
		contentPane.add(btnConfirmar);
		
		setLocationRelativeTo(null);
	}

}
