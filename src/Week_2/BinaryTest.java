package Week_2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class BinaryTest {

	private JFrame panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BinaryTest window = new BinaryTest();
					window.panel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BinaryTest() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		panel = new JFrame();
		panel.setBounds(100, 100, 450, 300);
		
		JLabel lblBinaryToDecimal = new JLabel("Binary to Decimal Converter");
		lblBinaryToDecimal.setBounds(0, 0, 50, 200);
		lblBinaryToDecimal.setHorizontalAlignment(SwingConstants.CENTER);
		lblBinaryToDecimal.setFont(new Font("Tahoma", Font.BOLD, 22));
		panel.getContentPane().add(lblBinaryToDecimal);
		
		
	}

}
