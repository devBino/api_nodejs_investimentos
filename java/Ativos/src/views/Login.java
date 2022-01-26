package views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;

import java.io.UnsupportedEncodingException;

import java.security.NoSuchAlgorithmException;

import views.Sistema;
import controllers.CtLogin;
import models.Sessao;
import repositories.DialogoUsuario;
import repositories.Sha1;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtLogin;
	private JPasswordField txtSenha;
	public DialogoUsuario dialogo;
	public Sha1 sha1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		
		dialogo = new DialogoUsuario();
		
		setUndecorated(true);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				
				fecharAplicacao();
			}
		});
		
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 536, 290);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRealizeSeuLogin = new JLabel("CADASTRO DE ATIVOS");
		lblRealizeSeuLogin.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		lblRealizeSeuLogin.setForeground(SystemColor.activeCaption);
		lblRealizeSeuLogin.setBounds(27, 39, 211, 15);
		contentPane.add(lblRealizeSeuLogin);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(27, 128, 70, 15);
		contentPane.add(lblLogin);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(27, 146, 211, 19);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(27, 167, 70, 15);
		contentPane.add(lblSenha);
		
		JButton btnAcessar = new JButton("Acessar");
		btnAcessar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
					processaLogin();
				}catch(Exception err) {
					err.printStackTrace();
				}
			}
			
		});
		btnAcessar.setBounds(132, 215, 106, 25);
		contentPane.add(btnAcessar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fecharAplicacao();
			}
		});
		btnSair.setBounds(27, 215, 93, 25);
		contentPane.add(btnSair);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(27, 184, 211, 19);
		contentPane.add(txtSenha);
		
		JLabel lblImagem = new JLabel();
		lblImagem.setIcon( new ImageIcon(getClass().getResource("/imagens/telaLogin.jpeg")) );
		lblImagem.setBounds(256, 39, 250, 211);
		contentPane.add(lblImagem);
		
		setLocationRelativeTo(null);
	}
	
	public boolean processaLogin() throws NoSuchAlgorithmException, UnsupportedEncodingException {
		
		sha1 = new Sha1(new String(txtSenha.getPassword()));
		CtLogin ctLog = new CtLogin( txtLogin.getText(), sha1.getHash() );
		
		// verifica se foram informados os parametros
		if( txtLogin.getText().isEmpty() || new String(txtSenha.getPassword()).isEmpty() ) {
			JOptionPane.showMessageDialog(null, "Por Favor, informe login e senha...","Aviso",JOptionPane.WARNING_MESSAGE);
			return false;
		}
	
		// caso foi informado login e senha
		if( ctLog.validaLogin() ) {
			
			Sistema sis = new Sistema();
			
			Sessao.token = ctLog.getToken();
			
			this.dispose();
			sis.setVisible(true);
			
			return true;
			
		}else {
			if( !ctLog.mensagem.isEmpty() ) {
				JOptionPane.showMessageDialog(null,ctLog.mensagem,"Erro",JOptionPane.ERROR_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(null, "Login ou Senha inválidos...","Aviso",JOptionPane.WARNING_MESSAGE);				
			}
			
			return false;
		}
	}
	
	public void fecharAplicacao() {
		if( this.dialogo.confirmarEncerrarApp() ) {
			System.exit(0);
		}
	}
}
