package hotel.business;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import mhotel.jpadao.AddressJPADAO;
import mhotel.model.Address;

@RequestScoped
public class AddressServiceJPADAO {

	private static final Logger __logger = Logger.getLogger("hotel.business.AddressServiceJPADAO");

	@Inject
	AddressJPADAO mDao;

	public List<Address> getAllAddress() throws Exception {
		if (__logger.isLoggable(Level.INFO))
			__logger.log(Level.INFO, "getAllAddress entered");
		return mDao.findAll();
	}

	public Address getAddressById(long pId) throws Exception {
		if (__logger.isLoggable(Level.INFO))
			__logger.log(Level.INFO, "getAddress from ID:" + pId);
		return mDao.findOne(pId);

	}

	public Address addAddress(Address pAddress) throws Exception {
		mDao.create(pAddress);
		return pAddress;
	}
}
