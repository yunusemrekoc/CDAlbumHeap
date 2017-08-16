import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TimeZone;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Main {
	public static String x;
	public static int seconds;
	static ArrayList<CD> array = new ArrayList<CD>();
	static int a[] = new int[100];

	// ---------------------------------------------------
	public static void display() {
		int x = 0;
		for (int i = 0; i < array.size(); i++) {
			for (int j = 0; j < Heap.sortedArray.length; j++) {
				if (array.get(j).totalTime.equals(getTime(Heap.sortedArray[i]))) {
					System.out.println(array.get(j).toString());
					x = 1;
				}// end if statement

			}
		}// end for loop
		if (x == 0) {
			System.out.println("not found");
		}

	}

	// --------------------------------------------------------

	public static String getTime(int data) {// The method converts the total
											// seconds of albums into date time
											// format

		TimeZone tz = TimeZone.getTimeZone("UTC");
		SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
		df.setTimeZone(tz);
		return df.format(new Date(data * 1000));
	}

	// ----------------------------------------------------

	public static void main(String[] args) throws IOException {
		int y = 0;// it is a flag to determine array size

		BufferedReader e = new BufferedReader(new FileReader(
				"C:\\Users\\seyma\\Desktop\\input.txt"));// reading input.txt
		x = e.readLine();
		while (x != null) {

			String split1[] = x.split(", ");
			if (split1.length != 4) {
				System.out.println("your text file is not correct!");
			}
			CD cd = new CD(split1[0], split1[1], Integer.parseInt(split1[2]),
					split1[3]);
			array.add(cd);
			String split2[] = cd.totalTime.split(":");
			int hour = Integer.parseInt(split2[0]);
			int min = Integer.parseInt(split2[1]);
			int second = Integer.parseInt(split2[2]);
			seconds = (hour * 3600) + (min * 60) + second; // calculate total
															// seconds for each
															// Audio CD
			a[y] = seconds;
			y++;

			x = e.readLine();

		}// end while loop
		e.close();// close file
		Heap h = new Heap(y);// create object for class heap
		h.constructHeap(a);
		h.sort();
		display();

	} // end main method
	// --------------------------------------------

	public static class CD {// Static inner class
		String title;
		String artist;
		int releaseDate;
		String totalTime;

		public CD(String title, String artist, int releaseDate, String totalTime) {// constructor

			this.title = title;
			this.artist = artist;
			this.releaseDate = releaseDate;
			this.totalTime = totalTime;
		}

		public String toString()// toString method for Audio CD
		{
			return title + " ," + totalTime;
		}// end of method

	}// end of CD class
}// end of Test class
// -----------------------------------------------------