/*
Jeremy Richard Ikediashi & Kamsiyochuckwu Uwah
Assignment 2
3/12/2022
 */
import java.util.*;
import javax.swing.*;

public class PerceptionTest { 
    public static void main(String[] args) {
        String[] colors= {"red", "blue", "green", "yellow", "black"};
        String[] shapes = {"square", "circle", "star", "wavy", "plus"};
        String[] options = {"Color", "Shape", "Both", "Quit"};
        String[] end_options={"quit", "Another 5 trials"};
    
        
        Random randGen = new Random();
       
        int shape = randGen.nextInt(5);
        int color = randGen.nextInt(5);
        
        ImageIcon introIcon = new ImageIcon("psi_cards/unknown.png");
        String prompt= "Welcome to a perception test\n"
                + "The program displays the result from the cards guess by the user\n"
                + "The user is to select from options of colors shapes or both and guess the output\n"
                + "The program would result the number of correct guesses as a result";
        JOptionPane.showMessageDialog(null, prompt, 
                "Introduction                        Jeremy R.I & Kamsi Uwah",
                0, introIcon);
        
        ImageIcon testIcon= new ImageIcon("psi_cards/question.png");
        String perception_prompt= "Which perception test would you like to perform";
        int choice= JOptionPane.showOptionDialog(null, perception_prompt, "Choose test",
            0,0 ,testIcon, options, 3);
        int correct_guess = 0;
        int wrong_guess = 0;
        String color_prompt= "Your card has been generated\n"
                +  " What color do you percieve";
        String shape_prompt= "Your card has been generated\n"
                +  " What shape do you percieve";
        String shapeColor_prompt_two= "Your card has been generated\n"
                +  " You chose both shape and color!\n"
                +" Your second perception would be color\n"
                + " What color do you percieve";
        String shapeColor_prompt_one= "Your card has been generated\n"
                +  " You chose both shape and color!\n"
                +" Your first perception would be shape\n"
                + " What shape do you percieve";
        int score =0;
        int color_score=0;
        int shape_score=0;
        int backup_counter=0;
        while(true)
        {
        int counter =0;
        while (counter<5){
       
        switch(choice)
        {
            case 0:
            {
            int generated_color = randGen.nextInt(5);
            String computers_card= colors[color];
            int computers_choice = generated_color;
            int players_choice = JOptionPane.showOptionDialog(null,color_prompt ,
                    "Choose a color", 0, 0, introIcon, 
                    colors, colors[0]);
            
            ImageIcon generated_card = new ImageIcon("psi_cards/"+colors[computers_choice]
            +"AND"+ shapes[shape]+ ".png");
            if(computers_choice==players_choice)
            {
                JOptionPane.showMessageDialog(null,"Color perception\n"+
                    "    The card generated was "+
                    colors[computers_choice]
                  + "\n   You chose "+colors[players_choice]+
                    "\nGood perception on the color", 
                    "result", 0, generated_card);
            score++;
            color_score++;
            }
            else{
                JOptionPane.showMessageDialog(null,"Shape Perception\n"+
                        "    The card generated was "+colors[computers_choice]
                  + "\n    You chose "+colors[players_choice]+
                        "\nA bit off on this one", 
                    "result", 0, generated_card);
            }
            break;
            } 
            
            case 1:
            {
            int generated_shapes = randGen.nextInt(5);
            String computers_shapes= shapes[generated_shapes];
            int computers_choices_shapes = generated_shapes;
            int players_choice_shapes= JOptionPane.showOptionDialog(null,shape_prompt ,
                    "Choose a shape", 0, 0, introIcon, 
                    shapes, shapes[0]);
            
            ImageIcon generated_card_shapes = new ImageIcon("psi_cards/"+
                    colors[color]
            +"AND"+ shapes[computers_choices_shapes]+ ".png");
            
            if(computers_choices_shapes==players_choice_shapes)
            {
                JOptionPane.showMessageDialog(null,"The card generated was "+
                    shapes[computers_choices_shapes]
                  + "\nYou chose "+shapes[players_choice_shapes]+
                     "\nGood perception on the shape", 
                    "result", 0, generated_card_shapes);
            score++;
           
            }
            
            else{
                JOptionPane.showMessageDialog(null,"Shape Perception\n"+
                        "    The card generated was "+
                        shapes[computers_choices_shapes]
                  + "\n    You chose "+shapes[players_choice_shapes]+
                        "\nA bit off on this one", 
                    "result", 0, generated_card_shapes);
            }
            break;
            }
            
            case 2:
            {
            int generated_shapes_both = randGen.nextInt(5);
            int generated_colors_both=randGen.nextInt(5);
            String computers_shapes_both= shapes[generated_shapes_both];
            String computers_colors_both= shapes[generated_colors_both];
            int computers_choices_bothshapes = generated_shapes_both;
            int computers_choices_bothcolors = generated_colors_both;
            int players_choice_bothshapes= JOptionPane.showOptionDialog(null,
                    shapeColor_prompt_one ,
                    "Choose a shape", 0, 0, introIcon, 
                    shapes, shapes[0]);
            
             int players_choice_bothcolors= JOptionPane.showOptionDialog(null,
                     shapeColor_prompt_two ,
                    "Choose a color", 0, 0, introIcon, 
                    colors, colors[0]);
             
            ImageIcon generated_card_shapes = new ImageIcon("psi_cards/"+
                    colors[computers_choices_bothcolors]
            +"AND"+ shapes[computers_choices_bothshapes]+ ".png");
            
            if(computers_choices_bothshapes==players_choice_bothshapes &&
                    computers_choices_bothcolors == computers_choices_bothshapes)
            {
                JOptionPane.showMessageDialog(null,"Shape perception\n"+
                    "    The shape generated was "+
                    shapes[computers_choices_bothshapes]
                  + "\n    You chose "+shapes[players_choice_bothshapes]+
                     "\nGood perception on the shape"+"\nColor perception"
                    +"    The color generated was "+
                    colors[computers_choices_bothcolors]+ "\n    You chose "+
                   colors[players_choice_bothcolors]+
                     "\nGood perception on the colors" , 
                    "result", 0, generated_card_shapes);
            score++;
            color_score++;
            shape_score++;
            }
            
            else if(computers_choices_bothshapes==players_choice_bothshapes &&
                    computers_choices_bothcolors != players_choice_bothcolors)
            {
                JOptionPane.showMessageDialog(null,"Shape perception\n"+
                    "    The shape generated was "+
                    shapes[computers_choices_bothshapes]
                  + "\n    You chose "+shapes[players_choice_bothshapes]+
                     "\nGood perception on the shape"+"\nColor perception\n"
                    +"    The color generated was "+
                    colors[computers_choices_bothcolors]+ "\n    You chose "+
                   colors[players_choice_bothcolors]+
                     "\nA bit off on that one" , 
                    "result", 0, generated_card_shapes);
            shape_score++;
            }
            
            else if(computers_choices_bothshapes!=players_choice_bothshapes &&
                    computers_choices_bothcolors == players_choice_bothcolors)
            {
                JOptionPane.showMessageDialog(null,"Shape perception\n"+
                    "    The shape generated was "+
                    shapes[computers_choices_bothshapes]
                  + "\n    You chose "+shapes[players_choice_bothshapes]+
                     "\nA bit off on that one"+"\nColor perception\n"
                    +"    The color generated was "+
                    colors[computers_choices_bothcolors]+ "\n    You chose "+
                   colors[players_choice_bothcolors]+
                     "\nGood perception of the color" , 
                    "result", 0, generated_card_shapes);
            color_score++;
            }
            
            else{
                JOptionPane.showMessageDialog(null,"Shape Perception\n"
                        + "    The card generated was "+
                        shapes[computers_choices_bothshapes]
                  + "\n    You chose "+shapes[players_choice_bothshapes]+
                        "\nA bit off on this one "+"\nColor perception\n"
                    +"    The color generated was "+
                    colors[computers_choices_bothcolors]+ "\n    You chose "+
                   colors[players_choice_bothcolors]+
                     "\nA bit off on this one", 
                    "result", 0, generated_card_shapes);
            }
            break;           
        }
            default:
                JOptionPane.showMessageDialog(null, "The program is now ending!",
                "Termination screen", 0) ;
                System.exit(0);
               
    }
        counter++;
        backup_counter++;
    
    }
        if (choice==2){
            int end_choices=JOptionPane.showOptionDialog(null,
                    "You have entered "+
                    backup_counter  
                +" perceptions\n"+"    Your color score is "+color_score
                +"\n    Your shape score is  "+shape_score
                    +"\nYour got both correct "+score+" times", 
                    "Results so far!", 0, 0, testIcon
                , end_options, 0);
            if(end_choices==0){
            break;
        }
        }
        
        if (choice==1){
            int end_choices1=JOptionPane.showOptionDialog(null,
                    "You have entered "+
                    backup_counter  
                +" perceptions\n"+"Your shape score was "+score, 
                    "Results so far!",
                0, 0, testIcon
                , end_options, 0);
            if(end_choices1==0){
            break;
        }
            }
            
       if (choice==0){
       int end_choices2=JOptionPane.showOptionDialog(null,
                    "You have entered "+
                    backup_counter  
                +" perceptions\n"+"Your color score is "+score,
                    "Results so far!",
                0, 0, testIcon
                , end_options, 0);
            if(end_choices2==0){
            break;
        }
     }
   
       
}
         JOptionPane.showMessageDialog(null, "The program is now ending!",
                "Termination screen", 0);
}
}
