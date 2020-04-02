import java.io.File;
import java.util.ArrayList;

public class Management implements  FileSystem{

    private ArrayList<FileSystem> driveObj;
    private int leafCount;

    public Management(){
        leafCount = 0;
        driveObj = new ArrayList<>();
    }

    public void addDriveObj(Drive obj){
        driveObj.add(obj);
    }

    public FileSystem getDriveObj(String name)
    {
        for(FileSystem d:driveObj){
            if(d.getName().equals(name)) return d;
        }
        return null;
   }
    public void removeDriveObj(FileSystem obj){
        driveObj.remove(obj);
    }

    public void showDrives(){
        for(FileSystem d: driveObj){
            System.out.println(d.getName()+"\n");
        }
    }

    @Override
    public void numOfLeaf() {

    }

    @Override
    public int getNumOfLeaf() {
        return 0;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public boolean checkName(String name) {
        for (FileSystem d : driveObj) {
            if(d.checkName(name)) return true;
        }
        return false;
    }

    @Override
    public String getName() {

        return null;
    }

    @Override
    public void addFolders(Folders f) {

    }

    @Override
    public void removeFolders(Folders f) {

    }

    @Override
    public void addFiles(Files f) {

    }

    @Override
    public void removeFiles(Files f) {

    }

    @Override
    public boolean checkFolderName(String name) {
        return false;
    }

    @Override
    public boolean checkFileName(String name) {
        return false;
    }

    @Override
    public Folders getFolderObj(String name) {
        return null;
    }

    @Override
    public void showFilesAndFolders() {

    }

    @Override
    public void addFolder(Folders f) {

    }

    @Override
    public void setParentDrive(Drive d) {

    }

    @Override
    public void setParentFolder(Folders f) {

    }

    @Override
    public Folders getParentFolder() {
        return null;
    }

    @Override
    public Files getFileObj(String name) {
        return null;
    }
}
