package Busres;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Booking {
	String PassengerName;
	int busno;
	Date date;
	Booking(){
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter name of passenger: ");
		PassengerName=scanner.next();
		System.out.println("Enter bus no: ");
		busno =scanner.nextInt();
		System.out.println("Enter date dd-mm-yyyy");
		String dateInput=scanner.next();
		SimpleDateFormat dateFormat =new SimpleDateFormat("dd-mm-yyyy");
		
		try {
			date = dateFormat.parse(dateInput);
		}catch(ParseException e) {
			e.printStackTrace();
		}
	}
	public boolean isAvailable(ArrayList<Booking> bookings, ArrayList<Bus> buses) {
		int capacity =0;
		for(Bus bus:buses) {
			if(bus.getbusno() == busno)
				capacity =bus.getcapacity();
		}
		int booked=0;
		for(Booking b:bookings) {
			if(b.busno ==busno && b.date.equals(date)) {
		
				booked++;
			}
		}
		return booked<capacity?true:false;
	}
}
	


