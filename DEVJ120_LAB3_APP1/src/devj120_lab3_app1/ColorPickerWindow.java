
package devj120_lab3_app1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import javax.swing.*;
import javax.swing.event.ChangeEvent;

public class ColorPickerWindow extends JFrame{

    private JPanel canvasPanel;
    private JPanel sliderPanel;
    
    private JSlider sliderR;
    private JSlider sliderG;
    private JSlider sliderB;

    private Clipboard clipboard = Toolkit
                                .getDefaultToolkit()
                                .getSystemClipboard();
    
    public ColorPickerWindow() throws HeadlessException {  
        setTitle("Color Picker");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth / 3, screenHeight / 4);       
        
        setLocationRelativeTo(null);
        
        /* Both panels (canvas and slider) are placed into cells of one Grid 
        /* (1 row, 2 columns). */
        setLayout(new GridLayout(1, 2));

        canvasPanel = new JPanel();
        canvasPanel.setLayout(new BorderLayout());
        canvasPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 10));
        
        sliderPanel = new JPanel();
        sliderPanel.setLayout(new GridLayout(3, 1));
        sliderPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 10));
        sliderPanel.setBackground(Color.WHITE);

        sliderR = new JSlider(0, 255, 125);
        sliderG = new JSlider(0, 255, 125);
        sliderB = new JSlider(0, 255, 125);
            
        addSlider(sliderR, "Red:");
        addSlider(sliderG, "Green:");
        addSlider(sliderB, "Blue:");   
    
        canvasPanel.setBackground
        (new Color(sliderR.getValue(), sliderG.getValue(), sliderB.getValue()));    
         
        add(canvasPanel);
        add(sliderPanel);  
    }

    public void addSlider(JSlider slider, String description){
    slider.setValue(125);
    slider.addChangeListener(this::onSliderChanged);
    slider.setBackground(Color.WHITE);
    slider.setPaintTicks(true);
    slider.setPaintLabels(true);
    slider.setMinorTickSpacing(32);
    slider.setMajorTickSpacing(255);
    
    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(1, 2));
    panel.setBackground(Color.WHITE);
    panel.add(new JLabel(description));
    panel.add(slider);
    sliderPanel.add(panel);
    }

    private void onSliderChanged(ChangeEvent e) {
        canvasPanel.setBackground
        (new Color(sliderR.getValue(), sliderG.getValue(), sliderB.getValue()));
        String colorHexCode = "#" + Integer
                .toHexString(canvasPanel.getBackground().getRGB())
                .substring(2)
                .toUpperCase();
        canvasPanel.setToolTipText(colorHexCode);
        copyToClipboard(colorHexCode);
    }
    
    private void copyToClipboard(String text) {
    StringSelection selection = new StringSelection(text);
    clipboard.setContents(selection, selection);
    }
   
}

//    public void addSlider(JSlider slider, String description){
//    JPanel panel = new JPanel();
//    
//    GridBagLayout gbl = new GridBagLayout();
//    panel.setLayout(gbl);
//    
//    GridBagConstraints c =  new GridBagConstraints();
//    c.weightx = 0.0;
//    c.weighty = 0.0;
//    
//    GridBagConstraints c1 =  new GridBagConstraints();
//    c1.weightx = 1.0;
//    c1.weighty = 1.0;
//        
//    panel.setBackground(Color.WHITE);
//    slider.setBackground(Color.WHITE);
//    slider.setPaintTicks(true);
//    slider.setPaintLabels(true);
//    slider.setMinorTickSpacing(32);
//    slider.setMajorTickSpacing(255);
//    
//    
//    JLabel label = new JLabel(description);
//    panel.add(label);
//    gbl.setConstraints(label, c);
//    
//    panel.add(slider);
//    gbl.setConstraints(slider, c1);
//    sliderPanel.add(panel);
//   }