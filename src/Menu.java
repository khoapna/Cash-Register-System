import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Panel;
import javax.swing.JScrollBar;
import javax.swing.JMenu;
import javax.swing.JPanel;
import java.awt.TextArea;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextPane;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;

public class Menu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setAlwaysOnTop(true);
		frame.setResizable(false);
		frame.setBounds(0, 0, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// Set background
		
		
		JButton btnPay = new JButton();
		btnPay.setIcon(new ImageIcon("src\\Pictures\\payment.png"));
		btnPay.setBounds(918, 107, 313, 161);
		frame.getContentPane().add(btnPay);
		
		JButton btnDiscount = new JButton();
		btnDiscount.setIcon(new ImageIcon("src\\Pictures\\discount.png"));
		btnDiscount.setBounds(918, 298, 313, 161);
		frame.getContentPane().add(btnDiscount);
		
		JButton btnCancel = new JButton();
		btnCancel.setIcon(new ImageIcon("src\\Pictures\\cancel.png"));
		btnCancel.setBounds(918, 490, 313, 161);
		frame.getContentPane().add(btnCancel);
		
		Panel panel = new Panel();
		panel.setEnabled(false);
		panel.setBounds(52, 107, 393, 544);
		frame.getContentPane().add(panel);
		
		JMenu mnNewMenu = new JMenu("New menu");
		panel.add(mnNewMenu);
		
		// Set titled border with blue line and the title in right
		Border lineBorder = new LineBorder(Color.BLUE, 2);
		Font font = new Font("Serif", Font.BOLD, 40);
		TitledBorder titledBorder = new TitledBorder(lineBorder, "Total", TitledBorder.RIGHT, TitledBorder.CENTER, font, Color.BLUE);
		titledBorder.setTitlePosition(TitledBorder.CENTER);
		
		// Set space for displaying total money
		JLabel labelTotal = new JLabel("Lorem ipsum");
		labelTotal.setBounds(507, 549, 348, 103);
		labelTotal.setBorder(titledBorder);
		frame.getContentPane().add(labelTotal);
		
		// Set titled border with blue line and the title in left bottom
		titledBorder = new TitledBorder(lineBorder, "Bill", TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION, font, Color.BLUE);
		titledBorder.setTitlePosition(TitledBorder.DEFAULT_POSITION);
		
		JEditorPane BillPane = new JEditorPane();
		BillPane.setEditable(false);
		BillPane.setBorder(titledBorder);
		BillPane.setBounds(507, 107, 348, 431);
		frame.getContentPane().add(BillPane);
		
		// Set background
		JLabel Background = new JLabel();
		Background.setBounds(0, 0, 1274, 691);
		Background.setIcon(new ImageIcon("src\\Pictures\\background.png"));
		frame.getContentPane().add(Background);
		
	}
}
