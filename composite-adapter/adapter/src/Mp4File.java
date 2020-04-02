import java.util.ArrayList;

public class Mp4File implements FileType{

    private String type;
    private ArrayList<String> mp4File;

    public Mp4File(){
        this.type = "MP4";
        mp4File = new ArrayList<String>();
    }

    @Override
    public String getType() {
        return this.type;

    }

    @Override
    public void addFile(String name) {
            this.mp4File.add(name);
    }

    @Override
    public ArrayList getFile() {
            return mp4File;
    }
}
