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
import javax.swing.ListSelectionModel;

public class PesquisaAtivo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private CtAtivo ctAtivo;
	private CtTipoAtivo ctTipoAtivo;
	private DefaultTableModel modelAtivos;
	private DefaultTableModel modelTipoAtivos;
	private DialogoUsuario dialogo;
	
	public static JRadioButton rdbtnPesquisarAtivos;
	public static JRadioButton rdbtnPesquisarTipos;
	
	public static String opcaoJanela;
	
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
		opcaoJanela = "views.Aportes";
		
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
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		scrollPane.setViewportView(table);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( table.getSelectedRows().length > 0 ) {
					if( dialogo.confirmarAcao("Deseja confirmar a seleção dos dados??") ) {
						confirmarSelecao();
						dispose();
					}
				}else {
					dialogo.aviso("Por Favor, selecione um ou mais registros");
				}
			}
		});
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
			
			setarModelTabela(1);
			
			ArrayList<String[]> lista = ctTipoAtivo.listar();
			
			for(int i=0; i<lista.size(); i++) {
				modelTipoAtivos.addRow(new Object[] {
						lista.get(i)[0],
						lista.get(i)[1]
				});
			}
		}else if( rdbtnPesquisarAtivos.isSelected() ) {
			
			setarModelTabela(2);
			
			ArrayList<String[]> lista = ctAtivo.listar();
			
			for(int i=0; i<lista.size(); i++) {
				modelAtivos.addRow(new Object[] {
						lista.get(i)[0],
						lista.get(i)[1]
				});
			}
		}
	}
	
	public void confirmarSelecao() {

		int[] listaIndices = table.getSelectedRows();
		ArrayList<String[]> lista = new ArrayList<String[]>();
		
		for(Integer indice : listaIndices) {
			String[] arrLista = new String[2];
			arrLista[0] = table.getValueAt(indice,0).toString();
			arrLista[1] = table.getValueAt(indice,1).toString();
			lista.add(arrLista);
		}
		
		if( rdbtnPesquisarTipos.isSelected() ) {
			models.PesquisaAtivo.setListaTipoAtivo(lista);
			setarCampoJanelaSolicitante(1);
		}else if( rdbtnPesquisarAtivos.isSelected()) {
			models.PesquisaAtivo.setListaAtivo(lista);
			setarCampoJanelaSolicitante(2);
		}
		
	}
	
	/**
	 * @description Metodo abaixo, por hora não respeita o Strategy Design Patterns
	 * O projeto é pequeno, mas a medida que novas telas forem solicitar essa atual
	 * é importante pensar em algo que evite ficar adicionando IFs a cada nova tela que chame 
	 * essa atual
	*/
	public void setarCampoJanelaSolicitante(int opcao) {
		if( opcaoJanela.equals("views.Aportes") ) {
			if( opcao == 1 ) {
				views.Aportes.txtTipoAtivo.setText(models.PesquisaAtivo.getListaTipoAtivo());
			}else if( opcao == 2 ) {
				views.Aportes.txtAtivos.setText(models.PesquisaAtivo.getListaAtivo());	
			}
		}
	}

}
