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
import java.text.ParseException;

import java.awt.Frame;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class Sistema extends JFrame {
	
	public DialogoUsuario dialogo = new DialogoUsuario();
	
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
		getContentPane().setBackground(Color.WHITE);
		setResizable(false);
		setTitle("Sistema de Cadastro de Ativos de Investimento");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1188, 633);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Cadastro");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmTiposDeAtivos = new JMenuItem("Tipos de Ativos");
		mntmTiposDeAtivos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		mntmTiposDeAtivos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TipoAtivos tp = new TipoAtivos();
				tp.setVisible(true);
				dispose();
			}
		});
		mnNewMenu.add(mntmTiposDeAtivos);
		
		JMenuItem mntmAtivos = new JMenuItem("Ativos");
		mntmAtivos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0));
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
		mntmAportes.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0));
		mntmAportes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Aportes ap = new Aportes();
					ap.setVisible(true);
					dispose();
				}catch(Exception err) {
					err.printStackTrace();
				}
			}
		});
		mnLanamentos.add(mntmAportes);
		
		JMenu mnCotacoes = new JMenu("Acompanhamento");
		menuBar.add(mnCotacoes);
		
		JMenuItem mntmCotaes = new JMenuItem("Cotações");
		mntmCotaes.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0));
		mntmCotaes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cotacao ct = new Cotacao();
				ct.setVisible(true);
				dispose();
			}
		});
		
		JMenuItem mntmAcompanharRetorno = new JMenuItem("Acompanhar Retorno");
		mntmAcompanharRetorno.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, 0));
		mnCotacoes.add(mntmAcompanharRetorno);
		mnCotacoes.add(mntmCotaes);
		
		JMenu mnMais = new JMenu("Mais");
		menuBar.add(mnMais);
		
		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mntmSobre.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F6, 0));
		mntmSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sobre sb = new Sobre();
				sb.setVisible(true);
				dispose();
			}
		});
		mnMais.add(mntmSobre);
		
		JMenuItem mntmFecharSistema = new JMenuItem("Encerrar");
		mntmFecharSistema.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F8, 0));
		mntmFecharSistema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fecharAplicacao();
			}
		});
		
		JMenuItem mntmLogin = new JMenuItem("Login");
		mntmLogin.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F7, 0));
		mntmLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				retornarLogin();
			}
		});
		mnMais.add(mntmLogin);
		mnMais.add(mntmFecharSistema);
		
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblMenuTipoAtivos = new JLabel("Tipos de Ativos - F1");
		lblMenuTipoAtivos.setBounds(33, 37, 151, 15);
		getContentPane().add(lblMenuTipoAtivos);
		
		JLabel lblTipoAtivos = new JLabel("");
		lblTipoAtivos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TipoAtivos tp = new TipoAtivos();
				tp.setVisible(true);
				dispose();
			}
		});
		lblTipoAtivos.setIcon(new ImageIcon("imagens/tipoAtivos.png"));
		lblTipoAtivos.setBounds(30, 64, 154, 129);
		getContentPane().add(lblTipoAtivos);
		
		JLabel lblMenuAtivos = new JLabel("Ativos - F2");
		lblMenuAtivos.setBounds(215, 37, 151, 15);
		getContentPane().add(lblMenuAtivos);
		
		JLabel lblAtivos = new JLabel("");
		lblAtivos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Ativos at = new Ativos();
				at.setVisible(true);
				dispose();
			}
		});
		lblAtivos.setIcon(new ImageIcon("imagens/ativos.png"));
		lblAtivos.setBounds(231, 64, 135, 129);
		getContentPane().add(lblAtivos);
		
		JLabel lblMenuAportes = new JLabel("Aportes - F3");
		lblMenuAportes.setBounds(399, 37, 151, 15);
		getContentPane().add(lblMenuAportes);
		
		JLabel lblAportes = new JLabel("");
		lblAportes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Aportes ap = new Aportes();
					ap.setVisible(true);
					dispose();
				}catch(Exception err) {
					err.printStackTrace();
				}
			}
		});
		lblAportes.setIcon(new ImageIcon("imagens/aportes.png"));
		lblAportes.setBounds(399, 64, 154, 129);
		getContentPane().add(lblAportes);
		
		JLabel lblMenuAcompanhamento = new JLabel("Acompanhamento - F4");
		lblMenuAcompanhamento.setBounds(33, 230, 170, 15);
		getContentPane().add(lblMenuAcompanhamento);
		
		JLabel lblAcompanhamento = new JLabel("");
		lblAcompanhamento.setIcon(new ImageIcon("imagens/andamento.png"));
		lblAcompanhamento.setBounds(33, 253, 154, 129);
		getContentPane().add(lblAcompanhamento);
		
		JLabel lblMenuCotacao = new JLabel("Cotações - F5");
		lblMenuCotacao.setBounds(215, 230, 151, 15);
		getContentPane().add(lblMenuCotacao);
		
		JLabel lblCotacao = new JLabel("");
		lblCotacao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Cotacao ct = new Cotacao();
				ct.setVisible(true);
				dispose();
			}
		});
		lblCotacao.setIcon(new ImageIcon("imagens/cotacao.png"));
		lblCotacao.setBounds(215, 253, 154, 129);
		getContentPane().add(lblCotacao);
		
		JLabel lblMenuSobre = new JLabel("Sobre - F6");
		lblMenuSobre.setBounds(399, 230, 151, 15);
		getContentPane().add(lblMenuSobre);
		
		JLabel lblSobre = new JLabel("");
		lblSobre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Sobre sb = new Sobre();
				sb.setVisible(true);
				dispose();
			}
		});
		lblSobre.setIcon(new ImageIcon("imagens/sobre.png"));
		lblSobre.setBounds(396, 253, 154, 129);
		getContentPane().add(lblSobre);
		
		JLabel lblMenuLogin = new JLabel("Login - F7");
		lblMenuLogin.setBounds(1013, 37, 151, 15);
		getContentPane().add(lblMenuLogin);
		
		JLabel lblLogin = new JLabel("");
		lblLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				retornarLogin();
			}
		});
		lblLogin.setIcon(new ImageIcon("imagens/login.png"));
		lblLogin.setBounds(1010, 64, 154, 129);
		getContentPane().add(lblLogin);
		
		JLabel lblMenuEncerrar = new JLabel("Encerrar - F8");
		lblMenuEncerrar.setBounds(1013, 230, 151, 15);
		getContentPane().add(lblMenuEncerrar);
		
		JLabel lblEncerrar = new JLabel("");
		lblEncerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fecharAplicacao();
			}
		});
		lblEncerrar.setIcon(new ImageIcon("imagens/encerrar.png"));
		lblEncerrar.setBounds(1013, 253, 154, 129);
		getContentPane().add(lblEncerrar);
		
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
