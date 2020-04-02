import java.util.ArrayList;

public class FLVFile implements FileType {
    private String type;
    private ArrayList<String> flvFile;

    public FLVFile(){
        this.type = "FLV" ;
        flvFile = new ArrayList<String>();
    }
    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public void addFile(String name) {
        this.flvFile.add(name);
    }

    @Override
    public ArrayList getFile() {
        return flvFile;
    }
}
