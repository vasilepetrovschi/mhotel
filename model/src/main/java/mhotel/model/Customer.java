package mhotel.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "CUSTOMER", schema = "HOTEL")
public class Customer implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long mId; // PK
	@Column(name = "NAME")
	@NotEmpty(message = "Name cannot be empty")
	@NotBlank(message = "Name cannot be whitespace")
	private String mName;
	@Column(name = "SEX")
	@NotNull(message = "Sex cannot be null")
	private String mSex;
	@Column(name = "LEGAL_ID")
	@NotEmpty(message = "Identity cannot be empty")
	@NotBlank(message = "Identity cannot be whitespace")
	private String mLegalId; // PassportId,SSN,
	@Column(name = "LEGAL_ID_TYPE")
	@NotEmpty(message = "Identity Type cannot be empty")
	@NotBlank(message = "Identity Type cannot be whitespace")
	private String mLegalIdType; // PASSPORT,DRIVERID,IDENTITY_CARD,etc
	@Column(name = "BIRTHDAY")
	@NotEmpty(message = "Birthday cannot be empty")
	@NotBlank(message = "Birthday cannot be whitespace")
	private String birthday;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ADDRESS_ID")
	private Address mAddress;

	public Long getId() {
		return mId;
	}

	public void setId(Long pId) {
		mId = pId;
	}

	public String getName() {
		return mName;
	}

	public void setName(String pName) {
		mName = pName;
	}

	public String getSex() {
		return mSex;
	}

	public void setSex(String pSex) {
		mSex = pSex;
	}

	public String getLegalId() {
		return mLegalId;
	}

	public void setLegalId(String pLegalId) {
		mLegalId = pLegalId;
	}

	public String getLegalIdType() {
		return mLegalIdType;
	}

	public void setLegalIdType(String pLegalIdType) {
		mLegalIdType = pLegalIdType;
	}
	
	

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public Address getAddress() {
		return mAddress;
	}

	public void setAddress(Address pAddress) {
		mAddress = pAddress;
	}

	
	@Override
	public String toString() {
		return "Customer [mId=" + mId + ", mName=" + mName + ", mSex=" + mSex + ", mLegalId=" + mLegalId
				+ ", mLegalIdType=" + mLegalIdType + ", birthday=" + birthday + ", mAddress=" + mAddress + "]";
	}

}
