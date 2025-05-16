package ticTacToe;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


public class TicTacToe extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton[][] buttons;
	private char[][] ganar;
	private int turno;
	private JMenuItem mntmEmpezar;
	private JMenuItem mntmNombreJugador;
	private JMenuItem mntmTurno; 
	private String [] jugadores;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TicTacToe frame = new TicTacToe();
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
	public TicTacToe() {
		setTitle("TicTacToe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mntmJuego = new JMenu("Juego");
		menuBar.add(mntmJuego);

		mntmEmpezar = new JMenuItem("Empezar");
		mntmJuego.add(mntmEmpezar);

		mntmNombreJugador = new JMenuItem("");
		mntmNombreJugador.setEnabled(false);
		menuBar.add(mntmNombreJugador);

		mntmTurno = new JMenuItem("");
		mntmTurno.setEnabled(false);
		menuBar.add(mntmTurno);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		mntmEmpezar.addActionListener(this);

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 3, 0, 0));

		/*Botón de ejemplo para el tema de colorear y hacer que no se pueda volver a pulsar
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setEnabled(false);
		btnNewButton.setBackground(new Color(255, 0, 0));
		contentPane.add(btnNewButton); */

		//Una array para acceder a los jugadores faciliitooo (después de más tiempo del que gustaría reconocer)
		jugadores = new String[2];

		//Creamos los botones al toque 
		buttons = new JButton[3][3];
		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons[i].length; j++) {
				JButton boton = new JButton();
				buttons[i][j] = boton;
				contentPane.add(boton);
				boton.addActionListener(this);
				boton.setEnabled(false);//Esto es para que no se pueda seleccionar nada hasta que empiece la partida
			}
		}
		//Y el tablero auxiliar para ver quién gana
		ganar = new char[3][3];
		for (int i = 0; i < ganar.length; i++) {
			for (int j = 0; j < ganar[i].length; j++) {
				ganar[i][j] = '*';
			}
		}

	}
	//Esto para comprobar cada combinación
	public boolean hayGanador() {
		//Comprobar fila
		for (int i = 0; i < 3; i++) {
			if (ganar [i][0] != '*' &&
					ganar [i][0] == ganar[i][1] &&
					ganar [i][1] == ganar[i][2]) {
				return true;
			}
		}
		//Comprobar columnas
		for (int j = 0; j < 3; j++) {
			if (ganar [0][j] != '*' &&
					ganar [0][j] == ganar[1][j] &&
					ganar [1][j] == ganar[2][j]) {
				return true;
			}
		}
		//Comprobar 1ºDiagonal
		if (ganar [0][0] != '*' &&
				ganar [0][0] == ganar[1][1] &&
				ganar [1][1] == ganar[2][2]) {
			return true;
		}
		//Comprobar 2ºDiagonal
		if (ganar [0][2] != '*' &&
				ganar [0][2] == ganar[1][1] &&
				ganar [1][1] == ganar[2][0]) {
			return true;
		}
		//Si nada se cumple, no gana nadie
		return false;

	}
	public void deshabilitarTablero() {
		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons[i].length; j++) {
				buttons[i][j].setEnabled(false);

			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==mntmEmpezar) {
			//Este bucle para reinciar todo antes de que empiece la partida
			for (int i = 0; i < buttons.length; i++) {
				for (int j = 0; j < buttons[i].length; j++) {
					buttons[i][j].setEnabled(true);
					buttons[i][j].setBackground(null); //Para que se queden los botonos con su aspecto a botón
					ganar[i][j] = '*';
				}
			}
			mntmNombreJugador.setText("");
			mntmTurno.setText("");
			String jugador1 = JOptionPane.showInputDialog("Introduzca nombre Jugador1");
			jugadores[0] = jugador1;
			String jugador2 = JOptionPane.showInputDialog("Introduzca nombre Jugador2");
			jugadores[1] =jugador2;
			turno = 1;
			mntmNombreJugador.setText(jugador1);
			mntmTurno.setText(String.valueOf(turno));
			return;
		}
		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons[i].length; j++) {
				if(e.getSource()==buttons[i][j]) {
					mntmTurno.setText(String.valueOf(turno));
					mntmNombreJugador.setText(jugadores[turno % 2]);
					if(turno%2 != 0) {
						buttons[i][j].setEnabled(false);
						buttons[i][j].setBackground(new Color(255, 0, 0));
						ganar[i][j] = 'X';
						if(hayGanador()) {
							JOptionPane.showMessageDialog(contentPane, jugadores[0] + " gana!");
							deshabilitarTablero();
							return;
						}
						turno++;
					}else {
						buttons[i][j].setEnabled(false);
						buttons[i][j].setBackground(new Color(0, 255, 0));
						ganar[i][j] = 'O';
						if(hayGanador()) {
							JOptionPane.showMessageDialog(contentPane, jugadores[1] + " gana!");
							deshabilitarTablero();
							return;
						}
						turno++;
					}
					if(turno == 10) {
						JOptionPane.showMessageDialog(contentPane, "Se ha quedado en TABLAS");
						return;
					}
				}
			}
		}

	}

}
