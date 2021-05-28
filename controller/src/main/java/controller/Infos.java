package controller;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;

public class Infos extends JFrame {

	private JPanel contentPane;
	private JTextField textNom;
	private JTextField textPrénom;
	private JTextField textÂge;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Infos frame = new Infos();
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
	public Infos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setBounds(79, 77, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Pénom");
		lblNewLabel_1.setBounds(79, 107, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Âge ");
		lblNewLabel_2.setBounds(79, 137, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		textNom = new JTextField();
		textNom.setBounds(135, 77, 200, 20);
		contentPane.add(textNom);
		textNom.setColumns(10);
		
		textPrénom = new JTextField();
		textPrénom.setBounds(135, 107, 200, 20);
		contentPane.add(textPrénom);
		textPrénom.setColumns(10);
		
		textÂge = new JTextField();
		textÂge.setBounds(135, 134, 200, 20);
		contentPane.add(textÂge);
		textÂge.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("INFO GAMER");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(159, 11, 126, 24);
		contentPane.add(lblNewLabel_3);
		
		JButton btnBegin = new JButton("Begin");
		btnBegin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection cnx = cnx();
				try {
					String reqaj = "insert into INFOS GAMER values(?,?,?)";
					java.sql.PreparedStatement aj = cnx.prepareStatement(reqaj);
					
				}catch (Exception e1) {
					
				} 
			}
		});
		btnBegin.setBounds(180, 227, 89, 23);
		contentPane.add(btnBegin);
	}
	
	static Connection cnx(){
		  try {
		   String driver="com.mysql.jdbc.Driver";
		   Class.forName(driver);
		   return (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/pojet_uml-java", "root","");

		   
		  } catch (Exception e) {
		    System.out.println("pas de connexion "+ e);  }
		  return null;

		 }
		 private void Ajouter(){
		  Connection cnx=cnx();
		  try {
		   String req="insert into salarie values(?,?,?,?)";
		   PreparedStatement aj = (PreparedStatement) cnx.prepareStatement(req);
		   aj.setString(1, textNom.getText());
		   aj.setString(2, textPrénom.getText());
		   aj.setString(3, textÂge.getText());
		   aj.execute();
		   JOptionPane.showMessageDialog(null, "salarié bien ajouté!!!");
		  } catch (Exception e) {
		   System.out.println("erreur"+e);  
		}
	}
		 
}
