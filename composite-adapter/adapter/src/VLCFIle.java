import java.io.File;
import java.util.ArrayList;

public class VLCFIle implements FileType {

    private String type;
    private ArrayList<String> vlcFile;

    public VLCFIle(){
        this.type = "VLC";
        vlcFile = new ArrayList<>();
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public void addFile(String name) {
        this.vlcFile.add(name);
    }

    @Override
    public ArrayList getFile() {
        return this.vlcFile;
    }
}
