import java.util.Scanner;

class VotingAge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i=1; i<=10; i++){
            System.out.println("Enter age of student " + i + ":");
            int age = sc.nextInt();
            
            if(age>=18){
                System.out.println("Student " + i + " can vote");
            }
            else{
                System.out.println("Student " + i + " cannot vote");
            }            
        }
    }
}
