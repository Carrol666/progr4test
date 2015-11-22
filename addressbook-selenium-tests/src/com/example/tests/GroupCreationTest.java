package com.example.tests;


import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import static org.junit.Assert.assertThat;
import static com.example.tests.GroupDataGeneration.loadGroupsFromCsvFile;
import static com.example.tests.GroupDataGeneration.loadGroupsFromXmlFile;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class GroupCreationTest  extends TestBase{
    
	@DataProvider
	public Iterator<Object[]> groupsFromFile() throws IOException {
		return wrapGroupsToDataProvider(loadGroupsFromCsvFile(new File("groups.txt"))).iterator();
	}
	



@Test(dataProvider = "groupsFromFile")
  public void testGroupCreationWithValidData(GroupData group) throws Exception {
	      
      // save old state
	  SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
      // actions
       app.getGroupHelper().createGroup(group);
     
   // save new sate
       SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();
     // compare states
       assertThat(newList, equalTo(oldList.withAdded(group)));
    
  }
  
}