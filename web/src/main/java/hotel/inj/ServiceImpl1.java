package hotel.inj;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class ServiceImpl1 implements ServiceIntf {

	@Override
	public String  doCeva() {
		return "ServiceImpl1 doceva";

	}

}
