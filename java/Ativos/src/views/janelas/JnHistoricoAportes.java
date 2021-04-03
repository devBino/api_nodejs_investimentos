package views.janelas;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import java.util.List;
import java.util.ArrayList;

import controllers.CtAporte;
import models.Aporte;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import repositories.DialogoUsuario;

public class JnHistoricoAportes extends JInternalFrame {

	public static JTable table;
	
	private CtAporte ctAporte;
	private Aporte mdAporte;
	private DefaultTableModel model;
	private JTextField txtNomeAtivo;
	private DialogoUsuario dialogo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JnHistoricoAportes frame = new JnHistoricoAportes();
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
	public JnHistoricoAportes() {
		
		ctAporte = new CtAporte();
		mdAporte = new Aporte();
		dialogo = new DialogoUsuario();
		
		setTitle("Histórico de Aportes");
		setIconifiable(true);
		setClosable(true);
		setBounds(10,270,830,275);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 47, 796, 184);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		model = new DefaultTableModel();
		model.setColumnIdentifiers( mdAporte.getArrayNomesCampos() );
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listar();
			}
		});
		btnAtualizar.setBounds(351, 10, 98, 25);
		getContentPane().add(btnAtualizar);
		
		JLabel lblNomeAtivo = new JLabel("Nome Ativo");
		lblNomeAtivo.setBounds(12, 20, 91, 15);
		getContentPane().add(lblNomeAtivo);
		
		txtNomeAtivo = new JTextField();
		txtNomeAtivo.setBounds(106, 16, 149, 19);
		getContentPane().add(txtNomeAtivo);
		txtNomeAtivo.setColumns(10);
		
		JButton btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filtrarNomeAtivo();
			}
		});
		btnFiltrar.setBounds(267, 10, 83, 25);
		getContentPane().add(btnFiltrar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				model.removeRow(i);
			}
		});
		btnDeletar.setBounds(450, 10, 117, 25);
		getContentPane().add(btnDeletar);

		
		
		listar();
	}
	
	public void listar() {
		
		model.setNumRows(0);
		
		ArrayList<String[]> lista = ctAporte.listar();
		
		for( int i=0; i<lista.size(); i++ ) {
			model.addRow(new String[] {
					lista.get(i)[0],
					lista.get(i)[8],
					lista.get(i)[2],
					lista.get(i)[3],
					lista.get(i)[4],
					lista.get(i)[5].substring(0,10),
					lista.get(i)[6],
			});
		}
		
	}
	
	public void filtrarNomeAtivo() {
		if( !txtNomeAtivo.getText().isEmpty() ) {
			
			listar();
			
			DefaultTableModel modelFiltro = new DefaultTableModel();
			modelFiltro.setColumnIdentifiers( mdAporte.getArrayNomesCampos() );
			
			for( int i=0; i<model.getRowCount(); i++ ) {
				if(model.getValueAt(i,1).toString().toLowerCase().contains( txtNomeAtivo.getText().toLowerCase() )) {
					
					String[] objRow = new String[model.getColumnCount()];
					
					for( int j=0; j<model.getColumnCount(); j++ ) {						
						objRow[j] = model.getValueAt(i,j).toString();
					}
					
					modelFiltro.addRow(objRow);
				}
				
			}
			
			model = modelFiltro;
			table.setModel(model);
		}else {
			dialogo.aviso("Por favor, informe o nome do ativo...");
			txtNomeAtivo.requestFocus();
		}
	}
}
