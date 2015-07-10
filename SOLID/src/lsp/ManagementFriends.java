package lsp;

import java.util.ArrayList;
import java.util.List;
public class ManagementFriends {
	private List<Friends> friends;
	
	public ManagementFriends() {
		friends = new ArrayList<Friends>();
	}
	
	public void addFriends(Friends friends) {
		
	}
	
	public void addFriends(HighFriends highFriends) {
		this.friends.add(highFriends);
	}
	
	public void addFriends(MiddleFriends middleFriends) {
		this.friends.add(middleFriends);
		
	}
	public void showAllFriends() {
		
		for(Friends f : friends) {
			System.out.println(f.getName());
			System.out.println(f.getPhone());
			
			if( f instanceof HighFriends) {
				System.out.println( ((HighFriends) f).getSchool());
			}
			else if (f instanceof MiddleFriends) {
				System.out.println( ((MiddleFriends) f).getSchool());
				
			}
		}
	}
	
	//Annotation reflection 공부 추천
}
