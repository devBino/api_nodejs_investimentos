package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import views.componentes.JpAcompanhamento;
import views.janelas.TabelaPesquisaAtivo;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import repositories.DialogoUsuario;

public class Acompanhamento extends JFrame {

	private JPanel contentPane;
	private JTextField txtTipoAtivo;
	private JTextField txtAtivo;
	private JTabbedPane painelMultitab;
	private JPanel panel;
	private JButton btnFecharAbas;
	
	private DialogoUsuario dialogo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Acompanhamento frame = new Acompanhamento();
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
	public Acompanhamento() {
		setTitle("Cadastro de Ativos - Acompanhamento de Aportes Realizados");
		
		dialogo = new DialogoUsuario();
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Sistema s = new Sistema();
				s.setVisible(true);
			}
		});
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 962, 561);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTipoAtivo = new JLabel("Tipo Ativo");
		lblTipoAtivo.setBounds(12, 10, 70, 15);
		contentPane.add(lblTipoAtivo);
		
		txtTipoAtivo = new JTextField();
		txtTipoAtivo.setBounds(90, 10, 124, 19);
		contentPane.add(txtTipoAtivo);
		txtTipoAtivo.setColumns(10);
		
		JLabel lblAtivo = new JLabel("Ativo");
		lblAtivo.setBounds(220, 10, 41, 15);
		contentPane.add(lblAtivo);
		
		txtAtivo = new JTextField();
		txtAtivo.setBounds(267, 10, 130, 19);
		contentPane.add(txtAtivo);
		txtAtivo.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TabelaPesquisaAtivo janelaPesquisa = new TabelaPesquisaAtivo();
				janelaPesquisa.setVisible(true);
				
				JpAcompanhamento jpAcompanhamento = new JpAcompanhamento();
				painelMultitab.addTab("titulo teste",null,jpAcompanhamento,null);
			}
		});
		btnBuscar.setBounds(400, 10, 82, 19);
		contentPane.add(btnBuscar);
		
		painelMultitab = new JTabbedPane(JTabbedPane.TOP);
		painelMultitab.setBounds(12, 46, 938, 466);
		contentPane.add(painelMultitab);
		
		btnFecharAbas = new JButton("Fechar Abas");
		btnFecharAbas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( dialogo.confirmarAcao("Deseja fechar todas as abas?") ) {
					painelMultitab.removeAll();
				}
			}
		});
		btnFecharAbas.setBounds(486, 10, 124, 19);
		contentPane.add(btnFecharAbas);
		
		setLocationRelativeTo(null);
	}
}
