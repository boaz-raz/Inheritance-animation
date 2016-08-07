import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;




public  class AsciiCanvas extends Component {


    // add InheritanceAnimation
    static final AsciiCanvas T = null;

     int frame; // the current frame
     boolean keepgoing = true;
     boolean end = false;

    public static int startFrame = 0;

    // initial Array List
    ArrayList<String> address = new ArrayList<String>();
    public static String[] states = { "1", "2", "3", "4" };

    // add java select file
    JavaFilter selectfile = new JavaFilter();

    static JTextArea mainContent = null;


    File xfile = new File("untitled.txt");


    public AsciiCanvas() {

    }


//    public void init() {
//        this.setTitle("Animation ");
//    }


    public void go() {
        System.out.println("anim method was called");
        try {
            for (int i = startFrame; i < address.size() && keepgoing; i++) {
                startFrame = i;
                FileInputStream sStream = new FileInputStream(address.get(i));
                DataInputStream dataIn = new DataInputStream(sStream);
                BufferedReader buffer = new BufferedReader(
                        new InputStreamReader(dataIn));
                String strLine;

                // reading file's line
                String tLines = "";

                while ((strLine = buffer.readLine()) != null) {
                    tLines = tLines + strLine + "\n";

                }// end while
                mainContent.setText(tLines);
                dataIn.close(); // close file
            }
            Thread.sleep(1000);
        }// end try
        catch (Exception e) {
            System.err.println("Error: " + e.getMessage());

        }// end catch

    }// end go

    public void prevFrame() {
        System.out.println("prevFrame method was called");
        if (startFrame > 0) {
            startFrame--;
            nextBefore(address);
        }

    } // end prevFrame method


    public void nextFrame() {
        System.out.println("nextFrame method was called");

        if (startFrame > 0) {
            startFrame++;
            nextBefore(address);
        };
    }
    public void load() {
        System.out.println("load btn method was called"); // this is for testing

        JFileChooser openMyFile = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "txt file ", "txt");
        openMyFile.addChoosableFileFilter(filter);

        int returN = openMyFile.showDialog(null, "open file");

        if (returN == JFileChooser.APPROVE_OPTION)
            ;
        File file = openMyFile.getSelectedFile();

        try {
            BufferedReader reader =

                    new BufferedReader(new FileReader(file
                            .getAbsolutePath()));
            String line;

            while ((line = reader.readLine()) != null) {
                ((Appendable) openMyFile).append(line);
                ((Appendable) openMyFile).append("\n");
            }

            reader.close();
        } catch (Exception ess) {
        }

    } // end load method

    public void save() {
        saveFile();

//        end = saveFile();
//        {
//            if (!end) {
//                JOptionPane.showMessageDialog(null, "saving file ",
//                        "File Save Error", JOptionPane.ERROR_MESSAGE);
//            } // end if
//
//        }// end saveFile

    }
    public boolean saveFile() {
        File file = null;
        JFileChooser jfc = new JFileChooser();

        jfc.setCurrentDirectory(new File("."));

        jfc.setFileFilter(selectfile);
        // Set to a default name for save.
        jfc.setSelectedFile(xfile);

        // Open chooser dialog
        int result = jfc.showSaveDialog(this);

        if (result == JFileChooser.CANCEL_OPTION) {
            return true;
        }

        else if (result == JFileChooser.APPROVE_OPTION) {
            xfile = jfc.getSelectedFile();
            if (xfile.exists()) {
                int response = JOptionPane.showConfirmDialog(null,
                        "Overwrite existing file?", "Confirm Overwrite",
                        JOptionPane.

                                OK_CANCEL_OPTION, JOptionPane.

                                QUESTION_MESSAGE);
                if (response == JOptionPane.CANCEL_OPTION)
                    return false;
            }

            return (writeFile( xfile, mainContent.getText() ) && address.add( xfile
                    .getAbsolutePath() ));
        }

        else {
            return false;
        }
    }// end saveFile method



    public static boolean writeFile(File file, String dataString) {
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(
                    new FileWriter(file)));
            out.print(dataString);
            out.flush();
            out.close();

        } catch (IOException e) {
            return false;
        }

        return true;
    } // end


    public void nextBefore(ArrayList<String> nameOfFile) {
        try {
            FileInputStream fstream =

                    new FileInputStream(nameOfFile.get(startFrame));
            // Get the object of DataInputStream
            DataInputStream in =

                    new DataInputStream(fstream);
            BufferedReader br =

                    new BufferedReader(new InputStreamReader(in));
            String strLine;

            // Read File Line By Line
            String totalLines =

                    "";
            while ((strLine = br.readLine()) != null) {
                totalLines = totalLines + strLine +

                        "\n";
            }

            // print file on JTArea
            mainContent.setText(totalLines);
            in.close();

        }

        catch (Exception eBackForward) {
        }

    }


    public void anim() {

        go();
    }
} // end AsciiCanvas class


