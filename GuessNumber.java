package com.company;
import java.util.*;
import java.util.Scanner;
class Game{
    int sysinput;
    int usrinput;
    int nog=0;
    Game(){
        Random random=new Random();
        this.sysinput=random.nextInt(100)+1;
    }
    public boolean takeuser(){
        if(nog<10){
            System.out.println("Guess the number: ");
            this.usrinput=GuessNumber.takeIntInp(100);
            nog+=1;
            return false;
        }
        else{
            System.out.println("No attempts left");
            return true;

        }
    }
    public boolean isGuess() {

        if (sysinput == usrinput) {
            System.out.println("Correct guess in "+nog+" attempts");
            switch (nog){
                case 1:
                    System.out.println("Your score is 100");break;
                case 2:
                    System.out.println("Your score is 90");break;
                case 3:
                    System.out.println("Your score is 80");break;
                case 4:
                    System.out.println("Your score is 70");break;
                case 5:
                    System.out.println("Your score is 60");break;
                case 6:
                    System.out.println("Your score is 50");break;
                case 7:
                    System.out.println("Your score is 40");break;
                case 8:
                    System.out.println("Your score is 30");break;
                case 9:
                    System.out.println("Your score is 20");break;
                case 10:
                    System.out.println("Your score is 10");break;

            }
            System.out.println();
            return true;
        }
        else if (nog<10 && usrinput>sysinput){
            if (usrinput-sysinput>10){
                System.out.println("Too High");
            }
            else {
                System.out.println("Little High");
            }
        }
        else if (nog<10 && usrinput<sysinput){
            if (sysinput-usrinput>10){
                System.out.println("Too Low");
            }
            else{
                System.out.println("Little Low");
            }

        }

        return false;
    }
}
public class GuessNumber{
    public static int takeIntInp(int lmt){
        int inp=0;
        boolean f=false;
        while (!f){
            try{
                Scanner in=new Scanner(System.in);
                inp=in.nextInt();
                f=true;
                if (f&&inp>lmt||inp<1){
                    System.out.println("Select number between 1 to 100: ");
                    f=false;
                }
            }
            catch (Exception e){
                System.out.println("Only integer values allowed");
                f=false;
            }
        };
        return inp;
    }
    public static void main(String[] args) {
        System.out.println("1. Start the game \n2. Exit");
        System.out.println("Enter your choice");
        int c=takeIntInp(2);
        int nxtrnd=1;
        int nornd=0;
        if (c==1){
            while (nxtrnd==1){
                Game g=new Game();
                boolean ismatched=false;
                boolean limit=false;
                System.out.println("\n----Round "+ ++nornd+"----");
                while (!ismatched && !limit){
                    limit=g.takeuser();
                    ismatched=g.isGuess();
                }
                System.out.println("1. Next Round\n2. Exit");
                System.out.println("Enter your choice: ");
                if(nxtrnd!=1){
                    System.exit(0);
                }
            }
        }
        else {
            System.exit(0);
        }
    }

}
