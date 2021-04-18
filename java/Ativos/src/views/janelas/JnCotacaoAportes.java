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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.ArrayList;

import controllers.CtAporte;
import controllers.CtCotacao;
import repositories.Numero;
import repositories.DialogoUsuario;
import repositories.TableOrdem;

public class JnCotacaoAportes extends JInternalFrame {
	
	private JTextField txtValor;
	private JTable table;
	public static JTextField txtAtivos;
	private DefaultTableModel model;
	
	private JRadioButton radioCotarMaiorQtdeCotas;
	private JRadioButton radioCotarMenorQtdeCotas;
	private JRadioButton radioCotarMaiorCusto;
	private JRadioButton radioCotarMenorCusto;
	
	private Numero numero;
	private CtAporte ctAporte;
	private CtCotacao cotacao;
	private DialogoUsuario dialogo;
	private String[] colunasModel;
	private String radioEscolhido;
	

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
		
		setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		
		numero = new Numero();
		ctAporte = new CtAporte();
		cotacao = new CtCotacao();
		dialogo = new DialogoUsuario();
		radioEscolhido = "";
		colunasModel = new String[] {"ATIVO","VALOR","QTDE","SUBTOTAL","PROVENTO","TOTAL PROVENTOS"};
		
		setClosable(true);
		setIconifiable(true);
		setTitle("Cotação de Aportes");
		setBounds(320,10,520,251);
		getContentPane().setLayout(null);
		
		radioCotarMaiorQtdeCotas = new JRadioButton("Cotar Maior Quantidade");
		radioCotarMaiorQtdeCotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checarRadio("cotarMaiorQtdeCotas");
			}
		});
		radioCotarMaiorQtdeCotas.setBounds(55, 35, 201, 23);
		getContentPane().add(radioCotarMaiorQtdeCotas);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(227, 12, 48, 15);
		getContentPane().add(lblValor);
		
		txtValor = new JTextField();
		txtValor.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				txtValor.setText( numero.getNumero( txtValor.getText() ) );
			}
		});
		txtValor.setBounds(267, 10, 90, 19);
		getContentPane().add(txtValor);
		txtValor.setColumns(10);
		
		radioCotarMenorQtdeCotas = new JRadioButton("Cotar Menor Quantidade");
		radioCotarMenorQtdeCotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checarRadio("cotarMenorQtdeCotas");
			}
		});
		radioCotarMenorQtdeCotas.setBounds(55, 62, 201, 23);
		getContentPane().add(radioCotarMenorQtdeCotas);
		
		radioCotarMaiorCusto = new JRadioButton("Cotar Maior Custo");
		radioCotarMaiorCusto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checarRadio("cotarMaiorCusto");
			}
		});
		radioCotarMaiorCusto.setBounds(273, 35, 197, 23);
		getContentPane().add(radioCotarMaiorCusto);
		
		radioCotarMenorCusto = new JRadioButton("Cotar Menor Custo");
		radioCotarMenorCusto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checarRadio("cotarMenorCusto");
			}
		});
		radioCotarMenorCusto.setBounds(273, 62, 201, 23);
		getContentPane().add(radioCotarMenorCusto);
		
		JLabel lblOk = new JLabel("Calcular");
		lblOk.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblOk.setBackground(SystemColor.textInactiveText);
		lblOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if( !txtAtivos.getText().isEmpty() && !txtValor.getText().isEmpty() ) {
					if( txtValor.getText().isEmpty() || txtValor.getText().replace(",",".").equals("0.00") ) {
						dialogo.aviso("Por Favor, informe um Valor maior que 0,00");
						txtValor.requestFocus();
					}else {
						calcularCotacao();
					}
				}else {
					dialogo.aviso("Por Favor, informar Ativos e Valor...");
					txtValor.requestFocus();
				}
			}
		});
		lblOk.setBounds(362, 10, 69, 19);
		getContentPane().add(lblOk);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 85, 486, 130);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				calcularProventos();
			}
		});
		model = new DefaultTableModel();
		model.setColumnIdentifiers( colunasModel );
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JLabel lblAtivos = new JLabel("Ativos");
		lblAtivos.setBounds(12, 12, 48, 15);
		getContentPane().add(lblAtivos);
		
		txtAtivos = new JTextField();
		txtAtivos.setEnabled(false);
		txtAtivos.setBounds(60, 10, 90, 19);
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
		lblBuscarAtivos.setBounds(154, 10, 69, 19);
		getContentPane().add(lblBuscarAtivos);

	}
	
	public ArrayList<String[]> getAtivos() {
		String[] ativos = txtAtivos.getText().split("&");
		ArrayList<String[]> arrAtivos = new ArrayList<String[]>();
		
		for(String ativo : ativos) {
			String[] arrAtivo = ativo.split("@");
			arrAtivos.add(arrAtivo);
		}
		
		return arrAtivos;
	}
	
	public void calcularCotacao() {
		
		model.setNumRows(0);
		
		ArrayList<String[]> ativos = getAtivos();
				
		for(int i=0;i<ativos.size();i++) {
			
			String[] arrLinha = new String[ model.getColumnCount() ]; 
					
			String valorCotacao = cotacao.getCotacao( ativos.get(i)[1] );
			
			if( Double.parseDouble(valorCotacao) == 0.00 ) {
				continue;
			}
			
			Double qtde = Double.parseDouble(txtValor.getText().replace(",",".")) / Double.parseDouble(valorCotacao);
			
			String strQtde = qtde.toString().substring(
				0,
				qtde.toString().indexOf(".")
			);
			
			
			Double subTotal = Double.parseDouble(strQtde) * Double.parseDouble(valorCotacao);
			
			arrLinha[0] = ativos.get(i)[1];
			arrLinha[1] = String.format("%.2f",Double.parseDouble(valorCotacao));
			arrLinha[2] = strQtde;
			arrLinha[3] = String.format("%.2f",subTotal);
			
			model.addRow(arrLinha);
			
		}
		
		if( !radioEscolhido.isEmpty() ) {
			ordenar();
		}
		
	}
	
	public void calcularProventos() {
		try {
			int linha = table.getSelectedRow();
	
			String qtde = table.getValueAt(linha,2).toString();
			
			String provento = table.getValueAt(linha,4).toString();
			table.setValueAt( numero.getNumero(provento).replace(",","."),linha, 4 );
			
			Double totalProventos = Double.parseDouble(qtde) * Double.parseDouble( numero.getNumero(provento).replace(",",".") );
			table.setValueAt(totalProventos.toString(),linha,5);
			
		}catch(Exception e) {
			
		}
	}

	public void checarRadio(String strRadio) {
		
		radioEscolhido = strRadio;
				
		radioCotarMaiorQtdeCotas.setSelected(false);
		radioCotarMenorQtdeCotas.setSelected(false);
		radioCotarMaiorCusto.setSelected(false);
		radioCotarMenorCusto.setSelected(false);
		
		switch(strRadio) {
		
			case "cotarMaiorQtdeCotas":
				radioCotarMaiorQtdeCotas.setSelected(true);
				break;
			case "cotarMenorQtdeCotas":
				radioCotarMenorQtdeCotas.setSelected(true);
				break;
			case "cotarMaiorCusto":
				radioCotarMaiorCusto.setSelected(true);
				break;
			case "cotarMenorCusto":
				radioCotarMenorCusto.setSelected(true);
				break;
			default:
				radioCotarMaiorQtdeCotas.setSelected(true);
				radioEscolhido = "cotarMenorQtdeCotas";
				break;
				
		}
		
	}
	
	public void ordenar() {
		
		TableOrdem tb = new TableOrdem(model, colunasModel);
		
		switch(radioEscolhido) {
			case "cotarMaiorQtdeCotas":
				tb.modelDesc(2);
				break;
			case "cotarMenorQtdeCotas":
				tb.modelAsc(2);
				break;
			case "cotarMaiorCusto":
				tb.modelDesc(3);
				break;
			case "cotarMenorCusto":
				tb.modelAsc(3);
				break;
			default:
				tb.modelAsc(2);
				break;
		}
		
		table.setModel( tb.getModel() );
		
	}
	
}
