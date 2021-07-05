package Test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class GUIConsumerTest {

	private JFrame frmGuiItiGr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIConsumerTest window = new GUIConsumerTest();
					window.frmGuiItiGr.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUIConsumerTest() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGuiItiGr = new JFrame();
		frmGuiItiGr.getContentPane().setBackground(new Color(189, 183, 107));
		frmGuiItiGr.setBackground(new Color(128, 0, 128));
		frmGuiItiGr.setTitle("GUI ITI GR3");
		frmGuiItiGr.setBounds(100, 100, 504, 373);
		frmGuiItiGr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frmGuiItiGr.getContentPane().setLayout(gridBagLayout);
		
		Button button = new Button("DisplayDataFrame");
		button.setBackground(new Color(176, 224, 230));
		button.setFont(new Font("Dialog", Font.BOLD, 12));
		button.setForeground(Color.BLACK);
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 2;
		gbc_button.gridy = 1;
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ConsumerTest ob =new ConsumerTest();
				ob.ReadCSVandDisplayDataFrame();				
			}
			
			
		});
		frmGuiItiGr.getContentPane().add(button, gbc_button);
		
		Button button_4 = new Button("Summary");
		button_4.setBackground(new Color(32, 178, 170));
		button_4.setFont(new Font("Dialog", Font.BOLD, 10));
		button_4.setForeground(new Color(0, 0, 0));
		GridBagConstraints gbc_button_4 = new GridBagConstraints();
		gbc_button_4.anchor = GridBagConstraints.NORTH;
		gbc_button_4.insets = new Insets(0, 0, 5, 5);
		gbc_button_4.gridx = 5;
		gbc_button_4.gridy = 1;
		button_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ConsumerTest ob =new ConsumerTest();
				ob.StructureandSummary();				
			}
			
			
		});
		frmGuiItiGr.getContentPane().add(button_4, gbc_button_4);
		
		Button button_8 = new Button("Cleaning");
		button_8.setBackground(new Color(176, 224, 230));
		GridBagConstraints gbc_button_8 = new GridBagConstraints();
		gbc_button_8.gridwidth = 4;
		gbc_button_8.insets = new Insets(0, 0, 5, 0);
		gbc_button_8.gridx = 6;
		gbc_button_8.gridy = 1;
		button_8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ConsumerTest ob =new ConsumerTest();
				ob.DataCleaning();				
			}
			
			
		});
		frmGuiItiGr.getContentPane().add(button_8, gbc_button_8);
		
		Button button_1 = new Button("TopDemandingCompaniesforJobs");
		button_1.setBackground(new Color(255, 222, 173));
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.gridwidth = 2;
		gbc_button_1.anchor = GridBagConstraints.EAST;
		gbc_button_1.insets = new Insets(0, 0, 5, 5);
		gbc_button_1.gridx = 1;
		gbc_button_1.gridy = 3;
		button_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ConsumerTest ob =new ConsumerTest();
				ob.TopDemandingCompaniesforJobs();				
			}
			
			
		});
		frmGuiItiGr.getContentPane().add(button_1, gbc_button_1);
		
		Button button_5 = new Button("PlotTopDemandingCompanies");
		GridBagConstraints gbc_button_5 = new GridBagConstraints();
		gbc_button_5.gridwidth = 2;
		gbc_button_5.insets = new Insets(0, 0, 5, 5);
		gbc_button_5.gridx = 4;
		gbc_button_5.gridy = 3;
		button_5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ConsumerTest ob =new ConsumerTest();
				ob.PlotTopDemandingCompanies();				
			}
			
			
		});
		frmGuiItiGr.getContentPane().add(button_5, gbc_button_5);
		
		Button button_9 = new Button("TopPopularJobTitle");
		GridBagConstraints gbc_button_9 = new GridBagConstraints();
		gbc_button_9.gridwidth = 4;
		gbc_button_9.insets = new Insets(0, 0, 5, 0);
		gbc_button_9.gridx = 6;
		gbc_button_9.gridy = 3;
		button_9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ConsumerTest ob =new ConsumerTest();
				ob.TopPopularJobTitle();				
			}
			
			
		});
		
		frmGuiItiGr.getContentPane().add(button_9, gbc_button_9);
		
		Button button_2 = new Button("PlotTopPopularJobTitles");
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.insets = new Insets(0, 0, 5, 5);
		gbc_button_2.gridx = 2;
		gbc_button_2.gridy = 6;
		button_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ConsumerTest ob =new ConsumerTest();
				ob.PlotTopPopularJobTitles();				
			}
			
			
		});
		frmGuiItiGr.getContentPane().add(button_2, gbc_button_2);
		
		Button button_6 = new Button("TopPopularAreas");
		GridBagConstraints gbc_button_6 = new GridBagConstraints();
		gbc_button_6.gridwidth = 3;
		gbc_button_6.insets = new Insets(0, 0, 5, 5);
		gbc_button_6.gridx = 3;
		gbc_button_6.gridy = 6;
		button_6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ConsumerTest ob =new ConsumerTest();
				ob.TopPopularAreas();				
			}
			
			
		});
		frmGuiItiGr.getContentPane().add(button_6, gbc_button_6);
		
		Button button_10 = new Button("PlotTopPopularAreas");
		GridBagConstraints gbc_button_10 = new GridBagConstraints();
		gbc_button_10.gridwidth = 4;
		gbc_button_10.insets = new Insets(0, 0, 5, 0);
		gbc_button_10.gridx = 6;
		gbc_button_10.gridy = 6;
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsumerTest ob =new ConsumerTest();
				ob.PlotTopPopularAreas();	
			}
		});
		frmGuiItiGr.getContentPane().add(button_10, gbc_button_10);
		
		Button button_3 = new Button("TopSkills");
		GridBagConstraints gbc_button_3 = new GridBagConstraints();
		gbc_button_3.insets = new Insets(0, 0, 5, 5);
		gbc_button_3.gridx = 2;
		gbc_button_3.gridy = 8;
		button_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ConsumerTest ob =new ConsumerTest();
				ob.TopSkills();				
			}
			
			
		});
		frmGuiItiGr.getContentPane().add(button_3, gbc_button_3);
		
		Button button_7 = new Button("YearsExpFactorization");
		GridBagConstraints gbc_button_7 = new GridBagConstraints();
		gbc_button_7.insets = new Insets(0, 0, 5, 5);
		gbc_button_7.gridx = 5;
		gbc_button_7.gridy = 8;
		button_7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ConsumerTest ob =new ConsumerTest();
				ob.YearsExpFactorization();				
			}
			
			
		});
		frmGuiItiGr.getContentPane().add(button_7, gbc_button_7);
		
		Button button_11 = new Button("Kmeans");
		GridBagConstraints gbc_button_11 = new GridBagConstraints();
		gbc_button_11.gridwidth = 4;
		gbc_button_11.insets = new Insets(0, 0, 5, 0);
		gbc_button_11.gridx = 6;
		gbc_button_11.gridy = 8;
		button_11.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ConsumerTest ob =new ConsumerTest();
				ob.Kmeans();				
			}
			
			
		});
		frmGuiItiGr.getContentPane().add(button_11, gbc_button_11);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ConsumerTest ob =new ConsumerTest();
				return;				
			}
			
			
		});
		
		Button button_13 = new Button("Exit");
		GridBagConstraints gbc_button_13 = new GridBagConstraints();
		gbc_button_13.gridwidth = 4;
		gbc_button_13.insets = new Insets(0, 0, 0, 5);
		gbc_button_13.gridx = 2;
		gbc_button_13.gridy = 10;
		frmGuiItiGr.getContentPane().add(button_13, gbc_button_13);
		button_13.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ConsumerTest ob =new ConsumerTest();
								
			}
			
			
		});
	}

}
