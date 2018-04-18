import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MyEntrance {
    //private JButton nextButton,cancelButton,backButton;
    private JFrame firstFrame,secondFrame,thirdFrame;
    private JPanel firstPanel,secondPanel,thirdPanel;
    private static String awFile;

    //private MyListener myListener = new MyListener();


    public void init() {
        firstView();
    }

    /**
     * 第一个视图，登陆界面
     */
    private void firstView() {
        JButton nextButton, cancelButton;



        nextButton = new JButton(AppConstants.BUTTON_NEXT);
        nextButton.setBounds(300, 300, 80, 25);
        nextButton.setName("next1");
        //nextButton匿名内部类注册监听器
        //nextButton.addActionListener(myListener);
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstFrame.removeAll();
                firstFrame.dispose();
                secondView();
            }
        });


        cancelButton = new JButton(AppConstants.BUTTON_CANCEL);
        cancelButton.setBounds(400, 300, 60, 25);
        cancelButton.setName("cancel");
        //cancelButton.addActionListener(myListener);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstFrame.removeAll();
                firstFrame.dispose();
            }
        });

        JLabel welcomeLabel = new JLabel();
        welcomeLabel.setText("<html><p>欢迎使用安装程序</p></p>接下来进入安装步骤</p></html>");
        //welcomeLabel.setLocation(100,100);
        welcomeLabel.setBounds(100,100,300,100);
        welcomeLabel.setFont(new Font(null, Font.PLAIN, 25));

        firstPanel = new JPanel();
        firstPanel.setBackground(new Color(90,90,146));
        firstPanel.setLayout(null);
        firstPanel.add(nextButton);
        firstPanel.add(cancelButton);
        firstPanel.add(welcomeLabel);

        firstFrame = initFrame();
        firstFrame.add(firstPanel);
        firstFrame.setVisible(true);

    }

    /**
     * 第二个视图，版本选择界面
     */
    private void secondView() {

        JLabel welcomeLabel = new JLabel();
        welcomeLabel.setText("<html><p>请选择需要安装的软件版本</p></html>");
        //welcomeLabel.setLocation(100,100);
        welcomeLabel.setBounds(100,20,300,60);
        welcomeLabel.setFont(new Font(null, Font.PLAIN, 25));

        JList<String> list = new JList<String>();
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        String[] mStr = new String[]{"《三国演义》","《水浒传》","《西游记》","《红楼梦》"};
        list.setListData(mStr);
        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int index = list.getSelectedIndex();
                ListModel listModel = list.getModel();
                System.out.println("选中：" + index + " = " + listModel.getElementAt(index));
            }
        });
        list.setSelectedIndex(0);

        JScrollPane jScrollPane = new JScrollPane();
        jScrollPane.setBounds(100,100,300,100);
        jScrollPane.setViewportView(list);

        JButton backButton, nextButton, cancelButton;

        backButton = new JButton(AppConstants.BUTTON_BACK);
        backButton.setBounds(200, 300, 80, 25);
        backButton.setName("back2");
        nextButton = new JButton(AppConstants.BUTTON_NEXT);
        nextButton.setBounds(300, 300, 80, 25);
        nextButton.setName("next2");
        cancelButton = new JButton(AppConstants.BUTTON_CANCEL);
        cancelButton.setBounds(400, 300, 60, 25);
        cancelButton.setName("cancel");


        //backButton.addActionListener(myListener);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                secondFrame.removeAll();
                secondFrame.dispose();
                firstView();
            }
        });

        //nextButton.addActionListener(myListener);
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                secondFrame.removeAll();
                secondFrame.dispose();
                thirdView();
            }
        });

        //cancelButton.addActionListener(myListener);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                secondFrame.removeAll();
                secondFrame.dispose();
            }
        });

        secondPanel = new JPanel();
        secondPanel.setBackground(new Color(90,90,146));
        secondPanel.setLayout(null);
        secondPanel.add(backButton);
        secondPanel.add(nextButton);
        secondPanel.add(cancelButton);
        secondPanel.add(jScrollPane);
        secondPanel.add(welcomeLabel);

        secondFrame = initFrame();
        secondFrame.add(secondPanel);
        secondFrame.setVisible(true);
    }

    /**
     * 第三个视图，下载目录试图
     */
    private void thirdView (){

        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setCurrentDirectory(new File("d:\\电子书"));

        JTextField awPathText = new JTextField();
        awPathText.setSize(300,25);
        awPathText.setBounds(160, 260, 200, 25);

        JButton awButton = new JButton("File");
        awButton.setBounds(360, 260, 60, 25);
        awButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int showOpenDialog = jFileChooser.showOpenDialog(thirdPanel);
                File selectedFile = jFileChooser.getSelectedFile();
                if(null != selectedFile && showOpenDialog == JFileChooser.APPROVE_OPTION){
                    awPathText.setText(selectedFile.getPath());
                    awFile = awPathText.getText();
                }
            }
        });

        JButton backButton, nextButton, cancelButton;
        backButton = new JButton(AppConstants.BUTTON_BACK);
        backButton.setBounds(200, 300, 80, 25);
        backButton.setName("back2");
        nextButton = new JButton(AppConstants.BUTTON_NEXT);
        nextButton.setBounds(300, 300, 80, 25);
        nextButton.setName("next2");
        cancelButton = new JButton(AppConstants.BUTTON_CANCEL);
        cancelButton.setBounds(400, 300, 60, 25);
        cancelButton.setName("cancel");

        thirdPanel = new JPanel();
        thirdPanel.setBackground(new Color(90,90,146));
        thirdPanel.setLayout(null);
        thirdPanel.add(awPathText);
        thirdPanel.add(awButton);

        thirdFrame = initFrame();
        thirdFrame.add(thirdPanel);
        thirdFrame.setVisible(true);
    }

    /**
     * 初始化Frame对象
     */
    private JFrame initFrame () {
        JFrame frame = new JFrame(AppConstants.VIEW_TITLE);
        frame.setSize(500,400);
        frame.setLocation(300,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        return frame;
    }

/*    class MyListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton bt = (JButton) e.getSource();
            switch (bt.getName()){
                case "cancel":
                    System.exit(0);
                    break;
                case "next1":
                    firstFrame.removeAll();
                    firstFrame.dispose();
                    secondFrame();
                    break;
                case "next2":
                    System.exit(0);
                    break;
                case "back2":
                    //System.exit(0);
                    *//*secondFrame.removeAll();
                    secondFrame.dispose();
                    firstFrame();*//*
                    secondFrame.removeAll();
                    secondFrame.dispose();
                    firstFrame();
                    break;
            }
            firstFrame.removeAll();
            firstFrame.dispose();
            secondFrame();
        }
    }*/
}
