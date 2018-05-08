package mhotel.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="ADDRESS",schema="HOTEL")
public class Address implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private Long mId;// PK
	@Column(name="STREET")
	@NotEmpty(message = "Strada cannot be empty")
	private String mStreet;
	@Column(name="ADDRESS_NUMBER")
	@NotEmpty(message = "Numar cannot be empty")
	private String mNumber;
	@Column(name="CITY")
	@NotEmpty(message = "Oras type cannot be empty")
	private String mCity;
	@Column(name="COUNTRY")
	@NotEmpty(message = "Tara cannot be empty")
	private String mCountry;
	@Column(name="ZIP_CODE")
	@NotEmpty(message = "Cod postal cannot be empty")
	private String mPostalCode;
	

	public Address() {
	}

	public String getStreet() {
		return mStreet;
	}

	public void setStreet(String pStreet) {
		mStreet = pStreet;
	}

	@JsonProperty("street_number")
	public String getNumber() {
		return mNumber;
	}
	

	@JsonProperty("street_number")
	public void setNumber(String pNumber) {
		mNumber = pNumber;
	}

	public String getCity() {
		return mCity;
	}

	public void setCity(String pCity) {
		mCity = pCity;
	}

	public String getCountry() {
		return mCountry;
	}

	public void setCountry(String pCountry) {
		mCountry = pCountry;
	}

	public String getPostalCode() {
		return mPostalCode;
	}

	public void setPostalCode(String pPostalCode) {
		mPostalCode = pPostalCode;
	}
	
	

	public Long getId() {
		return mId;
	}

	public void setId(Long pId) {
		mId = pId;
	}

	@Override
	public String toString() {
		return "Address [mId=" + mId + ", mStreet=" + mStreet + ", mNumber=" + mNumber + ", mCity=" + mCity
				+ ", mCountry=" + mCountry + ", mPostalCode=" + mPostalCode + "]";
	}

	

	
}
