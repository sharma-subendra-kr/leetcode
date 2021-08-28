// 1185. Day of the Week
// https://leetcode.com/problems/day-of-the-week/

class S1185 {
	public static void main (String[] args) {
		int day, month, year;

		day = 31;
		month = 8;
		year = 2019;

		// day = 18;
		// month = 7;
		// year = 1999;

		// day = 31;
		// month = 8;
		// year = 2100;

		day = 29;
		month = 2;
		year = 2000;

		String res = dayOfTheWeek(day, month, year);

		System.out.println(res);
	}

	public static String dayOfTheWeek (int day, int month, int year) {
		int monthToDays[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		String daysMap[] = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

		boolean isLeapYear = year % 4 == 0;

		int sum = (year - 1) * 365;
		sum += (year - 1) / 4;
		sum -= (year - 1) / 100;
		sum += (year - 1) / 400;

		int c = month - 2;
		while (c >= 0) {
			sum += monthToDays[c];
			c--;
		}

		if (month > 2 && (isLeapYear && year % 100 != 0) || month > 2 && year % 400 == 0) {
			sum += 1;
		}

		sum += day;

		int d = sum % 7;

		return daysMap[d];
	}
}