import java.util.Scanner; 

class marks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);       
        System.out.println("Enter marks for physics chemistry and math");
        double physicsMarks = sc.nextInt();
        double chemistryMarks = sc.nextInt();
        double mathMarks = sc.nextInt();
        double avgMarks = (physicsMarks + chemistryMarks + mathMarks)/3;
        //System.out.print(avgMarks);
        
        if(avgMarks >= 80){
            System.out.println("Obtained grade A \nLevel 4 -> Above agency-normalised standards ");
        }
        else if(avgMarks >= 70 || avgMarks <=79){
            System.out.println("Obtained grade B \nLevel 3 -> Agency-normalised standards ");
        }
        else if(avgMarks >= 60 || avgMarks <=69){
            System.out.println("Obtained grade C \nLevel 2 -> Approaching agency-normalised standards ");
        }
        else if(avgMarks >= 50 || avgMarks <=59){
            System.out.println("Obtained grade D \nLevel 1 -> Below agency-normalised standards ");
        }
        else if(avgMarks >= 40 || avgMarks <=49){
            System.out.println("Obtained grade E \nLevel 1- -> Too below agency-normalised standards ");
        }
        else{
            System.out.println("Obtained grade R \nRemedial Standards");
        }
    }
}
