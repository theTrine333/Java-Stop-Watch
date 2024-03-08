package com.tesla;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EtchedBorder;

import com.formdev.flatlaf.FlatIntelliJLaf;

@SuppressWarnings("all")
public class main extends JFrame {
	private final ButtonGroup buttonGroup = new ButtonGroup();
	static JLabel secLabel;
	static JLabel minLabel;
	static JLabel hrLabel;
	static JButton tglbtnStart;
	static Timer myTimer = new Timer(1000, new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			decreaseSeconds();
			
		}
	});
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		main frame = new main();
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public main() {
		setResizable(false);
		FlatIntelliJLaf.setup();
		setTitle("Stop Watch");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450, 323);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 11, 414, 52);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton hrUp = new JButton("Up");
		hrUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				increaseHours();
			}
		});
		buttonGroup.add(hrUp);
		hrUp.setFocusable(false);
		hrUp.setBounds(10, 11, 121, 30);
		panel.add(hrUp);
		
		JButton minUp = new JButton("Up");
		minUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				increaseMinutes();
			}
		});
		buttonGroup.add(minUp);
		minUp.setFocusable(false);
		minUp.setBounds(141, 11, 132, 30);
		panel.add(minUp);
		
		JButton secUp = new JButton("Up");
		secUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int tempValue = Integer.valueOf(secLabel.getText());
				increaseSeconds();
			}
			
		});
		buttonGroup.add(secUp);
		secUp.setFocusable(false);
		secUp.setBounds(283, 11, 121, 30);
		panel.add(secUp);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(10, 74, 414, 92);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		hrLabel = new JLabel("00");
		hrLabel.setFont(new Font("Bauhaus 93", Font.PLAIN, 32));
		hrLabel.setHorizontalAlignment(SwingConstants.CENTER);
		hrLabel.setBounds(10, 11, 119, 70);
		panel_1.add(hrLabel);
		
		minLabel = new JLabel("00");
		minLabel.setFont(new Font("Bauhaus 93", Font.PLAIN, 32));
		minLabel.setHorizontalAlignment(SwingConstants.CENTER);
		minLabel.setBounds(139, 11, 131, 70);
		panel_1.add(minLabel);
		
		secLabel = new JLabel("00");
		secLabel.setFont(new Font("Bauhaus 93", Font.PLAIN, 32));
		secLabel.setHorizontalAlignment(SwingConstants.CENTER);
		secLabel.setBounds(285, 11, 119, 70);
		panel_1.add(secLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel_2.setLayout(null);
		panel_2.setBounds(10, 173, 414, 52);
		getContentPane().add(panel_2);
		
		JButton hrDown = new JButton("Down");
		hrDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				decreaseHours();
			}
		});
		buttonGroup.add(hrDown);
		hrDown.setFocusable(false);
		hrDown.setBounds(10, 11, 121, 30);
		panel_2.add(hrDown);
		
		JButton minDown = new JButton("Down");
		minDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				decreaseMinutes();
			}
		});
		buttonGroup.add(minDown);
		minDown.setFocusable(false);
		minDown.setBounds(141, 11, 132, 30);
		panel_2.add(minDown);
		
		JButton secDown = new JButton("Down");
		secDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				decreaseSeconds();
			}
		});
		buttonGroup.add(secDown);
		secDown.setFocusable(false);
		secDown.setBounds(283, 11, 121, 30);
		panel_2.add(secDown);
		
		tglbtnStart = new JButton("Start");
		tglbtnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tglbtnStart.getText().equals("Start")) { 
					myTimer.start();
					tglbtnStart.setText("Stop");
				}else {
					myTimer.stop();
					tglbtnStart.setText("Start");
				}
			}
		});
		tglbtnStart.setFocusable(false);
		tglbtnStart.setBounds(10, 236, 414, 42);
		getContentPane().add(tglbtnStart);
		setVisible(true);
	}
	
	private void increaseSeconds() {
		// TODO Auto-generated method stub
		int seconds = Integer.valueOf(secLabel.getText());
		int minutes = Integer.valueOf(minLabel.getText());
		int hours = Integer.valueOf(hrLabel.getText());
		
		if (seconds<59) {
			secLabel.setText(String.valueOf(seconds+1));
		}else if(seconds == 59 && minutes<59) {
			increaseMinutes();
			secLabel.setText(String.valueOf(00));
		}else if(minutes == 59 && hours<24) {
			hrLabel.setText(String.valueOf(hours+1));
			minLabel.setText(String.valueOf(00));
			secLabel.setText(String.valueOf(00));
		}
	}

	private static void decreaseSeconds() {
		// TODO Auto-generated method stub
		int seconds = Integer.valueOf(secLabel.getText());
		int minutes = Integer.valueOf(minLabel.getText());
		int hours = Integer.valueOf(hrLabel.getText());
		
		if (seconds>00 && minutes == 00) {
			secLabel.setText(String.valueOf(seconds-1));
			minLabel.setText("00");
		}else if (seconds>00) {
			secLabel.setText(String.valueOf(seconds-1));
		}else if(seconds == 00 && minutes>00) {
			decreaseMinutes();
			secLabel.setText(String.valueOf(59));
		}else if(minutes == 00 && hours>00) {
			decreaseMinutes();
			secLabel.setText(String.valueOf(59));
		}else if(seconds == 00) {
			tglbtnStart.setText("Start");
			secLabel.setText("00");
			myTimer.stop();
		}
	}
	
	private static void decreaseMinutes() {
		// TODO Auto-generated method stub
		int minutes = Integer.valueOf(minLabel.getText());
		int hours = Integer.valueOf(hrLabel.getText());
		
		if(minutes==00 && hours==00) {
			minLabel.setText("00");
		}else if (minutes>00) {
			minLabel.setText(String.valueOf(minutes-1));
		}else if(minutes == 00 && hours>00) {
			decreaseHours();
			minLabel.setText(String.valueOf(59));
		} 
	}
	
	private void increaseMinutes() {
		// TODO Auto-generated method stub
		int minutes = Integer.valueOf(minLabel.getText());
		int hours = Integer.valueOf(hrLabel.getText());
		
		if (minutes<59) {
			minLabel.setText(String.valueOf(minutes+1));
		}else if(minutes == 59 && hours<24) {
			hrLabel.setText(String.valueOf(hours+1));
			minLabel.setText(String.valueOf(00));
		}
	}
	
	private void increaseHours() {
		// TODO Auto-generated method stub
		int hours = Integer.valueOf(hrLabel.getText());
		
		if (hours<24) {
			hrLabel.setText(String.valueOf(hours+1));
		}else if(hours==24) {
			hrLabel.setText(String.valueOf(00));
		}
	}
	
	private static void decreaseHours() {
		// TODO Auto-generated method stub
		int hours = Integer.valueOf(hrLabel.getText());
		
		if (hours>00) {
			hrLabel.setText(String.valueOf(hours-1));
		}else if(hours==24) {
			hrLabel.setText(String.valueOf(00));
		}
	}
	
}
