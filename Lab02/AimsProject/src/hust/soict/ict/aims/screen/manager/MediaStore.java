package hust.soict.ict.aims.screen.manager;

import javax.swing.BoxLayout;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import hust.soict.ict.aims.media.Media;
import hust.soict.ict.aims.media.Playable;
import hust.soict.ict.aims.store.Store;

public class MediaStore extends JPanel {
	    private Media media;
	    public MediaStore(Media media) {
		this.media = media;
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		 
		JLabel title = new JLabel(media.getTitle());
	    title.setFont(new Font(title.getFont().getName(),Font.PLAIN,15));
	    //Căn giữa
	    title.setAlignmentX(CENTER_ALIGNMENT);

	    //Chuyen media.getCost() thanh chuoi
	    JLabel cost = new JLabel(""+ media.getCost()+" $");
	    cost.setAlignmentX(CENTER_ALIGNMENT);


	    JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));
        btnPlayMedia btnListener = new btnPlayMedia();
        
        if(media instanceof Playable){
            JButton playButton = new JButton("Play media");
            container.add(playButton);
            playButton.addActionListener(btnListener);
        }
        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
	    private class btnPlayMedia implements ActionListener{
	        @Override 
	        public void actionPerformed(ActionEvent e){
	            DisplayMedia temp = new DisplayMedia(media);
	        }
	    }
	}


