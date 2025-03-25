package gui;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ExitWindow extends JInternalFrame{
    public ExitWindow() {
    	super("Выход", true, true, true, true);
    	JFrame frame = new JFrame();
    	Object[] options={"Да","Нет"};
    	
    	final JOptionPane optionPane = new JOptionPane(
    			"Вы действительно хотите выйти ?",
                JOptionPane.QUESTION_MESSAGE,
                JOptionPane.YES_NO_OPTION,
                null,options);

		final JDialog dialog = new JDialog(frame,true);
		dialog.setContentPane(optionPane);
		optionPane.addPropertyChangeListener(
		    new PropertyChangeListener() {
		        public void propertyChange(PropertyChangeEvent e) {
		            String prop = e.getPropertyName();
		
		            if (dialog.isVisible() 
		             && (e.getSource() == optionPane)
		             && (prop.equals(JOptionPane.VALUE_PROPERTY))) {
		                //If you were going to check something
		                //before closing the window, you'd do
		                //it here.
		                dialog.setVisible(false);
		            }
		        }
		    });
		dialog.pack();
		dialog.setVisible(true);
		
		Object value = optionPane.getValue();
		if (value == "Да") {
		    System.exit(0);
		}
    }
}
