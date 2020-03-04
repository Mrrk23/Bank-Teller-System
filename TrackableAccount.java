/**************************************************************
 *Name: Trackable Account
 *Input:None
 *Output: None 
 *Description:interface to get and store username, password and URL
 **************************************************************/
public interface TrackableAccount 
{
	//Declares methods without any implementation
	public String getURL();
	public String getPassword();
	public String getUsername();
}
