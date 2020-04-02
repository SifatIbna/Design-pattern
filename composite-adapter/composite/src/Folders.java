import java.io.File;
import java.util.ArrayList;

public class Folders implements FileSystem {

    private String name;
    private String path;
    private int numOfLeaf;

    private Drive parentDrive;
    private Folders parentFolder;

    private ArrayList<FileSystem> folderObj;
    private ArrayList<FileSystem> fileObj;

    public Folders(){
        name = null;
        path = null;
        numOfLeaf = 0;

        folderObj = new ArrayList<>();
        fileObj = new ArrayList<>();
    }

    public Folders(Folders fo,Files fi){
        folderObj.add(fo);
        fileObj.add(fi);
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
    public void addFolders(Folders f) {

    }

    @Override
    public void removeFolders(Folders f) {

    }

    @Override
    public void removeFiles(Files f) {

    }

    public void addFolder(Folders f){
        folderObj.add(f);
    }

    public void addFiles(Files f){
        fileObj.add(f);
    }

    public void removeFolder(Folders f){
        folderObj.remove(f);
    }

    public void removeFile(Files f){
        fileObj.remove(f);
    }

    public boolean checkFolderName(String name){
        for(FileSystem f:folderObj){
            Folders temp = (Folders)f;
            if(temp.getName().equals(name)) return true;
        }
        return false;
    }

    public boolean checkFileName(String name){

        for (FileSystem f: fileObj){
            Files temp = (Files)f;
            if(temp.getName() == name) return true;
        }
        return false;
    }

    public void setParentDrive(Drive d){
        this.parentDrive = d;
    }

    public void setParentFolder(Folders f){
        this.parentFolder = f;
    }

    public Folders getParentFolder()
    {
        return this.parentFolder;
    }

    public Folders getFolderObj(String name){
        for (FileSystem f:folderObj){
            Folders temp = (Folders)f;
            if(f.getName().equals(name)) return temp;
        }
        return null;
    }

    public Files getFileObj(String name){
        for (FileSystem f : fileObj){
            Files temp = (Files)f;
            if(f.getName().equals(name)) return temp;

        }

        return null;
    }

    public void showFilesAndFolders(){
        System.out.println("Folders :");
        for(FileSystem f: folderObj){
            System.out.println(f.getName()+"\n");
        }

        System.out.println("\n"+"Files : ");
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

    @Override
    public void numOfLeaf() {
        numOfLeaf = numOfLeaf+fileObj.size();
        for (FileSystem f :folderObj){
            numOfLeaf = numOfLeaf+f.getNumOfLeaf();
        }
    }

    @Override
    public int getNumOfLeaf() {
        numOfLeaf();
        return this.numOfLeaf;
    }
}
