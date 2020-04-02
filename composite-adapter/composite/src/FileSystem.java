public interface FileSystem {
    public void setName(String name);
    public boolean checkName(String name);
    public String getName();
    public void addFolders(Folders f);
    public void removeFolders(Folders f);
    public void addFiles(Files f);
    public void removeFiles(Files f);
    public boolean checkFolderName(String name);
    public boolean checkFileName(String name);
    public Folders getFolderObj(String name);
    public void showFilesAndFolders();
    public void addFolder(Folders f);
    public void setParentDrive(Drive d);
    public void setParentFolder(Folders f);
    public Folders getParentFolder();
    public Files getFileObj(String name);
    public void addDriveObj(Drive obj);
    public FileSystem getDriveObj(String name);
    public void removeDriveObj(FileSystem obj);
    public void showDrives();
    public void numOfLeaf();
    public int getNumOfLeaf();
}
