package mhotel.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tech_ins", schema = "test")
public class TechnicalInspection {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Temporal(TemporalType.DATE)
	@Column(name = "i_date")
	private Date mInspectionDate;
	@Column(name = "location", length = 128, nullable = false)
	private String mLocation;
	@Column(name = "report", length = 2048, nullable = false)
	private String mInspectionReport;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "CAR_ID")
	private Car mCar;

	public Long getId() {
		return id;
	}

	public void setId(Long pId) {
		id = pId;
	}

	public Date getInspectionDate() {
		return mInspectionDate;
	}

	public void setInspectionDate(Date pInspectionDate) {
		mInspectionDate = pInspectionDate;
	}

	public String getLocation() {
		return mLocation;
	}

	public void setLocation(String pLocation) {
		mLocation = pLocation;
	}

	public String getInspectionReport() {
		return mInspectionReport;
	}

	public void setInspectionReport(String pInspectionReport) {
		mInspectionReport = pInspectionReport;
	}

	@Override
	public String toString() {
		return "TechnicalInspection [id=" + id + ", mInspectionDate=" + mInspectionDate + ", mLocation=" + mLocation
				+ ", mInspectionReport=" + mInspectionReport + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TechnicalInspection other = (TechnicalInspection) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Car getCar() {
		return mCar;
	}

	public void setCar(Car pCar) {
		mCar = pCar;
	}

	
}
