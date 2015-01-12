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

    //booleans holding statuses
    private boolean bdooropen = false;
    private boolean blighton = false;
    private boolean balarmon = false;

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

        setLabelImage(alarmoff, "/images/AlarmChimneyOff.png");
        setLabelImage(alarmon, "/images/AlarmChimneyOn.png");
        setLabelImage(doorclosedlightoff, "/images/DoorClosedLightInsideOff.png");
        setLabelImage(dooropenedlightoff, "/images/DoorOpenLightInsideOff.png");
        setLabelImage(doorclosedlighton, "/images/AlarmChimneyOn.png");
        setLabelImage(dooropenedlighton, "/images/AlarmChimneyOn.png");
        setLabelImage(smallwindowlightoff, "/images/SmallWindowLightInOff.png");
        setLabelImage(smallwindowlighton, "/images/SmallWindowLightInOn.png");
        setLabelImage(windowclosed, "/images/windowOUTclosed.png");
        setLabelImage(windowopenlightoff, "/images/windowOUTopenLightInOFF.png");
        setLabelImage(windowopenlighton, "/images/windowOUTopenLightInON.png");

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
        alarmoff.setVisible(true);
        dooropenedlightoff.setVisible(true);
        smallwindowlightoff.setVisible(true);
        windowclosed.setVisible(true);
        //Actions();
    }

    public void ChangeStat(String what, boolean stat) {
        if (what.equals("bdooropen")) {
            this.bdooropen = stat;
        }
        if (what.equals("blighton")) {
            this.blighton = stat;
        }
        if (what.equals("balarmon")) {
            this.balarmon = stat;
        } else {
            System.out.println("No such boolean. Make sure to call it properly");

        }
    }

    private void setLabelImage(JLabel label, String imgPath) {
        try {
            InputStream imgStream = VHouse.class
                    .getClass().getResourceAsStream(imgPath);
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
        long timer = System.currentTimeMillis();
        while (balarmon) {
            //System.out.println("in actions loop");
            if (System.currentTimeMillis() - timer > 200) {
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
}
