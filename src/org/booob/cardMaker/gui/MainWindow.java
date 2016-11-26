package org.booob.cardMaker.gui;

import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.booob.cardMaker.CardMaker;
import org.booob.cardMaker.dataLoader.GraphicsIO;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = -1466440285193237853L;

	private JLabel imageLabel;
	private JButton startProcessingImg;

	private static Graphics2D graphics;
	private static BufferedImage renderedImage;

	private static String imagePath;
	private static String csvPath;

	private static int xScale = 1950;
	private static int yScale = 500;

	public MainWindow(String imagePath, String csvPath) {

		this.imagePath = imagePath;
		this.csvPath = csvPath;

		setSize(1300, 600);
		setVisible(true);
		setLayout(new FlowLayout());

		createComponents(imagePath);

		add(imageLabel);
		add(startProcessingImg);

		setEvents();
	}

	private void createComponents(String imagePath) {
		renderedImage = GraphicsIO.loadImage(imagePath);
		graphics = (Graphics2D) renderedImage.getGraphics();

		Image scaledImage = displayScaledImage(renderedImage);

		ImageIcon image = new ImageIcon(scaledImage);

		imageLabel = new JLabel(image);
		startProcessingImg = new JButton("Dodaj tekst");
	}

	private Image displayScaledImage(BufferedImage renderedImage) {

		Image scaledImage = renderedImage.getScaledInstance(renderedImage.getWidth() - xScale,
				renderedImage.getHeight() - yScale, 1);

		return scaledImage;
	}

	private void setEvents() {
		startProcessingImg.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CardMaker cardMaker = new CardMaker(csvPath, imagePath);
				cardMaker.makeCards();
			}
		});
	}

}
