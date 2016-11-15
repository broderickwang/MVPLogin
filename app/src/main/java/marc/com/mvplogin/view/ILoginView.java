package marc.com.mvplogin.view;

/**
 * Created by Broderick on 2016/11/15.
 */

public interface ILoginView {
	void loginResult(boolean result,int code);
	void clean();
}
