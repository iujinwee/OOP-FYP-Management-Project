package Requests.RequestClasses;

import java.util.Scanner;

import Database.ProjectDB;
import Requests.Request;
import Requests.RequestStatus;
import Requests.RequestType;
import Users.UserDetails.*;

public class ChangeTitleRequest extends Request {

    private String newTitle;

    public ChangeTitleRequest(int requestID, User fromUser, User toUser, int projectID) {
        super(requestID, fromUser, toUser, RequestStatus.PENDING, RequestType.CHANGETITLE, projectID);

        Scanner sc = new Scanner(System.in);
        System.out.println("Input new project title:");
        newTitle = sc.next();

        super.setNewTitle(newTitle);
        sc.close();
    }

    // public void enactRequest(int choice){
    //     switch(choice){
    //         case 1:
    //             ProjectDB projDB = new ProjectDB();
    //             projDB.findInstance(getProjectID()).setProjectTitle(super.getNewTitle());

    //             projDB.exportDB();
    //             setRequestStatus(RequestStatus.APPROVED);
    //             break;

    //         case 0:
    //             setRequestStatus(RequestStatus.REJECTED);
    //             break;
                
    //         default:
    //             System.out.println("Invalid choice");
    //             break;
    //     }
    // }
}
