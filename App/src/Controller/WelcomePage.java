package Controller;

import Boundaries.Menu.WelcomePageInterface;

public class WelcomePage implements WelcomePageInterface {
    
    public WelcomePage(){

        welcomePage();
    }
    
    public void welcomePage() {
        System.out.println("*******************************************************************************************************");
        System.out.println("**                                                                                                   **");
        System.out.println("**   █▀▀▀ ░█──░█ ░█▀▀█    ░█▀▄▀█ █▀▀█ █▀▀▄ █▀▀█ █▀▀▀ █▀▀ █▀▄▀█ █▀▀ █▀▀▄ ▀▀█▀▀    ─█▀▀█ ░█▀▀█ ░█▀▀█   **");
        System.out.println("**   █▀▀▀ ░█▄▄▄█ ░█▄▄█    ░█░█░█ █▄▄█ █──█ █▄▄█ █─▀█ █▀▀ █─▀─█ █▀▀ █──█ ──█──    ░█▄▄█ ░█▄▄█ ░█▄▄█   **");
        System.out.println("**   █─── ──░█── ░█───    ░█──░█ ▀──▀ ▀──▀ ▀──▀ ▀▀▀▀ ▀▀▀ ▀───▀ ▀▀▀ ▀──▀ ──▀──    ░█─░█ ░█─── ░█───   **");
        System.out.println("**                                                                                                   **");    
        System.out.println("*******************************************************************************************************");
    }
}
