package org.booob.cardMaker.gui.view;

import static org.booob.cardMaker.utils.Statics.X_SCALE;
import static org.booob.cardMaker.utils.Statics.Y_SCALE;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.HashSet;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.booob.cardMaker.dataLoader.GraphicsIO;
import org.booob.cardMaker.gui.controller.MainWindowController;


public class MainWindow extends JFrame {

	private static final long serialVersionUID = -1466440285193237853L;

	private MainWindowController mainWindowController;

	private JLabel imageLabel;

	private JButton startProcessingImg;
	private JButton addDefaultText;
	private JButton testPrintout;

	private JTextField labelText;

	private static BufferedImage renderedImage;

	private static String imagePath;
	private static String csvPath;

	private Set<JLabel> labels;
	

	public MainWindow(String imagePath, String csvPath) {

		this.imagePath = imagePath;
		this.csvPath = csvPath;
		
		setSize(1300, 600);
		setVisible(true);
		setLayout(new FlowLayout());

		mainWindowController = new MainWindowController();
		
		labels = new HashSet();

		createComponents(imagePath);

		add(imageLabel);
		add(startProcessingImg);
		add(testPrintout);
		add(addDefaultText);
		add(labelText);

		setEvents();
	}

	private void createComponents(String imagePath) {
		renderedImage = GraphicsIO.loadImage(imagePath);

		Image scaledImage = displayScaledImage(renderedImage);

		ImageIcon image = new ImageIcon(scaledImage);

		imageLabel = new JLabel(image);
		imageLabel.setLayout(new FlowLayout());

		labelText = new JTextField("Default text");

		startProcessingImg = new JButton("Drukuj karty");
		addDefaultText = new JButton("Dodaj tekst");
		testPrintout = new JButton("Test");
	}

	private Image displayScaledImage(BufferedImage renderedImage) {

		Image scaledImage = renderedImage.getScaledInstance(renderedImage.getWidth() - X_SCALE,
				renderedImage.getHeight() - Y_SCALE, 1);

		return scaledImage;
	}

	private void setEvents() {
		mainWindowController.createStartProcessingImgListener(startProcessingImg, csvPath, imagePath, labels);

		mainWindowController.createAddDefaultTextListener(addDefaultText, imageLabel, labels, labelText);
		
		mainWindowController.createTestPrintoutListener(testPrintout, csvPath, imagePath, labels);
	}

}
