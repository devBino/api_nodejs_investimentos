package views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.List;
import java.util.ArrayList;

import controllers.CtTipoAtivo;
import models.Sessao;
import parametros.Parametros;
import repositories.DialogoUsuario;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TipoAtivos extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeTipo;
	
	private DefaultTableModel model;
	private CtTipoAtivo ctTipo = new CtTipoAtivo();
	private DialogoUsuario dialogo = new DialogoUsuario();
	private JTable table;
	private JLabel lblRegistros;
	private JButton btnRegistroAnterior;
	private JButton btnProximoRegistro;
	
	private String idTipo = "";
	private int indexRegistro = 0;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TipoAtivos frame = new TipoAtivos();
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
	public TipoAtivos() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Sistema s = new Sistema();
				s.setVisible(true);
			}
		});
		setResizable(false);
		setTitle("Cadastro de Ativos - Tipos de Ativos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 552, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTipoAtivo = new JLabel("Tipo Ativo");
		lblTipoAtivo.setBounds(12, 100, 70, 15);
		contentPane.add(lblTipoAtivo);
		
		txtNomeTipo = new JTextField();
		txtNomeTipo.setBounds(100, 98, 434, 19);
		contentPane.add(txtNomeTipo);
		txtNomeTipo.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvar();
			}
		});
		btnSalvar.setBounds(12, 52, 84, 25);
		contentPane.add(btnSalvar);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listar();
			}
		});
		btnListar.setBounds(100, 52, 90, 25);
		contentPane.add(btnListar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		
		
		scrollPane.setBounds(12, 130, 522, 236);
		contentPane.add(scrollPane);
		
		table = new JTable();
		
		table.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				int linhaClicada = table.getSelectedRow();
				idTipo = model.getValueAt(linhaClicada,0).toString();
				txtNomeTipo.setText(model.getValueAt(linhaClicada,1).toString());
			}
		});
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int linhaClicada = table.getSelectedRow();
				idTipo = model.getValueAt(linhaClicada, 0).toString();
				txtNomeTipo.setText(model.getValueAt(linhaClicada, 1).toString());
				txtNomeTipo.requestFocus();
			}
		});
		
		model = new DefaultTableModel();
		
		Object[] colunas = {"ID","ATIVO","SITUAÇÃO"};
		Object[] linhas = new Object[0];
		
		model.setColumnIdentifiers(colunas);
		model.isCellEditable(0, 0);
		table.setModel(model);
		
		scrollPane.setViewportView(table);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletar();
			}
		});
		btnDeletar.setBounds(193, 52, 90, 25);
		contentPane.add(btnDeletar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar(true);
			}
		});
		btnLimpar.setBounds(287, 52, 84, 25);
		contentPane.add(btnLimpar);
		
		JLabel lblNewLabel = new JLabel("Cadastro de Tipo de Ativos");
		lblNewLabel.setForeground(SystemColor.activeCaption);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel.setBounds(12, 12, 271, 15);
		contentPane.add(lblNewLabel);
		
		btnRegistroAnterior = new JButton("<<");
		btnRegistroAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registroAnterior();
			}
		});
		btnRegistroAnterior.setBounds(373, 52, 54, 25);
		contentPane.add(btnRegistroAnterior);
		
		btnProximoRegistro = new JButton(">>");
		btnProximoRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				proximoRegistro();
			}
		});
		btnProximoRegistro.setBounds(428, 52, 54, 25);
		contentPane.add(btnProximoRegistro);
		
		setLocationRelativeTo(null);
		txtNomeTipo.requestFocus();
	}
	
	public void limpar(boolean confirmar) {
		if( confirmar ) {
			if( dialogo.confirmarAcao("Deseja Limpar os dados da Tela??") ) {
				txtNomeTipo.setText("");
				model.setNumRows(0);
				idTipo = "";
				indexRegistro = 0;
				btnRegistroAnterior.setEnabled(true);
				btnProximoRegistro.setEnabled(true);				
				txtNomeTipo.requestFocus();
			}
		}else {
			txtNomeTipo.setText("");
			model.setNumRows(0);
			idTipo = "";
			indexRegistro = 0;
			btnRegistroAnterior.setEnabled(true);
			btnProximoRegistro.setEnabled(true);
			txtNomeTipo.requestFocus();
		}
	}
	
	public void salvar() {
		if( idTipo.isEmpty() ) {
			if(txtNomeTipo.getText().isEmpty()) {
				dialogo.campoNaoInformado("Tipo Ativo");
			}else {
				ctTipo.salvar(txtNomeTipo.getText());
				limpar(false);
				listar();
			}
		}else {
			if(txtNomeTipo.getText().isEmpty()) {
				dialogo.campoNaoInformado("Tipo Ativo");
			}else {
				ctTipo.alterar(txtNomeTipo.getText(), idTipo);
				limpar(false);
				listar();
			}
		}
	}
	public void listar() {
		
		model.setNumRows(0);
		
		ArrayList<String[]> lista = ctTipo.listar();
		
		for(int i=0; i<lista.size(); i++) {
			String[] arrLinha = lista.get(i);
			model.addRow( new Object[] {arrLinha[0],arrLinha[1],  Parametros.situacoes[ Integer.parseInt(arrLinha[2]) ] } );
		}
		
	}
	public void deletar() {
		if( idTipo.isEmpty() ) {
			dialogo.aviso("Por favor, selecione um registro da tabela...");
		}else {
			if( dialogo.confirmarAcao("Deseja Deletar o Tipo de Ativo "+txtNomeTipo.getText()+" ??") ) {
				ctTipo.deletar(idTipo);
				limpar(false);
				listar();
			}
		}
	}
	public void registroAnterior() {
		try {
			if( model.getRowCount() >= 1 && indexRegistro > 0 ) {
				
				idTipo = model.getValueAt(indexRegistro,0).toString();
				txtNomeTipo.setText( model.getValueAt(indexRegistro, 1).toString() );
				
				indexRegistro = indexRegistro - 1;
			}else {
				idTipo = model.getValueAt(0,0).toString();
				txtNomeTipo.setText( model.getValueAt(0,1).toString() );
				indexRegistro = 0;
				
				btnRegistroAnterior.setEnabled(false);
				btnProximoRegistro.setEnabled(true);
			}
		}catch(Exception e) {
			idTipo = model.getValueAt(0,0).toString();
			txtNomeTipo.setText( model.getValueAt(0,1).toString() );
			
			indexRegistro = 0;
			
			btnRegistroAnterior.setEnabled(false);
			btnProximoRegistro.setEnabled(true);
		}
		
	}
	public void proximoRegistro() {
		try {
			if( model.getRowCount() > 0 && indexRegistro < model.getRowCount() - 1 ) {
				idTipo = model.getValueAt(indexRegistro,0).toString();
				txtNomeTipo.setText( model.getValueAt(indexRegistro,1).toString() );
				
				indexRegistro = indexRegistro + 1;
			}else {
				idTipo = model.getValueAt(model.getRowCount()-1,0).toString();
				txtNomeTipo.setText( model.getValueAt(model.getRowCount()-1,1).toString() );
				indexRegistro = model.getRowCount() - 1;
				
				btnRegistroAnterior.setEnabled(true);
				btnProximoRegistro.setEnabled(false);
			}
		}catch(Exception e) {
			idTipo = model.getValueAt(model.getRowCount()-1,0).toString();
			txtNomeTipo.setText( model.getValueAt(model.getRowCount()-1,1).toString() );
			indexRegistro = model.getRowCount() - 1;
			
			btnRegistroAnterior.setEnabled(true);
			btnProximoRegistro.setEnabled(false);
		}
	}
	
}