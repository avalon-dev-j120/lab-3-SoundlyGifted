
package devj120_lab3_app1;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;


public class DEVJ120_LAB3_APP1 {
  
    static JButton colorPickerButton;
    static JButton calculatorButton;
    
    private static ActionListener onColorPickerButtonClick 
            = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            ColorPickerWindow colorPickerWindow = new ColorPickerWindow();
            colorPickerWindow.setVisible(true);            
        }      
    };   
    
     private static ActionListener onCalculatorButtonClick 
            = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            Calculator calculator = new Calculator();
            calculator.setVisible(true);
        }      
    };    
    
    public static void main(String[] args) {
        
        JFrame choose = new JFrame();
        choose.setResizable(false);
        choose.setSize(100, 100);
        choose.setTitle("Choose Application");
        choose.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        Dimension screenSizeActual 
                = Toolkit.getDefaultToolkit().getScreenSize();   
        choose.setSize(screenSizeActual.width/6, screenSizeActual.height/14);
        choose.setLocationRelativeTo(null);
        choose.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        colorPickerButton = new JButton("Color Picker");
        colorPickerButton.setFont(new Font("SansSerif", Font.BOLD, 
                screenSizeActual.height/72));        
        colorPickerButton.addActionListener(onColorPickerButtonClick);
       
        calculatorButton = new JButton("Calculator");
        calculatorButton.setFont(new Font("SansSerif", Font.BOLD, 
                screenSizeActual.height/72));
        calculatorButton.addActionListener(onCalculatorButtonClick);
        
        choose.add(colorPickerButton);
        choose.add(calculatorButton);
        choose.setVisible(true); 
    }
}     