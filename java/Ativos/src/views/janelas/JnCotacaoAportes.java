package views.janelas;

import java.awt.EventQueue;

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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class JnCotacaoAportes extends JInternalFrame {
	private JTextField txtValor;
	private JTable table_1;
	private JTextField txtAtivos;

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
		lblValor.setBounds(12, 33, 48, 15);
		getContentPane().add(lblValor);
		
		txtValor = new JTextField();
		txtValor.setBounds(62, 31, 90, 19);
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
				
			}
		});
		lblOk.setBounds(158, 31, 69, 19);
		getContentPane().add(lblOk);
		
		JLabel lblResultados = new JLabel("Resultados");
		lblResultados.setBounds(251, 12, 247, 15);
		getContentPane().add(lblResultados);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(251, 28, 247, 179);
		getContentPane().add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblAtivos = new JLabel("Ativos");
		lblAtivos.setBounds(12, 54, 48, 15);
		getContentPane().add(lblAtivos);
		
		txtAtivos = new JTextField();
		txtAtivos.setEnabled(false);
		txtAtivos.setBounds(62, 52, 90, 19);
		getContentPane().add(txtAtivos);
		txtAtivos.setColumns(10);
		
		JLabel lblBuscarAtivos = new JLabel("Buscar");
		lblBuscarAtivos.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblBuscarAtivos.setBackground(Color.GRAY);
		lblBuscarAtivos.setBounds(158, 51, 69, 19);
		getContentPane().add(lblBuscarAtivos);

	}
}
