package org.booob.cardMaker.gui;

import static java.awt.Font.PLAIN;
import static org.booob.cardMaker.utils.Statics.X_SCALE;
import static org.booob.cardMaker.utils.Statics.Y_SCALE;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.util.HashSet;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.booob.cardMaker.CardMaker;
import org.booob.cardMaker.dataLoader.GraphicsIO;
import org.booob.cardMaker.utils.Statics;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = -1466440285193237853L;

	private JLabel imageLabel;

	private JButton startProcessingImg;
	private JButton addDefaultText;

	private static BufferedImage renderedImage;

	private static String imagePath;
	private static String csvPath;

	private static final String DEFAULT_TEXT = "Default text to add";

	private Set<JLabel> labels;

	private int mouseOnDragStartOnX;
	private int mouseOnDragStartOnY;

	public MainWindow(String imagePath, String csvPath) {

		setSize(1300, 600);
		setVisible(true);
		setLayout(new FlowLayout());

		labels = new HashSet();

		createComponents(imagePath);

		add(imageLabel);
		add(startProcessingImg);
		add(addDefaultText);

		setEvents();
	}

	private void createComponents(String imagePath) {
		renderedImage = GraphicsIO.loadImage(imagePath);

		Image scaledImage = displayScaledImage(renderedImage);

		ImageIcon image = new ImageIcon(scaledImage);

		imageLabel = new JLabel(image);
		imageLabel.setLayout(new FlowLayout());

		startProcessingImg = new JButton("Drukuj karty");
		addDefaultText = new JButton("Dodaj tekst");
	}

	private Image displayScaledImage(BufferedImage renderedImage) {

		Image scaledImage = renderedImage.getScaledInstance(renderedImage.getWidth() - X_SCALE,
				renderedImage.getHeight() - Y_SCALE, 1);

		return scaledImage;
	}

	private void setEvents() {
		startProcessingImg.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CardMaker cardMaker = new CardMaker(csvPath, imagePath, labels);
				cardMaker.makeCards();
			}
		});

		addDefaultText.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				JLabel label = createDragAndDropLbl();

				labels.add(label);

				imageLabel.add(label);
				imageLabel.doLayout();
			}

		});
	}

	private JLabel createDragAndDropLbl() {
		JLabel label = new JLabel();
		label.setText(DEFAULT_TEXT);
		label.setFont(new Font("Helvetica", PLAIN, 30));
		label.setForeground(Color.white);

		label.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) {
				mouseOnDragStartOnX = evt.getX();
				mouseOnDragStartOnY = evt.getY();
			}
		});

		label.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				label.setLocation(e.getXOnScreen() - mouseOnDragStartOnX, e.getYOnScreen() - mouseOnDragStartOnY);
			}
		});
		return label;
	}
}
