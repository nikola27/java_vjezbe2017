package emailapp;

public class EmailApp {
    public static void main(String[] args){
        Email em1 =  new Email("John", "Smith");//preko konstruktora sve ovo ide
        //za ispis info
        System.out.println(em1.showInfo());




        //preko set i get
        //em1.setAlternateEmail("js@email.com");
        //System.out.println(em1.getAlternateEmail());
        //em1.changePassword();
        //em1.getMailboxCapacity()

    }
}
