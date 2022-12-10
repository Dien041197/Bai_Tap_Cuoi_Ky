package pageUIs;

public class RegisterPageUIs {
	//ERROR_MESSAGE
			public static final String FIRST_NAME_ERROR_MESSAGE = "//span[@id='FirstName-error']";
			public static final String LAST_NAME_ERROR_MESSAGE = "//span[@id='LastName-error']";
			public static final String EMAIL_ERROR_MESSAGE = "//span[@id='Email-error']";
			public static final String PASS_WORD_ERROR_MESSAGE = "//span[@id='Password-error']";
			public static final String PASS_WORD_ERROR_MESSAGE_P = "//span[@id='Password-error']/p";
			public static final String PASS_WORD_ERROR_MESSAGE_UL = "//span[@id='Password-error']/ul";
			public static final String COMFIRM_PASS_WORD_ERROR_MESSAGE = "//span[@id='ConfirmPassword-error']";
			public static final String EMAIL_ERROR_VALIDATION_SUMMARY_MESSAGE = "//div[@class='message-error validation-summary-errors']";
			//RESULT_MESSAGE
			public static final String REGISTER_RESULT_MESSAGE = "//div[@class='result']";
			
			//BUTTON
			public static final String REGISTER_BUTTON = "//button[@class='button-1 register-next-step-button']";
			
			//TEXTBOX
			public static final String FIRST_NAME_TEXTBOX = "//input[@id='FirstName']";
			public static final String LAST_NAME_TEXTBOX = "//input[@id='LastName']";
			public static final String EMAL_TEXTBOX = "//input[@id='Email']";
			public static final String COMPANY_NAME_TEXTBOX = "//input[@id='Company']";
			public static final String PASS_WORD_TEXTBOX = "//input[@id='Password']";
			public static final String COMPIRM_PASS_WORD_TEXTBOX = "//input[@id='ConfirmPassword']";
			
			//CHECKBOX
			public static final String GENDER_MALE_CHECKBOX = "//label[@class='forcheckbox' and text()='Male']";
			public static final String GENDER_FEMALE_CHECKBOX = "//label[@class='forcheckbox' and text()='Female']";
			public static final String NEWSLETTER_CHECKBOX = "//input[@id='Newsletter' and @name='Newsletter']";
			
			//DATE_PICKER
			public static final String DAY_DATE_PICKER = "//select[@name='DateOfBirthDay']";
			public static final String MONTH_DATE_PICKER = "//select[@name='DateOfBirthMonth']";
			public static final String YEAR_DATE_PICKER = "//select[@name='DateOfBirthYear']";

}
