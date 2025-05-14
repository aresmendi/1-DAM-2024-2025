package ejemplo;
//Este ha sido el primer ejemplo que a puesto él, voy a explicar aquí como nos ha dicho que hagamos los eventos en 4 pasos
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
//1ºImplementamos ActionListener,y hacemos que nos cree su método (que se pondrá abajo del todo con el @override)
public class EjemploCalculadora extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textOp1;
	private JTextField textOp2;
	//3ºPaso Aquí declaramos como un atributo de la clase al que recibe el evento, para que podamos acceder desde métodos
	private JButton btnSuma;
	private JLabel lblResultado;
	private JButton btnResta;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EjemploCalculadora frame = new EjemploCalculadora();
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
	public EjemploCalculadora() {
		setTitle("Calculadora");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitulo = new JLabel("Calculadora");
		lblTitulo.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblTitulo.setBounds(158, 10, 114, 40);
		contentPane.add(lblTitulo);

		textOp1 = new JTextField();
		textOp1.setFont(new Font("Dialog", Font.PLAIN, 20));
		textOp1.setBounds(81, 60, 78, 20);
		contentPane.add(textOp1);
		textOp1.setColumns(10);

		textOp2 = new JTextField();
		textOp2.setFont(new Font("Dialog", Font.PLAIN, 20));
		textOp2.setColumns(10);
		textOp2.setBounds(81, 116, 78, 20);
		contentPane.add(textOp2);

		JLabel lblValor1 = new JLabel("Valor1");
		lblValor1.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblValor1.setBounds(0, 60, 72, 20);
		contentPane.add(lblValor1);

		JLabel lblValor2 = new JLabel("Valor2");
		lblValor2.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblValor2.setBounds(0, 116, 72, 20);
		contentPane.add(lblValor2);

		lblResultado = new JLabel("");
		lblResultado.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblResultado.setBounds(81, 178, 191, 20);
		contentPane.add(lblResultado);
		//Aquí podeis ver que solo de instancia el JButon, no se declara y se instancia como los JLabels por que daría error (ERROR COMÚN)
		btnSuma = new JButton("Suma");
		btnSuma.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnSuma.setBounds(218, 59, 85, 21);
		//4ºPaso Se le añade a btnSuma ESTE ActionListener, que es el que he instanciado abajo
		btnSuma.addActionListener(this);//Botón suma tiene que estar escuchando que ocurra un evento, y mandarlo a la instancia de mi clase
		contentPane.add(btnSuma);
		
		btnResta = new JButton("Resta");
		btnResta.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnResta.setBounds(218, 116, 85, 21);
		btnResta.addActionListener(this);
		contentPane.add(btnResta);
	}
	//****Este es el método del que os hablaba en el primer paso.****** 
	@Override
	public void actionPerformed(ActionEvent e) {
		//2ºPaso, hacemos este if con el ActionEvent (en este caso es 'e') getSource asignado al elemento que queremos que este ESCUCHANDO QUE PASA
		//(En este caso btnSuma) y le metemos la lógica
		if(e.getSource()==btnSuma) {
			int num1;
			int num2;
			try {
				num1 = Integer.parseInt(textOp1.getText()); 
				num2 = Integer.parseInt(textOp2.getText());
				int suma = num1 + num2;
				lblResultado.setText("Resultado = " + suma);
			} catch (NumberFormatException e1) {
				lblResultado.setText("Valor no válido");
				JOptionPane.showInternalMessageDialog(null, "Valor no válido");
			} 
		}
		if(e.getSource()==btnResta) {
			int num1;
			int num2;
			try {
				num1 = Integer.parseInt(textOp1.getText()); 
				num2 = Integer.parseInt(textOp2.getText());
				int resta = num1 - num2;
				lblResultado.setText("Resultado = " + resta);
			} catch (NumberFormatException e1) {
				lblResultado.setText("Valor no válido");
				JOptionPane.showInternalMessageDialog(null, "Valor no válido");
			} 

		}
	}
}
