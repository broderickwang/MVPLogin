package marc.com.mvplogin.view;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import marc.com.mvplogin.R;
import marc.com.mvplogin.presenter.ILoginPresenter;
import marc.com.mvplogin.presenter.LoginPresenterImpl;

public class LoginActivity extends AppCompatActivity
					implements ILoginView, View.OnClickListener{

	private ILoginPresenter loginPresenter;

	private android.widget.EditText name;
	private android.widget.EditText pwd;
	private android.widget.Button login;
	private android.widget.Button clean;
	private android.support.constraint.ConstraintLayout activitymain;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		this.clean = (Button) findViewById(R.id.clean);
		this.login = (Button) findViewById(R.id.login);
		this.pwd = (EditText) findViewById(R.id.pwd);
		this.name = (EditText) findViewById(R.id.name);

		login.setOnClickListener(this);
		clean.setOnClickListener(this);

		loginPresenter = new LoginPresenterImpl(this);
	}

	@Override
	public void loginResult(boolean result, int code) {
		if(result)
			Toast.makeText(this, "login sucessful", Toast.LENGTH_SHORT).show();
		else
			Toast.makeText(this, "login failed", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void clean() {
		name.setText("");
		pwd.setText("");
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()){
			case R.id.login:
				loginPresenter.doLogin(name.getText().toString()
				,pwd.getText().toString());
				break;
			case R.id.clean:
				loginPresenter.clear();
				break;
		}
	}
}
