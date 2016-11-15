package marc.com.mvplogin.presenter;

import marc.com.mvplogin.view.ILoginView;

/**
 * Created by Broderick on 2016/11/15.
 */

public class LoginPresenterImpl implements ILoginPresenter {
	private ILoginView loginView;

	public LoginPresenterImpl(ILoginView loginView) {
		this.loginView = loginView;
	}

	@Override
	public void clear() {
		loginView.clean();
	}

	@Override
	public void doLogin(String name, String pwd) {
		if("abc".equalsIgnoreCase(name)&&"123".equalsIgnoreCase(pwd))
			loginView.loginResult(true,1);
		else
			loginView.loginResult(false,0);
	}
}
