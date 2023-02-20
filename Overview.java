package app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Overview implements ActionListener, ChangeListener {

    //create frame
    JFrame myF = new JFrame();
    //create panel for menu
    JPanel menuP;
    JPanel editP;
    //create menu bar
    JMenuBar menuBar;
    //create file and edit menus
    JMenu fileMenu = new JMenu("File");
    JMenu editMenu = new JMenu("Edit");
    //items for file menu
    JMenuItem newItem = new JMenuItem("New");
    JMenuItem openItem = new JMenuItem("Open");
    JMenuItem saveItem = new JMenuItem("Save");
    JMenuItem saveAllItem = new JMenuItem("Save all");

    //items for edit menu
    JMenuItem undoItem = new JMenuItem("Undo");
    JMenuItem redoItem = new JMenuItem("Redo");

    JMenuItem cutItem = new JMenuItem("");
    JMenuItem copyItem = new JMenuItem("");
    JMenuItem pasteItem = new JMenuItem("");

    JMenuItem find = new JMenuItem("");

    //create toolbar
    JToolBar actionToolBar;
    JToolBar formattingToolBar;
    //create buttons for toolbar
    JButton newBtn;
    JButton openBtn;
    JButton saveBtn;
    /*JButton saveAllBtn;
    JButton findBtn = new JButton("Search");
    JTextField findField = new JTextField();
    */
    
    JButton fontColorBtn;
    JLabel fontSizeLabel;
    SpinnerModel spinnerLimit;
    JSpinner fontSizeSpinner;
    JComboBox fontBox;
    
    ImageIcon newIcon;
    ImageIcon openIcon;
    ImageIcon saveIcon;
    
    ImageIcon saveAllIcon = new ImageIcon("images/save all.png");
    ImageIcon findIcon = new ImageIcon("images/find.png");

    JTextArea textArea;
    JScrollBar scroll;

    JButton boldFontBtn;
    JButton italicFontBtn;
    JButton plainFontBtn;
    
    Dimension styleBtnSize;

    //create empty borders to apply to buttons in the toolbar
    Border emptyBorder = BorderFactory.createEmptyBorder();

    Overview() {

        myF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myF.setSize(700, 400);
        myF.setResizable(false);
        myF.setOpacity(1);
        
        //instantiate nested panels
        menuP = new JPanel();
        editP = new JPanel();
        //instantiate menu bar and text area
        textArea = new JTextArea();
        menuBar = new JMenuBar();
        
        //instantiate toolbars and scroll bar
        actionToolBar = new JToolBar();
        formattingToolBar = new JToolBar();
        scroll = new JScrollBar();
        menuP.setVisible(true);
        editP.add(textArea);
        
        myF.setJMenuBar(menuBar);

        menuBar.add(fileMenu);

        menuBar.add(editMenu);

        actionToolBar.setBorder(emptyBorder);
        formattingToolBar.setBorder(emptyBorder);
            
        boldFontBtn = new JButton("B");
        italicFontBtn = new JButton("I");
        plainFontBtn = new JButton("P");
   
        
        newBtn = new JButton("new");
        openBtn = new JButton("open");
        saveBtn = new JButton("save");
        //saveAllBtn = new JButton("save all");
        spinnerLimit = new SpinnerNumberModel(0, 0, 90, 1);
        fontSizeSpinner = new JSpinner(spinnerLimit);
        fontSizeLabel = new JLabel("Font size: ");
        
        fontColorBtn = new JButton("Font colour");
        newIcon = new ImageIcon("images/new file.png");
        openIcon = new ImageIcon("images/open.png");
        saveIcon = new ImageIcon("images/save.png");
        
        newBtn.setBorder(emptyBorder);
        openBtn.setBorder(emptyBorder);
        saveBtn.setBorder(emptyBorder);
        /*saveAllBtn.setBorder(emptyBorder);
        findField.setBorder(emptyBorder);
        findBtn.setBorder(emptyBorder);
        */
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(saveAllItem);
        editMenu.add(undoItem);
        editMenu.add(redoItem);

        Dimension d = new Dimension(250, 50);
        actionToolBar.setPreferredSize(d);
        formattingToolBar.setPreferredSize(new Dimension(500,25));
        //textArea.setSize(new Dimension(800, 400));
        textArea.setRows(20);

        //textArea.add(scrollPane);
        
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setAutoscrolls(true);
        //remove focus for buttons
        newBtn.setFocusable(false);
        openBtn.setFocusable(false);
        saveBtn.setFocusable(false);
        
        fontSizeLabel.setFocusable(false);
        //fontSizeSpinner.setFocusable(false);
        //fontBox.setFocusable(false);
        //fontColorBtn.setFocusable(false);
        
        boldFontBtn.setFocusable(false);
        italicFontBtn.setFocusable(false);
        plainFontBtn.setFocusable(false);
        
        
        fontSizeLabel.setBorder(emptyBorder);
        
        /*saveAllBtn.setFocusable(false);
        findField.setBorder(emptyBorder);

        Font findFieldF = new Font("Verdana", 0, 9);
        Font findBtnF = new Font("Tahoma", 0, 30);
        Font areaTextF = new Font("Calibri", 0, 24);
        findField.setFont(findFieldF);
        findBtn.setFont(findBtnF);
        */
        
        boldFontBtn.setFont(new Font("tahoma", 1, 24));
        italicFontBtn.setFont(new Font("tahoma", 2, 24));
        plainFontBtn.setFont(new Font("tahoma", 0, 24));
        setFontSpinnerSize();
        fontSpinnerDefaultFontSize();
        
        fontSizeSpinner.setBorder(emptyBorder);
        
        
        
        JScrollPane scrollPane = new JScrollPane(textArea);
        //textArea.setAutoscrolls(true);

        
        scrollPane.setPreferredSize(new Dimension(1200, 450));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        //scrollPane.setAutoscrolls(true);
        editP.add(scrollPane);

        //set icons for buttons
        newBtn.setIcon(newIcon);
        openBtn.setIcon(openIcon);
        saveBtn.setIcon(saveIcon);
        //saveAllBtn.setIcon(saveAllIcon);

        //add buttons to toolbars
        actionToolBar.add(newBtn);
        actionToolBar.add(openBtn);
        actionToolBar.add(saveBtn);
        /*actionToolBar.add(saveAllBtn);
        actionToolBar.add(findField);

        actionToolBar.add(findBtn);
        */
        
        createFontBox();
        
        initFontSize();
        initFontFamily();
        
        fontBox.setBorder(emptyBorder);
        fontBox.setFocusable(false);
        formattingToolBar.add(fontSizeLabel);
        formattingToolBar.add(fontSizeSpinner);
        formattingToolBar.add(fontBox);
        formattingToolBar.add(fontColorBtn);
        

        
        styleBtnSize = new Dimension(50, 25);
        boldFontBtn.setPreferredSize(styleBtnSize);
        italicFontBtn.setPreferredSize(styleBtnSize);
        plainFontBtn.setPreferredSize(styleBtnSize);
        

        boldFontBtn.setBorder(emptyBorder);
        italicFontBtn.setBorder(emptyBorder);
        plainFontBtn.setBorder(emptyBorder);
        //formattingToolBar.add(fontBox);
       fontColorBtn.setFocusable(false);
        

        saveBtn.addActionListener(this);
        openBtn.addActionListener(this);
        newBtn.addActionListener(this);

        boldFontBtn.addActionListener(this);
        italicFontBtn.addActionListener(this);
        plainFontBtn.addActionListener(this);
                

        
        
        
        formattingToolBar.add(boldFontBtn);
        formattingToolBar.add(italicFontBtn);
        formattingToolBar.add(plainFontBtn);
        
        fontBox.addActionListener(this);
        

        saveItem.addActionListener(this);
        openItem.addActionListener(this);
        newItem.addActionListener(this);

        fontSizeSpinner.addChangeListener(this);
        fontColorBtn.addActionListener(this);
        
        
        menuP.add(actionToolBar);
        menuP.add(formattingToolBar);

        myF.add(menuP, BorderLayout.WEST);
        myF.add(editP, BorderLayout.SOUTH);
        
        myF.pack();
        myF.setVisible(true);

    }
    
    public void setFontSpinnerSize(){
        fontSizeSpinner.setPreferredSize(new Dimension(30, 30));
    }
    
    public void fontSpinnerDefaultFontSize(){
        fontSizeSpinner.setValue(24);
        
    }
    
    public void createFontBox(){
        
        //send available fonts to string array and add these to fontbox combobox
        String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        fontBox = new JComboBox(fonts);
        fontBox.setPreferredSize(new Dimension(60, 25));
        
/*        add to toolbar and add an action listener
*        This has been changed so it is now done inside the constructor.   
*        formattingToolBar.add(fontBox);
*        fontBox.addActionListener(this);
*/       
        /*set initial font*/
        fontBox.setSelectedItem("Verdana");

        
    }
    
    public void initFontSize(){
    textArea.setFont(new Font((String)fontBox.getSelectedItem(), Font.PLAIN, textArea.getFont().getSize()));    
    
}
    public void initFontFamily(){
    textArea.setFont(new Font(textArea.getFont().getFamily(), Font.PLAIN,(int) fontSizeSpinner.getValue())); 
    
}

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource().equals(newBtn) || ae.getSource().equals(newItem)) {

            textArea.setText("");

        }

        if (ae.getSource().equals(openBtn) || ae.getSource().equals(openItem)) {

            Scanner fileIn;
            int response;

            JFileChooser fileChooser = new JFileChooser();
            response = fileChooser.showOpenDialog(null);

            if (response == JFileChooser.APPROVE_OPTION);
            {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());

                try {
                    fileIn = new Scanner(file);
                    if (file.isFile()) {
                        while (fileIn.hasNextLine()) {
                            String line = fileIn.nextLine();
                            System.out.println(line);
                            textArea.setText(line);
                        }
                    } else {
                        System.out.println("invalid file selection");
                    }

                    fileIn.close();

                } catch (IOException ex) {
                    System.out.println(ex);
                }

            }

        }

        if (ae.getSource().equals(saveBtn) || ae.getSource().equals(saveItem)) {

            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);

            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                String s = textArea.getText();

                try {
                    FileWriter myWriter = new FileWriter(file);

                    myWriter.write(s);
                    myWriter.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }

        }

        if (ae.getSource().equals(boldFontBtn)) {
            textArea.setFont(new Font((String)fontBox.getSelectedItem(), Font.BOLD, textArea.getFont().getSize()));
            
        }

        if (ae.getSource().equals(italicFontBtn)) {

            textArea.setFont(new Font((String)fontBox.getSelectedItem(), Font.ITALIC, textArea.getFont().getSize()));
           
        }
        
        if (ae.getSource().equals(plainFontBtn)) {
             textArea.setFont(new Font((String)fontBox.getSelectedItem(), Font.PLAIN, textArea.getFont().getSize()));
        }
        

        if(ae.getSource().equals(fontColorBtn)){
            JColorChooser colorChooser = new JColorChooser();
            
            Color color = colorChooser.showDialog(null, "", Color.BLACK);
            textArea.setForeground(color);
        }
        
        if(ae.getSource().equals(fontBox)){
            //textArea.setFont(new Font((String)fontBox.getSelectedItem(), Font.PLAIN, textArea.getFont().getSize()));
            initFontSize();
        }
        
    }
    
    public void stateChanged(ChangeEvent ce){
        //textArea.setFont(new Font(textArea.getFont().getFamily(), Font.PLAIN,(int) fontSizeSpinner.getValue()));
        initFontFamily();
    }
}

