package constance;

public class SetBoundsJFrameMain {
//	static int screenWidth = 1920; // Độ phân giải ngang của màn hình (pixels)
//	static int screenHeight = 1080; // Độ phân giải dọc của màn hình (pixels)
	static int screenWidth = 1366; // Độ phân giải ngang của màn hình (pixels)
	static int screenHeight = 768; // Độ phân giải dọc của màn hình (pixels)


	static int windowWidth = (int) (screenWidth);
	static int windowHeight = (int) (screenHeight);


	static int windowX = (screenWidth - windowWidth) / 2; // Để đặt cửa sổ ở giữa màn hình theo chiều ngang
	static int windowY = (screenHeight - windowHeight) / 2; // Để đặt cửa sổ ở giữa màn hình theo chiều dọc
	//<==============================================================================>
	
	public static final int WINDOWX = windowX;
	public static final int WINDOWY = windowY;
	public static final int WINDOW_WIDTH = windowWidth;
	public static final int WINDOW_HEIGHT = windowHeight;
}
