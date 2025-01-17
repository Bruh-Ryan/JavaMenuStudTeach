import java.util.ArrayList;
import java.util.Scanner;

public class Teacher extends menu
//teachwer logicX here crazy!!!!
{
    private String name;
    private String[] Description;

    //constructure
    public Teacher() {
        // Initialize fields to default values
        this.name = "";
        this.Description = new String[5];
    }
    public Teacher(String name, String[]Description) {
        // Initialize fields to default values
        this.name = name;
        this.Description = Description;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(name).append("\nDescriptions: ");
        for (String i : Description) {
            sb.append(i).append(", ");
        }
        return sb.toString();
    }


     public String getName()
    {
        return name;
    }
    public void setDescription(String [] Description)
    {
        this.Description=Description;
    }

    public void teacherMainMenu()
    {
        System.out.println("Teacher Menu ::::");
        
        ArrayList<Teacher> TeacherList=new ArrayList<>();
        String description[]=new String[5];
        Scanner in=new Scanner(System.in);
        String findTeach;
        boolean whale=true;

        while(whale)
        {
            System.out.println("Choose option 1.create teacher DBMS\n 2.view teacher DBMS\n 3. update teacher description\n 4.delete teacher DBMS \n5.exit");
            int options=in.nextInt();
           
            switch (options) {
                
                case 1://create 
                System.out.print("how many teacher you want to add?\n");
                int add=in.nextInt();
                for(int n=0;n<add;n++)
                {
                    System.out.print("enter name: \n");
                    String name=in.next();
                    System.out.print("enter description of "+name+":");

                    for(int j=0;j<5;j++)
                    {
                        description[j]=in.nextLine();   
                    }
                    TeacherList.add(new Teacher(name, description));
                }
                    System.out.println("Saved!");
                    break;

                case 2://view all
                if (TeacherList.isEmpty()) {
                    System.out.println("No teachers available.");
                } else {
                    System.out.println("\nTeacher List:");
                    for (Teacher teacher : TeacherList) {
                        System.out.println(teacher);
                    }
                }
                break;
                
                
                case 3://update descriptions

                System.out.print("Enter Teacher name here:\n");
                findTeach= in.next();

                if (TeacherList.isEmpty()) {
                    System.out.println("No teachers available.");
                } else {
                for(Teacher i:TeacherList)
                {
                    if(i.getName().equalsIgnoreCase(findTeach))
                    {
                        System.out.println("Enter 5 updated Description::");
                        String[] newDescriptions = new String[5];
                        for (int j = 0; j < 5; j++) 
                        { 
                            newDescriptions[j] = in.nextLine();
                        }
                        i.setDescription(newDescriptions);

                        TeacherList.add(new Teacher(findTeach,newDescriptions));
                        System.out.println("Teacher updated successfully!");
                    }
                    

                }}

                case 4:
                System.out.print("Enter Teacher name here:\n");
                findTeach= in.next();

                if (TeacherList.isEmpty()) {
                    System.out.println("No teachers available.");
                } 
                else 
                {
                for(Teacher i:TeacherList)
                {
                    if(i.getName().equalsIgnoreCase(findTeach))
                    {
                        System.out.println("Teacher Found: "+i);
                        TeacherList.remove(i);
                        System.out.println("Removed!");
                    }
                }
            }
                break;

                case 5:
                whale=false;
                break;

                default:
                System.out.println(("Enter integer values for all type of operations"));
             }
            
            }  
            System.out.println("Thank You"); 
        }
        
    
}