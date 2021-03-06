package Entrada.MobileApp;

public interface Elements {
	// Entrada Application
	public String Choose_PIN = ">//android.widget.EditText[contains(@resource-id,'com.entradahealth.entrada.android:id/pin_entry_edit') and @text ='Choose PIN']";
	public String OK = ">//android.widget.TextView[@text='OK']";
	public String Confirm_PIN = ">//android.widget.EditText[@text='Confirm PIN']";
	public String User_ID = ">//android.widget.EditText[@text='User ID']";
	public String Password = ">//android.widget.EditText[@text='Password']";
	public String Login = ">//android.widget.Button[contains(@resource-id,'com.entradahealth.entrada.android:id/loginButton')]";
	public String env_Qa2=">//android.widget.TextView[@text = 'QA2']";
	public String path ="C:\\Users\\Admin\\eclipse-workspace\\MobileApp\\Data\\AppData.xlsx";
	public String EnterPIN=">//android.widget.EditText[@text = 'Enter PIN']";
	
	public String JoblistTitle="//android.widget.TextView[@text='Job List']";
	
	public String schedule =">//android.widget.TextView[@text='Schedule']";
	
	
	
	
	
	
	
	// Chrome Browser
	public String Acpt_continue = ">//android.widget.Button[contains(@resource-id,'com.android.chrome:id/terms_accept') and @text='ACCEPT & CONTINUE']";
	public String No_thanks = ">//android.widget.Button[contains(@resource-id,'com.android.chrome:id/negative_button') and @text='NO THANKS']";
	public String Search_B = ">\r\n"
			+ "//android.widget.ScrollView[@content-desc=\"New tab\"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText";

}
