import java.io.File;
import java.util.Scanner;

public class SystemManager {
    public static void main(String[] args) {

        Management management = new Management();


        FileSystem currentDrive = new Drive();
        Folders currentFolders = new Folders();

        int folderCount = 0;
        int fileCount = 0;
        int driveCount = 0;



        while(true) {

            System.out.println("1.Add Drive 2.Go to 3.Delete Drive");
            Scanner input = new Scanner(System.in);
            int user = input.nextInt();
            if(user == 1) {
                Drive obj = new Drive();

                System.out.println("Enter the name of the Drive");
                Scanner input1 = new Scanner(System.in);
                String driveName = input1.nextLine();
                if (driveName.equals(" ")) System.out.println("Name can not be empty");
                else {
                    obj.setName(driveName);


                    if (management.checkName(driveName)) {
                        System.out.println("This name is already taken");

                    } else {
                        System.out.println("Drive Added Successfully :D ");
                        management.addDriveObj(obj);
                        driveCount++;
                    }


                }
            }

            else if(user == 2) {
                System.out.println("Enter The name of the drive you want to go");
                Scanner input2 = new Scanner(System.in);
                String driveName = input2.nextLine();

                currentDrive = DriveGoto(management, driveName);

                if (currentDrive != null) {
                    //start Here
                //    System.out.println("You are in Inside "+currentDrive.getName()+"drive");
                    System.out.println("Details of "+currentDrive.getName());
                    System.out.println("Name :"+currentDrive.getName()+"\n"
                    +"Type: "+"Drive"+"\n"+"Directory: "+currentDrive.getName()+":\\"+"\n"+
                            "Component Count: "+currentDrive.getNumOfLeaf());
                    driveCount++;
                    while (true) {
                        currentDrive.showFilesAndFolders();
                        System.out.println("1.Add Folders 2.Add Files  3.Go to a Folder 4.Remove folder 5.Remove File 6.Back");
                        int optionChoice = input.nextInt();

                        if (optionChoice == 1) {
                            FolderInsideDrive(currentDrive, currentFolders);
                            //folderCount++;
                        } else if (optionChoice == 2) {
                            FileInsideDrive(currentDrive, currentFolders);
                            fileCount++;
                        } else if (optionChoice == 3) {
                            System.out.println("Enter the name of the folder");
                            Scanner folderInput = new Scanner(System.in);
                            String folderName = folderInput.nextLine();
                            currentFolders = FolderGoto(currentDrive, folderName);

                            if (currentFolders == null) {
                                System.out.println("Enter the correct name :V");
                            }

                            else {
                             //   System.out.println("You are inside "+currentFolders.getName()+"folder");
                                System.out.println("Name :"+currentFolders.getName()+"\n"+
                                        "Type :Folder"+"Directory : "+currentDrive.getName()+":\\"+currentFolders.getName()+"\n"+
                                        "Component Count : "+currentFolders.getNumOfLeaf());
                                folderCount++;
                                FolderManagement(currentFolders, currentDrive, folderCount, fileCount);
                            }
                        }

                        else if(optionChoice == 4){
                            currentDrive.showFilesAndFolders();

                            System.out.println("Enter the name of the folder you want to remove :D ");
                            Scanner remove = new Scanner(System.in);
                            String removeFolder = remove.nextLine();

                            Folders temp = currentDrive.getFolderObj(removeFolder);
                            if(temp == null) System.out.println("Folder not found");
                            else {
                               currentDrive.removeFolders(temp);
                                System.out.println("Folder Removed :( ");
                            }
                        }

                        else if(optionChoice == 5){
                            currentDrive.showFilesAndFolders();
                            System.out.println("Enter the name : ");
                            Scanner removeFile = new Scanner(System.in);
                            String removeFiles = removeFile.nextLine();

                            Files temp = currentDrive.getFileObj(removeFiles);

                            if(temp == null) System.out.println("Invalid Name");
                            else {
                                currentDrive.removeFiles(temp);
                                System.out.println("File removed Successfully");
                            }
                        }

                        else if(optionChoice == 6) {
                            management.showDrives();
                            folderCount =0;
                           // folderCount--;
                            break;
                        }

                        else {
                            System.out.println("Enter a valid input");
                        }

                    }
                }

                else {
                    System.out.println("Drive Name is incorrect");
                }
            }

            else if(user == 3) {
                management.showDrives();
                System.out.println("Enter the name ");
                Scanner deleteDrive = new Scanner(System.in);
                String deleteDriveName = deleteDrive.nextLine();
                FileSystem removeDrive = management.getDriveObj(deleteDriveName);
                if(removeDrive == null) System.out.println("Drive is not found");
                else{
                    management.removeDriveObj(removeDrive);
                    System.out.println("Drive removed successfully :( ");
                }
            }

            else{
                System.out.println("Enter a valid input");
            }
        }
    }

    public static void FolderManagement(Folders folder,FileSystem Drive,int folderCount,int fileCount){
        while (true){
            folder.showFilesAndFolders();
            System.out.println("1.Add Folders 2.Add Files 3.Go to a folder 4.Remove Folders 5.Remove Files 6.Back");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();

            if(choice ==1){
                FolderInsideFolder(folder,Drive);
               // folderCount++;
            }

            else if(choice ==2){
                FileInsideFolder(folder,Drive);
                fileCount++;
            }

            else if(choice ==3){
                System.out.println("Enter the name ");
                Scanner in = new Scanner(System.in);
                String folName = in.nextLine();

                Folders temp = FolderToFolderGoto(Drive,folder,folName);
                if(temp == null) System.out.println("Name is incorrect");
                else {
                  //  System.out.println("you are inside "+temp.getName()+"folder");
                    folder = temp;
                    System.out.println("Name : "+folder.getName()+"\n"+
                            "Type : Folder");
                    System.out.println("Directory : "+folder.getName());
                    while (true){
                        temp = temp.getParentFolder();
                        if(temp == null){System.out.println(Drive.getName());break;}
                        else {
                            System.out.println(temp.getName());
                        }
                    }
                    folderCount++;
                }
            }

            else if(choice == 4){
                System.out.println("Enter the name ");
                Scanner folderRemove = new Scanner(System.in);
                String removeFolderName = folderRemove.nextLine();
                Folders temp = folder.getFolderObj(removeFolderName);
                if(temp == null) System.out.println("Folder not found");
                else{
                    folder.removeFolder(temp);
                    System.out.println("Folder removed successfully");
                }
            }

            else if(choice ==5) {
                System.out.println("Enter the name ");
                Scanner fileRemove = new Scanner(System.in);
                String removeFileName = fileRemove.nextLine();
                Files temp = folder.getFileObj(removeFileName);
                if(temp == null) System.out.println("File not found");
                else{
                    folder.removeFile(temp);
                    System.out.println("File removed successfully");
                }
            }

            else if(choice ==6 && folderCount>0){
                folder = folder.getParentFolder();
                folderCount--;
            }

            else System.out.println("Unvalid");

            if(folderCount ==0) break;
        }
    }

    public static Folders FolderToFolderGoto(FileSystem drive,Folders fol,String name){
            Folders folders = fol.getFolderObj(name);
            return folders;
    }

    public static Folders FolderGoto(FileSystem drive,String foldername){
        Folders temp  = drive.getFolderObj(foldername);
        return temp;
    }

    public static FileSystem DriveGoto(Management m,String driveName){
            FileSystem temp = m.getDriveObj(driveName);
            return temp;
    }

    public static void FileInsideDrive(FileSystem obj,Folders fol){
        Files newFile = new Files();

        System.out.println("Enter a name for the File");

        Scanner input = new Scanner(System.in);
        String  newFileName = input.nextLine();

        newFile.setName(newFileName);
       // obj.addFiles(newFile);

        if(obj.checkFileName(newFileName)){
            System.out.println("File name is already taken :v");
           // obj.removeFiles(newFile);
        }

        else {
            System.out.println("File added successfully");
            obj.addFiles(newFile);
            newFile.setParentDrive((Drive)obj);
            newFile.setParentFolders(fol);
        }

    }

    public static void FolderInsideDrive(FileSystem obj,Folders fol){
        Folders newFolder = new Folders();

        System.out.println("Enter a name for the Folder");

        Scanner input = new Scanner(System.in);
        String newFolderName = input.nextLine();

        newFolder.setName(newFolderName);
       // obj.addFolders(newFolder);

        if(obj.checkFolderName(newFolderName)){
            System.out.println("This name is already taken :V");
           // obj.removeFolders(newFolder);
        }

        else {
            System.out.println("Folder added successfully");
            obj.addFolders(newFolder);
            newFolder.setParentDrive((Drive)obj);
            newFolder.setParentFolder(fol);
        }
    }

    public static void FolderInsideFolder(Folders folders,FileSystem drive){
        Folders newFolder = new Folders();

        System.out.println("Enter a name for the folder");

        Scanner input = new Scanner(System.in);
        String newFolderName = input.nextLine();

       // newFolder.setName(newFolderName);
       // folders.addFolder(newFolder);

        if(folders.checkFolderName(newFolderName)){
            System.out.println("This name already taken :V");
           // folders.removeFolder(newFolder);
        }

        else {
            System.out.println("Folder added successfully");
            newFolder.setName(newFolderName);
            folders.addFolder(newFolder);
            newFolder.setParentFolder(folders);
            newFolder.setParentDrive((Drive)drive);
        }

    }

    public static void FileInsideFolder(Folders folders,FileSystem drive){
            Files newFile = new Files();

        System.out.println("Enter a name of the File");

        Scanner input = new Scanner(System.in);
        String newFileName = input.nextLine();

       // newFile.setName(newFileName);
      //  folders.addFiles(newFile);

        if(folders.checkFileName(newFileName)) {
            System.out.println("Name is already taken :V");
          //  folders.removeFile(newFile);
        }

        else {
            System.out.println("File added successfully");
            newFile.setName(newFileName);
            folders.addFiles(newFile);
            newFile.setParentFolders(folders);
            newFile.setParentDrive((Drive)drive);
        }
    }
}
