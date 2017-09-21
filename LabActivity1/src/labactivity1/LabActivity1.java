package labactivity1;
import java.util.*;
public class LabActivity1 
{    
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner (System.in);
        System.out.println("Connecting to the database now.");
        System.out.println("Please enter the number of the feature you want to do: ");
        System.out.println("1: View entries in the database.");
        System.out.println("2: Add data to the table.");
        System.out.println("3: Update existing data.");
        System.out.println("4: Delete a specific user.");    

        int feature = scan.nextInt();
        
        ViewDatabase view = new ViewDatabase();
        
        switch(feature)
        {
            case 1:
            {
                view.viewDatabase();
                break; 
            }
            case 2:
            {
                AddToDatabase add = new AddToDatabase();
                add.addToTable();
                break;
            }
            case 3:
            {
                UpdateDatabase update = new UpdateDatabase();
                update.updateTable();
                break;
            }
            case 4:
            {
                DeleteFromDatabase delete = new DeleteFromDatabase();
                delete.deleteFromTable();
                break;
            }
        }
        
        System.out.println("Thank you for using the database!");
    }
}

                
     
