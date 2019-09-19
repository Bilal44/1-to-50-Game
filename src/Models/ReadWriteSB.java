/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bilal
 */
public class ReadWriteSB {
    

    public static void SBReadFile(JTable table) throws IOException {
        
        File f = new File(".","HighScores.dat");
        f.createNewFile();
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        DefaultTableModel model  =  (DefaultTableModel) table.getModel();
        Object[] lines = br.lines().toArray();
        
        for (Object line : lines) {
            String[] row = line.toString().split("\t");
            model.addRow(row);
        }

    }
    
    public static void SBWriteFile(JTable table) {

            try {
            File f = new File(".", "HighScores.dat");
            f.createNewFile();
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);

                for(int i = 0; i < table.getRowCount(); i++){//rows
                for(int j = 0; j < table.getColumnCount(); j++){
                    bw.write(table.getValueAt(i, j).toString()+"\t");
                }
                bw.newLine();
            }

            bw.close();
            fw.close();

        } catch (IOException e) {
            System.out.println(e);
        }
}
}
