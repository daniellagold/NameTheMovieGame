package com.techelevator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class NameTheSong {
    static int score = 0;
    public static void main(String[] args) throws FileNotFoundException, JavaLayerException {


        System.out.println("\n");
        System.out.print("** Welcome to Name The Movie #DISNEY_EDITION. When prompted with a name of a song, choose the movie the song is from. There will be 10 questions, and in order to win, you need to get at least 8 correct. Good luck!**\n");

        questions(1, "Let It Go", "a. Frozen   b. Sleeping Beauty   c. Good Luck Charlie   d. Camp Rock", "a", "Let It Go.mp3");
        questions(2, "A Night To Remember", "a. The Lion King   b. KC Undercover   c. High School Musical   d. Aladidn", "c", "HSM.mp3");
        questions(3, "Set It Off", "a. Cinderella   b. Descendants   c. Zombies   d. Shake It Up", "b", "Set It Off.mp3");
        questions(4, "You're Welcome", "a. Beauty And The Beast   b. 101 Dalmatians   c. Ant Farm   d. Moana", "d", "Youre Welcome.mp3");
        questions(5, "Wildside", "a. Smart House   b. Twitches   c. Adventures In Babysitting   d. Tangled", "c", "Wildside.mp3");
        questions(6, "Surf's Up", "a. Wizards Of Waverly Place   b. Teen Beach   c. Hanna Montana   d. The Little Mermaid", "b", "Surfs Up.mp3");
        questions(7, "I Just Can't Wait To Be King", "a. The Lion King   b. Alice In Wonderland   c. Dumbo   d. Toy Story", "a", "Lion King.mp3");
        questions(8, "I'll Make A Man Out Of You", "a. Pocahontas   b. Mary Poppins   c. Mulan   d. The Aristocrats", "c", "Mulan.mp3");
        questions(9, "Can't Back Down", "a. The Cheetah Girls   b. Princess Protection Program   c. Starstruck   d. Camp Rock", "d", "Camp Rock.mp3");
        questions(10, "Under The Sea", "a. Encanto   b. The Little Mermaid   c. Enchanted   d. Pinocchio", "b", "Under The Sea.mp3");

        if (score>=8){
            System.out.println("CONGRATS! You won! You are a DISNEY super star!!");

        } else if (score == 7){
            System.out.println("YOU WERE SO CLOSE!!!! Try again!");

        } else {
            System.out.println("AWWWW! Better luck next time!");
        }
    }

    private static void questions(int questionNumber, String nameOfSong, String answers, String correctAnswer, String songName) throws FileNotFoundException, JavaLayerException {

        System.out.println(" ");
        System.out.print("Number "+ questionNumber+ ": ");
        System.out.print(nameOfSong+ "\n--------------------------------- \n" + answers);


        Scanner answer = new Scanner(System.in);
        System.out.print("\n \n Choose the correct answer, followed by the enter key: a, b, c, or d. ");
        String answerString = answer.nextLine();


        if (answerString.equals(correctAnswer)){
            System.out.println("CORRECT!");
            score +=1;

            FileInputStream song = new FileInputStream(songName);
            Player playmp3 = new Player (song);
            playmp3.play();
            System.out.println("SCORE: "+ score);
        } else {
            System.out.println("INCORRECT");

            FileInputStream incorrect = new FileInputStream("Buzzer.mp3");
            Player playmp3 = new Player (incorrect);
            playmp3.play();
            System.out.println("SCORE: "+ score);

        }
    }

}
