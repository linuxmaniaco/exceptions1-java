package Application;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Model.entities.Reservation;
import Model.exceptions.DomainException;


public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");

		try {
			System.out.print("Room Number: ");
			int number = sc.nextInt(); sc.nextLine();
			System.out.print("check-In date (dd/MM/yyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("check-Out date (dd/MM/yyy): ");
			Date checkOut = sdf.parse(sc.next());
			
			
		
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.print("check-In date (dd/MM/yyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("check-Out date (dd/MM/yyy): ");
			checkOut = sdf.parse(sc.next());
		
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
		
		} catch(ParseException e) {
			System.out.println("Invalid Format");			
		} catch (DomainException e) {
			System.out.println("Error in reservation " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Unexpected Error");
		}
			
			
		
		
		sc.close();
		
	}

}
