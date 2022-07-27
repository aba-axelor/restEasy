package demoRest;


import com.google.inject.AbstractModule;

public class alienModule extends AbstractModule{
	@Override
	public void configure() {
		bind(alienResource.class);
		bind(alienRepo.class).to(alienrepoImpl.class);
	}
}
