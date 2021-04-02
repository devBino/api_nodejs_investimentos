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
	private JTable table;
	private JTextField txtValor;
	private JTable table_1;

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
		
		JLabel lblSeleoDeAtivo = new JLabel("Marque Ativos");
		lblSeleoDeAtivo.setBounds(12, 12, 124, 15);
		getContentPane().add(lblSeleoDeAtivo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 27, 124, 180);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblOpes = new JLabel("Opções");
		lblOpes.setBounds(144, 12, 137, 15);
		getContentPane().add(lblOpes);
		
		JCheckBox checPrecoMedio = new JCheckBox("Considerar Preço Médio");
		checPrecoMedio.setBounds(140, 62, 205, 23);
		getContentPane().add(checPrecoMedio);
		
		JRadioButton rdbtnQuantasCotas = new JRadioButton("Cotar Maior Quantidade");
		rdbtnQuantasCotas.setBounds(140, 87, 201, 23);
		getContentPane().add(rdbtnQuantasCotas);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(144, 39, 48, 15);
		getContentPane().add(lblValor);
		
		txtValor = new JTextField();
		txtValor.setBounds(194, 35, 90, 19);
		getContentPane().add(txtValor);
		txtValor.setColumns(10);
		
		JRadioButton rdbtnQualValor = new JRadioButton("Cotar Menor Quantidade");
		rdbtnQualValor.setBounds(140, 115, 201, 23);
		getContentPane().add(rdbtnQualValor);
		
		JRadioButton rdbtnCotarMaiorCusto = new JRadioButton("Cotar Maior Custo");
		rdbtnCotarMaiorCusto.setBounds(140, 142, 197, 23);
		getContentPane().add(rdbtnCotarMaiorCusto);
		
		JRadioButton rdbtnCotarMenorCusto = new JRadioButton("Cotar Menor Custo");
		rdbtnCotarMenorCusto.setBounds(140, 169, 201, 23);
		getContentPane().add(rdbtnCotarMenorCusto);
		
		JLabel lblOk = new JLabel("OK");
		lblOk.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblOk.setBackground(SystemColor.textInactiveText);
		lblOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null,"teste");
			}
		});
		lblOk.setBounds(290, 35, 35, 19);
		getContentPane().add(lblOk);
		
		JLabel lblResultados = new JLabel("Resultados");
		lblResultados.setBounds(353, 12, 145, 15);
		getContentPane().add(lblResultados);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(353, 28, 145, 179);
		getContentPane().add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);

	}
}
