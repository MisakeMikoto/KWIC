import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class SoftwareArchitectureApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("软件体系结构教学软件");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 800);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JComboBox<String> architectureStyles = new JComboBox<>(new String[]{"主程序-子程序", "面向对象", "事件系统", "管道-过滤器"});
        mainPanel.add(architectureStyles, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        JTextArea resultTextArea = new JTextArea();

        JLabel imageLabel2 = new JLabel();
        JPanel topCenterPanel = new JPanel();
        topCenterPanel.add(imageLabel2);
        centerPanel.add(topCenterPanel, BorderLayout.CENTER);

        JPanel bottomCenterPanel = new JPanel();
        JLabel imageLabel1 = new JLabel();
        bottomCenterPanel.add(imageLabel1);
        centerPanel.add(bottomCenterPanel, BorderLayout.SOUTH);

        mainPanel.add(centerPanel, BorderLayout.CENTER);

        JTextArea resultTextArea2 = new JTextArea();
        mainPanel.add(new JScrollPane(resultTextArea2), BorderLayout.EAST);

        mainPanel.add(new JScrollPane(resultTextArea), BorderLayout.WEST);

        JButton processButton = new JButton("处理文件");
        mainPanel.add(processButton, BorderLayout.SOUTH);
        processButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                File file = null;

                String selectedStyle = (String) architectureStyles.getSelectedItem();
                String selectedFile = "input.txt"; // 替换为实际的文件路径
                ImageIcon icon = null;
                ImageIcon icon1 = null;
                String result = processFile(selectedStyle, selectedFile);
                switch (selectedStyle){
                    case "主程序-子程序":
                        icon = new ImageIcon("MSSA.png"); // 替换为实际的图片路径
                        icon1 = new ImageIcon("MSSA1.png"); // 替换为实际的图片路径
                        file = new File("MSSA.txt");
                        break;
                    case "面向对象":
                        icon = new ImageIcon("OOSA.png"); // 替换为实际的图片路径
                        icon1 = new ImageIcon("OOSA1.png"); // 替换为实际的图片路径
                        file = new File("OOSA.txt");
                        break;
                    case "事件系统":
                        icon = new ImageIcon("ESSA.png"); // 替换为实际的图片路径
                        icon1 = new ImageIcon("ESSA1.png"); // 替换为实际的图片路径
                        file = new File("ESSA.txt");
                        break;
                    case "管道-过滤器":
                        icon = new ImageIcon("PFSA.png"); // 替换为实际的图片路径
                        icon1 = new ImageIcon("PFSA1.png"); // 替换为实际的图片路径
                        file = new File("PFSA.txt");
                        break;
                    default:
                        break;
                }
                BufferedReader br = null;
                try {
                    br = new BufferedReader(new FileReader(file));
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                String line;
                StringBuilder result1 = new StringBuilder();
                while (true) {
                    try {
                        if (!((line = br.readLine()) != null)) break;
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    result1.append(line).append("\n");
                }
                try {
                    br.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                resultTextArea.setText(result);
                resultTextArea2.setText(result1.toString());
                imageLabel1.setIcon(icon);
                imageLabel2.setIcon(icon1);
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });

        mainPanel.add(processButton, BorderLayout.SOUTH);

        frame.getContentPane().add(mainPanel);
        frame.setVisible(true);
    }

    private static String processFile(String architectureStyle, String filePath) {
        // 在这里实现根据不同风格处理文件的逻辑
        // 你可以根据所选风格执行不同的操作
        // 例如，读取文件内容，应用相应的算法，返回处理结果
        try {
            String outputFile = "output5.txt";
            switch (architectureStyle){
                case "主程序-子程序":
                    MainandSubProSA sa = new MainandSubProSA();
                    sa.input(filePath);
                    sa.shift();
                    sa.alphabetizer();
                    sa.output(outputFile);
                    break;
                case "面向对象":
                    OOSA oosa = new OOSA();
                    oosa.execute(filePath, outputFile);
                    break;
                case "事件系统":
                    ESSA essa = new ESSA();
                    essa.execute(filePath, outputFile);
                    break;
                case "管道-过滤器":
                    PFSA pfsa = new PFSA();
                    pfsa.execute(filePath, outputFile);
                    break;
                default:
                    break;
            }
            File file = new File(outputFile);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            StringBuilder result = new StringBuilder();
            while ((line = br.readLine()) != null) {
                // 在这里添加你的处理逻辑
                result.append(line).append("\n");
            }
            br.close();
            return result.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "处理文件时出错：" + e.getMessage();
        }
    }
}



