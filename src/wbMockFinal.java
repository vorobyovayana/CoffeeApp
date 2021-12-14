package GUImockfinal;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class wbMockFinal extends JFrame {

	private JPanel contentPane;
	private JLabel lblMenu;
	private JList list;
	private JRadioButton rdbtnSmall;
	private JRadioButton rdbtnMedium;
	private JRadioButton rdbtnLarge;
	private JButton btnAdd;
	private JButton btnConfirm;
	private JComboBox Coffees;
	ArrayList<menuItem> coffees =  new ArrayList<>();
	ArrayList<orderItem>chosenCoffees = new ArrayList<>();
	DefaultListModel<String> itemsOrdered = new DefaultListModel<>();
	int coffeeCount;
	int chosenCoffeesCount = 0;
	private JLabel lblSize;
	private JLabel lblTotal;
	int chosenIdx;
	double price;
	String size;
	double Total;
	private JLabel lblTotal1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					wbMockFinal frame = new wbMockFinal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void setUpComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		list = new JList();
		
		DefaultListModel<String> itemsList= new DefaultListModel<>();
		
		lblMenu = new JLabel("Menu:");
		lblSize = new JLabel("Size:");	
		lblTotal = new JLabel("Total:  $0");
		JLabel lblItemsOrdered = new JLabel("ItemsOrdered");
		Coffees = new JComboBox();
		ButtonGroup G = new ButtonGroup();
		rdbtnSmall = new JRadioButton("Small");
		rdbtnMedium = new JRadioButton("Medium");
		rdbtnLarge = new JRadioButton("Large");
		
		G.add(rdbtnSmall);
		G.add(rdbtnMedium);
		G.add(rdbtnLarge);
		
		btnAdd = new JButton("Add to order");
		
		btnConfirm = new JButton("Confirm order");
		
		lblTotal1 = new JLabel("Total:" + String.format("%.2f", Total) +"$");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addContainerGap()
									.addComponent(lblMenu, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
									.addGap(120)
									.addComponent(lblSize)
									.addGap(73))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(Coffees, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addContainerGap()
											.addComponent(lblItemsOrdered)))
									.addGap(28)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(rdbtnSmall)
										.addComponent(rdbtnMedium, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
										.addComponent(rdbtnLarge))
									.addGap(29)))
							.addGap(5)
							.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
							.addGap(160))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(list, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(76)
									.addComponent(lblTotal1))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(49)
									.addComponent(btnConfirm, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)))
							.addGap(171)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblTotal, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblMenu))
						.addComponent(lblSize))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(22)
							.addComponent(Coffees, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(rdbtnSmall)
								.addComponent(btnAdd))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rdbtnMedium, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(20)
							.addComponent(lblItemsOrdered, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rdbtnLarge)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(9)
							.addComponent(btnConfirm)
							.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
							.addComponent(lblTotal1)
							.addGap(34))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(list, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(156)
					.addComponent(lblTotal)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public void readFile(String filePath) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(filePath));
			String line;
			while ((line = br.readLine()) != null) {
				String[] tokens = line.split(",");
				menuItem coffee = new menuItem(tokens[0],Double.parseDouble(tokens[1]),Double.parseDouble(tokens[2]),Double.parseDouble(tokens[3]));				
				coffees.add(coffee);
				Coffees.addItem(coffee.getName());
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void getPricesAndSizes() {
		price = 0.0;
		if(rdbtnSmall.isSelected()) {
			price = coffees.get(chosenIdx).getPriceSmall();
			size = "Small";
		}
		else if(rdbtnMedium.isSelected()) {
			price = coffees.get(chosenIdx).getPriceMedium();
			size = "Medium";
		}
		else if(rdbtnLarge.isSelected()) {
			price = coffees.get(chosenIdx).getPriceLarge();
			size = "Large";
		}
	}

	
	public void createEvents() {
		
		Coffees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					chosenIdx = Coffees.getSelectedIndex();
					rdbtnSmall.setText("Small "+ coffees.get(chosenIdx).getPriceSmall()+"$");
					rdbtnMedium.setText("Medium "+ coffees.get(chosenIdx).getPriceMedium()+"$");
					rdbtnLarge.setText("Large "+ coffees.get(chosenIdx).getPriceLarge()+"$");					
				}				
			}
		);
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getPricesAndSizes();
				orderItem item = new orderItem(coffees.get(chosenIdx).getName(), price, size);
				chosenCoffees.add(item);
				itemsOrdered.addElement(item.getName()+", "+ item.getPrice()+", "+ item.getSize());
				Total+= item.getPrice();
				chosenCoffeesCount++;
				list.setModel(itemsOrdered);
				lblTotal1.setText("Total: "+ String.format("%.2f", Total)+"$");	
			}
		});
		
		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				 if (e.getClickCount() == 2) {
					 int toRemove = list.getSelectedIndex();
					 if(toRemove<0) {
							return;
						}
					Total -= chosenCoffees.get(toRemove).getPrice();
					DefaultListModel listRemoval = (DefaultListModel) list.getModel();
					listRemoval.remove(toRemove);
					chosenCoffees.remove(toRemove);
					for(int i= toRemove; i< chosenCoffees.size()-1; i++) {
						chosenCoffees.add(i, chosenCoffees.get(i+1));	
				   }
					lblTotal1.setText("Total: "+ String.format("%.2f", Total)+"$");			
			}
		}});
		
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chosenCoffees.size()!= 0) {
					String message = "";
					for(int i=0; i<chosenCoffees.size(); i++) {
						message += chosenCoffees.get(i).getName()+ ", "+ chosenCoffees.get(i).getPrice()+", "+ chosenCoffees.get(i).getSize() +"\n";
					}
					JOptionPane.showMessageDialog(null, "Your order is being processed: " +"\n"+
					message+ "Total: $"+String.format("%.2f", Total));			
				}				
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public wbMockFinal() {
		setUpComponents();
		readFile("/Users/yanavorobeva/eclipse-workspace/MockFinal/src/GUImockfinal/menu.txt");
		
		
		createEvents();		
	}
}
