package interfacesGráficas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class BurgerApp extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JComboBox<String> comboBoxBurgers;
	private JComboBox<String> comboBoxBebida; 
	private JComboBox<String> comboBoxPatatas;
	private JComboBox<String> comboBoxPan;
	private JCheckBox chckbxBurgerDoble;
	private JCheckBox chckbxExtraQueso;
	private JCheckBox chckbxExtraPatatas;
	private JLabel lblPedir;
	private JButton btnKetchup;
	private JButton btnMostaza;
	private JButton btnBarbacoa;
	private JButton btnThai;
	private ButtonGroup rbButton;
	private JRadioButton rdbtnRecogida;
	private JRadioButton rdbtnADomicilio;
	private JButton btnPedir;
	private JLabel lblTotal;
	private double total = 8.0;
	private int numSalsas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BurgerApp frame = new BurgerApp();
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
	public BurgerApp() {
		setTitle("BurgerApp");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 537);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblBurger = new JLabel("Burger");
		lblBurger.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBurger.setBounds(60, 146, 100, 21);
		contentPane.add(lblBurger);

		JLabel lblObligatorio = new JLabel("OBLIGATORIO");
		lblObligatorio.setForeground(new Color(255, 0, 0));
		lblObligatorio.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblObligatorio.setBounds(88, 105, 135, 21);
		contentPane.add(lblObligatorio);

		JLabel lblBebida = new JLabel("Bebida");
		lblBebida.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBebida.setBounds(60, 279, 100, 21);
		contentPane.add(lblBebida);
		
		JLabel lblPatatas = new JLabel("Patatas");
		lblPatatas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPatatas.setBounds(60, 234, 100, 21);
		contentPane.add(lblPatatas);
		
		JLabel lblPan = new JLabel("Pan");
		lblPan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPan.setBounds(60, 191, 100, 21);
		contentPane.add(lblPan);
		
		JLabel lblExtra = new JLabel("EXTRA");
		lblExtra.setHorizontalAlignment(SwingConstants.CENTER);
		lblExtra.setForeground(Color.RED);
		lblExtra.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblExtra.setBounds(293, 105, 135, 21);
		contentPane.add(lblExtra);
		
		JLabel lblMenBsico = new JLabel("MENÚ BÁSICO 8€ ");
		lblMenBsico.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenBsico.setForeground(Color.RED);
		lblMenBsico.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMenBsico.setBounds(88, 43, 340, 21);
		contentPane.add(lblMenBsico);

		JLabel lblSalsas = new JLabel("SALSAS (+0,50€)");
		lblSalsas.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSalsas.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalsas.setBounds(335, 211, 117, 21);
		contentPane.add(lblSalsas);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNombre.setBounds(275, 355, 96, 21);
		contentPane.add(lblNombre);

		
		comboBoxBurgers = new JComboBox<>(new String[] {"Pollo","Cerdo","Ternera (+1€)","Vegana(+1€)"});
		comboBoxBurgers.setBounds(170, 146, 103, 21);
		contentPane.add(comboBoxBurgers);
		comboBoxBurgers.addActionListener(this);

		comboBoxBebida = new JComboBox<>(new String [] {"Cola","Naranja","Limón","Agua","Cerveza"});
		comboBoxBebida.setBounds(170, 279, 103, 21);
		contentPane.add(comboBoxBebida);
		comboBoxBebida.addActionListener(this);
		
		comboBoxPatatas = new JComboBox<>(new String[] {"Fritas", "Gajo","Caseras(+1€)"});
		comboBoxPatatas.setBounds(170, 234, 103, 21);
		contentPane.add(comboBoxPatatas);
		comboBoxPatatas.addActionListener(this);
		
		comboBoxPan = new JComboBox<>(new String[] {"Normal", "Integral", "Centeno"});
		comboBoxPan.setBounds(170, 191, 103, 21);
		contentPane.add(comboBoxPan);
		comboBoxPan.addActionListener(this);
		
		chckbxBurgerDoble = new JCheckBox("Doble Burger (+2€)");
		chckbxBurgerDoble.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxBurgerDoble.setBounds(325, 146, 127, 21);
		contentPane.add(chckbxBurgerDoble);
		chckbxBurgerDoble.addActionListener(this);
		
		chckbxExtraQueso = new JCheckBox("Extra Queso (+0,50)");
		chckbxExtraQueso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxExtraQueso.setBounds(325, 169, 135, 21);
		contentPane.add(chckbxExtraQueso);
		chckbxExtraQueso.addActionListener(this);
		
		chckbxExtraPatatas = new JCheckBox("Extra Patatas (+1€)");
		chckbxExtraPatatas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxExtraPatatas.setBounds(325, 192, 135, 21);
		contentPane.add(chckbxExtraPatatas);
		chckbxExtraPatatas.addActionListener(this);
		
		btnKetchup = new JButton("Ketchup");
		btnKetchup.setBounds(311, 234, 85, 21);
		contentPane.add(btnKetchup);
		btnKetchup.addActionListener(this);
		
		btnMostaza = new JButton("Mostaza");
		btnMostaza.setBounds(311, 279, 85, 21);
		contentPane.add(btnMostaza);
		btnMostaza.addActionListener(this);
		
		btnBarbacoa = new JButton("BBQ");
		btnBarbacoa.setBounds(401, 234, 85, 21);
		contentPane.add(btnBarbacoa);
		btnBarbacoa.addActionListener(this);
		
		btnThai = new JButton("Thai");
		btnThai.setBounds(401, 279, 85, 21);
		contentPane.add(btnThai);
		btnThai.addActionListener(this);
		
		rbButton = new ButtonGroup();
		rbButton.add(rdbtnRecogida);
		rbButton.add(rdbtnADomicilio);

		rdbtnRecogida = new JRadioButton("Recogida en Local (-20%)");
		rdbtnRecogida.setBounds(60, 331, 186, 21);
		contentPane.add(rdbtnRecogida);
		rdbtnRecogida.addActionListener(this);
		
		rdbtnADomicilio = new JRadioButton("A Domicilio");
		rdbtnADomicilio.setBounds(60, 355, 163, 21);
		contentPane.add(rdbtnADomicilio);
		rdbtnADomicilio.addActionListener(this);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(373, 357, 96, 19);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		textFieldNombre.addActionListener(this);

		btnPedir = new JButton("Pedir");
		btnPedir.setBounds(401, 414, 85, 21);
		contentPane.add(btnPedir);
		btnPedir.addActionListener(this);

		lblPedir = new JLabel("");
		lblPedir.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPedir.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPedir.setBounds(10, 414, 386, 21);
		contentPane.add(lblPedir);
		
		lblTotal = new JLabel("");
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTotal.setBounds(328, 444, 100, 21);
		contentPane.add(lblTotal);

	}
	private void calcularTotal() {
	    total = 8.0;

	    // Extras según selección
	    if (comboBoxBurgers.getSelectedItem().toString().contains("+1€")) total += 1;
	    if (comboBoxPatatas.getSelectedItem().toString().contains("+1€")) total += 1;
	    if (chckbxBurgerDoble.isSelected()) total += 2;
	    if (chckbxExtraPatatas.isSelected()) total += 1;
	    if (chckbxExtraQueso.isSelected()) total += 0.5;

	    // Salsas → mejor tener un contador
	    total += numSalsas * 0.5;

	    // Recogida con descuento
	    if (rdbtnRecogida.isSelected()) total *= 0.80;

	    lblTotal.setText(total + "€");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String resumen = "Hamburguesa de " + comboBoxBurgers.getSelectedItem() + " con patatas " + comboBoxPatatas.getSelectedItem() + " y pan " + comboBoxPan.getSelectedItem();
		String resumenCompleto = "Pedido de " + textFieldNombre.getText() + resumen + ". Bebida " + comboBoxBebida.getSelectedItem() + " " + total;
		
		if (e.getSource() == btnBarbacoa || e.getSource() == btnKetchup || e.getSource() == btnMostaza || e.getSource() == btnThai) numSalsas++;
		
		lblPedir.setText(resumen);
		
		if (e.getSource() == btnPedir) {
			try {
				FileWriter fw = new FileWriter("pedidos.txt", true);
				fw.write(resumenCompleto);
				JOptionPane.showMessageDialog(contentPane, "Pedido Registrado con éxito");
				fw.close();
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(contentPane, "Error de escritura", getTitle(), JOptionPane.ERROR_MESSAGE);
			}
		}
		calcularTotal();
	}
}
