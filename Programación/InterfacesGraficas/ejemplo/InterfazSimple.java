package ejemplo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JFormattedTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;


public class InterfazSimple extends JFrame {
	//Este es el intento que hice antes de ir a clase
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jTextField1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazSimple frame = new InterfazSimple();
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
	public InterfazSimple() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel jPanelGeneral = new JPanel();
		jPanelGeneral.setBounds(0, 0, 436, 199);
		contentPane.add(jPanelGeneral);
		jPanelGeneral.setLayout(null);
		
		JLabel jLabel1 = new JLabel("Etiqueta");
		jLabel1.setBounds(189, 73, 66, 24);
		jPanelGeneral.add(jLabel1);
		
		jTextField1 = new JTextField();
		jTextField1.setText("textoAleatorio");
		jTextField1.setBounds(139, 107, 143, 19);
		jPanelGeneral.add(jTextField1);
		jTextField1.setColumns(10);
		
		JButton jButton1 = new JButton("Botón");
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(InterfazSimple.this, jTextField1.getText());
			}
		});
		jButton1.setBounds(170, 136, 85, 21);
		jPanelGeneral.add(jButton1);
		
		JRadioButton opcion1RadioButton = new JRadioButton("Opcion 1");
		opcion1RadioButton.setBounds(22, 30, 103, 21);
		jPanelGeneral.add(opcion1RadioButton);
		
		JRadioButton opcion2RadioButton = new JRadioButton("Opcion 2");
		opcion2RadioButton.setBounds(22, 75, 103, 21);
		jPanelGeneral.add(opcion2RadioButton);
		
		ButtonGroup grupoBotones = new ButtonGroup();
		grupoBotones.add(opcion1RadioButton);
		grupoBotones.add(opcion2RadioButton);
		
		try {
			MaskFormatter maskDNI = new MaskFormatter("######## - ?");
			JFormattedTextField formattedTextField = new JFormattedTextField(maskDNI);
			formattedTextField.setBounds(139, 31, 163, 19);
			jPanelGeneral.add(formattedTextField);
			
			JMenuBar menuBar = new JMenuBar();
			menuBar.setBounds(0, 0, 436, 24);
			jPanelGeneral.add(menuBar);
			
			JMenu jMenu1 = new JMenu("File");
			menuBar.add(jMenu1);
			
			JMenu jMenu2 = new JMenu("Edit");
			menuBar.add(jMenu2);
			
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
	}
}
