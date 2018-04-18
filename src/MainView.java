import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainView extends JFrame {



    /*private JPanel jPanel0,jPanelCenter, jPanelSouth;
    //按钮“下一步”、“取消”
    private JButton nextButton, cancelButton;
    //提示文本
    private JLabel wordLabel;

    public MainView(){
        init();
    }

    private void init(){
        nextButton = new JButton(AppConstants.BUTTON_NEXT);
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                *//*dispose();
                new MainView();*//*

            }
        });
        cancelButton = new JButton(AppConstants.BUTTON_CANCEL);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                //System.exit(0);
            }
        });
        wordLabel = new JLabel();
        wordLabel.setText("<html><p>欢迎使用安装程序</p></p>接下来进入安装步骤</p></html>");
        wordLabel.setFont(new Font(null, Font.PLAIN, 25));


        jPanel0 = new JPanel();
        jPanelCenter = new JPanel();
        jPanelSouth = new JPanel();

        jPanelSouth.setLayout(new GridLayout(1,4));
        jPanelSouth.add(nextButton);
        jPanelSouth.add(cancelButton);
        jPanelCenter.add(wordLabel);
        jPanel0.add(jPanelCenter, BorderLayout.CENTER);
        jPanel0.add(jPanelSouth, BorderLayout.SOUTH);

        this.setTitle(AppConstants.VIEW_TITLE);
        *//*this.add(jPanelCenter, BorderLayout.CENTER);
        this.add(jPanelSouth, BorderLayout.SOUTH);*//*
        this.setLayout(new CardLayout());
        this.add(jPanel0);

        //this.setBounds(470, 200, 400, 270);
        this.pack();
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }*/
}
