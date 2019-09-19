/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import Views.MainWindow;

/**
 *
 * @author Bilal
 */
public class ButtonChecker implements ActionListener {

    int i = 0;

    public void actionPerformed(ActionEvent evt) {
        String currentNumber = String.valueOf(MainWindow.arrCorrectOrder.get(0));
        String currentBtnText = evt.getActionCommand();
        JButton currentButton = (JButton) evt.getSource();
        System.out.println(currentBtnText);
        if (currentBtnText.equals(currentNumber)) {
            MainWindow.arrCorrectOrder.remove(0);
            if (Integer.valueOf(currentButton.getText()) < 26) {
                currentButton.setText(String.valueOf(i + 26));
                i++;
            } else if (Integer.valueOf(currentButton.getText()) >= 26) {
                currentButton.setVisible(false);
            }
        } else {
            Toolkit.getDefaultToolkit().beep();
            MainWindow.jLabelMistakeCount.setText("Mistakes: " + (++MainWindow.mistakeCount));
        }

        if (MainWindow.arrCorrectOrder.isEmpty()) {
                MainWindow.endGame();
        }
    }
}
