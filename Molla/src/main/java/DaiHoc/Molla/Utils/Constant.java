package DaiHoc.Molla.Utils;

public class Constant {
	public static int productPerPage = 16;
	public static enum eSortby{
		ASCENDING,
		POPULARITY,
		RATING,
		DATE
	}
	public static String vnp_ReturnUrl = "http://localhost:8081/vnpay-return";
	public static enum eRole{
		ADMIN,
		CUSTOMER
	}
}
