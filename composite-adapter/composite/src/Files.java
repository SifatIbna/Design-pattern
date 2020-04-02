public class Files implements FileSystem{
    private String path;
    private String name;

    private Drive parentDrive;
    private Folders parentFolders;

    public Files(){
        name = null;
        path = null;

        parentDrive = new Drive();
        parentFolders = new Folders();
    }

    public void setParentDrive(Drive drive){
        parentDrive = drive;
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

    public void setParentFolders(Folders folders){
        parentFolders = folders;
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
    public int getNumOfLeaf() {
        return 0;
    }

    @Override
    public void numOfLeaf() {

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
}
