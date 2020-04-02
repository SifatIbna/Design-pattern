import java.util.Scanner;

public class ServerManagement {
    public static void main(String[] args) {

        Observer premiumUser = new Premium();
        Observer regularUser = new Regular();

        Company companyABC = new ABC_Company();
        Company companyDEF = new DEF_Company();

        ServerCondition op = new Operational();
        ServerCondition par = new PartiallyDown();
        ServerCondition ful = new FullyDown();

        ServerCondition currentServer = op;

        while (true){
          //  System.out.println("0.Operational Server 1.Partial Server 2.Full Server");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();

            if(choice == 0){
                ServerCondition operational = new Operational();

                premiumUser.setServerCondition(operational);
                regularUser.setServerCondition(operational);

                premiumUser.setCompanyCount(1);

                operational.addRegularObserver(regularUser);
                operational.addPremiumObserver(premiumUser);

                if(currentServer.equals(par)) {

                    operational.setPreviousServerCondition(par);

                    if(regularUser.isPay()) {
                        operational.setMsgForRegularUser("Regular user prompt: Now the server is operational again. Your total bill: x taka");
                        regularUser.setPay(false);
                    }

                    else operational.setMsgForRegularUser("Regular user prompt: Now the server is operational again.");

                    operational.setMsgForPremiumUser("Premium user prompt: Now the server is operational again.");
                    operational.postMessagePremiumUser();
                    operational.postMessageRegularUser();
                }

                else {
                    operational.setPreviousServerCondition(ful);
                    if(regularUser.isPay()) operational.setMsgForRegularUser("Regular user prompt: Now the server is operational again. Your total bill: x taka");
                    else operational.setMsgForRegularUser("Regular user prompt: Now the server is operational again.");

                    operational.setMsgForPremiumUser("Premium user prompt: Now the server is operational again.");
                    operational.postMessagePremiumUser();
                    operational.postMessageRegularUser();
                }

                currentServer = op;

            }

            else if(choice == 1) {
                ServerCondition partial = new PartiallyDown();

             //   premiumUser.setServerCondition(partial);
             //   regularUser.setServerCondition(partial);

                partial.setPreviousServerCondition(currentServer);

                if (op.equals(currentServer)) {
                    System.out.println("Premium user prompt: Server is partially down now. Do you want to use service from two servers (partially from the server of our company and partially from the server of DEF company) or from one server (server of DEF company)? \n" +
                            "Please choose:\n" +
                            "1. one server\n" +
                            "2. two servers");
                    Scanner serverChoice = new Scanner(System.in);
                    int userChoice = serverChoice.nextInt();

                    if (userChoice == 2) {
                        companyABC.addPartialFacilityUsers(premiumUser);
                        companyDEF.addPartialFacilityUsers(premiumUser);

                        premiumUser.addCompany(companyABC);
                        premiumUser.addCompany(companyDEF);
                        premiumUser.setCompanyCount(2);

                        partial.addPremiumObserver(premiumUser);
                      //  partial.setMsgForPremiumUser("You are using partial server facility form ABC company and other half from DEF Company");

                        premiumUser.setServerCondition(partial);
                        partial.postMessagePremiumUser();


                    } else if (userChoice == 1) {
                        companyDEF.addFullFacilityUsers(premiumUser);
                        premiumUser.addCompany(companyDEF);
                        premiumUser.setCompanyCount(1);

                       partial.addPremiumObserver(premiumUser);

                     //   partial.setMsgForPremiumUser("You are using Full Facility from DEF servers");

                        premiumUser.setServerCondition(partial);

                        partial.postMessagePremiumUser();

                    } else {
                        System.out.println("Invalid input");
                    }

                    System.out.println("Regular user prompt: Server is partially down now. Do you want to continue using the limited functionality or pay $20 per hour to enjoy the full functionality taking service from server of DEF company? In the 2nd case, all your data will be copied to the server of DEF company.\n" +
                            "Please choose:\n" +
                            "1. limited functionality\n" +
                            "2. pay for full functionality");
                    Scanner regularUserInput = new Scanner(System.in);

                    int regularUserChoice = regularUserInput.nextInt();

                    if (regularUserChoice == 1) {
                        companyABC.addPartialFacilityUsers(regularUser);
                        regularUser.addCompany(companyABC);
                        regularUser.setPay(false);
                        partial.addRegularObserver(regularUser);
                     //   partial.setMsgForRegularUser("You are using limited service");
                        regularUser.setServerCondition(partial);
                        partial.postMessageRegularUser();

                    } else if (regularUserChoice == 2) {

                        companyDEF.addFullFacilityUsers(regularUser);

                        regularUser.addCompany(companyDEF);
                        regularUser.setPay(true);
                        partial.addRegularObserver(regularUser);
                      //  partial.setMsgForRegularUser("Your data has been copied to DEF server");
                        regularUser.setServerCondition(partial);
                        partial.postMessageRegularUser();

                    } else System.out.println("Invalid choice");


                    currentServer = par;
                }

            }

            else if(choice == 2){
                ServerCondition fullyDown = new FullyDown();

             //   premiumUser.setServerCondition(fullyDown);
             //   regularUser.setServerCondition(fullyDown);

            //    fullyDown.addRegularObserver(regularUser);
            //    fullyDown.addPremiumObserver(premiumUser);

                if(currentServer.equals(op)){

                    fullyDown.setPreviousServerCondition(currentServer);
                    fullyDown.setMsgForPremiumUser("Premium user prompt: Server is fully down now. Service is now being provided by DEF company.");
                    premiumUser.addCompany(companyDEF);
                    companyDEF.addFullFacilityUsers(premiumUser);
                    premiumUser.setServerCondition(fullyDown);

                    fullyDown.addPremiumObserver(premiumUser);
                    fullyDown.postMessagePremiumUser();

                    System.out.println("Regular user prompt: Server is fully down now. Do you want to pay $20 per hour to take service from the server of DEF company? Note that, it will copy all your data to the server of DEF company.\n" +
                            "Please choose:\n" +
                            "1. yes, pay $20 per hour\n" +
                            "2. no");
                    Scanner userchoice = new Scanner(System.in);
                    int choiceFul = userchoice.nextInt();

                    if(choiceFul == 1){
                        companyDEF.addFullFacilityUsers(regularUser);
                        regularUser.addCompany(companyDEF);
                        regularUser.setPay(true);
                        fullyDown.addRegularObserver(regularUser);
                      //  fullyDown.setMsgForRegularUser("Your Service is now Provided by DEF SERVER and All your Data is copied to DEF Server");
                        regularUser.setServerCondition(fullyDown);

                        fullyDown.postMessageRegularUser();
                    }

                    else if(choiceFul == 2){
                    //    fullyDown.setMsgForRegularUser("Server is Down");
                        regularUser.setServerCondition(fullyDown);
                        regularUser.setPay(false);
                        fullyDown.addRegularObserver(regularUser);
                        regularUser.setServerCondition(fullyDown);

                        fullyDown.postMessageRegularUser();
                    }

                    currentServer = ful;

                }

                else {
                    fullyDown.setMsgForRegularUser("Regular user prompt: Server is fully down now.");

                    if(premiumUser.isPartial()) {
                        fullyDown.setMsgForPremiumUser("Premium user prompt: Server is fully down now. All of your services has been shifted to the server of DEF company.");
                    }
                    else fullyDown.setMsgForPremiumUser("Premium user prompt: Server is fully down now. Your service is now provided by DEF company");
                    fullyDown.setPreviousServerCondition(currentServer);

                    fullyDown.addPremiumObserver(premiumUser);
                    fullyDown.addRegularObserver(regularUser);
                    fullyDown.setPreviousServerCondition(currentServer);

                    premiumUser.setServerCondition(fullyDown);
                    regularUser.setServerCondition(fullyDown);

                    fullyDown.postMessagePremiumUser();
                    fullyDown.postMessageRegularUser();

                    currentServer = ful;
                }
            }

        }
    }
}
