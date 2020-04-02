import java.io.File;
import java.util.ArrayList;

public class MediaPlayerAdapter implements FileType {

    private Mediaplayer mediaplayer;

    private FileType mp4FileType;
    private FileType vlcFileType;
    private FileType flvFileType;

    public MediaPlayerAdapter(){
        mediaplayer = new Mediaplayer();
    }

    public void setMp4FileType(Mp4File mp4File){
        this.mp4FileType = mp4File;
    }

    public void setVlcFileType(VLCFIle vlcfIle){
        this.vlcFileType = vlcfIle;
    }

    public void setFlvFileType(FLVFile flvFile){
        this.flvFileType = flvFile;
    }
    public void setMediaPlayer(Mediaplayer m){
        this.mediaplayer = m;
        getFile();

//        if(fileType.getType().equals("MP4")) {
//            mediaplayer.addMp4File(fileType.getFile());
//        }
//
//        else if(fileType.getType().equals("VLC")) {
//            mediaplayer.addVLCFile(fileType.getFile());
//        }
//
//        else if(fileType.getType().equals("FLV")) {
//            mediaplayer.addFLVFile(fileType.getFile());
//        }
    }


    @Override
    public String getType() {
        return null;
    }

    @Override
    public void addFile(String name) {

    }

    @Override
    public ArrayList getFile() {

        mediaplayer.addFLVFile(flvFileType.getFile());
        mediaplayer.addVLCFile(vlcFileType.getFile());
        mediaplayer.addMp4File(mp4FileType.getFile());

        return null;
    }
}
