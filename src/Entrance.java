import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Entrance implements ActionListener {

    private JFrame firstFram,secondFram;
    private JPanel firstPanel;
    private JPanel secondPanel;
    private JFileChooser awPathCh = new JFileChooser();
    private JTextField awPathText;

    private static String awFile;

    private void firstFram(){
        firstFram = new JFrame();
        firstFram.setSize(500,400);
        firstFram.setDefaultCloseOperation(3);
        firstFram.setResizable(false);

        firstPanel = new JPanel();
        firstPanel.setBackground(new Color(90,90,146));
        firstPanel.setLayout(null);

        awPathText = new JTextField();
        awPathText.setSize(300,25);
        awPathText.setBounds(160, 260, 200, 25);

        JButton awButton,next;
        awButton = new JButton("File");
        awButton.setName("awButton");
        awButton.setBounds(360, 260, 60, 25);
        awButton.addActionListener(this);

        next = new JButton("Next");
        next.setName("next1");
        next.setBounds(250, 320, 75, 26);
        next.addActionListener(this);

        firstPanel.add(awPathText);
        firstPanel.add(awButton);
        firstPanel.add(next);
        firstFram.add(firstPanel);
        firstFram.setVisible(true);
    }

    private void secondFram(){
        secondFram = new JFrame();
        secondFram.setSize(500,400);
        secondFram.setDefaultCloseOperation(3);
        secondFram.setResizable(false);

        secondPanel = new JPanel();
        secondPanel.setBackground(new Color(0,0,0));
        secondPanel.setLayout(null);

        JButton programButton,back,next;
        programButton = new JButton("File");
        programButton.setName("awPathButton");
        programButton.setBounds(360, 260, 60, 25);
        programButton.addActionListener(this);

        back = new JButton("Back");
        back.setName("back2");
        back.setBounds(200, 320, 75, 26);
        back.addActionListener(this);

        next = new JButton("Next");
        next.setName("next2");
        next.setBounds(300, 320, 75, 26);
        next.addActionListener(this);

        secondPanel.add(programButton);
        secondPanel.add(back);
        secondPanel.add(next);

        secondFram.add(secondPanel);
        secondFram.setVisible(true);
    }

    public static void main(String[] args) {
        Entrance entrance = new Entrance();
        entrance.firstFram();
    }

    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        JButton bt = (JButton) e.getSource();
        if (bt.getName() == "awButton") {
            int showOpenDialog = awPathCh.showOpenDialog(firstPanel);
            File selectedFile = awPathCh.getSelectedFile();
            if(null != selectedFile && showOpenDialog == JFileChooser.APPROVE_OPTION){
                awPathText.setText(selectedFile.getPath());
                awFile = awPathText.getText();
            }
        }else if(bt.getName() == "next1" && awPathText.getText().length() > 4){
            firstFram.removeAll();
            firstFram.dispose();
            secondFram();
        }else if(bt.getName() == "back2"){
            secondFram.removeAll();
            secondFram.dispose();
            firstFram();
            awPathText.setText(awFile);
        }
    }
}
