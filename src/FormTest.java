import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by deodexed on 02/11/2015.
 * Project name GestParapente
 */
public class FormTest {
	private JTextField textField1;
	private JTable nomTable;
	private JButton button1;

	public FormTest() {
		textField1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				super.keyTyped(e);
			}
		});
	}

	private void createUIComponents() {
		// TODO: place custom component creation code here
	}

	public static void main(String[] args){
		new FormTest();
	}
}
