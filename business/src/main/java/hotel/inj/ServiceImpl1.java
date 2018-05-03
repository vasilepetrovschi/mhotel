package hotel.inj;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@RequestScoped @Named(value="pufi")
public class ServiceImpl1 implements ServiceIntf {

	@Override
	public String  doCeva() {
		return "ServiceImpl1 doceva";

	}
	
	public String lista() {
		
	return "inca ceva";
	}

}
