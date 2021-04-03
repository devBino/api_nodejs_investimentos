package views;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JInternalFrame;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.border.SoftBevelBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import javax.swing.JDesktopPane;

import java.text.ParseException;

import views.janelas.JnHistoricoAportes;
import views.janelas.JnLancamento;
import views.janelas.JnCotacaoAportes;
import views.janelas.PesquisaAtivo;
import repositories.DialogoUsuario;
import repositories.Numero;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Aportes extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;
	
	public static JTextField txtAtivos;
	public static JTextField txtTipoAtivo;
	
	private JTextField txtValorMaiorIgual;
	private JTextField txtValorMenorIgual;
	private JTextField txtQtdeMaiorIgual;
	private JTextField txtQtdeMenorIgual;
	private JTextField txtSubTotalMaiorIgual;
	private JTextField txtSubTotalMenorIgual;
	private JTextField txtTxRetorno;
	
	public JnLancamento jnlancamento;
	public JnCotacaoAportes jnCotacaoAportes;
	public JnHistoricoAportes jnHistoricoAportes;
	public Boolean janelasAdicionadasInicio;
	
	private DialogoUsuario dialogo;
	private Numero numero;
	
	public static String listaAuxiliarTiposAtivos; 
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aportes frame = new Aportes();
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
	public Aportes() throws ParseException {
	
		dialogo = new DialogoUsuario();
		janelasAdicionadasInicio = false;
		numero = new Numero();
		listaAuxiliarTiposAtivos = "";
		
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Sistema s = new Sistema();
				s.setVisible(true);
			}
		});
		
		setTitle("Cadastro de Ativos - Aportes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1044, 661);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLanamentos = new JButton("Lançamentos");
		btnLanamentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( !jnlancamento.isVisible() ) {
				
					jnlancamento = new JnLancamento();
					desktopPane.add(jnlancamento);
					jnlancamento.setVisible(true);
					jnlancamento.setBounds(10, 10, 306, 251);
					
				}
			}
		});
		btnLanamentos.setBounds(12, 5, 174, 25);
		contentPane.add(btnLanamentos);
		
		JButton btnHistorico = new JButton("Histórico");
		btnHistorico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( !jnHistoricoAportes.isVisible() ) {
					jnHistoricoAportes = new JnHistoricoAportes();
					desktopPane.add(jnHistoricoAportes);
					jnHistoricoAportes.setVisible(true);
					jnHistoricoAportes.setBounds(10,270,830,275);
				}
			}
		});
		btnHistorico.setBounds(12, 57, 174, 25);
		contentPane.add(btnHistorico);
		
		JButton btnCotarAportes = new JButton("Cotar Aportes");
		btnCotarAportes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( !jnCotacaoAportes.isVisible() ) {
					jnCotacaoAportes = new JnCotacaoAportes();
					desktopPane.add(jnCotacaoAportes);
					jnCotacaoAportes.setVisible(true);
					jnCotacaoAportes.setBounds(320,10,520,251);
				}
			}
		});
		btnCotarAportes.setBounds(12, 31, 174, 25);
		contentPane.add(btnCotarAportes);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBorder(UIManager.getBorder("DesktopIcon.border"));
		desktopPane.setBounds(196, 0, 848, 612);
		contentPane.add(desktopPane);
		
		adicionarJanelas();
		
		JInternalFrame frameFiltro = new JInternalFrame("Filtros Histórico");
		frameFiltro.setBounds(12, 115, 174, 497);
		contentPane.add(frameFiltro);
		frameFiltro.setBorder(UIManager.getBorder("DesktopIcon.border"));
		frameFiltro.getContentPane().setLayout(null);
		
		JLabel lblAtivos = new JLabel("Ativos");
		lblAtivos.setBounds(12, 12, 144, 15);
		frameFiltro.getContentPane().add(lblAtivos);
		
		txtAtivos = new JTextField();
		txtAtivos.setEnabled(false);
		txtAtivos.setBounds(10, 31, 112, 19);
		frameFiltro.getContentPane().add(txtAtivos);
		txtAtivos.setColumns(10);
		
		JLabel lblSelAtivo = new JLabel("...");
		lblSelAtivo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PesquisaAtivo p = new PesquisaAtivo();
				
				p.rdbtnPesquisarAtivos.setSelected(true);
				p.rdbtnPesquisarAtivos.setEnabled(false);
				p.rdbtnPesquisarTipos.setSelected(false);
				p.rdbtnPesquisarTipos.setEnabled(false);
				
				p.setVisible(true);
			}
		});
		lblSelAtivo.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblSelAtivo.setBackground(SystemColor.textInactiveText);
		lblSelAtivo.setBounds(130, 31, 28, 19);
		frameFiltro.getContentPane().add(lblSelAtivo);
		
		JLabel lblSelTipoAtivo = new JLabel("...");
		lblSelTipoAtivo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PesquisaAtivo p = new PesquisaAtivo();
				
				p.rdbtnPesquisarTipos.setSelected(true);
				p.rdbtnPesquisarTipos.setEnabled(false);
				p.rdbtnPesquisarAtivos.setSelected(false);
				p.rdbtnPesquisarAtivos.setEnabled(false);
				
				p.setVisible(true);
			}
		});
		lblSelTipoAtivo.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblSelTipoAtivo.setBackground(Color.GRAY);
		lblSelTipoAtivo.setBounds(130, 63, 28, 19);
		frameFiltro.getContentPane().add(lblSelTipoAtivo);
		
		
		JLabel lblValor = new JLabel("Valor >=");
		lblValor.setBounds(12, 88, 144, 15);
		frameFiltro.getContentPane().add(lblValor);
		
		txtValorMaiorIgual = new JTextField();
		txtValorMaiorIgual.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				txtValorMaiorIgual.setText( numero.getNumero( txtValorMaiorIgual.getText() ) );
			}
		});
		
		txtValorMaiorIgual.setBounds(10, 106, 146, 19);
		frameFiltro.getContentPane().add(txtValorMaiorIgual);
		txtValorMaiorIgual.setColumns(10);
		
		JLabel lblValor_1 = new JLabel("Valor <= ");
		lblValor_1.setBounds(12, 127, 144, 15);
		frameFiltro.getContentPane().add(lblValor_1);
		
		txtValorMenorIgual = new JTextField();
		txtValorMenorIgual.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				txtValorMenorIgual.setText( numero.getNumero( txtValorMenorIgual.getText() ) );
			}
		});
		
		txtValorMenorIgual.setBounds(10, 145, 146, 19);
		frameFiltro.getContentPane().add(txtValorMenorIgual);
		txtValorMenorIgual.setColumns(10);
		
		JLabel lblQtde = new JLabel("Qtde >=");
		lblQtde.setBounds(12, 165, 144, 15);
		frameFiltro.getContentPane().add(lblQtde);
		
		txtQtdeMaiorIgual = new JTextField();
		txtQtdeMaiorIgual.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				txtQtdeMaiorIgual.setText( numero.getNumero( txtQtdeMaiorIgual.getText() ) );
			}
		});
		
		txtQtdeMaiorIgual.setBounds(10, 182, 146, 19);
		frameFiltro.getContentPane().add(txtQtdeMaiorIgual);
		txtQtdeMaiorIgual.setColumns(10);
		
		JLabel lblQtde_1 = new JLabel("Qtde <=");
		lblQtde_1.setBounds(12, 202, 144, 15);
		frameFiltro.getContentPane().add(lblQtde_1);
		
		txtQtdeMenorIgual = new JTextField();
		txtQtdeMenorIgual.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				txtQtdeMenorIgual.setText( numero.getNumero( txtQtdeMenorIgual.getText() ) );
			}
		});
		
		txtQtdeMenorIgual.setBounds(10, 220, 146, 19);
		frameFiltro.getContentPane().add(txtQtdeMenorIgual);
		txtQtdeMenorIgual.setColumns(10);
		
		JLabel lblSubtotal = new JLabel("SubTotal >=");
		lblSubtotal.setBounds(12, 241, 144, 15);
		frameFiltro.getContentPane().add(lblSubtotal);
		
		txtSubTotalMaiorIgual = new JTextField();
		txtSubTotalMaiorIgual.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				txtSubTotalMaiorIgual.setText( numero.getNumero( txtSubTotalMaiorIgual.getText() ) );
			}
		});
		
		txtSubTotalMaiorIgual.setBounds(10, 258, 146, 19);
		frameFiltro.getContentPane().add(txtSubTotalMaiorIgual);
		txtSubTotalMaiorIgual.setColumns(10);
		
		JLabel lblSubtotalMenorIgual = new JLabel("SubTotal <=");
		lblSubtotalMenorIgual.setBounds(12, 278, 144, 15);
		frameFiltro.getContentPane().add(lblSubtotalMenorIgual);
		
		txtSubTotalMenorIgual = new JTextField();
		txtSubTotalMenorIgual.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				txtSubTotalMenorIgual.setText( numero.getNumero( txtSubTotalMenorIgual.getText() ) );
			}
		});
		
		txtSubTotalMenorIgual.setBounds(10, 295, 146, 19);
		frameFiltro.getContentPane().add(txtSubTotalMenorIgual);
		txtSubTotalMenorIgual.setColumns(10);
		
		JLabel lblDataInicio = new JLabel("Data Inicio");
		lblDataInicio.setBounds(12, 314, 144, 15);
		frameFiltro.getContentPane().add(lblDataInicio);
		
		JFormattedTextField txtDataInicio = new JFormattedTextField(new MaskFormatter("##/##/####"));
		txtDataInicio.setBounds(10, 332, 146, 19);
		frameFiltro.getContentPane().add(txtDataInicio);
		
		JLabel lblDataFim = new JLabel("Data Fim");
		lblDataFim.setBounds(12, 351, 144, 15);
		frameFiltro.getContentPane().add(lblDataFim);
		
		JFormattedTextField txtDataFim = new JFormattedTextField(new MaskFormatter("##/##/####"));
		txtDataFim.setBounds(10, 368, 146, 19);
		frameFiltro.getContentPane().add(txtDataFim);
		
		JLabel lblTxretorno = new JLabel("Tx.Retorno <=");
		lblTxretorno.setBounds(12, 388, 144, 15);
		frameFiltro.getContentPane().add(lblTxretorno);
		
		JLabel lblTipoAtivo = new JLabel("Tipo ativo");
		lblTipoAtivo.setBounds(12, 50, 144, 15);
		frameFiltro.getContentPane().add(lblTipoAtivo);
		
		txtTipoAtivo = new JTextField();
		txtTipoAtivo.setEnabled(false);
		txtTipoAtivo.setBounds(10, 67, 112, 19);
		frameFiltro.getContentPane().add(txtTipoAtivo);
		txtTipoAtivo.setColumns(10);
		
		txtTxRetorno = new JTextField();
		txtTxRetorno.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				txtTxRetorno.setText( numero.getNumero( txtTxRetorno.getText() ) );
			}
		});
		txtTxRetorno.setBounds(10, 404, 146, 19);
		frameFiltro.getContentPane().add(txtTxRetorno);
		txtTxRetorno.setColumns(10);
		
		JButton btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setBounds(10, 440, 146, 25);
		frameFiltro.getContentPane().add(btnFiltrar);
		
		JButton btnRestaurarJanelas = new JButton("Restaurar Janelas");
		btnRestaurarJanelas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( dialogo.confirmarAcao("Deseja restaurar as janelas?? As informações em edição serão perdidas...") ) {
					restaurarJanelas();
				}
			}
		});
		btnRestaurarJanelas.setBounds(12, 83, 174, 25);
		contentPane.add(btnRestaurarJanelas);
		frameFiltro.setVisible(true);
		
		setLocationRelativeTo(null);
	}

	public void restaurarJanelas() {
		jnlancamento.dispose();
		jnCotacaoAportes.dispose();
		jnHistoricoAportes.dispose();
		
		adicionarJanelas();
	}
	
	public void adicionarJanelas() {

		if( janelasAdicionadasInicio ) {
			
			if( !jnlancamento.isVisible() ) {
				jnlancamento = new JnLancamento();
				desktopPane.add(jnlancamento);
				jnlancamento.setVisible(true);
				jnlancamento.setBounds(10, 10, 306, 251);
			}
			
			if( !jnCotacaoAportes.isVisible() ) {
				jnCotacaoAportes = new JnCotacaoAportes();
				desktopPane.add(jnCotacaoAportes);
				jnCotacaoAportes.setVisible(true);
				jnCotacaoAportes.setBounds(320,10,520,251);
			}
			
			if( !jnHistoricoAportes.isVisible() ) {
				jnHistoricoAportes = new JnHistoricoAportes();
				desktopPane.add(jnHistoricoAportes);
				jnHistoricoAportes.setVisible(true);
				jnHistoricoAportes.setBounds(10,270,830,275);
			}
		}else {
					
			jnlancamento = new JnLancamento();
			desktopPane.add(jnlancamento);
			jnlancamento.setVisible(true);
			jnlancamento.setBounds(10, 10, 306, 251);
			
			jnCotacaoAportes = new JnCotacaoAportes();
			desktopPane.add(jnCotacaoAportes);
			jnCotacaoAportes.setVisible(true);
			jnCotacaoAportes.setBounds(320,10,520,251);
			
			jnHistoricoAportes = new JnHistoricoAportes();
			desktopPane.add(jnHistoricoAportes);
			jnHistoricoAportes.setVisible(true);
			jnHistoricoAportes.setBounds(10,270,830,275);
			
		}
	}
	
}
