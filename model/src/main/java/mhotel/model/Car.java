package mhotel.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="cars",schema="test")
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "car_maker",length=128)
	private String mMaker;
	@Column(name = "car_model")
	private String mModel;
	@Column(name = "car_year")
	private int mYear;
	@Column(name = "color")
	private String mColor;
	@Column(name = "milleage")
	//@Transient
	private int mMileage;
	@OneToMany(mappedBy="mCar", fetch=FetchType.LAZY)
	private List<TechnicalInspection> mInspections = new ArrayList<>();

	public String getMaker() {
		return mMaker;
	}

	public void setMaker(String pMaker) {
		mMaker = pMaker;
	}

	public String getModel() {
		return mModel;
	}

	public void setModel(String pModel) {
		mModel = pModel;
	}

	public int getYear() {
		return mYear;
	}

	public void setYear(int pYear) {
		mYear = pYear;
	}

	public String getColor() {
		return mColor;
	}

	public void setColor(String pColor) {
		mColor = pColor;
	}

	public int getMileage() {
		return mMileage;
	}

	public void setMileage(int pMileage) {
		mMileage = pMileage;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long pId) {
		id = pId;
	}

	
	@Override
	public String toString() {
		return "Car [id=" + id + ", mMaker=" + mMaker + ", mModel=" + mModel + ", mYear=" + mYear + ", mColor=" + mColor
				+ ", mMileage=" + mMileage + ", mInspections=" + mInspections + "]";
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
		Car other = (Car) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public List<TechnicalInspection> getInspections() {
		return mInspections;
	}

	public void setInspections(List<TechnicalInspection> pInspections) {
		mInspections = pInspections;
	}

	
}
