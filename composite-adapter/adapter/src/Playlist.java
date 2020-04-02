import java.util.ArrayList;

public class Playlist {

    private String playlistName;
    private int playlistID;
    private double time;

    private ArrayList<String>mp3File;
    private ArrayList<String>flvFile;
    private ArrayList<String>mp4File;
    private ArrayList<String>vlcFile;

    private String currentSong;

    public Playlist(){
        this.mp3File = new ArrayList<String>();
        this.flvFile = new ArrayList<String>();
        this.mp4File = new ArrayList<String >();
        this.vlcFile = new ArrayList<String>();
        this.playlistID = 0;
        this.time = 0;
    }

    public void setCurrentSong(String song){
        this.currentSong = song;
    }
    public String getCurrentSong(){return this.currentSong; }

    public void setPlaylistID(int id){
        this.playlistID = id;
    }

    public void setPlaylistName(String name){
        this.playlistName = name;
    }

    public String getPlaylistName(){
        return this.getPlaylistName();
    }

    public int getPlaylistID(){
       return this.playlistID;
    }

    public void addMP3File(String name){
        String temp = name.split("/",3)[2];
        double minutes = Double.parseDouble(temp.split(":")[0]);
        double seconds = Double.parseDouble(temp.split(":")[1]);

        time = time+minutes+(seconds/60);
        this.mp3File.add(name);
    }

    public void addMP4File(String name){
        String temp = name.split("/",3)[2];
        double minutes = Double.parseDouble(temp.split(":")[0]);
        double seconds = Double.parseDouble(temp.split(":")[1]);

        time = time+minutes+(seconds/60);
        this.mp4File.add(name);
    }

    public void addFLVFile(String name){
        String temp = name.split("/",3)[2];
        double minutes = Double.parseDouble(temp.split(":")[0]);
        double seconds = Double.parseDouble(temp.split(":")[1]);

        time = time+minutes+(seconds/60);
        this.flvFile.add(name);
    }

    public void addVLCFile(String name){
        String temp = name.split("/",3)[2];
        double minutes = Double.parseDouble(temp.split(":")[0]);
        double seconds = Double.parseDouble(temp.split(":")[1]);

        time = time+minutes+(seconds/60);
        this.vlcFile.add(name);
    }

    public void showFiles(){

        System.out.println(this.playlistName+" "+this.playlistID);

        System.out.println("Total Time :" + getTime());

        for (String mp3: mp3File){
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
    }

    public double getTime(){
        return this.time;
    }

    public boolean checkSongExisting(String song){
        for (String mp3 : mp3File){
            String temp = mp3.split("/")[0];
            if(song.equalsIgnoreCase(temp)) return true;
        }

        for (String mp3 : mp4File){
            String temp = mp3.split("/")[0];
            if(song.equalsIgnoreCase(temp)) return true;
        }

        for (String mp3 : vlcFile){
            String temp = mp3.split("/")[0];
            if(song.equalsIgnoreCase(temp)) return true;
        }

        for (String mp3 : flvFile){
            String temp = mp3.split("/")[0];
            if(song.equalsIgnoreCase(temp)) return true;
        }

        return false;
    }
}
