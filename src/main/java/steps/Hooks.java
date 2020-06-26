package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
@Before
public void prescenario(Scenario sc)
{
	System.out.println("Scenario name is: "+sc.getName());
	System.out.println("Line no is:"+sc.getId());
	System.out.println("before status:"+sc.getStatus());
}
@After
public void postscenario(Scenario sc)
{
	System.out.println("After status:"+sc.getStatus());
}
}