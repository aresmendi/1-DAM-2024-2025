package ejemplo;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class InterfazConArchivos extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textOp1;
	private JTextField textOp2;
	private JButton btnMatricula;
	private JLabel lblResultado;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazConArchivos frame = new InterfazConArchivos();
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
	public InterfazConArchivos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 44, 57, 19);
		contentPane.add(lblNombre);
		
		JLabel lblGrupo = new JLabel("Grupo");
		lblGrupo.setBounds(10, 84, 57, 19);
		contentPane.add(lblGrupo);
		
		textOp1 = new JTextField();
		textOp1.setBounds(88, 44, 96, 19);
		contentPane.add(textOp1);
		textOp1.setColumns(10);
		
		textOp2 = new JTextField();
		textOp2.setColumns(10);
		textOp2.setBounds(88, 84, 96, 19);
		contentPane.add(textOp2);
		
		btnMatricula = new JButton("Matricula");
		btnMatricula.setBounds(252, 58, 85, 21);
		btnMatricula.addActionListener(this);
		contentPane.add(btnMatricula);
		
		lblResultado = new JLabel("");
		lblResultado.setBounds(114, 140, 179, 13);
		contentPane.add(lblResultado);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnMatricula) {
			try {
				FileWriter fw = new FileWriter("matricula.txt", true);
				fw.write(textOp1.getText() + "*" + textOp2.getText()+ "\n");
				lblResultado.setText("Alumno matriculado");
				fw.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				System.out.println("Error de escritura");
			}
		}
		
	}

}
