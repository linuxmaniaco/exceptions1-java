package Application;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Model.entities.Reservation;


public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");

		System.out.print("Room Number: ");
		int number = sc.nextInt(); sc.nextLine();
		System.out.print("check-In date (dd/MM/yyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("check-Out date (dd/MM/yyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Error in Reservations: Check-Out date must be after check-In date");
		} else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.print("check-In date (dd/MM/yyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("check-Out date (dd/MM/yyy): ");
			checkOut = sdf.parse(sc.next());
			
			Date now  = new Date();
			if (checkIn.after(now) || checkOut.after(now)) {
				System.out.println("Erro in reservation: Reservation dates for update must be future dates.");
			} else if (!checkOut.after(now) || !checkIn.after(now)) {
				System.out.println("Erro in reservation: Reservation dates for update must be future dates.");
			} else {
				reservation.updateDates(checkIn, checkOut);
				System.out.println("Reservation: " + reservation);
			}
			
			
			
		}
		
		sc.close();
		
	}

}