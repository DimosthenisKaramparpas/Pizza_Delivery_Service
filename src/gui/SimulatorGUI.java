package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class SimulatorGUI extends JFrame{
	
	private JLabel timeLabel, orderLabel;
	private JTextField timeText, orderText;
	private JButton startButton;
	
	public SimulatorGUI() {
		super("Pizzaria Simulator");
		this.setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		UIManager.put("Control.background", new Color(0x5294E2));
        UIManager.put("TextField.background", new Color(0xD3D7CF));
        UIManager.put("TextField.foreground", new Color(0x2E3436));
        UIManager.put("Button.background", new Color(0x73d216));
        UIManager.put("Button.foreground", new Color(0x2E3436));
        UIManager.put("Label.foreground", new Color (0x2E3436));
        // Get the new look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		timeLabel = new JLabel("Enter time (in hours): ");
		orderLabel = new JLabel("Enter number of orders: ");
		timeText = new JTextField(10);
		orderText = new JTextField(10);
		startButton = new JButton("Start");
		
		startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String time = timeText.getText();
                timeText.setText("");
                String orders = orderText.getText();
                orderText.setText("");
                RunSimulationBtn runSimulationBtn = new RunSimulationBtn(time, orders);
                runSimulationBtn.runSimulation();
            }
        });
		
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.WEST;
		c.insets = new Insets(5,5,5,5);
		c.gridx = 0;
		c.gridy = 0;
		inputPanel.add(timeLabel,c);
		c.gridx = 1;
		inputPanel.add(timeText,c);
		c.gridx = 0;
		c.gridy = 1;
		inputPanel.add(orderLabel,c);
		c.gridx = 1;
		inputPanel.add(orderText,c);
		
		add(inputPanel, BorderLayout.NORTH);
		add(startButton, BorderLayout.SOUTH);

		setSize(300, 150);
		setVisible(true); 
		}
	
}
