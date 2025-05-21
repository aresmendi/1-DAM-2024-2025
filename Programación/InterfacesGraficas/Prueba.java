package interfacesGráficas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JSpinner;

public class Prueba extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox<String> comboBoxGrupos;
	private JTextField textFieldNombre;
	private JTextField textFieldApellidos;
	private JRadioButton rdbtnOtro;
	private JRadioButton rdbtnHombre;
	private JRadioButton rdbtnMujer;
	private ButtonGroup rbSexo;
	private JButton btnEnviar;
	private JTextArea textAreaObservaciones;
	private JSpinner spinnerEdad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prueba frame = new Prueba();
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
	public Prueba() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		comboBoxGrupos = new JComboBox<>(new String[]{"1ºPresencial","2ºPresencial","1ºSemiPresencial","2ºSemipresencial"});
		comboBoxGrupos.setBounds(279, 126, 80, 21);
		contentPane.add(comboBoxGrupos);

		JLabel lblGrupo = new JLabel("Grupo");
		lblGrupo.setBounds(201, 126, 80, 21);
		contentPane.add(lblGrupo);

		JLabel lblObservaciones = new JLabel("Observaciones");
		lblObservaciones.setBounds(10, 205, 80, 21);
		contentPane.add(lblObservaciones);

		rdbtnMujer = new JRadioButton("Hombre");
		rdbtnMujer.setBounds(279, 30, 103, 21);
		contentPane.add(rdbtnMujer);

		rdbtnHombre = new JRadioButton("Mujer");
		rdbtnHombre.setBounds(279, 53, 103, 21);
		contentPane.add(rdbtnHombre);

		rdbtnOtro = new JRadioButton("Otro");
		rdbtnOtro.setBounds(279, 76, 103, 21);
		contentPane.add(rdbtnOtro);

		rbSexo = new ButtonGroup();
		rbSexo.add(rdbtnHombre);
		rbSexo.add(rdbtnMujer);
		rbSexo.add(rdbtnOtro);

		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(201, 53, 72, 21);
		contentPane.add(lblSexo);

		btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(317, 205, 85, 21);
		contentPane.add(btnEnviar);
		btnEnviar.addActionListener(this);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 30, 57, 17);
		contentPane.add(lblNombre);

		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(66, 30, 72, 19);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);

		textAreaObservaciones = new JTextArea();
		textAreaObservaciones.setBounds(100, 193, 142, 43);
		contentPane.add(textAreaObservaciones);

		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(10, 57, 57, 17);
		contentPane.add(lblApellidos);

		textFieldApellidos = new JTextField();
		textFieldApellidos.setColumns(10);
		textFieldApellidos.setBounds(66, 54, 125, 19);
		contentPane.add(textFieldApellidos);
		
		SpinnerNumberModel modelo = new SpinnerNumberModel(16,15,100,1);
		spinnerEdad = new JSpinner();
		spinnerEdad.setBounds(66, 99, 45, 20);
		spinnerEdad.setModel(modelo);
		contentPane.add(spinnerEdad);

		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(11, 102, 45, 13);
		contentPane.add(lblEdad);
	}
	private String obtenerSexoSeleccionado() {
		if (rdbtnHombre.isSelected()) return rdbtnHombre.getText();
		if (rdbtnMujer.isSelected()) return rdbtnMujer.getText();
		if (rdbtnOtro.isSelected()) return rdbtnOtro.getText();
		return "No especificado";
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnEnviar) {
			try {
				FileWriter fw = new FileWriter("Registros.txt",true);
				fw.write(textFieldNombre.getText() + " " + textFieldApellidos.getText()+ "*" + spinnerEdad.getValue() + "*" 
				+ obtenerSexoSeleccionado() + "*"  + comboBoxGrupos.getSelectedItem() + "*" + textAreaObservaciones.getText() +"\n");
				JOptionPane.showMessageDialog(contentPane, "Introducido en el Fichero");
				fw.close();
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(contentPane, "Error de escritura", getTitle(), JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
