import java.io.File;
import java.util.ArrayList;

public class Drive implements FileSystem {

    private String name;
    private int numOfLeaf;
    private String path;

    private ArrayList<FileSystem> folderObj;
    private ArrayList<FileSystem> fileObj;

    public Drive(){
        name = null;
        numOfLeaf = 0;
        path = null;

        folderObj = new ArrayList<>();
        fileObj = new ArrayList<>();
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
    public void addDriveObj(Drive obj) {

    }

    @Override
    public FileSystem getDriveObj(String name) {
        return null;
    }

    @Override
    public void removeDriveObj(FileSystem obj) {

    }

    @Override
    public void showDrives() {

    }

    @Override
    public int getNumOfLeaf() {
        numOfLeaf();
            return this.numOfLeaf;
    }

    @Override
    public void numOfLeaf() {
        numOfLeaf = numOfLeaf+fileObj.size();
        for (FileSystem f : folderObj){
            numOfLeaf = numOfLeaf+f.getNumOfLeaf();
        }
    }

    public void addFolders(Folders f){
        folderObj.add(f);
    }

    public void removeFolders(Folders f){
        folderObj.remove(f);
    }

    public void addFiles(Files f){
        fileObj.add(f);
    }

    public void removeFiles(Files f){
        fileObj.remove(f);
    }

    public boolean checkFolderName(String name){
        for (FileSystem f :folderObj){
            Folders temp = (Folders)f;
            if(temp.checkName(name)) return true;
        }
        return false;
    }

    public boolean checkFileName(String name){

        for(FileSystem f: fileObj){
            Files temp = (Files)f;
            if(temp.getName().equals(name)) return true;

        }
        return false;
    }

    public Folders getFolderObj(String name){
        for(FileSystem f: folderObj){
            Folders temp = (Folders) f;
            if(temp.getName().equals(name)) return temp;
        }

        return null;
    }

    public Files getFileObj(String name){
        for (FileSystem f: fileObj){
            Files temp = (Files)f;
            if(temp.getName().equals(name)) return temp;

        }

        return null;
    }

    public void showFilesAndFolders(){
        System.out.println("Folders:");
        for (FileSystem f: folderObj)
        {
            System.out.println(f.getName()+"\n");
        }

        System.out.println("\n"+"Files:" );
        for (FileSystem f:fileObj){
            System.out.println(f.getName()+"\n");
        }
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean checkName(String name) {

        if(this.name.equals(name)) return true;

        return false;
    }

    @Override
    public String getName() {
        return this.name;
    }

}
