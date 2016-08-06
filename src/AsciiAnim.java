//AsciiAnim.java

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AsciiAnim extends JFrame implements ActionListener{

    AsciiCanvas cnvAnim = new AsciiCanvas();
    static JButton btnPrev = new JButton("prev");
    static JButton btnNext = new JButton("next");
    static JButton btnSave = new JButton("save");
    static JButton btnLoad = new JButton("load");
    static JButton btnAnim = new JButton("animate");

    JPanel pnlSouth = new JPanel();
    Timer timer = new Timer(1, this);

    boolean animating = false;

    public AsciiAnim(){

        this.setUpGUI();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(640, 480);
    } // end constructor

    public void setUpGUI(){
        //like it says, set up GUI
        Container pnlMain = this.getContentPane();

        pnlSouth.setLayout(new FlowLayout());
        pnlMain.add(cnvAnim, BorderLayout.CENTER);
        pnlMain.add(pnlSouth, BorderLayout.SOUTH);

        // I HAVE ADDED THIS ONE
//        init();
        this.pack();
        AsciiCanvas.startFrame = 0;
        AsciiCanvas.mainContent = new JTextArea();
        this.add(AsciiCanvas.mainContent, BorderLayout.CENTER);
//        this.getContentPane().setLayout(new BorderLayout());
        this.add(AsciiCanvas.mainContent, BorderLayout.CENTER);
        // END OF WHAT I HAVE ADDED

        pnlSouth.add(btnPrev);
        pnlSouth.add(btnNext);
        pnlSouth.add(btnAnim);
        pnlSouth.add(btnSave);
        pnlSouth.add(btnLoad);

        //add action listeners
        btnPrev.addActionListener(this);
        btnNext.addActionListener(this);
        btnAnim.addActionListener(this);
        btnSave.addActionListener(this);
        btnLoad.addActionListener(this);

    } // end setUpGUI

    public void actionPerformed(ActionEvent e){
        if (e.getSource() == btnPrev){
            cnvAnim.prevFrame();
        } else if (e.getSource() == btnNext){
            cnvAnim.nextFrame();
        } else if (e.getSource() == btnAnim){
            //change the animation status
            if (timer.isRunning()){
                btnAnim.setText("animate");
                timer.stop();
                this.animating = false;
            } else {
                btnAnim.setText("stop");
                timer.start();
                this.animating = true;
            } // end if
        } else if (e.getSource() == btnSave){
            cnvAnim.save();
        } else if (e.getSource() == btnLoad){
            cnvAnim.load();
        } else if (this.animating == true){
            cnvAnim.anim();
        } else {
            System.out.println("action not defined");
        } // end if
    } // end actionPerformed

    public static void main(String[] args){
        new AsciiAnim();
    } // end main


} // end class def
