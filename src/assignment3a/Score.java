package assignment3a;

public class Score {
    static int rightScore = 0;
    static int leftScore = 0;
    
    static void setRightScore(String str){
        rightScore+=Integer.parseInt(str);
    }
    
    static void setRightScore(int num){
        rightScore+=num;
    }
    
    static void setLeftScore(String str){
        leftScore+=Integer.parseInt(str);
    }
    
    static void setLeftScore(int num){
        leftScore+=num;
    }
    
    static int getLeftScore(){
        return leftScore;
    }
    
    static int getRightScore(){
        return rightScore;
    }
    
    static void resetScore(){
        rightScore = 0;
        leftScore = 0;
    }
}