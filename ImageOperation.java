package image;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JTextField;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.JFileChooser;


public class ImageOperation {
	public static void operate(int key) {
		//window opener
		JFileChooser filechooser = new JFileChooser();
		filechooser.showOpenDialog(null);
		File file = filechooser.getSelectedFile();
		
		//file FileInputStream
		
		try
		{
			FileInputStream fis = new FileInputStream(file);
			byte []data = new byte[fis.available()];
			fis.read(data);
			int i=0;
			for(byte b:data)
			{
				System.out.println(b);
				data[i] =(byte)(b^key);
				i++;
			}
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(data);
			fos.close();
			fis.close();
			JOptionPane.showMessageDialog(null, "Done");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	 	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("test");
		JFrame f = new JFrame();
		f.setTitle("img decryption and encryption");
		f.setSize(400,400);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		Font font = new Font("Roboto",Font.BOLD,25);
		//creating button
		JButton button = new JButton();
		button.setText("Open Image");
		button.setFont(font);
		
		
		
		
		//creating text field
		JTextField textfield = new JTextField(10);
		f.setLayout(new FlowLayout());
		f.add(button);
		f.add(textfield);
		
		
		//function
		
		button.addActionListener(e->{
					//lambda function
					System.out.println("button clicked!!");
					String text = textfield.getText();
					int temp = Integer.parseInt(text);
					operate(temp);
				});
		
		f.setVisible(true);
		

	}

}
