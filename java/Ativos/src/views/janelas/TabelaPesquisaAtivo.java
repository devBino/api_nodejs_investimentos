package views.janelas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;

import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TabelaPesquisaAtivo extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	public DefaultTableModel model;
	private String[] colunas;
	public String tipoAtivo;
	public String ativo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TabelaPesquisaAtivo frame = new TabelaPesquisaAtivo();
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
	public TabelaPesquisaAtivo() {
		setUndecorated(true);
		
		colunas = new String[] {"ID","ATIVO"};
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 405, 327);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSeleoDeAtivos = new JLabel("Selecione Um Ativo...");
		lblSeleoDeAtivos.setBounds(12, 10, 209, 15);
		contentPane.add(lblSeleoDeAtivos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 58, 380, 257);
		contentPane.add(scrollPane);
		
		table = new JTable();
		
		model = new DefaultTableModel();
		model.setColumnIdentifiers(colunas);
		
		table.setModel(model);
		
		scrollPane.setViewportView(table);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		btnFechar.setBounds(300, 10, 90, 18);
		contentPane.add(btnFechar);
		
		setLocationRelativeTo(null);
		
		table.requestFocus();
		
	}

}
