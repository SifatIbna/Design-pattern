import java.util.Scanner;

public class MediaPlayerHandler {
    public static void main(String[] args) {

        int playListId = 0;

        Mediaplayer mediaplayer = new Mediaplayer();
        Mp4File mp4File = new Mp4File();
        VLCFIle vlcfIle = new VLCFIle();
        FLVFile flvFile = new FLVFile();

        MediaPlayerAdapter mediaPlayerAdapter = new MediaPlayerAdapter();

        while (true){
            System.out.println("1.Add Song 2.Open a song 3.Make Playlist ");
            Scanner inputForChoice = new Scanner(System.in);
            int choice = inputForChoice.nextInt();

            if(choice ==1) {

                mediaplayer.showFile();

                System.out.println("Song name :");
                Scanner inputForName = new Scanner(System.in);
                String fileName = inputForName.nextLine();

                String[] temp1 = fileName.split("\\.",2);
                if (temp1[1].equalsIgnoreCase("mp4") || temp1[1].equalsIgnoreCase("vlc") || temp1[1].equalsIgnoreCase("flv") || temp1[1].equalsIgnoreCase("mp3")) {
                    System.out.println("File Size (MB)");
                    Scanner inputForSize = new Scanner(System.in);
                    String fileSize = inputForSize.nextLine();

                    System.out.println("Time : (M:S)");
                    Scanner inputForDuration = new Scanner(System.in);
                    String fileDuration = inputForDuration.nextLine();

                    StringBuilder temp = new StringBuilder();
                    temp.append(fileName).append("/").append(fileSize).append("/").append(fileDuration);
                    String file = temp.toString();

                    if (temp1[1].equalsIgnoreCase("mp3")) mediaplayer.addMP3File(file);
                    else if (temp1[1].equalsIgnoreCase("mp4")) mp4File.addFile(file);
                    else if (temp1[1].equalsIgnoreCase("flv")) flvFile.addFile(file);
                    else if (temp1[1].equalsIgnoreCase("vlc")) vlcfIle.addFile(file);

                    mediaPlayerAdapter.setMp4FileType(mp4File);
                    mediaPlayerAdapter.setFlvFileType(flvFile);
                    mediaPlayerAdapter.setVlcFileType(vlcfIle);
                    mediaPlayerAdapter.setMediaPlayer(mediaplayer);

                    mediaplayer.showFile();

                }
                else {
                    System.out.println("Invalid Format");
                }
            }

            else if(choice == 2){
                mediaplayer.showFile();
                System.out.println("Enter the name of the file you want to open : ");
                Scanner inputSongOpen = new Scanner(System.in);
                String songOpen = inputSongOpen.nextLine();

                if(mediaplayer.searchSong(songOpen)) {
                    if(songOpen.equalsIgnoreCase(mediaplayer.getCurrentSong())) System.out.println("Song already Opened");
                    else {
                        mediaplayer.setCurrentSong(songOpen);
                        System.out.println("Currently Playing : "+songOpen);
                    }
                }

                else System.out.println("Song not found");
            }

            else if(choice == 3){
                playListId++;
                System.out.println("Enter the name of the playlist");
                Scanner input = new Scanner(System.in);
                String playlistName = input.nextLine();
                mediaplayer.setPlaylist(playlistName,playListId);
                mediaplayer.confirmPlayList();

                System.out.println("Playlist Created Successfully");

                playListId = playlistHandler(mediaplayer,playListId);
            }
        }
    }

    public static int playlistHandler(Mediaplayer mediaplayer,int playListId){
            int currentlyPlaying = 0;
        while (true){
            System.out.println("1.Add Song 2.Play Song 3.Add another playlist 4.exit the playlist");
            Scanner choiceInput = new Scanner(System.in);
            int choice = choiceInput.nextInt();

            if(choice == 1){

                mediaplayer.showFile();

                System.out.println("Enter the name of the song ");
                Scanner songName = new Scanner(System.in);
                String song = songName.nextLine();
                String temp = song.split("\\.",2)[1];
                if(mediaplayer.getCurrentPlaylist().checkSongExisting(song)) System.out.println("Song already been added");
                else {
                    if (temp.equalsIgnoreCase("mp3") || temp.equalsIgnoreCase("vlc") || temp.equalsIgnoreCase("flv") || temp.equalsIgnoreCase("mp4")) {
                        if (mediaplayer.searchSong(song)) {
                            if (temp.equalsIgnoreCase("mp3"))
                                mediaplayer.addSongToPlayList(mediaplayer.getSong(song), "mp3");
                            else if (temp.equalsIgnoreCase("mp4"))
                                mediaplayer.addSongToPlayList(mediaplayer.getSong(song), "mp4");
                            else if (temp.equalsIgnoreCase("vlc"))
                                mediaplayer.addSongToPlayList(mediaplayer.getSong(song), "vlc");
                            else mediaplayer.addSongToPlayList(mediaplayer.getSong(song), "flv");

                            System.out.println("File added successfully");
                        } else System.out.println("File not Found");
                    }

                    else System.out.println("Invalid Format");
                }
            }

            else if(choice == 2) {

                mediaplayer.getCurrentPlaylist().showFiles();

                System.out.println("Enter the name of the song :");
                Scanner songName = new Scanner(System.in);
                String song = songName.nextLine();
                String tempSong = mediaplayer.getCurrentPlaylist().getCurrentSong();
                if (song.equals(tempSong)) System.out.println("It's Playing ");
                else {
                    String temp = song.split("\\.",2)[1];
                    if (mediaplayer.searchSong(song)) {

                        if (temp.equalsIgnoreCase("mp3") || temp.equalsIgnoreCase("mp4") || temp.equalsIgnoreCase("vlc") || temp.equalsIgnoreCase("flv")) {
                            mediaplayer.getCurrentPlaylist().setCurrentSong(song);
                            System.out.println("Currently Playing : "+mediaplayer.getCurrentPlaylist().getCurrentSong());
                         //   System.out.println("Currently Playing : " + song);
                            currentlyPlaying++;
                        } else System.out.println("Invalid song");

                    } else System.out.println("File not found");
              }
            }

            else if(choice ==3) {
                if (currentlyPlaying == 0) {
                    playListId++;
                    System.out.println("Enter the name of playlist :");
                    Scanner newPLatLIst = new Scanner(System.in);
                    String newName = newPLatLIst.nextLine();

                    mediaplayer.setPlaylist(newName, playListId);
                    mediaplayer.confirmPlayList();

                    System.out.println("Playlist created successfully");
                } else {
                    double totalTimePlaylist = mediaplayer.getCurrentPlaylist().getTime();

                    System.out.println("Enter the elapsed time in minutes :");
                    Scanner timeInput = new Scanner(System.in);
                    double time = timeInput.nextDouble();

                    if (time < totalTimePlaylist) System.out.println("You can not add Playlist");
                    else {

                        playListId++;
                        System.out.println("Enter your new playlistName :");
                        Scanner newPLaylist = new Scanner(System.in);
                        String newName = newPLaylist.nextLine();

                        mediaplayer.setPlaylist(newName, playListId);
                        mediaplayer.confirmPlayList();
                        currentlyPlaying = 0;
                        System.out.println("PlayList Created Successfully");

                    }
                }
            }

            else if(choice ==4) {
                break;
            }

            else System.out.println("Invalid KeyWords");


        }

        return playListId;
    }
}
