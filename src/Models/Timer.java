/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Views.MainWindow;

/**
 *
 * @author Bilal
 */
public class Timer {
    static int milliseconds = 0;
    static int seconds = 0;
    static int minutes = 0;
    static int hours = 0;
    
    public static void startTimer() {
       
        Thread t = new Thread() {
            public void run() {
              
                for (;;) {
                    if (MainWindow.isPaused == false) {
                        try {
                            sleep(50);
                            if(milliseconds >94){
                                milliseconds = 0;
                                seconds++;
                            }
                            if(seconds >59){
                                milliseconds = 0;
                                seconds = 0;
                                minutes++;
                            }
                            
                            milliseconds += 5;
                            
                            String time = String.format("%02d:%02d:%2d0", minutes, seconds, milliseconds);
                            
                            MainWindow.jLabelTimer.setText(time);
                        } catch (Exception e) {
                            System.out.println("Timer Error");
                        }
                        
                    } else if (MainWindow.resetGame == true){
                        
                        milliseconds = 0; seconds = 0; minutes = 0; hours = 0;
                        MainWindow.resetGame = false;
                        MainWindow.jLabelTimer.setText("00:00:000");
                        break;
                        
                    } else {
                        break;
                    }
                }
            }
        };
        t.start();
    }
}
