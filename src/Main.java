import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.Desktop;
import java.net.URI;

public class Main {
    public static void main(String[] args) {
        // Git visible?
        int choice = JOptionPane.showConfirmDialog(null, "Удачи!/Good Luck!/Viel Glück!", "SMS", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);

        JFrame frame = new JFrame("TextEdtior"); // создание окна
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// создание кнопки выключение
        frame.setSize(1000, 1000); // размер окна
        JTextArea textArea = new JTextArea();
        String iconPath = "f.png"; // путь к иконке файла фотки
        ImageIcon icon = new ImageIcon(iconPath); // создание иконки с этим путем
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        JPanel lineNumbersPanel = new JPanel(new BorderLayout());
        JTextArea lineNumbersTextArea = new JTextArea("1: \n"); // нумерация пока что только один есть
        lineNumbersTextArea.setEditable(false);
        lineNumbersPanel.add(lineNumbersTextArea, BorderLayout.CENTER);
        scrollPane.setRowHeaderView(lineNumbersPanel);

        // jmenu
        JMenuBar menuBar = new JMenuBar();
        JMenuBar infoBar = new JMenuBar();
        JMenu infoMenu = new JMenu("info"); // кнопочки при нажатии на file
        JMenu fileMenu = new JMenu("file"); // кнопочки при нажатии на file
        JMenuItem openFile = new JMenuItem("Open"); // кнопочки при нажатии на file
        JMenuItem saveFile = new JMenuItem("Save"); // кнопочки при нажатии на file
        JMenuItem support = new JMenuItem("Support developer");// кнопочки при нажатии на file
        JMenuItem Website = new JMenuItem("You can also visit my website");
        JCheckBox checkBox = new JCheckBox("test click me");

        // function
        openFile.addActionListener(new ActionListener() { // функция для открывание файла
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                if (fileChooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    try {
                        BufferedReader reader = new BufferedReader(new FileReader(file));
                        textArea.read(reader, null);
                        reader.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        support.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
                try {
                    Desktop desktop = Desktop.getDesktop();
                    URI urlka = new URI("https://www.youtube.com/watch?v=dQw4w9WgXcQ");
                    desktop.browse(urlka);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        saveFile.addActionListener(new ActionListener() { // функция при нажатии на сохранить
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                if (fileChooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    try {
                        BufferedWriter writing = new BufferedWriter(new FileWriter(file));
                        textArea.write(writing);
                        writing.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        Website.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
                try {
                    HttpsServer.HttpServer();
                    Desktop desktop = Desktop.getDesktop();
                    URI uri = new URI("http://localhost:8000/main");
                    desktop.browse(uri);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        
        JToolBar toolBar = new JToolBar();
        fileMenu.add(openFile);
        fileMenu.add(saveFile);
        fileMenu.add(support);
        frame.setIconImage(icon.getImage());
        fileMenu.add(Website);
        fileMenu.add(checkBox);
        menuBar.add(fileMenu);
        infoBar.add(infoMenu);
        frame.add(toolBar, BorderLayout.NORTH);
        frame.setJMenuBar(menuBar);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true); // window visible show
    }
}
