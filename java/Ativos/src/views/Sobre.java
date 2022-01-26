package views;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.UIManager;

public class Sobre extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sobre frame = new Sobre();
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
	public Sobre() {
		setUndecorated(true);
		setResizable(false);
		setTitle("Sobre o Cadastro de Ativos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 634, 265);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRealizeSeuLogin = new JLabel("CADASTRO DE ATIVOS");
		lblRealizeSeuLogin.setForeground(SystemColor.activeCaption);
		lblRealizeSeuLogin.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		lblRealizeSeuLogin.setBounds(203, 12, 211, 15);
		contentPane.add(lblRealizeSeuLogin);
		
		JLabel lblImagem = new JLabel("New label");
		lblImagem.setIcon(new ImageIcon(getClass().getResource("/imagens/telaLogin.jpeg")));
		lblImagem.setBounds(360, 39, 262, 208);
		contentPane.add(lblImagem);
		
		JButton btnFechar = new JButton("FECHAR");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFechar.setBounds(535, 8, 87, 25);
		contentPane.add(btnFechar);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(UIManager.getColor("Label.background"));
		textPane.setEditable(false);
		textPane.setForeground(Color.BLACK);
		textPane.setFont(new Font("Dialog", Font.BOLD, 12));
		textPane.setBounds(12, 146, 330, 101);
		contentPane.add(textPane);
		
		
		String textoApresentacao = "";
		textoApresentacao += "Desenvolvido por: Fernando Bino Machado\n";
		textoApresentacao += "Contato: programemachado@gmail.com\n";
		textoApresentacao += "GitHub: https://github.com/devBino\n";
		
		textPane.setText(textoApresentacao);
		setLocationRelativeTo(null);
	}
}
