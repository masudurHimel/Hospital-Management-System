import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class Patient extends Person implements Hospital {

	private String disease;
	private int cabin;
	private String gender;
	private java.util.Date admitDate;
	public java.util.Date disDate = null; // in case if there is no discharge
											// date
	public double disAmount; // discharge amount
	private double feeCabin = 2000;// Problem
	private double feeWard = 1000;
	public static int serial = 0;
	private String cabinType;

	protected Patient(String name, String address, String phone, String email, int age, int nid, String disease,
			int cabin, Date admitDate, String gender, String cabinType) {
		super(name, address, phone, email, age, nid); // without the discharge
														// as it is not certain
														// to have one
		this.disease = disease;
		this.cabin = cabin;

		this.admitDate = admitDate;
		this.gender = gender;
		this.cabinType = cabinType;
		

	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public int getCabin() {
		return cabin;
	}

	public void setCabin(int cabin) {
		this.cabin = cabin;
	}

	public int getSerial() {
		return serial;
	}

	public java.util.Date getadmitDate() {
		return admitDate;
	}

	public void setadmitDate(java.util.Date admitDate) {
		this.admitDate = admitDate;
	}

	public java.util.Date getdisDate() {
		return disDate;
	}

	public void setdisDate(java.util.Date disDate) {
		this.disDate = disDate;
	}

	public double getFeeCabin() {
		return feeCabin;
	}

	public void setFeeCabin(double feeCabin) {
		this.feeCabin = feeCabin;
	}

	public double getFeeWard() {
		return feeWard;
	}

	public void setFeeWard(double feeWard) {
		this.feeWard = feeWard;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCabinType() {
		return cabinType;
	}

	public void setCabinType(String cabinType) {
		this.cabinType = cabinType;
	}

	@Override // Problem
	public double dis_amount(Date admitDate, Date disDate, String cabinType, double otherCosting) {

		Calendar calendar1 = Calendar.getInstance();
		Calendar calendar2 = Calendar.getInstance();
		calendar1.setTime(admitDate);
		calendar2.setTime(disDate);
		long milliseconds1 = calendar1.getTimeInMillis();
		long milliseconds2 = calendar2.getTimeInMillis();
		long diff = milliseconds2 - milliseconds1;

		long diffDays = diff / (24 * 60 * 60 * 1000);
		if (cabinType.equals("Cabin")) {
			return (diffDays * feeCabin) + otherCosting;
		} else {
			return (diffDays * feeWard) + otherCosting;
		}

	}

	@Override
	public String toString() {
		return String.format(
				"Patient [disease=%s, cabin=%s, gender=%s, admitDate=%s, disDate=%s, disAmount=%s, feeCabin=%s, feeWard=%s, cabinType=%s]",
				disease, cabin, gender, admitDate, disDate, disAmount, feeCabin, feeWard, cabinType);
	}

	

}
