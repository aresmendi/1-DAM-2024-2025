package interfacesGráficas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class MAgenda extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuItem mntmGuardarAgenda;
	private JTextField textFieldNombre;
	private JTextField textFieldTlf;
	private JMenuItem mntmCargarAgenda;
	private JComboBox<String> comboBoxAgenda;
	private ArrayList<Contacto> listaContactos;
	private JButton btnAnyadir;
	private static Scanner rd;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MAgenda frame = new MAgenda();
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
	public MAgenda() {
		listaContactos = new ArrayList<>();

		setTitle("Agenda Contactos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);

		mntmGuardarAgenda = new JMenuItem("GuardarAgenda");
		mnArchivo.add(mntmGuardarAgenda);

		mntmCargarAgenda = new JMenuItem("CargarAgenda");
		mnArchivo.add(mntmCargarAgenda);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNombreContacto = new JLabel("Nombre Contacto");
		lblNombreContacto.setFont(new Font("Arial", Font.BOLD, 13));
		lblNombreContacto.setBounds(41, 47, 121, 25);
		contentPane.add(lblNombreContacto);

		JLabel lblTelfono = new JLabel("Teléfono");
		lblTelfono.setFont(new Font("Arial", Font.BOLD, 13));
		lblTelfono.setBounds(41, 102, 121, 25);
		contentPane.add(lblTelfono);

		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(205, 50, 128, 19);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);

		textFieldTlf = new JTextField();
		textFieldTlf.setColumns(10);
		textFieldTlf.setBounds(205, 105, 128, 19);
		contentPane.add(textFieldTlf);

		btnAnyadir = new JButton("Añadir");
		btnAnyadir.setBounds(341, 78, 85, 21);
		contentPane.add(btnAnyadir);
		btnAnyadir.addActionListener(this);

		comboBoxAgenda = new JComboBox<>();
		comboBoxAgenda.setBounds(73, 156, 292, 21);
		contentPane.add(comboBoxAgenda);
		
		mntmGuardarAgenda.addActionListener(this);
		mntmCargarAgenda.addActionListener(this);
	}

	public void llenarAgenda() {
		try {
			FileWriter fw = new FileWriter("agenda.txt");
			for (Contacto contacto : listaContactos) {
				String linea = contacto.toString();
				fw.write(linea + "\n"); //IMPORTANTE EL SALTO DE LINEA
			}
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public void traerAMemoria() {
		File f = new File("agenda.txt");
		try {
			rd = new Scanner(f);
			while (rd.hasNextLine()) {
				String linea = rd.nextLine();
				String[] partes = linea.split(",");
				String nombre = partes[0];
				String tlf = partes[1];
				listaContactos.add(new Contacto(nombre, tlf));
				comboBoxAgenda.addItem(linea);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnAnyadir) {
			String nombre = textFieldNombre.getText();
			String tlf = textFieldTlf.getText();
			Contacto nuevo = new Contacto(nombre,tlf);
			listaContactos.add(nuevo);
			comboBoxAgenda.addItem(nuevo.toString());
		}
		if(e.getSource() == mntmGuardarAgenda) {
			llenarAgenda();
		}
		if(e.getSource() == mntmCargarAgenda) {
			traerAMemoria();
		}
	}
}
