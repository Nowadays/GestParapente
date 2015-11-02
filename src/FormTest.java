import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by deodexed on 02/11/2015.
 * Project name GestParapente
 */
public class FormTest extends JFrame{
	private JTextField textField1;
	private JTable nomTable;
	private JButton ajouterButton;
	private JPanel rootPane;
	private JPanel leftPanel;

	public FormTest() {
		super("heelo world");
		textField1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				super.keyTyped(e);
			}
		});

		this.setContentPane(rootPane);
		pack();
		this.setMinimumSize(new Dimension(800,800));
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		createUIComponents();
		this.setVisible(true);

	}

	private void createUIComponents() {
		// TODO: place custom component creation code here
		ajouterButton.setBackground(new Color(0x143141));
        ajouterButton.setForeground(new Color(0xBBBBBB));
	}

	public static void main(String[] args){
		new FormTest();
	}
}
