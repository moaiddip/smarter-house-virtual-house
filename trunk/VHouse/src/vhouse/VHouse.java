package vhouse;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Michal
 */
public class VHouse {

    //JLabels holding all changable pictures
    private JLabel alarmoff;
    private JLabel alarmon;
    private JLabel doorclosedlightoff;
    private JLabel dooropenedlightoff;
    private JLabel doorclosedlighton;
    private JLabel dooropenedlighton;
    private JLabel windowopenlighton;
    private JLabel windowopenlightoff;
    private JLabel windowclosed;
    private JLabel smallwindowlightoff;
    private JLabel smallwindowlighton;
    private JLabel tvOn;
    private JLabel tvOff;
    private JLabel coffeeOn;
    private JLabel coffeeOff;
    private JLabel darkness;

    //booleans holding statuses
    private boolean bdooropen = false;
    private boolean blighton = false;
    private boolean balarmon = false;
    private boolean bwopen = false;
    private boolean bcoffee = false;
    private boolean btv = false;
    
    long timer;

    static VHouse vh = new VHouse();

    public static void main(String[] args) {
//        System.out.println(vh.bdooropen);
//        ChangeStat("bdooropen", true);
//        System.out.println(vh.bdooropen);
        
    }

    public VHouse() {
        JFrame jf = new JFrame();
        ArrayList<JLabel> labels = new ArrayList(); //array of JLabels

        alarmoff = new JLabel();
        labels.add(alarmoff);
        alarmon = new JLabel();
        labels.add(alarmon);
        doorclosedlightoff = new JLabel();
        labels.add(doorclosedlightoff);
        dooropenedlightoff = new JLabel();
        labels.add(dooropenedlightoff);
        doorclosedlighton = new JLabel();
        labels.add(doorclosedlighton);
        dooropenedlighton = new JLabel();
        labels.add(dooropenedlighton);
        windowopenlighton = new JLabel();
        labels.add(windowopenlighton);
        windowopenlightoff = new JLabel();
        labels.add(windowopenlightoff);
        windowclosed = new JLabel();
        labels.add(windowclosed);
        smallwindowlightoff = new JLabel();
        labels.add(smallwindowlightoff);
        smallwindowlighton = new JLabel();
        labels.add(smallwindowlighton);
        tvOn = new JLabel();
        labels.add(tvOn);
        tvOff = new JLabel();
        labels.add(tvOff);
        coffeeOn = new JLabel();
        labels.add(coffeeOn);
        coffeeOff = new JLabel();
        labels.add(coffeeOff);
        darkness = new JLabel();
        labels.add(darkness);
        
        
                
        alarmoff.setBounds(183, -20, 280, 240);
        alarmon.setBounds(183, -20, 280, 240);
        doorclosedlightoff.setBounds(395, 379, 90, 148);
        dooropenedlightoff.setBounds(395, 379, 90, 170);
        doorclosedlighton.setBounds(395, 379, 90, 148);
        dooropenedlighton.setBounds(395, 379, 90, 170);
        smallwindowlightoff.setBounds(397, 325, 82, 49);
        smallwindowlighton.setBounds(397, 325, 82, 49);
        windowclosed.setBounds(210, 345, 161, 97);
        windowopenlightoff.setBounds(210, 345, 161, 97);
        windowopenlighton.setBounds(210, 345, 161, 97);
        tvOff.setBounds(700,225,150,109);
        tvOn.setBounds(700,225,150,109);
        coffeeOff.setBounds(853,193,140,135);
        coffeeOn.setBounds(853,193,140,135);
        darkness.setBounds(680,0,680,698);


        setLabelImage(alarmoff, "/images/AlarmChimneyOff.png");
        setLabelImage(alarmon, "/images/AlarmChimneyOn.png");
        setLabelImage(doorclosedlightoff, "/images/DoorClosedLightInsideOff.png");
        setLabelImage(dooropenedlightoff, "/images/DoorOpenLightInsideOff.png");
        setLabelImage(doorclosedlighton, "/images/DoorClosedLightInsideOn.png");
        setLabelImage(dooropenedlighton, "/images/DoorOpenLightInsideOn.png");
        setLabelImage(smallwindowlightoff, "/images/SmallWindowLightInOff.png");
        setLabelImage(smallwindowlighton, "/images/SmallWindowLightInOn.png");
        setLabelImage(windowclosed, "/images/windowOUTclosed.png");
        setLabelImage(windowopenlightoff, "/images/windowOUTopenLightInOFF.png");
        setLabelImage(windowopenlighton, "/images/windowOUTopenLightInON.png");
        setLabelImage(tvOff,"/images/tvoff.png");
        setLabelImage(tvOn,"/images/tvon.png");
        setLabelImage(coffeeOff,"/images/coffeeoff.png");
        setLabelImage(coffeeOn,"/images/coffeeon.png");
        setLabelImage(darkness,"/images/black.png");

        //BACKGROUND
        JLabel bg = new JLabel();
        bg.setBounds(0, 0, 1360, 700);
        labels.add(bg);
        setLabelImage(bg, "/images/bg.png"); //background

        for (JLabel lbl : labels) {
            //System.out.println(lbl + " added");
            jf.add(lbl);
            lbl.setVisible(false);
        }

        Dimension d = new Dimension(1360, 700);
        jf.setPreferredSize(d);
        jf.setMinimumSize(d);
        jf.setMaximumSize(d);
        jf.setLocationRelativeTo(null);
        jf.setUndecorated(true);
        jf.setLayout(new BorderLayout());
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.toBack();
        jf.setVisible(true);
        jf.pack();

        bg.setVisible(true);
        //alarmoff.setVisible(true);
        //dooropenedlightoff.setVisible(true);
        //smallwindowlightoff.setVisible(true);
        //windowclosed.setVisible(true);
        //Actions();
        /*
        tvOff.setVisible(false);
        tvOn.setVisible(true);
        coffeeOff.setVisible(false);
        coffeeOn.setVisible(true);
        darkness.setVisible(true);
                */
        
        ChangeStat("bwopen", true);
        ChangeStat("bdooropen", true);
        ChangeStat("balarmon", true);
        ChangeStat("blighton", false); 
        ChangeStat("bcoffee", true);
        ChangeStat("btv", true);
        checkLoop();
    }

    public void ChangeStat(String what, boolean stat) {
        if (what.equals("bdooropen")) {
            this.bdooropen = stat;
        }
        else if(what.equals("bwopen")){
            this.bwopen=stat;
        }
        else if (what.equals("blighton")) {
            this.blighton = stat;
        }
        else if (what.equals("balarmon")) {
            this.balarmon = stat;
        }
        else if (what.equals("bcoffee")) {
            this.bcoffee = stat;
        }
         else if (what.equals("btv")) {
            this.btv = stat;
        }
        else {
            System.out.println("No such boolean. Make sure to call it properly");
        }
    }

    private void setLabelImage(JLabel label, String imgPath) {
        try {
            InputStream imgStream = VHouse.class.getClass().getResourceAsStream(imgPath);
            BufferedImage loadedImg = ImageIO.read(imgStream);
            ImageIcon img = new ImageIcon(loadedImg);

            label.setIcon(img);
        } catch (IOException ex) {
            Logger.getLogger(VHouse.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void Actions() {
        ChangeStat("balarmon", true);
        long timer = System.currentTimeMillis()/1000;
        while (balarmon) {
            System.out.println("Im here.");
            //System.out.println("in actions loop");
            if (System.currentTimeMillis()/1000 - timer >= 2) {
                System.out.println("Inside the if statement.");
                if (!this.alarmon.isVisible()) {
                    this.alarmoff.setVisible(false);
                    this.alarmon.setVisible(true);
                    this.doorclosedlightoff.setVisible(false);
                    this.dooropenedlightoff.setVisible(true);
                } else {
                    this.alarmoff.setVisible(true);
                    this.alarmon.setVisible(false);
                    this.doorclosedlightoff.setVisible(true);
                    this.dooropenedlightoff.setVisible(false);
                }
                timer = System.currentTimeMillis();
            }
        }
        if (!balarmon) {
            this.alarmon.setVisible(false);
            this.alarmoff.setVisible(true);
        }
    }

    public void checkLoop() {
        this.timer = System.currentTimeMillis();
        while (true) {
            if (this.balarmon) {
                if (System.currentTimeMillis() - this.timer > 200) {
                    if (!this.alarmon.isVisible()) {
                        this.alarmoff.setVisible(false);
                        this.alarmon.setVisible(true);
                    } else if(this.alarmon.isVisible()){
                        this.alarmoff.setVisible(true);
                        this.alarmon.setVisible(false);
                    }
                    this.timer = System.currentTimeMillis();
                }
            }
            else if (!this.balarmon) {
                this.alarmon.setVisible(false);
                this.alarmoff.setVisible(true);
            }

            if (this.blighton) {
                this.smallwindowlighton.setVisible(true);
                this.smallwindowlightoff.setVisible(false);
                this.darkness.setVisible(false);
                
                if(bcoffee){
                    this.coffeeOn.setVisible(true);
                    this.coffeeOff.setVisible(false);
                }
                else if(!bcoffee){
                    this.coffeeOn.setVisible(false);
                    this.coffeeOff.setVisible(true);
                }
                if(btv){
                    this.tvOn.setVisible(true);
                    this.tvOff.setVisible(false);
                }
                else if(!btv){
                    this.tvOn.setVisible(false);
                    this.tvOff.setVisible(true);
                }
                if (bdooropen) {
                    this.doorclosedlightoff.setVisible(false);
                    this.doorclosedlighton.setVisible(false);
                    this.dooropenedlightoff.setVisible(false);
                    this.dooropenedlighton.setVisible(true);
                }
                else if (!this.bdooropen) {
                    this.doorclosedlightoff.setVisible(false);
                    this.doorclosedlighton.setVisible(true);
                    this.dooropenedlightoff.setVisible(false);
                    this.dooropenedlighton.setVisible(false);
                }
                if (bwopen) {
                    this.windowclosed.setVisible(false);
                    this.windowopenlightoff.setVisible(false);
                    this.windowopenlighton.setVisible(true);
                }
                else if (!this.bwopen) {
                    this.windowclosed.setVisible(true);
                    this.windowopenlightoff.setVisible(false);
                    this.windowopenlighton.setVisible(false);
                }
            }
            else if (!this.blighton) {
                this.smallwindowlighton.setVisible(false);
                this.smallwindowlightoff.setVisible(true);
                this.darkness.setVisible(true);
                if (this.bdooropen) {
                    this.doorclosedlightoff.setVisible(false);
                    this.doorclosedlighton.setVisible(false);
                    this.dooropenedlightoff.setVisible(true);
                    this.dooropenedlighton.setVisible(false);
                }
                else if (!this.bdooropen) {
                    this.doorclosedlightoff.setVisible(true);
                    this.doorclosedlighton.setVisible(false);
                    this.dooropenedlightoff.setVisible(false);
                    this.dooropenedlighton.setVisible(false);
                }
                if (this.bwopen) {
                    this.windowclosed.setVisible(false);
                    this.windowopenlightoff.setVisible(true);
                    this.windowopenlighton.setVisible(false);
                }
                else if (!this.bwopen) {
                    this.windowclosed.setVisible(true);
                    this.windowopenlightoff.setVisible(false);
                    this.windowopenlighton.setVisible(false);
                }
            }
        }
    }
}
