//import java.util.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.*;
//import javax.swing.*;
//import javax.swing.event.AncestorEvent;
//import javax.swing.event.AncestorListener;
//import javax.swing.filechooser.*;
//
//public class animation extends JFrame implements ActionListener, Runnable {
//
//    // add InheritanceAnimation
//    static final animation T = null;
//    // adding layout
//    static JPanel nPanel = new JPanel(new FlowLayout());
//    static JPanel sPanel = new JPanel(new FlowLayout());
//    static JPanel cPanel = new JPanel(new FlowLayout());
//
//    // adding controllers buttons
//    JButton btnPlay = new JButton(">");
//    JButton btnStop = new JButton("#");
//    JButton btnNext = new JButton(">|");
//    JButton btnBack = new JButton("|<");
//
//    // adding buttons to load file and save
//    JButton btnLoad = new JButton("Load File");
//    JButton btnSave = new JButton("Save File");
//
//    JTextArea mainContent = null;
//    JMenuBar Navigation = new JMenuBar();
//
//    //
//    private int frame; // the current frame
//    boolean keepgoing = true;
//    boolean end = false;
//
//    private int startFrame = 0;
//
//    // initial Array List
//    ArrayList<String> address = new ArrayList<String>();
//    public static String[] states = { "1", "2", "3", "4" };
//
//    // add java select file
//    JavaFilter selectfile = new JavaFilter();
//
//    // loading file
//
//    File xfile = new File("untitled.txt");
//
//    public static void main(String[] args) {
//        new animation();
//    }// end main
//
//    // main layout
//    public animation() {
//        init();
//        this.pack();
//        startFrame = 0;
//        this.setSize(700, 450); // set box content
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        mainContent = new JTextArea();
//        this.getContentPane().setLayout(new BorderLayout());
//        this.add(mainContent, BorderLayout.CENTER);
//        // navigation.add()
//        Navigation.add(btnLoad); // load file
//        Navigation.add(btnSave); // save file button
//
//        setJMenuBar(Navigation);
//        Navigation.setBackground(new Color(219, 200, 200)); // add color to the
//        // Navigation bar
//        // apply the buttons the
//        sPanel.add(btnBack);
//        sPanel.add(btnPlay);
//        sPanel.add(btnNext);
//        sPanel.add(btnStop);
//
//        add(sPanel, BorderLayout.SOUTH); // adding sPanel to south border
//        this.setVisible(true);
//        Stop();
//        Load();
//        Next();
//        Back();
//        Save();
//
//        final Runnable myWorm = this;
//        btnPlay.addAncestorListener(new AncestorListener() {
//
//            public void actionPerformed(ActionEvent e) {
//                keepgoing = true;
//                new Thread(myWorm).start();
//
//            }// end action event
//
//            private void getPosition(Object object) {
//
//            }
//
//            @Override
//            public void ancestorAdded(AncestorEvent event) {
//                // TODO Auto-generated method stub
//
//            }
//
//            @Override
//            public void ancestorMoved(AncestorEvent event) {
//                // TODO Auto-generated method stub
//
//            }
//
//            @Override
//            public void ancestorRemoved(AncestorEvent event) {
//                // TODO Auto-generated method stub
//
//            }
//
//        });
//
//    }// end animation
//
//    // Method the read the frame
//    public void go() {
//        try {
//            for (int i = startFrame; i < address.size() && keepgoing; i++) {
//                startFrame = i;
//                FileInputStream sStream = new FileInputStream(address.get(i));
//                DataInputStream dataIn = new DataInputStream(sStream);
//                BufferedReader buffer = new BufferedReader(
//                        new InputStreamReader(dataIn));
//                String strLine;
//
//                // reading file's line
//                String tLines = "";
//
//                while ((strLine = buffer.readLine()) != null) {
//                    tLines = tLines + strLine + "\n";
//
//                }// end while
//                mainContent.setText(tLines);
//                dataIn.close(); // close file
//            }
//            Thread.sleep(1000);
//        }// end try
//        catch (Exception e) {
//            System.err.println("Error: " + e.getMessage());
//
//        }// end catch
//
//    }// end go
//
//    // /////////////// adding methods for the buttons //////////////////////
//
//    public void Next() {
//        btnNext.addActionListener(new ActionListener() {
//
//            public void actionPerformed(ActionEvent e) {
//                if (startFrame > 0) {
//                    startFrame++;
//                    nextBefore(address);
//                }// end if
//
//            }// end action event next button
//        });
//    }// end next method
//
//    public void Back() {
//        btnBack.addActionListener(new ActionListener() {
//
//            public void actionPerformed(ActionEvent e) {
//                if (startFrame > 0) {
//                    startFrame--;
//                    nextBefore(address);
//                }
//
//            }// avtion event back
//        });// end action listener back
//
//    }// back method
//
//    public void Stop() {
//        btnStop.addActionListener(this);
//
//    }// end stop
//
//    public void Load() {
//        btnLoad.addActionListener(new ActionListener() {
//
//            public void actionPerformed(ActionEvent e) {
//                Object click = e.getSource();
//                if (click == btnLoad) {
//                    JFileChooser openMyFile = new JFileChooser();
//                    FileNameExtensionFilter filter = new FileNameExtensionFilter(
//                            "txt file ", "txt");
//                    openMyFile.addChoosableFileFilter(filter);
//
//                    int returN = openMyFile.showDialog(null, "open file");
//
//                    if (returN == JFileChooser.APPROVE_OPTION)
//                        ;
//                    File file = openMyFile.getSelectedFile();
//
//                    try {
//                        BufferedReader reader =
//
//                                new BufferedReader(new FileReader(file
//                                        .getAbsolutePath()));
//                        String line;
//
//                        while ((line = reader.readLine()) != null) {
//                            ((Appendable) openMyFile).append(line);
//                            ((Appendable) openMyFile).append("\n");
//                        }
//
//                        reader.close();
//                    } catch (Exception ess) {
//                    }
//                }
//
//            }// end actionPerformed
//        });// end action listener load
//    }// end load method
//
//    public void Save() {
//        btnSave.addActionListener(new ActionListener() {
//
//            public void actionPerformed(ActionEvent e) {
//                end = saveFile();
//                {
//                    if (!end) {
//                        JOptionPane.showMessageDialog(null, "saving file ",
//                                "File Save Error", JOptionPane.ERROR_MESSAGE);
//                    } // end if
//
//                }// end saveFile
//
//            } // end action event save button
//        });
//
//    }// end save method
//
//    public boolean saveFile() {
//        File file = null;
//        JFileChooser jfc = new JFileChooser();
//
//        jfc.setCurrentDirectory(new File("."));
//
//        jfc.setFileFilter(selectfile);
//        // Set to a default name for save.
//        jfc.setSelectedFile(xfile);
//
//        // Open chooser dialog
//        int result = jfc.showSaveDialog(this);
//
//        if (result == JFileChooser.CANCEL_OPTION) {
//            return true;
//        }
//
//        else if (result == JFileChooser.APPROVE_OPTION) {
//            xfile = jfc.getSelectedFile();
//            if (xfile.exists()) {
//                int response = JOptionPane.showConfirmDialog(null,
//                        "Overwrite existing file?", "Confirm Overwrite",
//                        JOptionPane.
//
//                                OK_CANCEL_OPTION, JOptionPane.
//
//                                QUESTION_MESSAGE);
//                if (response == JOptionPane.CANCEL_OPTION)
//                    return false;
//            }
//
//            return (writeFile(xfile, mainContent.getText()) ? address.add(xfile
//                    .getAbsolutePath()) : false);
//        }
//
//        else {
//            return false;
//        }
//    }// end saveFile method`
//    public static boolean writeFile(File file, String dataString) {
//        try {
//            PrintWriter out = new PrintWriter(new BufferedWriter(
//                    new FileWriter(file)));
//            out.print(dataString);
//            out.flush();
//            out.close();
//
//        } catch (IOException e) {
//            return false;
//        }
//
//        return true;
//    } // end
//
//
//    public void init() {
//        this.setTitle("Animation ");
//    }
//
//    public void nextBefore(ArrayList<String> nameOfFile) {
//        try {
//            FileInputStream fstream =
//
//                    new FileInputStream(nameOfFile.get(startFrame));
//            // Get the object of DataInputStream
//            DataInputStream in =
//
//                    new DataInputStream(fstream);
//            BufferedReader br =
//
//                    new BufferedReader(new InputStreamReader(in));
//            String strLine;
//
//            // Read File Line By Line
//            String totalLines =
//
//                    "";
//            while ((strLine = br.readLine()) != null) {
//                totalLines = totalLines + strLine +
//
//                        "\n";
//            }
//
//            // print file on JTArea
//            mainContent.setText(totalLines);
//            in.close();
//
//        }
//
//        catch (Exception eBackForward) {
//        }
//
//    }
//
//    @Override
//    public void run() {
//        // TODO Auto-generated method stub
//
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent arg0) {
//        // TODO Auto-generated method stub
//
//    }
//
//    private class JavaFilter extends javax.swing.filechooser.FileFilter {
//        @Override
//        public boolean accept(File f) {
//            return false;
//        }
//
//        @Override
//        public String getDescription() {
//            return null;
//        }
//    }
//}// end animation class
