package com.EventBrite;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Panel;

public class LoginPageTest extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JTextField password;
	EventPageTest eventPage = new EventPageTest();
	static LoginPageTest loginPage = new LoginPageTest();
	static ArrayList<UserDatabaseTest> theUsers = new ArrayList<UserDatabaseTest>();

	// Launch the application.

	public static void main(String[] args) {
		InitTestData();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void InitTestData() {
		try {
			File file = new File("Fake Users.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			int x = 0;
			int userPassMail = 0;
			boolean isUsername = true;

			while ((line = bufferedReader.readLine()) != null) {
				if (userPassMail == 0) {
					theUsers.add(new UserDatabaseTest());
					theUsers.get(x).setUsername(line);
					userPassMail = 1;
					continue;
				}
				if (userPassMail == 1) {
					theUsers.get(x).setPassword(line);
					userPassMail = 2;
					continue;
				}
				if (userPassMail == 2) {
					theUsers.get(x).setEmail(line);
					userPassMail = 0;
				}

				x++;
			}
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Create the frame.

	public LoginPageTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		username = new JTextField();
		username.setBounds(172, 81, 116, 22);
		contentPane.add(username);
		username.setColumns(10);

		password = new JPasswordField();
		password.setColumns(10);
		password.setBounds(172, 116, 116, 22);
		contentPane.add(password);

		JLabel label = new JLabel("Username");
		label.setBounds(80, 84, 90, 16);
		contentPane.add(label);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(80, 119, 68, 16);
		contentPane.add(lblPassword);

		JLabel lblEventbrite = new JLabel("EventBrite");
		lblEventbrite.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblEventbrite.setBounds(172, 13, 102, 42);
		contentPane.add(lblEventbrite);
		
		final JLabel label_1 = new JLabel("");
		label_1.setBounds(133, 218, 198, 22);
		contentPane.add(label_1);

		JButton btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// System.out.println("There are " + theUsers.size() + " users");
				for (int i = 0; i < theUsers.size(); i++) {
					// System.out.println("passing " + username.getText());
					if (theUsers.get(i).loggingIn(username.getText(), password.getText())) {
						System.out.println("Successfully logged in with " + theUsers.get(i).username);
						loginPage.dispose();
						eventPage.setVisible(true);
						break;
					} else if (i == theUsers.size()-1) {
						/*JOptionPane.showMessageDialog(null, "Incorrect Username or Password", "Failed to log in",
								JOptionPane.INFORMATION_MESSAGE);
								*/
						label_1.setText(String.valueOf("Incorrect username or password"));
						break;
					}
				}
			}
		});
		btnLogIn.setBounds(90, 151, 97, 25);
		contentPane.add(btnLogIn);
		
		JButton btnCreateAccount = new JButton("Create an Account");
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCreateAccount.setBounds(199, 151, 148, 25);
		contentPane.add(btnCreateAccount);

	}
}
