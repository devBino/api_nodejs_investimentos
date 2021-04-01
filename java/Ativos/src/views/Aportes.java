package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import views.janelas.JnHistoricoAportes;
import views.janelas.JnLancamento;
import javax.swing.UIManager;

public class Aportes extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;
	
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
	 */
	public Aportes() {
		
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
		setBounds(100, 100, 996, 606);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLanamentos = new JButton("Lançamentos");
		btnLanamentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JnLancamento jnlancamento = new JnLancamento();
				desktopPane.add(jnlancamento);
				jnlancamento.setVisible(true);
				jnlancamento.setBounds(10, 10, 306, 251);
			}
		});
		btnLanamentos.setBounds(12, 0, 136, 25);
		contentPane.add(btnLanamentos);
		
		JButton btnHistorico = new JButton("Historico");
		btnHistorico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JnHistoricoAportes jnHistoricoAportes = new JnHistoricoAportes();
				desktopPane.add(jnHistoricoAportes);
				jnHistoricoAportes.setVisible(true);
				jnHistoricoAportes.setBounds(10,270,830,275);
				
			}
		});
		btnHistorico.setBounds(12, 26, 136, 25);
		contentPane.add(btnHistorico);
		
		JButton btnOrarAportes = new JButton("Orçar Aportes");
		btnOrarAportes.setBounds(12, 52, 136, 25);
		contentPane.add(btnOrarAportes);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBorder(UIManager.getBorder("DesktopIcon.border"));
		desktopPane.setBounds(148, 0, 848, 555);
		contentPane.add(desktopPane);
		
		setLocationRelativeTo(null);
	}
}
