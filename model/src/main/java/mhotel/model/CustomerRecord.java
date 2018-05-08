package mhotel.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class CustomerRecord implements Serializable {
	private Long mId; // PK
	private Customer mCustomer;
	private Room mRoom;
	private Timestamp mCheckInDate;
	private Timestamp mCheckOutDate; // NULL IFF NOT CHECKED OUT
	

	public Long getId() {
		return mId;
	}

	public void setId(Long pId) {
		mId = pId;
	}

	public Customer getCustomer() {
		return mCustomer;
	}

	public void setCustomer(Customer pCustomer) {
		mCustomer = pCustomer;
	}

	public Room getRoom() {
		return mRoom;
	}

	public void setRoom(Room pRoom) {
		mRoom = pRoom;
	}

	public Timestamp getCheckInDate() {
		return mCheckInDate;
	}

	public void setCheckInDate(Timestamp pCheckInDate) {
		mCheckInDate = pCheckInDate;
	}

	public Timestamp getCheckOutDate() {
		return mCheckOutDate;
	}

	public void setCheckOutDate(Timestamp pCheckOutDate) {
		mCheckOutDate = pCheckOutDate;
	}

	@Override
	public String toString() {
		return "CustomerRecord [mId=" + mId + ", mCustomer=" + mCustomer + ", mRoom=" + mRoom + ", mCheckInDate="
				+ mCheckInDate + ", mCheckOutDate=" + mCheckOutDate + "]";
	}

}
