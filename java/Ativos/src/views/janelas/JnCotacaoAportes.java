package views.janelas;

import javax.swing.JInternalFrame;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import controllers.CtAporte;
import repositories.Numero;
import repositories.DialogoUsuario;

public class JnCotacaoAportes extends JInternalFrame {
	
	private JTextField txtValor;
	private JTable table;
	public static JTextField txtAtivos;
	private DefaultTableModel model;
	
	private Numero numero;
	private CtAporte ctAporte;
	private DialogoUsuario dialogo;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JnCotacaoAportes frame = new JnCotacaoAportes();
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
	public JnCotacaoAportes() {
		
		numero = new Numero();
		ctAporte = new CtAporte();
		dialogo = new DialogoUsuario();
		
		setClosable(true);
		setIconifiable(true);
		setTitle("Cotação de Aportes");
		setBounds(320,10,520,251);
		getContentPane().setLayout(null);
		
		JLabel lblOpes = new JLabel("Opções");
		lblOpes.setBounds(12, 12, 137, 15);
		getContentPane().add(lblOpes);
		
		JCheckBox checPrecoMedio = new JCheckBox("Considerar Preço Médio");
		checPrecoMedio.setBounds(12, 77, 205, 23);
		getContentPane().add(checPrecoMedio);
		
		JRadioButton rdbtnQuantasCotas = new JRadioButton("Cotar Maior Quantidade");
		rdbtnQuantasCotas.setBounds(12, 102, 201, 23);
		getContentPane().add(rdbtnQuantasCotas);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(12, 58, 48, 15);
		getContentPane().add(lblValor);
		
		txtValor = new JTextField();
		txtValor.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				txtValor.setText( numero.getNumero( txtValor.getText() ) );
			}
		});
		txtValor.setBounds(60, 54, 90, 19);
		getContentPane().add(txtValor);
		txtValor.setColumns(10);
		
		JRadioButton rdbtnQualValor = new JRadioButton("Cotar Menor Quantidade");
		rdbtnQualValor.setBounds(12, 130, 201, 23);
		getContentPane().add(rdbtnQualValor);
		
		JRadioButton rdbtnCotarMaiorCusto = new JRadioButton("Cotar Maior Custo");
		rdbtnCotarMaiorCusto.setBounds(12, 157, 197, 23);
		getContentPane().add(rdbtnCotarMaiorCusto);
		
		JRadioButton rdbtnCotarMenorCusto = new JRadioButton("Cotar Menor Custo");
		rdbtnCotarMenorCusto.setBounds(12, 184, 201, 23);
		getContentPane().add(rdbtnCotarMenorCusto);
		
		JLabel lblOk = new JLabel("Calcular");
		lblOk.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblOk.setBackground(SystemColor.textInactiveText);
		lblOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if( txtValor.getText().isEmpty() || txtValor.getText().replace(",",".").equals("0.00") ) {
					dialogo.aviso("Por Favor, informe um Valor...");
					txtValor.requestFocus();
				}else {
					
				}
			}
		});
		lblOk.setBounds(154, 54, 69, 19);
		getContentPane().add(lblOk);
		
		JLabel lblResultados = new JLabel("Resultados");
		lblResultados.setBounds(233, 12, 265, 15);
		getContentPane().add(lblResultados);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(233, 28, 265, 179);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		
		model = new DefaultTableModel();
		model.setColumnIdentifiers( new Object[] {"ATIVO","VALOR","QTDE","SUBTOTAL"} );
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JLabel lblAtivos = new JLabel("Ativos");
		lblAtivos.setBounds(12, 34, 48, 15);
		getContentPane().add(lblAtivos);
		
		txtAtivos = new JTextField();
		txtAtivos.setEnabled(false);
		txtAtivos.setBounds(60, 32, 90, 19);
		getContentPane().add(txtAtivos);
		txtAtivos.setColumns(10);
		
		JLabel lblBuscarAtivos = new JLabel("Buscar");
		lblBuscarAtivos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PesquisaAtivo p = new PesquisaAtivo();
	
				p.opcaoJanela = "views.janelas.JnCotacaoAportes";
				
				p.rdbtnPesquisarAtivos.setSelected(true);
				p.rdbtnPesquisarTipos.setSelected(false);
				p.rdbtnPesquisarAtivos.setEnabled(false);
				p.rdbtnPesquisarTipos.setEnabled(false);
				
				p.show();
			}
		});
		lblBuscarAtivos.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblBuscarAtivos.setBackground(Color.GRAY);
		lblBuscarAtivos.setBounds(154, 32, 69, 19);
		getContentPane().add(lblBuscarAtivos);

	}
}
