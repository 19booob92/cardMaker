package org.booob.cardMaker.gui.controller;

import static java.awt.Font.PLAIN;
import static org.booob.cardMaker.utils.CardsPrintMode.ONLY_ONE;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.booob.cardMaker.CardMaker;

public class MainWindowController {

	private int mouseOnDragStartOnX;
	private int mouseOnDragStartOnY;

	public void createStartProcessingImgListener(JButton startProcessingImg, String csvPath, String imagePath,
			Set<JLabel> labels) {

		startProcessingImg.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CardMaker cardMaker = new CardMaker(csvPath, imagePath, labels);
				cardMaker.resetId();
				cardMaker.makeCards();
			}
		});

	}

	private JLabel createDragAndDropLbl(String textToSet) {
		JLabel label = new JLabel();
		label.setText(textToSet);
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

	public void createAddDefaultTextListener(JButton addDefaultText, JLabel imageLabel, Set<JLabel> labels,
			JTextField labelText) {
		addDefaultText.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String textToSetInLabel = labelText.getText();
				if (textToSetInLabel == null || textToSetInLabel.isEmpty()) {
					labelText.setText("Tekst nie może być pusty");
				} else {
					JLabel label = createDragAndDropLbl(labelText.getText());

					labels.add(label);

					imageLabel.add(label);
					imageLabel.doLayout();
				}
			}
		});
	}

	public void createTestPrintoutListener(JButton testPrintout, String csvPath, String imagePath, Set<JLabel> labels) {
		testPrintout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CardMaker cardMaker = new CardMaker(csvPath, imagePath, labels);
				cardMaker.resetId();
				cardMaker.makeCards(ONLY_ONE);
			}
		});
	}
}
