package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import repositories.DialogoUsuario;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import java.awt.Frame;

import views.internal.frames.*;

public class Sistema extends JFrame {
	
	public DialogoUsuario dialogo = new DialogoUsuario();
	public JDesktopPane desktopPane = new JDesktopPane();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sistema frame = new Sistema();
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
	public Sistema() {
		setResizable(false);
		setTitle("Sistema de Cadastro de Ativos de Investimento");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1188, 633);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Cadastro");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmTiposDeAtivos = new JMenuItem("Tipos de Ativos");
		mntmTiposDeAtivos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TipoAtivos tp = new TipoAtivos();
				tp.setVisible(true);
				dispose();
			}
		});
		mnNewMenu.add(mntmTiposDeAtivos);
		
		JMenuItem mntmAtivos = new JMenuItem("Ativos");
		mntmAtivos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ativos at = new Ativos();
				at.setVisible(true);
				dispose();
			}
		});
		mnNewMenu.add(mntmAtivos);
		
		JMenu mnLanamentos = new JMenu("Lançamentos");
		menuBar.add(mnLanamentos);
		
		JMenuItem mntmAportes = new JMenuItem("Aportes");
		mntmAportes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Aportes ap = new Aportes();
				ap.setVisible(true);
				dispose();
			}
		});
		mnLanamentos.add(mntmAportes);
		
		JMenu mnCotacoes = new JMenu("Acompanhamento");
		menuBar.add(mnCotacoes);
		
		JMenuItem mntmCotaes = new JMenuItem("Cotações");
		mntmCotaes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cotacao ct = new Cotacao();
				ct.setVisible(true);
				dispose();
			}
		});
		mnCotacoes.add(mntmCotaes);
		
		JMenu mnMais = new JMenu("Mais");
		menuBar.add(mnMais);
		
		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mntmSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sobre sb = new Sobre();
				sb.setVisible(true);
				dispose();
			}
		});
		mnMais.add(mntmSobre);
		
		JMenuItem mntmFecharSistema = new JMenuItem("Encerrar");
		mntmFecharSistema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fecharAplicacao();
			}
		});
		
		JMenuItem mntmLogin = new JMenuItem("Login");
		mntmLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				retornarLogin();
			}
		});
		mnMais.add(mntmLogin);
		mnMais.add(mntmFecharSistema);
		
		
		desktopPane.setBounds(0, 0, 1188, 563);
		getContentPane().add(desktopPane);
		
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
	}
	
	public void retornarLogin() {
		if( dialogo.confirmarLog0ff() ) {
			Login lg = new Login();
			this.dispose();
			lg.setVisible(true);
		}
	}
	public void fecharAplicacao() {
		if( dialogo.confirmarEncerrarApp() ) {
			System.exit(0);
		}
	}
}
