import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Created by boazraz on 8/5/16.
 */
public class JavaFilter extends FileFilter {
    public boolean accept(File f) {
        return f.getName().toLowerCase().endsWith( ".txt" )
                || f.isDirectory();
    }

    public String getDescription () {
        return "Txt files (*.txt)";
    }
}
