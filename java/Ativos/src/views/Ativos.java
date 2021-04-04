package views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import java.util.List;
import java.util.ArrayList;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

import controllers.CtAtivo;
import controllers.CtTipoAtivo;
import models.Ativo;
import models.TipoAtivo;
import parametros.Parametros;
import repositories.DialogoUsuario;
import repositories.Numero;


public class Ativos extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeAtivo;
	private JLabel lblValorCota;
	private JTextField txtValor;
	private JLabel lblNewLabel;
	private JLabel lblTxAdministracao;
	private JLabel lblTxCustdia;
	private JLabel lblTxPerformance;
	private JTextField txtTxAdministracao;
	private JTextField txtTxCustodia;
	private JTextField txtTxPerforamnce;
	private JTable table;
	private JComboBox cbxTipoAtivo;
	private JButton btnRegistroAnterior;
	private JButton btnProximoRegistro;
	
	private DefaultTableModel model;
	private DialogoUsuario dialogo = new DialogoUsuario();
	private CtAtivo ctAtivo = new CtAtivo();
	private Numero numero;
	
	private String idAtivo = "";
	private int indexRegistro = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ativos frame = new Ativos();
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
	public Ativos() {
		
		numero = new Numero();
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Sistema s = new Sistema();
				s.setVisible(true);
			}
		});
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 711, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastroDeAtivos = new JLabel("Cadastro de Ativos Financeiros");
		lblCadastroDeAtivos.setForeground(SystemColor.activeCaption);
		lblCadastroDeAtivos.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		lblCadastroDeAtivos.setBounds(12, 0, 292, 15);
		contentPane.add(lblCadastroDeAtivos);
		
		JLabel lblNomeAtivo = new JLabel("Nome Ativo");
		lblNomeAtivo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNomeAtivo.setBounds(12, 74, 95, 15);
		contentPane.add(lblNomeAtivo);
		
		txtNomeAtivo = new JTextField();
		txtNomeAtivo.setBounds(112, 71, 192, 19);
		contentPane.add(txtNomeAtivo);
		txtNomeAtivo.setColumns(10);
		
		lblValorCota = new JLabel("Valor Cota");
		lblValorCota.setHorizontalAlignment(SwingConstants.RIGHT);
		lblValorCota.setBounds(307, 73, 135, 15);
		contentPane.add(lblValorCota);
		
		txtValor = new JTextField();
		txtValor.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				txtValor.setText( numero.getNumero( txtValor.getText() ) );
			}
		});
		txtValor.setBounds(445, 71, 160, 19);
		contentPane.add(txtValor);
		txtValor.setColumns(10);
		
		lblNewLabel = new JLabel("Tipo Ativo");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(12, 104, 95, 15);
		contentPane.add(lblNewLabel);
		
		cbxTipoAtivo = new JComboBox();
		cbxTipoAtivo.setBounds(112, 100, 192, 24);
		contentPane.add(cbxTipoAtivo);
		
		lblTxAdministracao = new JLabel("Tx. Administração");
		lblTxAdministracao.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTxAdministracao.setBounds(307, 102, 135, 15);
		contentPane.add(lblTxAdministracao);
		
		lblTxCustdia = new JLabel("Tx. Custódia");
		lblTxCustdia.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTxCustdia.setBounds(12, 136, 95, 15);
		contentPane.add(lblTxCustdia);
		
		lblTxPerformance = new JLabel("Tx. Performance");
		lblTxPerformance.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTxPerformance.setBounds(307, 136, 135, 15);
		contentPane.add(lblTxPerformance);
		
		txtTxAdministracao = new JTextField();
		txtTxAdministracao.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				txtTxAdministracao.setText( numero.getNumero( txtTxAdministracao.getText() ));
			}
		});
		txtTxAdministracao.setBounds(445, 101, 160, 19);
		contentPane.add(txtTxAdministracao);
		txtTxAdministracao.setColumns(10);
		
		txtTxCustodia = new JTextField();
		txtTxCustodia.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				txtTxCustodia.setText( numero.getNumero( txtTxCustodia.getText() ) );
			}
		});
		
		txtTxCustodia.setBounds(112, 134, 192, 19);
		contentPane.add(txtTxCustodia);
		txtTxCustodia.setColumns(10);
		
		txtTxPerforamnce = new JTextField();
		txtTxPerforamnce.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				txtTxPerforamnce.setText( numero.getNumero( txtTxPerforamnce.getText() ) );
			}
		});
		txtTxPerforamnce.setBounds(445, 134, 160, 19);
		contentPane.add(txtTxPerforamnce);
		txtTxPerforamnce.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvar();
			}
		});
		btnSalvar.setBounds(12, 27, 78, 25);
		contentPane.add(btnSalvar);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listar();
			}
		});
		btnListar.setBounds(92, 27, 78, 25);
		contentPane.add(btnListar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletar();
			}
		});
		btnDeletar.setBounds(172, 27, 87, 25);
		contentPane.add(btnDeletar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( telaContemDados() ) {
					limpar(true);
				}else {
					dialogo.aviso("Não existem dados carregados...");
				}
			}
		});
		btnLimpar.setBounds(260, 27, 87, 25);
		contentPane.add(btnLimpar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 195, 687, 241);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setShowGrid(false);
		table.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				getDadosLinha(table.getSelectedRow());
			}
		});
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getDadosLinha(table.getSelectedRow());
			}
		});
		scrollPane.setViewportView(table);
		
		model = new DefaultTableModel();
		Object[] colunas = {"ID","ATIVO","VALOR","TIPO","TX.ADMIN.","TX.CUSTÓDIA","TX.PERFORMANCE"};
		Object[] linhas = new Object[0];
		model.setColumnIdentifiers(colunas);
		table.setModel(model);
		
		btnRegistroAnterior = new JButton("<<");
		btnRegistroAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( model.getRowCount() > 0 ) {
					registroAnterior();	
				}else {
					dialogo.aviso("Favor Listar os registros e tentar novamente...");
				}
			}
		});
		btnRegistroAnterior.setBounds(351, 27, 54, 25);
		contentPane.add(btnRegistroAnterior);
		
		btnProximoRegistro = new JButton(">>");
		btnProximoRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( model.getRowCount() > 0 ) {
					proximoRegistro();	
				}else {
					dialogo.aviso("Favor Listar os registros e tentar novamente...");
				}
			}
		});
		btnProximoRegistro.setBounds(406, 27, 54, 25);
		contentPane.add(btnProximoRegistro);
		
		povoarComboTipoAtivos();
		
		setLocationRelativeTo(null);
	}
	
	public void salvar() {
		//captura parametros da tela
		String[] arrTipoAtivo = cbxTipoAtivo.getSelectedItem().toString().split("-");
		
		String[] params = new String[] {
			txtNomeAtivo.getText(),
			txtValor.getText().replaceAll(",","."),
			txtTxAdministracao.getText().replaceAll(",","."),
			txtTxCustodia.getText().replaceAll(",","."),
			txtTxPerforamnce.getText().replaceAll(",","."),
			arrTipoAtivo[0].trim()
		};
		
		boolean vazio = false;
		
		//verifica se algum vazio
		for(int i=0; i<params.length; i++) {
			if(params[i].isEmpty()) {
				vazio =  true;
				break;
			}
		}
		
		if( !vazio ) {
			//verifica se é novo registro ou existente
			if( idAtivo.isEmpty() ) {
				ctAtivo.salvar(params);
				limpar(false);
				listar();
			}else {
				ctAtivo.alterar(params,idAtivo);
				limpar(false);
				listar();
			}
		}else {
			dialogo.aviso("Existem um ou mais campos vazio, por favor verifique...");
			txtNomeAtivo.requestFocus();
		}		
		
	}	

	public void listar() {
		model.setNumRows(0);
		ArrayList<String[]> lista = ctAtivo.listar();

		for(int i=0; i<lista.size(); i++) {
			model.addRow(new Object[] {
					lista.get(i)[0],
					lista.get(i)[1],
					lista.get(i)[2],
					lista.get(i)[6],
					lista.get(i)[3],
					lista.get(i)[4],
					lista.get(i)[5]
			});
		}
	}
	
	public boolean telaContemDados() {
		
		Boolean[] dadosCampos = new Boolean[7];
		
		dadosCampos[0] = !txtNomeAtivo.getText().isEmpty();
		dadosCampos[1] = !txtTxAdministracao.getText().isEmpty();
		dadosCampos[2] = !txtTxCustodia.getText().isEmpty();
		dadosCampos[3] = !txtTxPerforamnce.getText().isEmpty();
		dadosCampos[4] = !txtValor.getText().isEmpty();
		dadosCampos[5] = ( cbxTipoAtivo.getSelectedIndex() > 0 );
		dadosCampos[6] = ( model.getRowCount() > 0 );
		
		boolean temConteudo = false;
		
		for(Boolean b : dadosCampos) {
			
			if( b ) {
				temConteudo = true;
				break;
			}
		}
		
		return temConteudo;
	}
	
	public void limpar(boolean confirmar) {
		if(confirmar) {
			if( dialogo.confirmarAcao("Deseja limpar os dados da Tela  ??") ){
				txtNomeAtivo.setText("");
				txtValor.setText("");
				txtTxAdministracao.setText("");
				txtTxCustodia.setText("");
				txtTxPerforamnce.setText("");
				cbxTipoAtivo.setSelectedItem("");
				btnRegistroAnterior.setEnabled(true);
				btnProximoRegistro.setEnabled(true);
				
				model.setNumRows(0);
				idAtivo = "";
				indexRegistro = 0;
				
				txtNomeAtivo.requestFocus();
			}
		}else {
			txtNomeAtivo.setText("");
			txtValor.setText("");
			txtTxAdministracao.setText("");
			txtTxCustodia.setText("");
			txtTxPerforamnce.setText("");
			cbxTipoAtivo.setSelectedItem("");
			btnRegistroAnterior.setEnabled(true);
			btnProximoRegistro.setEnabled(false);
			
			model.setNumRows(0);
			idAtivo = "";
			indexRegistro = 0;
			
			txtNomeAtivo.requestFocus();
		}
	}
	public void deletar() {
		if( idAtivo.isEmpty() ) {
			dialogo.aviso("Por favor, selecione um Ativo Financeiro...");
		}else {
			if(dialogo.confirmarAcao("Deseja deletar o Ativo Financeiro "+txtNomeAtivo.getText()+" ??")) {
				ctAtivo.deletar(idAtivo);
				limpar(false);
				listar();
			}
		}
	}
	public void povoarComboTipoAtivos() {
		ArrayList<TipoAtivo> tipoAtivos = ctAtivo.listarCombo();
		
		cbxTipoAtivo.addItem("");
		
		for(int i=0; i<tipoAtivos.size(); i++) {
			cbxTipoAtivo.addItem(tipoAtivos.get(i).toString());
		}
	}
	
	public void getDadosLinha(int linha) {
				
		int indexCombo = getIndexCombo(model.getValueAt(linha,3).toString());
		
		idAtivo = model.getValueAt(linha,0).toString();
		
		txtNomeAtivo.setText( model.getValueAt(linha,1).toString() );
		txtValor.setText( model.getValueAt(linha,2).toString() );
		cbxTipoAtivo.setSelectedIndex(indexCombo);
		txtTxAdministracao.setText( model.getValueAt(linha,4).toString() );
		txtTxCustodia.setText( model.getValueAt(linha,5).toString());
		txtTxPerforamnce.setText( model.getValueAt(linha,6).toString() );
		
	}
	
	public int getIndexCombo(String strId) {
		
		int index = 0;
		
		for( int i=0; i<cbxTipoAtivo.getModel().getSize(); i++ ) {
			if( cbxTipoAtivo.getModel().getElementAt(i).toString().startsWith(strId) ) {
				index = i;
				break;
			}
		}
		
		return index;
	}
	
	public void registroAnterior() {
		try {
			if( model.getRowCount() >= 1 && indexRegistro > 0 ) {
				indexRegistro = indexRegistro - 1;
			}else {
				indexRegistro = 0;
				btnRegistroAnterior.setEnabled(false);
				btnProximoRegistro.setEnabled(true);
			}
			
		}catch(Exception e) {
			indexRegistro = 0;
			
			btnRegistroAnterior.setEnabled(false);
			btnProximoRegistro.setEnabled(true);
		}
		
		int indexCombo = getIndexCombo(model.getValueAt(indexRegistro,3).toString());
		
		idAtivo = model.getValueAt(indexRegistro,0).toString();
		txtNomeAtivo.setText( model.getValueAt(indexRegistro, 1).toString() );
		txtValor.setText( model.getValueAt(indexRegistro,2).toString() );
		cbxTipoAtivo.setSelectedIndex(indexCombo);
		txtTxAdministracao.setText( model.getValueAt(indexRegistro,4).toString() );
		txtTxCustodia.setText( model.getValueAt(indexRegistro,5).toString());
		txtTxPerforamnce.setText( model.getValueAt(indexRegistro,6).toString() );
		
	}
	
	public void proximoRegistro() {
		try {
			if( model.getRowCount() > 0 && indexRegistro < model.getRowCount() - 1 ) {
				indexRegistro = indexRegistro + 1;
			}else {
				indexRegistro = model.getRowCount() - 1;
				
				btnRegistroAnterior.setEnabled(true);
				btnProximoRegistro.setEnabled(false);
			}
		}catch(Exception e) {
			indexRegistro = model.getRowCount() - 1;
			
			btnRegistroAnterior.setEnabled(true);
			btnProximoRegistro.setEnabled(false);
		}
		
		int indexCombo = getIndexCombo(model.getValueAt(indexRegistro,3).toString());
		
		idAtivo = model.getValueAt(indexRegistro,0).toString();
		txtNomeAtivo.setText( model.getValueAt(indexRegistro, 1).toString() );
		txtValor.setText( model.getValueAt(indexRegistro,2).toString() );
		cbxTipoAtivo.setSelectedIndex(indexCombo);
		txtTxAdministracao.setText( model.getValueAt(indexRegistro,4).toString() );
		txtTxCustodia.setText( model.getValueAt(indexRegistro,5).toString());
		txtTxPerforamnce.setText( model.getValueAt(indexRegistro,6).toString() );
	}
	
	
}
