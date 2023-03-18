package bjv.proiect.bookmanagementsys;

import bjv.proiect.bookmanagementsys.utils.SessionManager;

public class Main {
    public static void main(String[] args) {
        SessionManager.getSessionFactory().openSession();
        System.out.println("asdas");
        SessionManager.shutdown();
    }
}