import java.util.ArrayList;
import java.util.SplittableRandom;

public class Mediaplayer {
    private ArrayList<Playlist> playlist;
    private Playlist mediaList;

    private String currentSong;

    private ArrayList<String>mp3File;
    private ArrayList<String>flvFile;
    private ArrayList<String>mp4File;
    private ArrayList<String>vlcFile;

    public Mediaplayer(){
        playlist = new ArrayList<Playlist>();

        mp3File = new ArrayList<String>();
        flvFile = new ArrayList<String>();
        mp4File=  new ArrayList<String >();
        vlcFile = new ArrayList<String>();
    }

    protected void setPlaylist(String name,int id){
        this.mediaList = new Playlist();
        mediaList.setPlaylistName(name);
        mediaList.setPlaylistID(id);
    }

    public void addSongToPlayList(String songName, String type){

        if(type.equalsIgnoreCase("MP4")) this.mediaList.addMP4File(songName);
        else if(type.equalsIgnoreCase("MP3")) this.mediaList.addMP3File(songName);
        else if(type.equalsIgnoreCase("VLC")) this.mediaList.addVLCFile(songName);
        else if(type.equalsIgnoreCase("FLV")) this.mediaList.addFLVFile(songName);
    }

    public void confirmPlayList(){
        addPlaylist(mediaList);
    }

    public void addPlaylist(Playlist p){
        this.playlist.add(p);
    }

    public Playlist getCurrentPlaylist(){
        return mediaList;
    }

    public void showCurrentPlaylist(Playlist p){
        p.showFiles();
    }

    public void addMP3File(String name){
        mp3File.add(name);
    }

    public void addFLVFile(ArrayList flvFile){
        this.flvFile = flvFile;
    }

    public void addMp4File(ArrayList mp4File){
        this.mp4File = mp4File;
    }

    public void addVLCFile(ArrayList vlcFile){
        this.vlcFile = vlcFile;
    }

    public String getSong(String song){
        for (String mp3 : mp3File){
            String name = mp3.split("/")[0].split("\\.")[0];
            String extension =mp3.split("/")[0].split("\\.")[1];

            if(name.equals(song.split("\\.")[0]) && extension.equalsIgnoreCase(song.split("\\.")[1])) return mp3;
        }

        for (String mp3 : mp4File){
            String name = mp3.split("/")[0].split("\\.")[0];
            String extension =mp3.split("/")[0].split("\\.")[1];

            if(name.equals(song.split("\\.")[0]) && extension.equalsIgnoreCase(song.split("\\.")[1])) return mp3;
        }

        for (String mp3 : vlcFile){
            String name = mp3.split("/")[0].split("\\.")[0];
            String extension =mp3.split("/")[0].split("\\.")[1];

            if(name.equals(song.split("\\.")[0]) && extension.equalsIgnoreCase(song.split("\\.")[1])) return mp3;
        }

        for (String mp3 : flvFile){
            String name = mp3.split("/")[0].split("\\.")[0];
            String extension =mp3.split("/")[0].split("\\.")[1];

            if(name.equals(song.split("\\.")[0]) && extension.equalsIgnoreCase(song.split("\\.")[1])) return mp3;
        }

        return null;
    }

    public void showFile(){
        for (String mp3 : mp3File) {
            System.out.println(mp3);
        }

        for (String flv: flvFile){
            System.out.println(flv);
        }

        for(String mp4: mp4File){
            System.out.println(mp4);
        }

        for (String vlc: vlcFile){
            System.out.println(vlc);
        }

        for (Playlist p : playlist){
            p.showFiles();
        }
    }

    public boolean searchSong(String name) {
        for (String mediaSong : mp3File) {
            String[] song = mediaSong.split("/");
            String[] song1 = song[0].split("\\.");
            if (name.split("\\.")[0].equals(song1[0]) && name.split("\\.")[1].equalsIgnoreCase("mp3")) return true;
        }

        for (String mediaSong : mp4File) {
            String[] song = mediaSong.split("/");
            String[] song1 = song[0].split("\\.");
            if (name.split("\\.")[0].equals(song1[0]) && name.split("\\.")[1].equalsIgnoreCase("mp4")) return true;
        }

        for (String mediaSong : vlcFile) {
            String[] song = mediaSong.split("/");
            String[] song1 = song[0].split("\\.");
            if (name.split("\\.")[0].equals(song1[0]) && name.split("\\.")[1].equalsIgnoreCase("vlc")) return true;
        }

        for (String mediaSong : flvFile) {
            String[] song = mediaSong.split("/");
            String[] song1 = song[0].split("\\.");
            if (name.split("\\.")[0].equals(song1[0]) && name.split("\\.")[1].equalsIgnoreCase("flv")) return true;
        }



        return false;
    }

    public void setCurrentSong(String song){
        this.currentSong = song;
    }

    public String getCurrentSong(){
        return this.currentSong;
    }
}
