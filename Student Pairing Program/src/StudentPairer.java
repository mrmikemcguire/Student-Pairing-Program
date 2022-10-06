import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentPairer
	{
	static Scanner file;
	static ArrayList <String> studentRoster = new ArrayList <String>();
	
	public static void main(String[] args) throws IOException
		{
		importRoster();
		displayRoster();
		pairStudents();
		}
	
	private static void importRoster() throws IOException
		{
		System.out.println("Which class is presenting?");
		System.out.println("(1) AP  (2) Java");
		Scanner userInput = new Scanner (System.in);
		int period = userInput.nextInt();
		if (period == 1)
			{
			file = new Scanner(new File("AP_2022_23.txt"));
			}
		else if (period == 2)
			{
			file = new Scanner(new File("Java_2022_23_tri1.txt"));
			}
		else
			{
			System.out.println("Sorry, but you must choose either (1) or (2)");
			System.out.println();
			importRoster();
			}
		while (file.hasNext())
			{
			studentRoster.add(file.nextLine());
			}
		}
	
	private static void displayRoster()
		{
		for(int i = 0; i < studentRoster.size(); i++)
			{
			System.out.println((i + 1) + ")  " + studentRoster.get(i));
			}
		}
	
	private static void pairStudents()
		{
		System.out.println("\nThe student pairings are:\n");
		while (studentRoster.size() > 0)
			{
			if (studentRoster.size() > 1)
				{
				for (int i = 0; i < 2; i++)
					{
					int randomNumber = (int) (Math.random() * studentRoster.size());
					System.out.println(studentRoster.get(randomNumber));
					studentRoster.remove(randomNumber);	
					}

				Scanner fake = new Scanner(System.in);
				String fakeVariable = fake.nextLine(); 			
				}
			else
				{
				System.out.println("And " + studentRoster.get(0) + " will join the last pair.");
				System.exit(0);
				}

			}
		System.out.println("That should be everyone.");
		
		}

	}
