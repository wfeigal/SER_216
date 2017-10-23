package Week_2;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Assignment2 extends JFrame {

	private JPanel contentPane;
	private JTextField binaryTxtBx;
	private JTextField decimalTxtBx;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Assignment2 frame = new Assignment2();
					try {//IF NIMBUS LOOK AND FEEL IS NOT AVAILABLE, USE STANDARD FORM
						UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
						SwingUtilities.updateComponentTreeUI(frame);
					}
					catch (Exception e) {
						//do Nothing
					}
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
	public Assignment2() {
		setTitle("Binary to Decimal Converter");
		//SETUP FRAME AND PANE
		try {
			setIconImage(Toolkit.getDefaultToolkit().getImage(Assignment2.class.getResource("/Images/icon010.png")));
		}
		catch (Exception e) {
			//do nothing - use default Icon
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 457, 200);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//ADD TOP TITLE TO FORM
		JLabel topTitle = new JLabel("Binary to Decimal Converter");
		topTitle.setHorizontalAlignment(SwingConstants.CENTER);
		topTitle.setFont(new Font("Tahoma", Font.BOLD, 24));
		topTitle.setBounds(10, 11, 414, 38);
		contentPane.add(topTitle);
		
		//ENTRY AND RESULT TEXT BOXES
		binaryTxtBx = new JTextField();
		binaryTxtBx.setFont(new Font("Tahoma", Font.BOLD, 11));
		binaryTxtBx.setText("Enter Binary Value.....");
		binaryTxtBx.setBounds(217, 54, 149, 30);
		binaryTxtBx.requestFocus();
		binaryTxtBx.selectAll();
		contentPane.add(binaryTxtBx);
		binaryTxtBx.setColumns(10);		
		binaryTxtBx.addFocusListener(new FocusAdapter() {//when focus is returned to the input box highlight all to facilitate data entry
			@Override
			public void focusGained(FocusEvent arg0) {
				binaryTxtBx.selectAll();
			}
		});	
		decimalTxtBx = new JTextField();
		decimalTxtBx.setFont(new Font("Tahoma", Font.BOLD, 11));
		decimalTxtBx.setEditable(false);
		decimalTxtBx.setBounds(217, 88, 149, 30);
		contentPane.add(decimalTxtBx);
		decimalTxtBx.setColumns(10);
		
		//FORM LABELS
		JLabel binaryLbl = new JLabel("Binary Value");
		binaryLbl.setHorizontalAlignment(SwingConstants.TRAILING);
		binaryLbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		binaryLbl.setBounds(86, 60, 121, 14);
		contentPane.add(binaryLbl);
		
		JLabel decimalLbl = new JLabel("Decimal Value");
		decimalLbl.setHorizontalAlignment(SwingConstants.TRAILING);
		decimalLbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		decimalLbl.setBounds(86, 94, 121, 14);
		contentPane.add(decimalLbl);
		
		//FORM BUTTON TO START CONVERSION PROCESS
		JButton convertBtn = new JButton("Convert to Decimal");
		convertBtn.setBackground(SystemColor.controlShadow);
		convertBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		convertBtn.setBounds(130, 122, 192, 33);
		contentPane.add(convertBtn);
		
		//EXECUTE THE CONVERSTION UPON BUTTON CLICK
		convertBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					decimalTxtBx.setText(Integer.toString(parseBinary(binaryTxtBx.getText())));
				}
				catch (NumberFormatException e) {
					decimalTxtBx.setText("Error: Invalid Input");
				}
			}
		});
	}
	private static int parseBinary(String binaryString) throws NumberFormatException {
		//VARIABLES AND DECLARATIONS
		int test = 0, val = 0, result = 0;
		//GET RID OF WHITESPACE WITHIN INPUT STRING
		binaryString = binaryString.trim().replaceAll("\\s", "");
		
		//ITERATE THROUGH THE INPUT STRING AND IF ANY VALUE IS GREATER THAN 1, THROW EXCEPTION
		for (int i = 0; i < binaryString.length(); i++) {
			test = Character.getNumericValue(binaryString.charAt(i));
			if (test > 1 || test < 0)
				throw new NumberFormatException();
		}
		
		//ITERATE THROUGH THE INPUT STRING AND IF A 1 IS FOUND RAISE 2 TO THE 
		//POWER IF ITS POSITION IN THE STRING AND ADD THAT TO THE RESULT
		for (int i = 0; i < binaryString.length(); i++) {
			val = Character.getNumericValue(binaryString.charAt(i));
			if (val == 1) {
				result += Math.pow(2, i);
			}
		}

		return result;
	}
}
