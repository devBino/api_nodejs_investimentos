package views.componentes;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

import javax.swing.table.DefaultTableModel;

import java.awt.Rectangle;
import java.awt.Font;
import java.awt.SystemColor;

public class JpAcompanhamento extends JPanel {
	
	private JTable table;
	public DefaultTableModel model;
	public String[] colunas;

	/**
	 * Create the panel.
	 */
	public JpAcompanhamento() {
		
		colunas = new String[] {"ID","ATIVO","TIPO","VALOR","QTDE","SUBTOTAL","DATA","TX.RETORNO","LUCRO BRUTO","DESCONTOS","LUCRO LÍQUIDO"};
		
		setToolTipText("Dados de acompanhamento do novo ativo selecionado...");
		setBounds(new Rectangle(0, 50, 0, 0));
		setLayout(null);
		
		JLabel lblTotalAportado = new JLabel("Total Aportado");
		lblTotalAportado.setBounds(new Rectangle(0, 50, 0, 0));
		lblTotalAportado.setBounds(12, 48, 113, 15);
		add(lblTotalAportado);
		
		JLabel lblValorTotalAportado = new JLabel("R$");
		lblValorTotalAportado.setBounds(new Rectangle(0, 50, 0, 0));
		lblValorTotalAportado.setBounds(137, 48, 104, 15);
		add(lblValorTotalAportado);
		
		JLabel lblPosicaoAtual = new JLabel("Posição Atual");
		lblPosicaoAtual.setBounds(new Rectangle(0, 50, 0, 0));
		lblPosicaoAtual.setBounds(240, 48, 104, 15);
		add(lblPosicaoAtual);
		
		JLabel lblValorPosicaoAtual = new JLabel("R$");
		lblValorPosicaoAtual.setBounds(new Rectangle(0, 50, 0, 0));
		lblValorPosicaoAtual.setBounds(358, 48, 104, 15);
		add(lblValorPosicaoAtual);
		
		JLabel lblLucroBruto = new JLabel("Lucro Bruto");
		lblLucroBruto.setBounds(new Rectangle(0, 50, 0, 0));
		lblLucroBruto.setBounds(474, 48, 95, 15);
		add(lblLucroBruto);
		
		JLabel lblValorLucroBruto = new JLabel("R$");
		lblValorLucroBruto.setBounds(new Rectangle(0, 50, 0, 0));
		lblValorLucroBruto.setBounds(581, 48, 104, 15);
		add(lblValorLucroBruto);
		
		JLabel lblDesconto = new JLabel("Descontos");
		lblDesconto.setBounds(new Rectangle(0, 50, 0, 0));
		lblDesconto.setBounds(697, 48, 84, 15);
		add(lblDesconto);
		
		JLabel lblValorDesconto = new JLabel("R$");
		lblValorDesconto.setBounds(new Rectangle(0, 50, 0, 0));
		lblValorDesconto.setBounds(793, 48, 104, 15);
		add(lblValorDesconto);
		
		JLabel lblAtivo = new JLabel("Ativo");
		lblAtivo.setForeground(SystemColor.activeCaption);
		lblAtivo.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		lblAtivo.setBounds(new Rectangle(0, 50, 0, 0));
		lblAtivo.setBounds(12, 15, 56, 15);
		add(lblAtivo);
		
		JLabel lblLucroLiquido = new JLabel("Lucro Líquido");
		lblLucroLiquido.setBounds(new Rectangle(0, 50, 0, 0));
		lblLucroLiquido.setBounds(12, 75, 113, 15);
		add(lblLucroLiquido);
		
		JLabel lblValorLucroLiquido = new JLabel("R$");
		lblValorLucroLiquido.setBounds(new Rectangle(0, 50, 0, 0));
		lblValorLucroLiquido.setBounds(137, 75, 104, 15);
		add(lblValorLucroLiquido);
		
		JLabel lblQtdeCotas = new JLabel("Qtde Cotas");
		lblQtdeCotas.setBounds(new Rectangle(0, 50, 0, 0));
		lblQtdeCotas.setBounds(240, 75, 104, 15);
		add(lblQtdeCotas);
		
		JLabel lblValorQtdeCotas = new JLabel("0");
		lblValorQtdeCotas.setBounds(new Rectangle(0, 50, 0, 0));
		lblValorQtdeCotas.setBounds(358, 75, 104, 15);
		add(lblValorQtdeCotas);
		
		JLabel lblDtUltimoAporte = new JLabel("Último Aporte");
		lblDtUltimoAporte.setBounds(new Rectangle(0, 50, 0, 0));
		lblDtUltimoAporte.setBounds(474, 75, 113, 15);
		add(lblDtUltimoAporte);
		
		JLabel lblValorDtUltimoAporte = new JLabel("  /  /    ");
		lblValorDtUltimoAporte.setBounds(new Rectangle(0, 50, 0, 0));
		lblValorDtUltimoAporte.setBounds(591, 75, 104, 15);
		add(lblValorDtUltimoAporte);
		
		JLabel lblHistorico = new JLabel("Histórico de Aportes");
		lblHistorico.setForeground(SystemColor.activeCaption);
		lblHistorico.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		lblHistorico.setBounds(new Rectangle(0, 50, 0, 0));
		lblHistorico.setBounds(12, 108, 332, 15);
		add(lblHistorico);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 139, 901, 274);
		add(scrollPane);
		
		table = new JTable();
		
		model = new DefaultTableModel();
		model.setColumnIdentifiers(colunas);
		
		table.setModel(model);
		
		scrollPane.setViewportView(table);
	}
}
