package hotel.inj;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class ServiceImpl2 implements ServiceIntf {

	@Override
	public String doCeva() {
		return "ServiceImpl2 DOALTCFEVA";
	}

}
