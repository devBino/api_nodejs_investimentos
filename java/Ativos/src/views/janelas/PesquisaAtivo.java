package views.janelas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import java.util.ArrayList;

import controllers.CtTipoAtivo;
import controllers.CtAtivo;
import repositories.DialogoUsuario;

public class PesquisaAtivo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private CtAtivo ctAtivo;
	private CtTipoAtivo ctTipoAtivo;
	private DefaultTableModel modelAtivos;
	private DefaultTableModel modelTipoAtivos;
	private DialogoUsuario dialogo;
	
	private JRadioButton rdbtnPesquisarAtivos;
	private JRadioButton rdbtnPesquisarTipos;
	
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
		
		ctAtivo = new CtAtivo();
		ctTipoAtivo = new CtTipoAtivo();
		dialogo = new DialogoUsuario();
		
		setTitle("Pequisa de Ativos");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 558, 447);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		rdbtnPesquisarTipos = new JRadioButton("Pesquisar Tipos de Ativos");
		rdbtnPesquisarTipos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setarModelTabela(1);
			}
		});
		rdbtnPesquisarTipos.setBounds(71, 25, 207, 23);
		contentPane.add(rdbtnPesquisarTipos);
		
		rdbtnPesquisarAtivos = new JRadioButton("Pesquisar Ativos");
		rdbtnPesquisarAtivos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setarModelTabela(2);
			}
		});
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
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listar();
			}
		});
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
	
	public void setarModelTabela(Integer opcao) {
		if( opcao == 1 ) {
			modelTipoAtivos = new DefaultTableModel();
			Object[] colunas = new Object[] {"ID","TIPO ATIVO"};
			modelTipoAtivos.setColumnIdentifiers(colunas);
			table.setModel(modelTipoAtivos);
			rdbtnPesquisarAtivos.setSelected(false);
		}else {
			modelAtivos = new DefaultTableModel();
			Object[] colunas = new Object[] {"ID","ATIVO"};
			modelAtivos.setColumnIdentifiers(colunas);
			table.setModel(modelAtivos);
			rdbtnPesquisarTipos.setSelected(false);
		}
	}
	
	public void listar() {
		if( rdbtnPesquisarTipos.isSelected() ) {
			ArrayList<String[]> lista = ctTipoAtivo.listar();
			
			for(int i=0; i<lista.size(); i++) {
				modelTipoAtivos.addRow(new Object[] {
						lista.get(i)[0],
						lista.get(i)[1]
				});
			}
		}else {
			ArrayList<String[]> lista = ctAtivo.listar();
			
			for(int i=0; i<lista.size(); i++) {
				modelAtivos.addRow(new Object[] {
						lista.get(i)[0],
						lista.get(i)[1]
				});
			}
		}
	}

}
