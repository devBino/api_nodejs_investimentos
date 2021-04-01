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

public class JnHistoricoAportes extends JInternalFrame {

	private JTable table;
	
	private CtAporte ctAporte;
	private Aporte mdAporte;
	private DefaultTableModel model;
	private JTextField txtNomeAtivo;

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
		
		setTitle("Histórico de Aportes");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 933, 343);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 47, 899, 252);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		model = new DefaultTableModel();
		model.setColumnIdentifiers( mdAporte.getArrayNomesCampos() );
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JButton btnAtualizar = new JButton("Atualizar");
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
		btnFiltrar.setBounds(267, 10, 83, 25);
		getContentPane().add(btnFiltrar);
		
		JButton btnMaisFiltros = new JButton("Mais Filtros");
		btnMaisFiltros.setBounds(450, 10, 117, 25);
		getContentPane().add(btnMaisFiltros);

		
		
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
					lista.get(i)[5],
					lista.get(i)[6],
			});
		}
		
	}
}
